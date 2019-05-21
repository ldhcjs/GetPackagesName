package com.example.packagesname;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;

public class GetPackagesName extends AccessibilityService {
    private final static String TAG = GetPackagesName.class.getSimpleName();

    @Override
    public void onAccessibilityEvent(final AccessibilityEvent event) {
        if (event == null ) {
            return;
        } else if(event.getPackageName() == null && event.getClassName() == null){
            return;
        }
        Log.d(TAG, "Package name : " + event.getPackageName());
    }

    @Override
    public void onInterrupt() {

    }

    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        Log.d(TAG, "onServiceConnected");

        //Configure these here for compatibility with API 13 and below.

        AccessibilityServiceInfo config = new AccessibilityServiceInfo();
        config.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
        config.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;

        if (Build.VERSION.SDK_INT >= 16)
            //Just in case this helps
            config.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;

        setServiceInfo(config);
    }
}
