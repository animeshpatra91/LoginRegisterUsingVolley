package com.example.animeshpatra.loginregisterusingvolley;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ANIMESH PATRA on 21-05-2017.
 */

public class RegisterRequest extends StringRequest {
    public static final String REGISTER_REQUEST_URL = "http://220.225.80.177/drbookingapp/bookingapp.asmx/UserRegistration";
    private Map<String, String> params;

    public RegisterRequest(String fname, String lname, String username, String password, String address, String phoneno, String email, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("fname", fname);
        params.put("lname", lname);
        params.put("username", username);
        params.put("pwd", password);
        params.put("address", address);
        params.put("phoneno", phoneno);
        params.put("email", email);
    }
    public Map<String, String> getParams(){
        return params;
    }
}
