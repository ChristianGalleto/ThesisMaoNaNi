package com.example.john.studentrecordrequest;

import android.app.ProgressDialog;
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

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);


        final Button verify = (Button) findViewById(R.id.verify);

        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText firstname1 = (EditText) findViewById(R.id.firstname);
                final EditText middlename1 = (EditText) findViewById(R.id.middlename);
                final EditText lastname1 = (EditText) findViewById(R.id.lastname);

                final String firstname = firstname1.getText().toString();
                final String middlename = middlename1.getText().toString();
                final String lastname = lastname1.getText().toString();

                final ProgressDialog progressDialog = new ProgressDialog(ForgotPassword.this);
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

                                String firstname = jsonResponse.getString("firstname");
                                String middlename = jsonResponse.getString("middlename");
                                String lastname = jsonResponse.getString("lastname");
                                String username = jsonResponse.getString("username");
                                String password = jsonResponse.getString("password");
                                String email = jsonResponse.getString("email");
                                String status = jsonResponse.getString("status");
                                String account = jsonResponse.getString("account");

                                Intent intent = new Intent(ForgotPassword.this, Email.class);

                                intent.putExtra("firstname", firstname );
                                intent.putExtra("middlename", middlename );
                                intent.putExtra("lastname", lastname );
                                intent.putExtra("username", username );
                                intent.putExtra("password", password );
                                intent.putExtra("email", email );
                                intent.putExtra("status", status );
                                intent.putExtra("account", account );

                                ForgotPassword.this.startActivity(intent);


                            } else {

                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {

                                                progressDialog.dismiss();
                                            }
                                        }, 3000);

                                AlertDialog.Builder builder = new AlertDialog.Builder(ForgotPassword.this);
                                builder.setMessage("You are not Registered! Please see the Registrar!")
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };


                AccountRequest accountRequest = new AccountRequest(firstname, middlename, lastname, responseListener);
                RequestQueue queue = Volley.newRequestQueue(ForgotPassword.this);
                queue.add(accountRequest);

            }
        });

    }
}
