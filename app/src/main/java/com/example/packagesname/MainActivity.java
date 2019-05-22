package com.example.packagesname;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button mBtnSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnSetting = (Button) findViewById(R.id.btn_setting);

        mBtnSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(
                        new Intent(android.provider.Settings.ACTION_ACCESSIBILITY_SETTINGS),
                        1000);
            }
        });
        startService(new Intent(this, GetPackagesName.class));
    }
}
