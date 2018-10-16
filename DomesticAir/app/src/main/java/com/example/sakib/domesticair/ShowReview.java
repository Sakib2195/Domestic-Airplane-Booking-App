package com.example.sakib.domesticair;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class ShowReview extends AppCompatActivity {

    String jsonString,targetString;
    ArrayList<String> arrayList;
    ArrayAdapter<String>arrayAdapter;
    JSONArray jsonArray;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_review);

        jsonString=getIntent().getExtras().getString("json_data");
        Toast.makeText(this,jsonString,Toast.LENGTH_LONG).show();

//        if(jsonString!=null){
//            Toast.makeText(this,jsonString,Toast.LENGTH_LONG).show();
//        }else {
//            Toast.makeText(this,"moiraja",Toast.LENGTH_LONG).show();
//        }
        lv= (ListView) findViewById(R.id.listView3);
        arrayList=new ArrayList<String>();
        arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        lv.setAdapter(arrayAdapter);
       // arrayList.add("tada");
        try {

//            JSONObject m_jobj;
//            try {
//                m_jobj = new JSONObject(jsonString);
//                Toast.makeText(this,"moiraja5",Toast.LENGTH_LONG).show();
//                JSONArray m_ja = m_jobj.getJSONArray("server_response");
//                Toast.makeText(this,"moirajasakibR",Toast.LENGTH_LONG).show();
//                for (int i = 0; i < m_ja.length(); i++)
//                {
//                    JSONObject m_obj = m_ja.getJSONObject(i);
//                    String city=m_obj.getString("name");
//                    String cityName=m_obj.getString("feedback");
//                    //And so on get all the values.
//                }

            JSONObject jo=new JSONObject(jsonString);
            jsonArray=jo.getJSONArray("server_response");
            //arrayList.add("tada2");

            int count=0;
            String name,feedback;
            while (count<jsonArray.length()){
                JSONObject jsonObject=jsonArray.getJSONObject(count);
                name=jsonObject.getString("name");
                feedback=jsonObject.getString("feedback");

                arrayList.add("User Name:" + name + " \nFeedback: " + feedback);
                arrayAdapter.notifyDataSetChanged();count++;

            }

           // arrayList.add("hi");
        } catch (JSONException e) {
            String er=""+e;
            Toast.makeText(ShowReview.this,er,Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }

    }
}
