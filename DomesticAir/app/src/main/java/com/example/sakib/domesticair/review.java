package com.example.sakib.domesticair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class review extends AppCompatActivity {

    Button btnSubmit,btnShowReview;
    EditText etUsername,etFeedback;
    String airplane="gmg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        airplane=getIntent().getExtras().getString("airplaneName");

        btnShowReview= (Button) findViewById(R.id.btnShowReview);
        btnSubmit= (Button) findViewById(R.id.btnSubmitReview);
        etUsername= (EditText) findViewById(R.id.etName);
        etFeedback= (EditText) findViewById(R.id.etReview);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name=etUsername.getText().toString();
                String review=etFeedback.getText().toString();
               //String hotelName=hotel;
                String method="submit";
                Toast.makeText(review.this,airplane,Toast.LENGTH_LONG)
                        .show();
                BackgroundWork backgroundWork=new BackgroundWork(review.this);
                backgroundWork.execute(method,name,review,airplane);
                etUsername.setText("");
                etFeedback.setText("");
            }
        });

        btnShowReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String method="showReview";
                //Toast.makeText(Review.this,method,Toast.LENGTH_LONG).show();
                String hotelName=airplane;
                BackgroundWork backgroundWork=new BackgroundWork(review.this);
                backgroundWork.execute(method, hotelName);

            }
        });

    }
}
