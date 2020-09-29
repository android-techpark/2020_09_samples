package ru.mail.techpark;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView view = findViewById(R.id.my_text);
        view.setTextColor(Color.RED);

        String s = getString(R.string.my_text);
        int color = ResourcesCompat.getColor(getResources(), R.color.colorSuperDuper, getTheme());
        view.setTextColor(color);

        Button button = findViewById(R.id.counter);
        View.OnClickListener listener = new MyClickListener(view);
        button.setOnClickListener(listener);

        Button buttonDec = findViewById(R.id.counter_decrement);
        buttonDec.setOnClickListener(listener);

        final Button starActivity = findViewById(R.id.start_activity);
        starActivity.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Class<?> aClass = SecondActivity.class;
                Intent i = new Intent(MainActivity.this, aClass);
                i.putExtra(Constants.MY_DATA_NUMBER, Integer.parseInt(view.getText().toString()));
                startActivity(i);
            }
        });
    }

    private class MyClickListener implements View.OnClickListener {

        private TextView mTextView;

        public MyClickListener(TextView view) {
            this.mTextView = view;
        }

        @Override
        public void onClick(View view) {
            incrementCounter(mTextView, view.getId() == R.id.counter);
        }
    }


    private void incrementCounter(TextView viewToIncrement, boolean increment) {
        String currentText = viewToIncrement.getText().toString();
        int currentNumber = Integer.parseInt(currentText);
        int nextNumber = increment ? currentNumber + 1 : currentNumber - 1;
        viewToIncrement.setText(String.valueOf(nextNumber));
    }
}