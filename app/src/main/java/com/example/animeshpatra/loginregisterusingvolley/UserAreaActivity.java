package com.example.animeshpatra.loginregisterusingvolley;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class UserAreaActivity extends AppCompatActivity {
    private EditText et_FirstName, et_LastName, et_Address, et_PhoneNo, et_Email;
    private TextView tv_welcomeMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);
        et_FirstName = (EditText) findViewById(R.id.et_Name);
        et_LastName = (EditText) findViewById(R.id.et_LastName);
        et_Address = (EditText) findViewById(R.id.et_Address);
        et_PhoneNo = (EditText) findViewById(R.id.et_PhoneNo);
        et_Email = (EditText) findViewById(R.id.et_Email);
        tv_welcomeMsg = (TextView) findViewById(R.id.tv_welcomeMsg);

        Intent intent = getIntent();
        String firstName = intent.getStringExtra("FName");
        String lastName = intent.getStringExtra("LName");
        String address = intent.getStringExtra("Address");
        String phoneno = intent.getStringExtra("PhNo");
        String email = intent.getStringExtra("Email");
        String username = intent.getStringExtra("Username");

        String message = username + "Welcome to your area :)";
        tv_welcomeMsg.setText(message);
        et_FirstName.setText(firstName);
        et_LastName.setText(lastName);
        et_Address.setText(address);
        et_PhoneNo.setText(phoneno);
        et_Email.setText(email);

    }
}
