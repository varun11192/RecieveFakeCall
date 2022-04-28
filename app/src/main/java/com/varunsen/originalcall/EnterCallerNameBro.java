package com.varunsen.originalcall;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EnterCallerNameBro extends AppCompatActivity {

    EditText callerNameEt;
    Button getCallBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_caller_name_bro);

        getCallBtn = findViewById(R.id.get_call_btn);
        callerNameEt = findViewById(R.id.et_caller_name);

        getCallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), CallRecieve.class);
                intent.putExtra ( "TextBox", callerNameEt.getText().toString() );
                startActivity(intent);
                finish();

            }
        });

    }
}