package superp.techpark.ru.lesson9;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.bottomsheet.BottomSheetBehavior;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CoordinatorSampleFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.coordinator_sample, container, false);
        BottomSheetBehavior behavior = BottomSheetBehavior.from(view.findViewById(R.id.bottomsheet));
        behavior.setHideable(true);
        view.findViewById(R.id.bottomsheet_trigger).setOnClickListener(v -> behavior.setState(BottomSheetBehavior.STATE_EXPANDED));
        return view;
    }
}
