package com.example.caesaryu.lab9;

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
    private Button button;
    private TextView tv;
    private BroadcastReceiver mBroadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MyService.class);
                startService(intent);
                Toast.makeText(MainActivity.this, "啟動SERVICE成功", Toast.LENGTH_SHORT).show();
            }
        });

        mBroadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Bundle bundle = intent.getExtras();
                int Int = bundle.getInt("sec");
                tv.setText("後臺SERVICE 執行:" + Int + "秒");
            }
        };

        IntentFilter intentFilter = new IntentFilter("SEC");
        registerReceiver(mBroadcastReceiver,intentFilter);
    }
}
