package superb.techpark.ru.lesson6.lesson;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class LessonsViewModel extends AndroidViewModel {

    private LessonRepo mRepo = new LessonRepo(getApplication());
    private LiveData<List<Lesson>> mLessons = mRepo.getLessons();

    public LessonsViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<List<Lesson>> getLessons() {
        return mLessons;
    }

    public void like(Lesson lesson) {
        mRepo.like(lesson);
    }

    public void refresh() {
        mRepo.refresh();
    }
}
