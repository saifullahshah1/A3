package com.i191980_i192200.a3;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class SignIn extends AppCompatActivity {

    Button signinBtn,signupBtn;
    EditText password,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signin);

        signinBtn = findViewById(R.id.signinbtn);
        signupBtn = findViewById(R.id.signupbtn);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(SignIn.this, SignUp.class);
                startActivity(intent1);
            }
        });

        signinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn_Ftn();
            }
        });
    }
    private void SignIn_Ftn(){
        String url ="http://192.168.10.2/a3/signin.php";
        RequestQueue requestqueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("signin ok")){
                    Toast.makeText(getApplicationContext(),"SignIn Successful", Toast.LENGTH_LONG).show();

                    Intent intent=new Intent(SignIn.this, Home.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(),"SignIn Failed", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error " + error.toString(), Toast.LENGTH_LONG).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<>();
                params.put("email", email.getText().toString().trim());
                params.put("password", password.getText().toString().trim());

                return params;
            }
        };
        requestqueue.add(stringRequest);
    }
}
