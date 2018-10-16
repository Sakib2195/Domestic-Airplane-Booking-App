package com.example.sakib.domesticair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserView extends AppCompatActivity {
    Button MyDb,PreReg,SS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_view);
        final String route=getIntent().getExtras().getString("route");
        final String planename=getIntent().getExtras().getString("planename");


        MyDb=(Button)findViewById(R.id.button);
        PreReg=(Button)findViewById(R.id.button2);
        SS=(Button)findViewById(R.id.button3);
        //PostReg=(Button)findViewById(R.id.button4);

        MyDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserView.this, MyDashboard.class);
                startActivity(i);
            }
        });


        SS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserView.this, SeatStatus.class);
                startActivity(i);
            }
        });

        PreReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserView.this, PreReg.class);
                i.putExtra("route",route);
                i.putExtra("planename",planename);
                startActivity(i);
            }
        });



    }
}
