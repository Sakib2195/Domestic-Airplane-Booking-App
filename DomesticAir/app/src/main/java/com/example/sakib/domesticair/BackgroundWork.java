package com.example.sakib.domesticair;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;


/**
 * Created by Sakib on 8/6/2016.
 */
public class BackgroundWork extends AsyncTask<String,Void,String>{

    Context ctx;
    String json="";
    String result="";
    String test="";

    public  BackgroundWork(Context ctx){
        this.ctx=ctx;
    }

    @Override
    protected String doInBackground(String... params) {

        String submitUrl="http://chowdhurysakib.info/android/putReview.php";
        String reviewUrl="http://chowdhurysakib.info/android/show_review.php";

        String metthod=params[0];

        if(metthod.equals("submit")){

            String name=params[1];
            String feedback=params[2];
            String airplaneName=params[3];

            try {
                URL url=new URL(submitUrl);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bf=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(name,"UTF-8");
                data +="&"+URLEncoder.encode("feedback","UTF-8")+"="+URLEncoder.encode(feedback,"UTF-8");
                //Toast.makeText(ctx,hotelName+"",Toast.LENGTH_LONG).show();
                data +="&"+URLEncoder.encode("airplaneName","UTF-8")+"="+URLEncoder.encode(airplaneName,"UTF-8");


                bf.write(data);
                bf.flush();
                bf.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();
                return "success";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else  if(metthod.equals("showReview")){

            String airplaneName=params[1];
            //test=hotelName;
            try {
                URL url=new URL(reviewUrl);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bf=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("name","UTF-8")+"="+URLEncoder.encode(airplaneName,"UTF-8");
                bf.write(data);
                bf.flush();
                bf.close();
                InputStream inputStream= httpURLConnection.getInputStream();
                BufferedReader bufferedReader= new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder= new StringBuilder();
                while((json=bufferedReader.readLine())!=null){
                    stringBuilder.append(json + "\n");
                    test+=json;
                    bufferedReader.close();
                    inputStream.close();
                    httpURLConnection.disconnect();
                    return stringBuilder.toString().trim();

                }
                // test=hotelName;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }else if(metthod.equals("booking")){
            String bookingUrl="http://chowdhurysakib.info/android/booking.php";
            String from=params[1];
            String to=params[2];
            String cabin=params[3];
            String ticketNo=params[4];
            String journeyDate=params[5];
            String totalCost=params[6];
            try {
                URL url=new URL(bookingUrl);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bf=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data= URLEncoder.encode("from", "UTF-8")+"="+URLEncoder.encode(from,"UTF-8");
                data +="&"+URLEncoder.encode("to","UTF-8")+"="+URLEncoder.encode(to,"UTF-8");
                data +="&"+URLEncoder.encode("cabin","UTF-8")+"="+URLEncoder.encode(cabin,"UTF-8");
                data +="&"+URLEncoder.encode("journyDate","UTF-8")+"="+URLEncoder.encode(journeyDate,"UTF-8");
                //Toast.makeText(ctx,hotelName+"",Toast.LENGTH_LONG).show();
                data +="&"+URLEncoder.encode("orderNumber","UTF-8")+"="+URLEncoder.encode(ticketNo,"UTF-8");
                data +="&"+URLEncoder.encode("totalCost","UTF-8")+"="+URLEncoder.encode(totalCost,"UTF-8");


                bf.write(data);
                bf.flush();
                bf.close();
                os.close();
                InputStream is=httpURLConnection.getInputStream();
                is.close();


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "success";
        }
        return null;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        if(s.equals("success")){
            Toast.makeText(ctx,"review posted",Toast.LENGTH_LONG).show();

        }
        else {

            result=test;
            Intent i=new Intent(ctx,ShowReview.class);
            i.putExtra("json_data",result);
            ctx.startActivity(i);
        }
        //super.onPostExecute(s);
    }
}

