package superb.techpark.ru.lesson6;

interface MVPContract {
    interface Presenter {
        void onLoginClicked(String login, String password);

        void onBackClicked();

        void onRetry();
    }

    interface View  {
        void showLessonsScreen();
        void loginError();
        void notifyErrorMsg();
    }

}
