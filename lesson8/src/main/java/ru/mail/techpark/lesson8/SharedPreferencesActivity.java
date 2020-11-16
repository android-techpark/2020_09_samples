package ru.mail.techpark.lesson8;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity для демонстрации работы с {@link SharedPreferences}. Показывает чтение и запись
 * различных типов данных.
 */
public class SharedPreferencesActivity extends AppCompatActivity {

    private final static String KEY_CHECK = "check";
    private final static String KEY_TEXT = "text";
    private final static String KEY_SEEK_PROGRESS = "seek_progress";
    private final static String KEY_FLOAT = "float_value";

    private CheckBox checkBox;
    private EditText editString;
    private SeekBar seek;
    private EditText editFloat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        checkBox = findViewById(R.id.checkbox);
        editString = findViewById(R.id.edit_text);
        seek = findViewById(R.id.seek);
        editFloat = findViewById(R.id.edit_text_float);
    }

    @Override
    protected void onStart() {
        super.onStart();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        checkBox.setChecked(prefs.getBoolean(KEY_CHECK, false));
        editString.setText(prefs.getString(KEY_TEXT, ""));
        seek.setProgress(prefs.getInt(KEY_SEEK_PROGRESS, 50));

        float f = prefs.getFloat(KEY_FLOAT, -1f);
        editFloat.setText(String.valueOf(f));
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences.Editor editor = getPreferences(MODE_PRIVATE).edit();
        editor.putBoolean(KEY_CHECK, checkBox.isChecked());
        editor.putString(KEY_TEXT, editString.getText().toString());
        editor.putInt(KEY_SEEK_PROGRESS, seek.getProgress());
        editor.putFloat(KEY_FLOAT, Float.parseFloat(editFloat.getText().toString()));
        editor.apply();
    }
}
