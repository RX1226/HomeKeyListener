package com.github.rx1226.system;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class HomeKeyListener {
    private Context context;
    private SystemDialogReceiver systemDialogReceiver;
    public HomeKeyListener(Context context){
        this.context = context;
        systemDialogReceiver = new SystemDialogReceiver();
    }

    public void setOnHomeKeyListener(OnHomeKeyListener OnHomeKeyListener){
        systemDialogReceiver.setSystemDialogListener(OnHomeKeyListener);
    }

    public void setSystemDialogListener(SystemDialogListener systemDialogListener){
        systemDialogReceiver.setSystemDialogListener(systemDialogListener);
    }

    public void register(){
        context.registerReceiver(systemDialogReceiver, new IntentFilter(Intent.ACTION_CLOSE_SYSTEM_DIALOGS));
    }
    public void unregister(){
        context.unregisterReceiver(systemDialogReceiver);
    }
}
