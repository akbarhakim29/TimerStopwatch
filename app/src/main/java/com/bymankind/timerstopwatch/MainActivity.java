package com.bymankind.timerstopwatch;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    TextView tvTime;
    CountDownTimer timer;
    Button btnStart,btnPause, btnReset;
    long seconds = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTime = (TextView) findViewById(R.id.tvTime);


        timer = new CountDownTimer(seconds*1000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                tvTime.setText((millisUntilFinished/1000)+"");                      // untuk waktu hitungan mundur
             //   tvTime.setText(((seconds*1000 - millisUntilFinished)/1000)+"");   // untuk waktu hitungan maju
            }

            @Override
            public void onFinish() {
                tvTime.setText("END TIME !");
            }
        };
        tvTime.setText("Begin Time!");
    }

    public void start(View view){
        timer.start();
    }

    public void pause(View view){
        timer.cancel();
    }

    public void reset(View view){
        finish();
        startActivity(getIntent());
    }



    /*public class CountDownT extends CountDownTimer{
        public CountDownT(long InMilliSeconds, long TimeGap){
            super(InMilliSeconds,TimeGap);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            tvTime.setText((millisUntilFinished/1000)+"");
        }

        @Override
        public void onFinish() {
            tvTime.setText("END TIME !");
        }
    }*/
}
