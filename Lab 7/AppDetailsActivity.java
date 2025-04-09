package com.example.newia;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AppDetailsActivity extends AppCompatActivity {

    private TextView appName, appVersion, appPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        appName = findViewById(R.id.app_name);
        appVersion = findViewById(R.id.app_version);
        appPermissions = findViewById(R.id.app_permissions);

        String packageName = getIntent().getStringExtra("packageName");
        try {
            PackageManager packageManager = getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);

            appName.setText("Name: " + packageManager.getApplicationLabel(packageInfo.applicationInfo));
            appVersion.setText("Version: " + packageInfo.versionName);

            String[] permissions = packageInfo.requestedPermissions;
            if (permissions != null) {
                StringBuilder permissionsText = new StringBuilder("Permissions:\n");
                for (String permission : permissions) {
                    permissionsText.append(permission).append("\n");
                }
                appPermissions.setText(permissionsText.toString());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}