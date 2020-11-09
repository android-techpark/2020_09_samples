package superb.techpark.ru.lesson6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import superb.techpark.ru.lesson6.lesson.LessonRepo;
import superb.techpark.ru.lesson6.lesson.LessonsFragment;

public class MainActivity extends AppCompatActivity implements Router {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new LoginFragment(), "Login")
                    .commit();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        ///
    }

    @Override
    public void openLessons() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new LessonsFragment(), "Lessons")
                .commit();
    }
}
