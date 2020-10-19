package ru.mail.techpark.lesson3;

import android.app.Application;

/**
 * Created by v.poselyanin on 19.10.2020.
 */
public class MyApplication extends Application {
    private boolean mFlag = true;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public boolean getFlag() {
        return mFlag;
    }
}
