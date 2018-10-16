package com.example.sakib.domesticair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
public class routes extends AppCompatActivity {
    ListView plane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routes);

        plane = (ListView) findViewById(R.id.listView);
        String[] values = new String[]{"Dhaka - Chittagong ",
                "Dhaka - Sylhet ",
                "Dhaka - CoxsBazar",
                "Dhaka - Barisal",
                "Dhaka - Jessore",
                "Dhaka - Saidpur",
                "Dhaka - Rajshahi"


        };


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        plane.setAdapter(adapter);


        plane.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(routes.this, airlplaneList.class);
                        i.putExtra("route","0");
                        startActivity(i);
                        break;
                    case 1:
                        Intent b = new Intent(routes.this, airlplaneList.class);
                        b.putExtra("route", "1");
                        startActivity(b);
                        break;


                    case 2:
                        Intent a = new Intent(routes.this, airlplaneList.class);
                        a.putExtra("route","2");
                        startActivity(a);
                        break;


                    case 3:
                        Intent j = new Intent(routes.this, airlplaneList.class);
                        j.putExtra("route", "3");

                        startActivity(j);
                        break;

                    case 4:
                        Intent k = new Intent(routes.this, airlplaneList.class);
                        k.putExtra("route", "4");
                        startActivity(k);
                        break;
                    case 5:
                        Intent e = new Intent(routes.this, airlplaneList.class);
                        e.putExtra("route", "5");
                        startActivity(e);
                        break;

                    case 6:
                        Intent l = new Intent(routes.this, airlplaneList.class);
                        l.putExtra("route","6");
                        startActivity(l);
                        break;
                }
            }
        });

    }
}
