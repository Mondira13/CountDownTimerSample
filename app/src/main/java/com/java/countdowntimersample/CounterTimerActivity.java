package com.java.countdowntimersample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

public class CounterTimerActivity extends AppCompatActivity {

    TextView timer1;
    TextView timer2;
    TextView timer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_timer);
        timer1 = findViewById(R.id.timer1);
        timer2 = findViewById(R.id.timer2);
        timer3 = findViewById(R.id.timer3);

        startTimerSecondWise();
        startTimerHourMinuteSecondWise();
        startTimerDayHourMinuteSecondWise();

    }


    public void startTimerSecondWise() {
        final String val;
        new CountDownTimer(30000, 1000) {

            public void onTick(long millisUntilFinished) {
                timer1.setText("Seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                timer1.setText("done!");
            }
        }.start();

    }

    public void startTimerHourMinuteSecondWise() {
        new CountDownTimer(7200000, 1000) {

            @Override

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d",
                        (TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis))),
                        (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))),
                        (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));

                timer2.setText(hms);//set text
            }

            @Override

            public void onFinish() {
                /*clearing all fields and displaying countdown finished message          */

                timer2.setText("Count down completed");
            }
        }.start();
    }

    public void startTimerDayHourMinuteSecondWise() {
        new CountDownTimer(172800000, 1000) {
            @Override

            public void onTick(long millisUntilFinished) {
                long millis = millisUntilFinished;
                String hms = String.format("%02d:%02d:%02d:%02d",
                        TimeUnit.HOURS.toDays(TimeUnit.MILLISECONDS.toHours(millis)),
                        (TimeUnit.MILLISECONDS.toHours(millis) - TimeUnit.DAYS.toHours(TimeUnit.MILLISECONDS.toDays(millis))),
                        (TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis))),
                        (TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))));

                timer3.setText(hms);//set text
            }

            @Override

            public void onFinish() {
                /*clearing all fields and displaying countdown finished message          */
                timer3.setText("Count down completed");
            }
        }.start();
    }


//    *****************************************Timing Equation******************************************

//    1 hr = 3600000 MiliSeconds
//    24 hr = 86400000 MiliSeconds
//    48 hr = 172800000 MiliSeconds

}