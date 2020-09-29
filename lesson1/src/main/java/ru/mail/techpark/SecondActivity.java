package ru.mail.techpark;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        int myNumber = getIntent().getIntExtra(Constants.MY_DATA_NUMBER, -1);

        final TextView view = findViewById(R.id.big_text);
        view.setText(String.valueOf(myNumber));
    }
}
