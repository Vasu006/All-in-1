package com.example.allin1.domain.businessLogic;

import android.app.Application;
import android.content.Context;

public class MainApplication_Java extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getBaseContext();
    }

    public static Context getContext() {
        return mContext;
    }
}