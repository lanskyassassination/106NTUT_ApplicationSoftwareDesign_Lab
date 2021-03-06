package com.example.user.lab8;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_start;
    private TextView run_time;
    private BroadcastReceiver myBBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_start = (Button)findViewById(R.id.send);
        run_time = (TextView)findViewById(R.id.message);

        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(MainActivity.this, MyService.class);
                startService(i);
                Toast.makeText(MainActivity.this, "Service啟動成功", Toast.LENGTH_SHORT).show();
            }
        });

        myBBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle myBundle = intent.getExtras();
                int myint = myBundle.getInt("background_service");

                run_time.setText("後台Service執行了" + myint + "秒");
            }
        };
        IntentFilter intentFilter = new IntentFilter("MyMessage");

        registerReceiver(myBBroadcastReceiver, intentFilter);
    }
}
