package superp.techpark.ru.lesson9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

public class CenterImageViewBehavior extends CoordinatorLayout.Behavior<View> {

    public CenterImageViewBehavior() {

    }

    public CenterImageViewBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(@NonNull CoordinatorLayout parent,
                                   @NonNull View imageview,
                                   @NonNull View dependency) {
        return super.layoutDependsOn(parent, imageview, dependency) || dependency.getId() == R.id.bottomsheet_trigger;
    }

    @Override
    public boolean onDependentViewChanged(@NonNull CoordinatorLayout parent,
                                          @NonNull View imageview,
                                          @NonNull View dependency) {


        if (dependency.getId() == R.id.bottomsheet_trigger) {
            imageview.setTranslationY(Math.min(0, dependency.getTop() - imageview.getBottom()));
        }

        return super.onDependentViewChanged(parent, imageview, dependency);
    }
}
