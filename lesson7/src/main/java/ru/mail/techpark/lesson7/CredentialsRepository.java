package ru.mail.techpark.lesson7;

import androidx.annotation.MainThread;

public interface CredentialsRepository {

    void validateCredentials(String login,
                             String pass,
                             ValidationCallback validationCallback);

    interface ValidationCallback {
        @MainThread
        void onSuccess();

        @MainThread
        void onError();

        void onNotFound();
    }
}
