package com.aarti.onboard_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sign_up extends AppCompatActivity {
    Button mlog,msign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mlog=findViewById(R.id.LogBack);
        mlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(sign_up.this,Login.class);
                startActivity(i);
            }
        });

        msign=findViewById(R.id.signbutton);
        msign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(sign_up.this,Login.class);
                startActivity(i);
            }
        });

    }
}
