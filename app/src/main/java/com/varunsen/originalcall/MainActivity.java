package com.varunsen.originalcall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView callerName;
    ImageButton endCall;
    MediaPlayer mediaPlayer, mediaPlayer2, mediaPlayer3;
    ImageView speaker, hold, addCall;
    Chronometer chronometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "Press speaker, hold and then add call.", Toast.LENGTH_LONG).show();

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.hello_bro);
        mediaPlayer2 = MediaPlayer.create(getApplicationContext(), R.raw.call_hold);
        mediaPlayer3 = MediaPlayer.create(getApplicationContext(), R.raw.stereo_heatrs);

        callerName = findViewById(R.id.caller_name);
        addCall = findViewById(R.id.add_call);
        hold = findViewById(R.id.call_hold);
        endCall = findViewById(R.id.end_call);
        speaker = findViewById(R.id.speaker);
        chronometer = findViewById(R.id.chronometer);

      chronometer.start();

      addCall.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mediaPlayer3.start();
          }
      });

      hold.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              mediaPlayer2.start();
          }
      });

        endCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

            }
        });

        speaker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer3.isPlaying()){
                    mediaPlayer3.stop();
                    mediaPlayer.start();
                } else{
                    mediaPlayer.start();
                }
            }
        });

        Intent i = getIntent();
        String text = i.getStringExtra ( "Answer" );
        callerName.setText(text);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
}