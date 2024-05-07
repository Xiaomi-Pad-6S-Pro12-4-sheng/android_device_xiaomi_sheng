/*
 * Copyright (C) 2023 Paranoid Android
 *
 * SPDX-License-Identifier: Apache-2.0
 */

package com.xiaomi.settings.touch;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class TouchEdgeFilterService extends Service {

    private static final String TAG = "XiaomiPartsTouchEdgeFilterService";
    private static final boolean DEBUG = Log.isLoggable(TAG, Log.DEBUG);

    @Override
    public void onCreate() {
        if (DEBUG) Log.d(TAG, "Creating service");
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (DEBUG) Log.d(TAG, "onStartCommand");
        TfWrapper.setTouchFeature(
                new TfWrapper.TfParams(/*TOUCH_EDGE_FILTER*/ 7, 2));
        stopSelf(); // only for now as we dont do anything else with this service rn
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (DEBUG) Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
