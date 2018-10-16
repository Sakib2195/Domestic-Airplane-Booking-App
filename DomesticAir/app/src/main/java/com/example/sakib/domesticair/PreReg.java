package com.example.sakib.domesticair;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


public class PreReg extends AppCompatActivity {
    CalendarView myCalendarView;
    TextView tv,tv2;
    Button sbmt;
    Spinner sp1,sp2,sp3,sp4;
    ArrayAdapter<CharSequence> adapter,adapter2,adapter3,adapter4;
    String source="";
    String destination="";
    String cabin="";
    int economyCost=0;
    int businessCost=0;
    int luxuryCost=0;
    int noOfpassenger=0;
    int totalCost=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pre_reg);

        final String route=getIntent().getExtras().getString("route");
        final String planename=getIntent().getExtras().getString("planename");

        Toast.makeText(getBaseContext(),route+ " halum "+planename, Toast.LENGTH_LONG).show();



        tv= (TextView) findViewById(R.id.fair);
        tv2= (TextView) findViewById(R.id.totalcost);
        sp1=(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this, R.array.Airport,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(adapter);


        if(route.equals("0")&& planename.equals("0")){
            economyCost=4000;
            businessCost=6000;
            luxuryCost=9000;
        }else if(route.equals("0")&& planename.equals("1") )
        {
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }else if(route.equals("0")&& planename.equals("2")){
            economyCost=4500;
            businessCost=6500;
            luxuryCost=8000;
        }else if(route.equals("0")&& planename.equals("3")){
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }



       else if(route.equals("1")&& planename.equals("0")){
            economyCost=4000;
            businessCost=6000;
            luxuryCost=9000;
        }else if(route.equals("1")&& planename.equals("1") )
        {
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }else if(route.equals("1")&& planename.equals("2")){
            economyCost=4500;
            businessCost=6500;
            luxuryCost=8000;
        }else if(route.equals("1")&& planename.equals("3")){
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }


         else if(route.equals("2")&& planename.equals("0")){
            economyCost=4000;
            businessCost=6000;
            luxuryCost=9000;
        }else if(route.equals("2")&& planename.equals("1") )
        {
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }else if(route.equals("2")&& planename.equals("2")){
            economyCost=4500;
            businessCost=6500;
            luxuryCost=8000;
        }else if(route.equals("2")&& planename.equals("3")){
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }
       else if(route.equals("3")&& planename.equals("0")){
            economyCost=4000;
            businessCost=6000;
            luxuryCost=9000;
        }else if(route.equals("3")&& planename.equals("1") )
        {
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }else if(route.equals("3")&& planename.equals("2")){
            economyCost=4500;
            businessCost=6500;
            luxuryCost=8000;
        }else if(route.equals("3")&& planename.equals("3")){
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }


        else if(route.equals("4")&& planename.equals("0")){
            economyCost=4000;
            businessCost=6000;
            luxuryCost=9000;
        }else if(route.equals("4")&& planename.equals("1") )
        {
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }else if(route.equals("4")&& planename.equals("2")){
            economyCost=4500;
            businessCost=6500;
            luxuryCost=8000;
        }else if(route.equals("4")&& planename.equals("3")){
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }
        else if(route.equals("5")&& planename.equals("0")){
            economyCost=4000;
            businessCost=6000;
            luxuryCost=9000;
        }else if(route.equals("5")&& planename.equals("1") )
        {
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }else if(route.equals("5")&& planename.equals("2")){
            economyCost=4500;
            businessCost=6500;
            luxuryCost=8000;
        }else if(route.equals("5")&& planename.equals("3")){
            economyCost=5000;
            businessCost=7000;
            luxuryCost=10000;
        }

        else if(route.equals("6")&& planename.equals("0")){
            economyCost = 4000;
            businessCost = 6000;
            luxuryCost = 9000;
        } else if (route.equals("6") && planename.equals("1")) {
            economyCost = 5000;
            businessCost = 7000;
            luxuryCost = 10000;
        } else if (route.equals("6") && planename.equals("2")) {
            economyCost = 4500;
            businessCost = 6500;
            luxuryCost = 8000;
        } else if (route.equals("6") && planename.equals("3")) {
            economyCost = 5000;
            businessCost=7000;
            luxuryCost=10000;
        }


        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();
                 source=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        sp2=(Spinner)findViewById(R.id.spinner2);
        adapter2=ArrayAdapter.createFromResource(this, R.array.Airport1,android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp2.setAdapter(adapter);
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               // Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + " is selected", Toast.LENGTH_LONG).show();

                destination=parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        myCalendarView = (CalendarView)findViewById(R.id.calendar);
        final int[] myDate = new int[4];
        myCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int dayOfMonth) {
                Toast.makeText(getApplicationContext(),
                        "Year: " + year + "\n" +
                                "Month: " + month + "\n" +
                                "Day of Month: " + dayOfMonth,
                        Toast.LENGTH_LONG).show();
                myDate[0] =year;
                myDate[1]=month;
                myDate[2]=dayOfMonth;
            }
        });

        sp3=(Spinner)findViewById(R.id.spinner3);
        adapter3=ArrayAdapter.createFromResource(this, R.array.choseClass,android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp3.setAdapter(adapter3);
        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();
                cabin=parent.getItemAtPosition(position).toString();
                if(cabin.equals("Economy")){
                    tv.setText("Cost per Ticket : "+economyCost);
                }else if(cabin.equals("Business")){
                    tv.setText("Cost per Ticket : "+businessCost);
                }else {
                    tv.setText("Cost per Ticket   : "+luxuryCost);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
//        String str=sp3.getSelectedItem().toString();
//        if(str.equals("Economy")){
//            tv.setText("Economy : 2000tk");
//        }else if(str.equals("Business")){
//            tv.setText("Business : 4000tk");
//        }else {
//            tv.setText("Luxury : 7000tk");
//        }

        sp4=(Spinner)findViewById(R.id.spinner4);
        adapter4=ArrayAdapter.createFromResource(this, R.array.Ticket,android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp4.setAdapter(adapter4);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
              //  Toast.makeText(getBaseContext(), parent.getItemAtPosition(position) + "is selected", Toast.LENGTH_LONG).show();
                String string=parent.getItemAtPosition(position).toString();
                noOfpassenger=Integer.parseInt(string);
                if(cabin.equals("Economy")){
                    totalCost=economyCost*noOfpassenger;
                    tv2.setText("Total cost : "+economyCost*noOfpassenger);
                }else if(cabin.equals("Business")){
                    tv2.setText("Total cost : "+businessCost*noOfpassenger);
                    totalCost=businessCost*noOfpassenger;
                }else {
                    tv2.setText("Total cost : "+luxuryCost*noOfpassenger);
                    totalCost=luxuryCost*noOfpassenger;
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        sbmt=(Button)findViewById(R.id.submitPreReg);

        sbmt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String from = sp1.getSelectedItem().toString();
                String to = sp2.getSelectedItem().toString();
                String cabin = sp3.getSelectedItem().toString();
                String ticketNo = sp4.getSelectedItem().toString();
                String journeyDate=myDate[2]+" / "+myDate[1]+" / "+myDate[0];
                Toast.makeText(PreReg.this,from+" "+to+" "+journeyDate,Toast.LENGTH_LONG).show();
                String method="booking";
                //Toast.makeText(Review.this,method,Toast.LENGTH_LONG).show();

                BackgroundWork backgroundWork=new BackgroundWork(PreReg.this);
                backgroundWork.execute(method, from,to,cabin,ticketNo,journeyDate,totalCost+"");
                Intent i = new Intent(PreReg.this, result.class);
                startActivity(i);
            }
        });

    }

}
