package com.example.sakib.domesticair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class booking extends AppCompatActivity {

    ListView book;
    //String airplane="gmg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_booking);

        book = (ListView) findViewById(R.id.listView3);
        String[] values = new String[]{"Biman Bangladesh Airlines Ltd. ",
                "Regent Airways ",
                "United Airways",
                "GMG Airlines"



        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        book.setAdapter(adapter);




        book.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(booking.this, review.class);
                        i.putExtra("airplaneName","Biman Bangladesh Ltd");
                        startActivity(i);

                        break;
                    case 1:
                        Intent b = new Intent(booking.this, review.class);
                        b.putExtra("airplaneName", "Regent Airways");
                        startActivity(b);
                        break;


                    case 2:
                        Intent a = new Intent(booking.this, review.class);
                        a.putExtra("airplaneName", "United Airways");

                        startActivity(a);
                        break;


                    case 3:
                        Intent j = new Intent(booking.this, review.class);
                        j.putExtra("airplaneName","GMG Airlines");

                        startActivity(j);
                        break;


                }
            }
        });

    }
}
