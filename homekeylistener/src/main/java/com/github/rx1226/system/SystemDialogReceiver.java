package com.github.rx1226.system;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class SystemDialogReceiver extends BroadcastReceiver {
    private static final String TAG = "HomeKeyReceiver";
    private static final String REASON = "reason";
    private static final String RECENT_APPS = "recentapps";
    private static final String HOME_KEY = "homekey";
    private static final String DREAM = "dream";
    private static final String ASSIST = "assist";
    private static final String VOICE_INTERACTION = "voiceinteraction";
    private SystemDialogListener systemDialogListener;

    public void setSystemDialogListener(SystemDialogListener systemDialogListener){
        this.systemDialogListener = systemDialogListener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (Intent.ACTION_CLOSE_SYSTEM_DIALOGS.equals(action)) {
            String reason = intent.getStringExtra(REASON);
            Log.e(TAG, "reason: " + reason);
            switch (reason){
                case HOME_KEY:
                    if(systemDialogListener != null) systemDialogListener.onHomeKey();
                    break;
                case RECENT_APPS:
                    if(systemDialogListener != null) systemDialogListener.onRecentApps();
                    break;
                case ASSIST:
                    if(systemDialogListener != null) systemDialogListener.onAssist();
                    break;
                case DREAM:
                    if(systemDialogListener != null) systemDialogListener.onDream();
                    break;
                case VOICE_INTERACTION:
                    if(systemDialogListener != null) systemDialogListener.onVoiceInterAction();
                    break;
            }
        }
    }
}
