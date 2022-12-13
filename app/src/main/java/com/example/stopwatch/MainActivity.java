package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    Chronometer chronometer;
    Button start, pause, restart;

    long pauseOffset;
    boolean isrunning = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chronometer = findViewById(R.id.chronometer);
        start = findViewById(R.id.start);
        pause = findViewById(R.id.pause);
        restart = findViewById(R.id.restart);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isrunning){
                    chronometer.setBase(SystemClock.elapsedRealtime() - pauseOffset);
                    chronometer.start();
                    isrunning = true;
                }
            }
        });

        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isrunning){
                    chronometer.stop();
                    pauseOffset = SystemClock.elapsedRealtime() - chronometer.getBase();
                    isrunning = false;
                }
            }
        });


        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chronometer.setBase((SystemClock.elapsedRealtime()));
                pauseOffset = 0;
            }
        });


    }
}