package com.example.administrator.tinkerdemo;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.util.Log;

import com.tinkerpatch.sdk.TinkerPatch;
import com.tinkerpatch.sdk.loader.TinkerPatchApplicationLike;

public class App extends Application {

    private static final String TAG = "App";

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initTinkerPatch();
    }

    private void initTinkerPatch() {
        //我们可以从这里获得Tinker加载过程的信息
        if (BuildConfig.TINKER_ENABLE) {
            //初始化TinkerPatch SDK
            TinkerPatch.init(TinkerPatchApplicationLike.getTinkerPatchApplicationLike())
                    .reflectPatchLibrary()
                    .setPatchRollbackOnScreenOff(true)
                    .setPatchRestartOnSrceenOff(true)
                    .setFetchPatchIntervalByHours(3);
            //获取当前的补丁版本
            Log.d(TAG, "Current patch version is" + TinkerPatch.with().getPatchVersion());
            TinkerPatch.with().fetchPatchUpdateAndPollWithInterval();
        }
    }
}
