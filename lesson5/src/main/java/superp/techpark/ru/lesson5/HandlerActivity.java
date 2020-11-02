package superp.techpark.ru.lesson5;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Пример работы с Thread'ами, Handler'ами и Looper'ами. Код демонстрирует:
 * <ul>
 *     <li>Запуск/остановку потоков</li>
 *     <li>Создание Looper'а и Handler'а на потоке</li>
 *     <li>Передачу сообщений ({@link Message}) между потоками</li>
 *     <li>Исполнение {@link Runnable} на указанном потоке</li>
 * </ul>
 */
public class HandlerActivity extends AppCompatActivity {

    private static final String TAG = "HandlerActivity";

    private static final int STRING_UPPER = 1;
    private static final int STRING_LOWER = 2;

    private static final long DELAY = 2000L;

    private final View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(final View view) {
            switch (view.getId()) {
                case R.id.start:
                    startThread();
                    break;
                case R.id.stop:
                    stopThread();
                    break;
                case R.id.to_lower:
                    sendToThread(STRING_LOWER, "Test Me");
                    break;
                case R.id.to_upper:
                    sendToThread(STRING_UPPER, "Test Me");
                    break;
                default:
                    throw new UnsupportedOperationException("Wrong view id " + view.getId());
            }
        }
    };

    private final Handler.Callback handlerCallback = new Handler.Callback() {

        private Handler mainHandler = new Handler(Looper.getMainLooper());

        @Override
        public boolean handleMessage(final Message message) {
            final String data = (String) message.obj;
            final String processedData;
            switch (message.what) {
                case STRING_UPPER:
                    processedData = data.toUpperCase();
                    break;
                case STRING_LOWER:
                    processedData = data.toLowerCase();
                    break;
                default:
                    return false;
            }
            mainHandler.post(new Runnable() {
                @Override
                public void run() {
                    result.setText(processedData);
                }
            });
            return true;
        }
    };

    private volatile Handler handler;
    private TextView result;
    private int anInt = 0;
    private Object lock = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);

        result = findViewById(R.id.result);

        findViewById(R.id.start).setOnClickListener(clickListener);
        findViewById(R.id.stop).setOnClickListener(clickListener);
        findViewById(R.id.to_lower).setOnClickListener(clickListener);
        findViewById(R.id.to_upper).setOnClickListener(clickListener);
    }

    private void startThread() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "Thread started");
                Looper.prepare();
                handler = new Handler(handlerCallback);
                Looper.loop();
                Log.d(TAG, "Thread stopped");
            }
        },"my Thread").start();
//        или так, через HandlerThread
//        HandlerThread thead1 = new HandlerThread("thead");
//        thead1.start();
//        Looper threadLooper = thead1.getLooper();
//        handler = new Handler(threadLooper,handlerCallback);
    }

    private void stopThread() {
        final Handler localHandler = handler;
        if (localHandler != null) {
            localHandler.post(new Runnable() {
                @Override
                public void run() {
                    final Looper looper = Looper.myLooper();
                    if (looper != null) {
                        looper.quit();
                    }
                }
            });
            handler = null;
        }
    }

    private void sendToThread(final int action, final String data) {
        final Handler localHandler = handler;
        if (localHandler != null) {
            final Message message = Message.obtain();
            message.what = action;
            message.obj = data;
            localHandler.sendMessage(message);
        }
    }
}
