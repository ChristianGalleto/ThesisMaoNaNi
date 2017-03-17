package com.example.john.studentrecordrequest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by John on 2/13/2017.
 */

public class UserSettingsRequest extends StringRequest {
    private static final String USER_SETTINGS_REQUEST_URL = "http://wishart.esy.es/ChangePassword.php";
    private Map<String, String> params;

    public UserSettingsRequest (String username, String password, Response.Listener<String> listener){
        super (Method.POST, USER_SETTINGS_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
    }

    @Override
    public Map<String, String> getParams() {return params;}
}
