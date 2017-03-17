package com.example.john.studentrecordrequest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;



public class AccountRequest extends StringRequest {
    private static final String ACCOUNT_REQUEST_URL = "http://wishart.esy.es/forgot.php";
    private Map<String, String> params;

    public AccountRequest (String firstname, String middlename, String lastname, Response.Listener<String> listener){
        super (Method.POST, ACCOUNT_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstname", firstname);
        params.put("middlename", middlename);
        params.put("lastname", lastname);
    }

    @Override
    public Map<String, String> getParams() {return params;}
}
