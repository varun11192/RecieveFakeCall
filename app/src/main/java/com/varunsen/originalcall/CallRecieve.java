package com.varunsen.originalcall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class CallRecieve extends AppCompatActivity {

    ImageView answerCall, declineCall;
    TextView incomingCaller;
    Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ongoing_call);

        incomingCaller = findViewById(R.id.incoming_caller);
        answerCall = findViewById(R.id.answer_call);
        declineCall = findViewById(R.id.decline_call);

        animation = AnimationUtils.loadAnimation(this, R.anim.shake);
        answerCall.setAnimation(animation);
        declineCall.setAnimation(animation);

        answerCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                intent.putExtra ( "Answer", incomingCaller.getText().toString() );
                startActivity(intent);
                finish();
            }
        });

        declineCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Intent i = getIntent();
        String text = i.getStringExtra ( "TextBox" );
        incomingCaller.setText(text);

    }
}