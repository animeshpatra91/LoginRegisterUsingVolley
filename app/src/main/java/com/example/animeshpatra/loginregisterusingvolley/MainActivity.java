package com.example.animeshpatra.loginregisterusingvolley;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et_UserName, et_password;
    private Button btn_login;
    private TextView registerLink;
    String success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_UserName = (EditText) findViewById(R.id.et_Name);
        et_password = (EditText) findViewById(R.id.et_Password);
        btn_login = (Button) findViewById(R.id.btn_Login);
        registerLink = (TextView) findViewById(R.id.tv_Register);
        registerLink.setOnClickListener(this);
        btn_login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == registerLink){
            Intent registerIntent = new Intent(MainActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        }
        if (v == btn_login){
            final String username = et_UserName.getText().toString();
            final String password = et_password.getText().toString();
            Response.Listener<String> responseListener = new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {
                        JSONObject jsonResponse = new JSONObject(response);
                        success = jsonResponse.getString("success");
                        if (success.equals("1")){
                            Intent intent = new Intent(MainActivity.this, UserAreaActivity.class);
                            startActivity(intent);
                        }
                        else {
                            AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                            dialog.setMessage("Login Failed")
                                    .setNegativeButton("Retry", null)
                                    .create()
                                    .show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            };
            LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
            RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
            queue.add(loginRequest);
        }
    }
}
