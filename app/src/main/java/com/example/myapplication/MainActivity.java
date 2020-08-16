package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button Btn_onWiFi;
    private Button Btn_offWiFi;
    private Button Btn_checkWiFi;
    private WifiManager wifimanager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //设置三个按钮
        Btn_onWiFi = findViewById(R.id.btn_onwifi);
        Btn_offWiFi = findViewById(R.id.btn_offwifi);
        Btn_checkWiFi = findViewById(R.id.btn_checkwifi);
        //为三个按钮设置监听器
        Btn_onWiFi.setOnClickListener(new OnWifiListener());
        Btn_offWiFi.setOnClickListener(new OffWifiListener());
        Btn_checkWiFi.setOnClickListener(new CheckWifiListener());
    }

    // 启动wifi的监听器
    public class OnWifiListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            // 从content中获得wifi_service的object，并且向下转型为wifimanager
            wifimanager = (WifiManager) MainActivity.this.getApplicationContext().getSystemService(MainActivity.this.WIFI_SERVICE);
            // 启动wifi开关
            wifimanager.setWifiEnabled(true);
            // 显示text
            Toast.makeText(MainActivity.this, "wifi已经打开了，请大喊", Toast.LENGTH_SHORT).show();
        }
    }

    // 用于关闭wifi的监听器
    public class OffWifiListener implements View.OnClickListener {


        @Override
        public void onClick(View view) {
            // 从content中获得wifi_service的object，并且向下转型为wifimanager
            wifimanager = (WifiManager) MainActivity.this.getApplicationContext().getSystemService(MainActivity.WIFI_SERVICE);
            // 关闭wifi的开管
            wifimanager.setWifiEnabled(false);
            // 显示text
            Toast.makeText(MainActivity.this, "wifi已经关闭，请叫我天才", Toast.LENGTH_SHORT).show();
        }
    }

    // 设置检查wifi状态的监听器
    public class CheckWifiListener implements View.OnClickListener {


        @Override
        public void onClick(View view) {
            // 从content中获得wifi_service的object，并且向下转型为wifimanager
            wifimanager = (WifiManager) MainActivity.this.getApplicationContext().getSystemService(MainActivity.this.WIFI_SERVICE);
            switch (wifimanager.getWifiState()) {
                case 0:
                    Toast.makeText(MainActivity.this, "wifi目前处于正在关闭状态", Toast.LENGTH_SHORT).show();
                    break;
                case 1:
                    Toast.makeText(MainActivity.this, "wifi目前处于关闭状态", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Toast.makeText(MainActivity.this, "wifi目前处于正在打开状态", Toast.LENGTH_SHORT).show();
                    break;
                case 3:
                    Toast.makeText(MainActivity.this, "wifi目前处于打开状态", Toast.LENGTH_SHORT).show();
                    break;
                case 4:
                    Toast.makeText(MainActivity.this, "wifi目前处于未知状态", Toast.LENGTH_SHORT).show();
                    break;
                default:
                    break;
            }

        }

    }

}

