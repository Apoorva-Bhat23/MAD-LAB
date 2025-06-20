package com.example.grocery;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "GroceryDB.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Grocery";
    private static final String COLUMN_ITEM = "item";
    private static final String COLUMN_COST = "cost";

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_ITEM + " TEXT, " +
                COLUMN_COST + " INTEGER);";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    // Insert item into database
    public void insertItem(String item, int cost) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ITEM, item);
        values.put(COLUMN_COST, cost);
        db.insert(TABLE_NAME, null, values);
        db.close();
    }

    // Get total cost of all items
    public int getTotalCost() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT SUM(" + COLUMN_COST + ") FROM " + TABLE_NAME, null);
        int totalCost = 0;
        if (cursor.moveToFirst()) {
            totalCost = cursor.getInt(0);
        }
        cursor.close();
        return totalCost;
    }
}
