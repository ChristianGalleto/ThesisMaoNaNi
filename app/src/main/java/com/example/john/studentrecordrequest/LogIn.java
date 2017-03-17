package com.example.john.studentrecordrequest;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;



public class LogIn extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        final Button bLogin = (Button) findViewById(R.id.bLogin);
        final TextView UserHome = (TextView) findViewById(R.id.forgot);
        context = this;
final ImageView up2 = (ImageView) findViewById(R.id.up);


        up2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                final Dialog dialog = new Dialog(context);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setCancelable(false);
                dialog.setCanceledOnTouchOutside(false);
                dialog.setContentView(R.layout.steps);

                TextView tvSampleText = (TextView) dialog.findViewById(R.id.custom_dialog_tv_text);


                Button btnDone = (Button) dialog.findViewById(R.id.custom_dialog_btn_done);

                btnDone.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });


        UserHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(LogIn.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Loading...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();

                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 3000);





                Intent HomeIntent = new Intent(LogIn.this, ForgotPassword.class);



                LogIn.this.startActivity(HomeIntent);
            }
        });


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText etUsername = (EditText) findViewById(R.id.etUsername);
                final EditText etPassword = (EditText) findViewById(R.id.etPassword);

                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();

                final ProgressDialog progressDialog = new ProgressDialog(LogIn.this);
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


                                String firstname = jsonResponse.getString("firstname");
                                String middlename = jsonResponse.getString("middlename");
                                String lastname = jsonResponse.getString("lastname");
                                String username = jsonResponse.getString("username");
                                String password = jsonResponse.getString("password");
                                String email = jsonResponse.getString("email");
                                String status = jsonResponse.getString("status");
                                String account = jsonResponse.getString("account");


                                if (account.toString().equals("Registrar")){

                                    new android.os.Handler().postDelayed(
                                            new Runnable() {
                                                public void run() {

                                                    progressDialog.dismiss();
                                                }
                                            }, 3000);

                                    Intent intent = new Intent(LogIn.this, Home_Registrar.class);

                                    intent.putExtra("firstname", firstname );
                                    intent.putExtra("middlename", middlename );
                                    intent.putExtra("lastname", lastname );
                                    intent.putExtra("username", username );
                                    intent.putExtra("password", password );
                                    intent.putExtra("email", email );
                                    intent.putExtra("status", status );
                                    intent.putExtra("account", account );


                                    LogIn.this.startActivity(intent);
                                }

                                else if (account.toString().equals("Cashier")){

                                    new android.os.Handler().postDelayed(
                                            new Runnable() {
                                                public void run() {

                                                    progressDialog.dismiss();
                                                }
                                            }, 3000);

                                    Intent intent = new Intent(LogIn.this, Home_Cashier.class);

                                    intent.putExtra("firstname", firstname );
                                    intent.putExtra("middlename", middlename );
                                    intent.putExtra("lastname", lastname );
                                    intent.putExtra("username", username );
                                    intent.putExtra("password", password );
                                    intent.putExtra("email", email );
                                    intent.putExtra("status", status );
                                    intent.putExtra("account", account );


                                    LogIn.this.startActivity(intent);

                                }
                                else{

                                    new android.os.Handler().postDelayed(
                                            new Runnable() {
                                                public void run() {

                                                    progressDialog.dismiss();
                                                }
                                            }, 3000);

                                    Intent intent = new Intent(LogIn.this, Home_User.class);

                                    intent.putExtra("firstname", firstname );
                                    intent.putExtra("middlename", middlename );
                                    intent.putExtra("lastname", lastname );
                                    intent.putExtra("username", username );
                                    intent.putExtra("password", password );
                                    intent.putExtra("email", email );
                                    intent.putExtra("status", status );
                                    intent.putExtra("account", account );


                                    LogIn.this.startActivity(intent);


                                }


                            } else {

                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {

                                                progressDialog.dismiss();
                                            }
                                        }, 3000);

                                AlertDialog.Builder builder = new AlertDialog.Builder(LogIn.this);
                                builder.setMessage("Wrong Credentials")
                                        .setNegativeButton("Retry!", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                };


                LoginRequest loginRequest = new LoginRequest(username, password, responseListener);
                RequestQueue queue = Volley.newRequestQueue(LogIn.this);
                queue.add(loginRequest);

            }
        });
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Exit?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                finish();

                dialog.dismiss();
            }
        });

        builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Do nothing
                dialog.dismiss();
            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }}

