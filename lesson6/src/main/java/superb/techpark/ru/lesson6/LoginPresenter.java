package superb.techpark.ru.lesson6;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;


public class LoginPresenter implements MVPContract.Presenter {

    private MVPContract.View mView;
    private final AuthRepo authRepo;
    Handler handler = new Handler(Looper.getMainLooper());

    public LoginPresenter(MVPContract.View mView) {
        this.mView = mView;
        authRepo = AuthRepo.getInstance((Context) mView);
    }


    // or login in MVVM !
    @Override
    public void onLoginClicked(String login, String password) {
        authRepo.login(login, password, new AuthRepo.LoginCallback() {
            @Override
            public void onSuccess() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mView.showLessonsScreen();
                    }
                });
            }

            @Override
            public void onError() {
                mView.loginError();
            }
        });
    }

    @Override
    public void onBackClicked() {

    }

    @Override
    public void onRetry() {

    }
}
