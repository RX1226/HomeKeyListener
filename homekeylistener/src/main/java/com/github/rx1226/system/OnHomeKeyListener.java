package com.github.rx1226.system;

public interface OnHomeKeyListener extends SystemDialogListener{
    void onHomeKey();
    default void onRecentApps(){};
    default void onDream(){};
    default void onAssist(){};
    default void onVoiceInterAction(){};
}
