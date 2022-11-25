package com.i191980_i192200.a3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Home extends AppCompatActivity {
    String senderID = "3";
    String receiverID = "2";
    RecyclerView rv;
    MyAdapter adapter;
    List<MyChat> ls;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        rv=findViewById(R.id.chatrv);
        RecyclerView.LayoutManager lm=new LinearLayoutManager(Home.this);
        ls=new ArrayList<>();
        adapter=new MyAdapter(Home.this,ls);
        rv.setAdapter(adapter);
        rv.setLayoutManager(lm);
//        GettingMessages();
    }

    @Override
    public void onResume() {
        super.onResume();
        String uri = String.format("http://192.168.10.2/a3/getmsgs.php?senderID=%1$s&receiverID=%2$s",senderID,receiverID);
        RequestQueue queue= Volley.newRequestQueue(Home.this);
        StringRequest request=new StringRequest( Request.Method.GET, uri, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject obj=new JSONObject(response);
                            if(obj.getInt("code")==1)
                            {
                                Toast.makeText(Home.this,"Successfull",Toast.LENGTH_LONG).show();
                                JSONArray messages=obj.getJSONArray("message");
                                for (int i=0; i<messages.length();i++)
                                {
                                    JSONObject message=messages.getJSONObject(i);
                                    ls.add(new MyChat(message.getString("msg"),message.getString("senderID"),message.getString("receiverID")));
                                    adapter.notifyDataSetChanged();
                                }

                            }
                            else{
                                Toast.makeText(Home.this,"UnSuccessfull:(",Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Home.this,"Error Connecting Server",Toast.LENGTH_LONG).show();
                    }
                });

        queue.add(request);
    }

}