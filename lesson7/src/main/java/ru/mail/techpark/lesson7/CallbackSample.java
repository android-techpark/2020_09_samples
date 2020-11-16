package ru.mail.techpark.lesson7;

/**
 * Created by v.poselyanin on 16.11.2020.
 */
public class CallbackSample {
    private boolean value = false;

    public void setValue(boolean value) {
        this.value = value;
    }

    public void callCallback(Callback callback) {
        // work
        if (value) {
            callback.logSuccess();
        } else {
            callback.logError();
        }
    }

    interface Callback{
        void logSuccess();
        void logError();
    }
}
