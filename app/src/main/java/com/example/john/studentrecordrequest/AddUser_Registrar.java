package com.example.john.studentrecordrequest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import static android.R.attr.button;

public class AddUser_Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user__registrar);

        final EditText firstname1 = (EditText) findViewById(R.id.firstname);
        final EditText middlename1 = (EditText) findViewById(R.id.middlename);
        final EditText lastname1 = (EditText) findViewById(R.id.lastname);
        final EditText username1 = (EditText) findViewById(R.id.username);
        final EditText password1 = (EditText) findViewById(R.id.password);
        final EditText email1 = (EditText) findViewById(R.id.email);
        final Spinner status1 = (Spinner) findViewById(R.id.status);
        final Spinner account1 = (Spinner) findViewById(R.id.account);
        final Button bRegister = (Button) findViewById(R.id.button24);

        Spinner c = (Spinner) findViewById(R.id.status);
        c.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        Spinner d = (Spinner) findViewById(R.id.account);

        d.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

                bRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    final String firstname = firstname1.getText().toString();
                    final String middlename = middlename1.getText().toString();
                    final String lastname = lastname1.getText().toString();
                    final String username = username1.getText().toString();
                    final String password = password1.getText().toString();
                    final String email = email1.getText().toString();
                    final String status = status1.getSelectedItem().toString();
                    final String account = account1.getSelectedItem().toString();

                final ProgressDialog progressDialog = new ProgressDialog(AddUser_Registrar.this);
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
                                Intent intent = new Intent(AddUser_Registrar.this, Home_Registrar.class);

                                AddUser_Registrar.this.startActivity(intent);
                            } else {
                                new android.os.Handler().postDelayed(
                                        new Runnable() {
                                            public void run() {

                                                progressDialog.dismiss();
                                            }
                                        }, 3000);
                                AlertDialog.Builder builder = new AlertDialog.Builder(AddUser_Registrar.this);
                                builder.setMessage("Register Failed!")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }

                };

                RegisterRequest registerRequest = new RegisterRequest(firstname, middlename, lastname, username, password, email, status, account, responseListener);
                RequestQueue queue = Volley.newRequestQueue(AddUser_Registrar.this);
                queue.add(registerRequest);
            }
        });

    }
}



