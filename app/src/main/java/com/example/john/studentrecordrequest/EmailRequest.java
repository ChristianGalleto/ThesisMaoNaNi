package com.example.john.studentrecordrequest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wishart on 2/24/2017.
 */

public class EmailRequest extends StringRequest {
    private static final String EMAIL_REQUEST_URL = "http://wishart.esy.es/ChangeEmail.php";
    private Map<String, String> params;

    public EmailRequest (String username, String email, Response.Listener<String> listener){
        super (Method.POST, EMAIL_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("email", email);
    }

    @Override
    public Map<String, String> getParams() {return params;}
}

