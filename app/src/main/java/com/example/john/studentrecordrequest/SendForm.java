package com.example.john.studentrecordrequest;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by John on 2/1/2017.
 */

public class SendForm extends StringRequest {

    private static final String SEND_FORM_URL = "http://wishart.esy.es/Request.php";
    private Map<String, String> params;

    public SendForm(String filename, int mobile , String address, String payment, String requester, Response.Listener<String> listener) {
        super(Method.POST, SEND_FORM_URL, listener, null);
        params = new HashMap<>();
        params.put("filename", filename) ;
        params.put("mobile", mobile + "") ;
        params.put("address", address) ;
        params.put("payment", payment);
        params.put("requester", requester);



    }

    @Override
    public Map<String, String> getParams() {

        return params;
    }
}

