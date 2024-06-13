package rs.lavgoodman.simplestopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0;
    private boolean running;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runTimer();
    }

    public void onClickStart(View view){

        running = true;
    }

    public void onClickStop(View view){
        running = false;

    }

    public void onClickRestart(View view){

        running = false;
        seconds = 0;
    }



    private void runTimer() {

        final TextView timeView = (TextView) findViewById(R.id.textView);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int sec = seconds % 60;

                String time = String.format(Locale.getDefault(),
                                             "%02d:%02d:%02d",
                                                    hours,minutes,sec);

                timeView.setText(time);

                if(running){
                    seconds ++;
                }

                handler.postDelayed(this, 1000);

            }
        });
    }
}