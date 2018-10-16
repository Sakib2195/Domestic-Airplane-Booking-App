package com.example.sakib.domesticair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class airlplaneList extends AppCompatActivity {

    ListView nop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airlplane_list);
        final String route=getIntent().getExtras().getString("route");
        nop = (ListView) findViewById(R.id.listView2);
        String[] values = new String[]{"Biman Bangladesh Airlines Ltd. ",
                "Regent Airways ",
                "United Airways",
                "GMG Airlines"



        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);


        // Assign adapter to ListView
        nop.setAdapter(adapter);



        nop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Intent i = new Intent(airlplaneList.this, login.class);
                        i.putExtra("route",route);
                        i.putExtra("planename","0");
                        startActivity(i);
                        break;
                    case 1:
                        Intent b = new Intent(airlplaneList.this, login.class);
                        b.putExtra("route", route);
                        b.putExtra("planename", "1");
                        startActivity(b);
                        break;


                    case 2:
                        Intent a = new Intent(airlplaneList.this, login.class);
                        a.putExtra("route",route);
                        a.putExtra("planename","2");
                        startActivity(a);

                        break;


                    case 3:
                        Intent j = new Intent(airlplaneList.this, login.class);
                        j.putExtra("route",route);
                        j.putExtra("planename","3");
                        startActivity(j);
                        break;


                }
            }
        });

    }
}
