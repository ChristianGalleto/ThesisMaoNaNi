package com.example.john.studentrecordrequest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class Email extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email);

        final EditText emailValidate = (EditText) findViewById(R.id.currentemail);
        final Button sendit = (Button) findViewById(R.id.sendit);


        final Intent intent = getIntent();
        final String firstname = intent.getStringExtra("firstname");
        final String middlename = intent.getStringExtra("middlename");
        final String lastname = intent.getStringExtra("lastname");
        final String username = intent.getStringExtra("username");
        final String password = intent.getStringExtra("password");

        final String user = firstname + " " + middlename + " " + lastname;


        sendit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {


                final String email_add = emailValidate.getText().toString();
                final String name_requester = user;
                final String u_name = username;
                final String p_word = password;

                final ProgressDialog progressDialog = new ProgressDialog(Email.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Loading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();



                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {

                                                progressDialog.dismiss();
                                            }
                                        }, 3000);
                                Intent intent = new Intent(Email.this, LogIn.class);

                                Email.this.startActivity(intent);

                                AlertDialog.Builder builder = new AlertDialog.Builder(Email.this);
                                builder.setMessage("Please check your email within 24 hrs!")
                                        .create()
                                        .show();
                            } else {
                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {

                                                progressDialog.dismiss();
                                            }
                                        }, 3000);
                                AlertDialog.Builder builder = new AlertDialog.Builder(Email.this);
                                builder.setMessage("Fields must not be empty")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };

                CurrentEmail currentEmail = new CurrentEmail(email_add, name_requester, u_name, p_word, responseListener);
                RequestQueue queue = Volley.newRequestQueue(Email.this);
                queue.add(currentEmail);

            }
        });


    }
}



