package com.example.animeshpatra.loginregisterusingvolley;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
    private EditText et_FirstName, et_LastName, et_UserName, et_Password, et_Address, et_PhoneNo,  et_Email;
    private Button btn_register;
    String msg, success;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        et_FirstName = (EditText) findViewById(R.id.et_FirstName);
        et_LastName = (EditText) findViewById(R.id.et_LastName);
        et_UserName = (EditText) findViewById(R.id.et_UserName);
        et_Password = (EditText) findViewById(R.id.et_Password);
        et_Address = (EditText) findViewById(R.id.et_Address);
        et_PhoneNo = (EditText) findViewById(R.id.et_PhoneNo);
        et_Email = (EditText) findViewById(R.id.et_Email);
        btn_register = (Button) findViewById(R.id.btn_Register);
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String firstName = et_FirstName.getText().toString();
                final String lastName = et_LastName.getText().toString();
                final String userName = et_UserName.getText().toString();
                final String password = et_Password.getText().toString();
                final String address = et_Address.getText().toString();
                final String phoneNo = et_PhoneNo.getText().toString();
                final String email = et_Email.getText().toString();
                Response.Listener<String> responseListener = new  Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            success = jsonResponse.getString("Sucess");
                            msg = jsonResponse.getString("Message");
                            if (success.equals("1")){
                                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            else {
                                AlertDialog.Builder dialog = new AlertDialog.Builder(RegisterActivity.this);
                                dialog.setMessage("Registration Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest registerRequest = new RegisterRequest(firstName, lastName, userName, password, address, phoneNo, email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);
            }
        });
    }
}
