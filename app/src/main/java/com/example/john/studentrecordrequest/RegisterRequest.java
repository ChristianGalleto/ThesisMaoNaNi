package com.example.john.studentrecordrequest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by John on 1/30/2017.
 */

public class RegisterRequest extends StringRequest {

    private static final String REGISTER_REQUEST_URL = "http://wishart.esy.es/Register.php";
    private Map<String, String> params;

    public RegisterRequest(String firstname, String middlename, String lastname, String username, String password, String email, String status, String account, Response.Listener<String> listener) {
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("firstname", firstname) ;
        params.put("middlename", middlename) ;
        params.put("lastname", lastname) ;
        params.put("username", username);
        params.put("password", password);
        params.put("email", email) ;
        params.put("status", status) ;
        params.put("account", account);

    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}