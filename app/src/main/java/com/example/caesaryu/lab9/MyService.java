package com.example.caesaryu.lab9;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        new Thread(){
            int count=0;

            @Override
            public void run() {

                while(true){
                    Intent intent=new Intent("SEC");
                    intent.putExtra("sec",count);
                    sendBroadcast(intent);
                    count++;
                    try {
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }.start();
    }
}
