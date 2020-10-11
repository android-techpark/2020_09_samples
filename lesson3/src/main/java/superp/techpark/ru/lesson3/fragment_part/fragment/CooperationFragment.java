package superp.techpark.ru.lesson3.fragment_part.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import superp.techpark.ru.lesson3.R;

/**
 * Fragment, показывающий механизм взаимодействия Activity и Fragment'а.
 */
public class CooperationFragment extends BaseFragment {

    private ReportListener reportListener;
    private String cooperationText;

    public void setCooperationText(String cooperationText) {
        this.cooperationText = cooperationText;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        reportListener = (ReportListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cooperation, container, false);
        view.findViewById(R.id.btn_do_it).setOnClickListener(view1 -> reportListener.reportMessage(cooperationText));
        return view;
    }

    @Override
    public void onDetach() {
        reportListener = null;
        super.onDetach();
    }

    public interface ReportListener {
        void reportMessage(String cooperationText);
    }
}
