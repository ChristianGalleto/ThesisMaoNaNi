package com.example.john.studentrecordrequest;


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

public class User_Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__settings);

        final EditText etUsername = (EditText) findViewById(R.id.user);
        final EditText etPassword = (EditText) findViewById(R.id.pass);
        final Button change = (Button) findViewById(R.id.change);




        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {


                                Intent intent = new Intent(User_Settings.this, LogIn.class);


                                User_Settings.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(User_Settings.this);
                                builder.setMessage("Account Not Found!")
                                        .setNegativeButton("Retry!", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };


                UserSettingsRequest userSettingsRequest = new UserSettingsRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(User_Settings.this);
                queue.add(userSettingsRequest);

            }
        });

    }}

