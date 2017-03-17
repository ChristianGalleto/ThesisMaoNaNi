package com.example.john.studentrecordrequest;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Wishart on 3/8/2017.
 */

public class CurrentEmail extends StringRequest {
    private static final String CURRENT_EMAIL_URL = "http://wishart.esy.es/currentemail.php";
    private Map<String, String> params;

    public CurrentEmail(String email_add, String name_requester, String u_name, String p_word, Response.Listener<String> listener) {
        super(Request.Method.POST, CURRENT_EMAIL_URL, listener, null);
        params = new HashMap<>();

        params.put("email_add", email_add) ;
        params.put("name_requester", name_requester) ;
        params.put("u_name", u_name) ;
        params.put("p_word", p_word) ;

    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}