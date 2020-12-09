package com.rx1226.sample;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.github.rx1226.system.HomeKeyListener;
import com.github.rx1226.system.OnHomeKeyListener;
import com.github.rx1226.system.SystemDialogListener;

public class MainActivity extends AppCompatActivity{
    private final static String TAG = "MainActivity";
    private HomeKeyListener homeKeyListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        homeKeyListener = new HomeKeyListener(this);
        homeKeyListener.setOnHomeKeyListener(() -> {
            Log.d(TAG, "click Home key");
        });

        //extension
        homeKeyListener.setSystemDialogListener(new SystemDialogListener() {
            @Override
            public void onHomeKey() {
                Log.d(TAG, "onHomeKey");
            }

            @Override
            public void onRecentApps() {
                Log.d(TAG, "onRecentApps");
            }

            @Override
            public void onDream() {
                Log.d(TAG, "onDream");
            }

            @Override
            public void onAssist() {
                Log.d(TAG, "onAssist");
            }

            @Override
            public void onVoiceInterAction() {
                Log.d(TAG, "onVoiceInterAction");
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        homeKeyListener.register();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        homeKeyListener.unregister();
    }
}
