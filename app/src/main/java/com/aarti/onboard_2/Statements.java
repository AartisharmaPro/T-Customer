package com.aarti.onboard_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class Statements extends AppCompatActivity {
ImageView back;
LinearLayout one;
LinearLayout statement_one;
    ViewGroup t_container;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statements);
        back=findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Statements.this,Wallet.class);
                startActivity(i);
            }
        });


        t_container=findViewById(R.id.t_c);
        one=findViewById(R.id.one);
        statement_one=findViewById(R.id.statement_one);

        one.setOnClickListener(new View.OnClickListener() {
            boolean visible;
            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(t_container);
                visible=!visible;
                statement_one.setVisibility(visible?View.VISIBLE:View.GONE);
            }
        });
    }
}