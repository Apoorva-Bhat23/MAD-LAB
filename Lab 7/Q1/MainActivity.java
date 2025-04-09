package com.example.newia;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView appListView;
    private List<ApplicationInfo> installedApps;
    private PackageManager packageManager;
    private ApplicationInfo selectedApp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        appListView = findViewById(R.id.app_list);
        packageManager = getPackageManager();

        // Fetch installed applications
        installedApps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        List<String> appNames = new ArrayList<>();
        for (ApplicationInfo app : installedApps) {
            appNames.add((String) packageManager.getApplicationLabel(app));
        }

        // Set adapter for ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, appNames);
        appListView.setAdapter(adapter);

        // Register context menu for ListView
        registerForContextMenu(appListView);

        // Capture selected app
        appListView.setOnItemClickListener((parent, view, position, id) -> selectedApp = installedApps.get(position));
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
        selectedApp = installedApps.get(info.position);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_open) {
            // Open the app
            Intent launchIntent = packageManager.getLaunchIntentForPackage(selectedApp.packageName);
            if (launchIntent != null) {
                startActivity(launchIntent);
            }
            return true;
        } else if (item.getItemId() == R.id.action_uninstall) {
            // Uninstall the app
            if ((selectedApp.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
                Intent intent = new Intent(Intent.ACTION_DELETE);
                intent.setData(Uri.parse("package:" + selectedApp.packageName));
                startActivity(intent);
            } else {
                // System apps can't be uninstalled
            }
            return true;
        } else if (item.getItemId() == R.id.action_view_details) {
            // Display app details
            Intent detailsIntent = new Intent(this, AppDetailsActivity.class);
            detailsIntent.putExtra("packageName", selectedApp.packageName);
            startActivity(detailsIntent);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }
}
