package com.example.john.studentrecordrequest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final TextView completename = (TextView) findViewById(R.id.completename);
        final TextView uname= (TextView) findViewById(R.id.uname);
        final TextView upass = (TextView) findViewById(R.id.upass);
        final TextView uemail = (TextView) findViewById(R.id.uemail);
        final TextView ustatus = (TextView) findViewById(R.id.ustatus);
        final Button uchange1 = (Button) findViewById(R.id.uchange1);
        final Button uchange2 = (Button) findViewById(R.id.uchange2);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("firstname");
        String middlename = intent.getStringExtra("middlename");
        String lastname = intent.getStringExtra("lastname");
        String username = intent.getStringExtra("username");
        String password = intent.getStringExtra("password");
        String email = intent.getStringExtra("email");
        String status = intent.getStringExtra("status");


        String user = firstname + " " + middlename + " " + lastname;
        completename.setText(user);
        uname.setText(username);
        upass.setText(password);
        uemail.setText(email);
        ustatus.setText(status);

        uchange1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Profile.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();


                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 3000);

                Intent i = new Intent(Profile.this, User_Settings.class);
                Profile.this.startActivity(i);
            }
        });

        uchange2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Profile.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();


                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 3000);

                Intent i = new Intent(Profile.this, ChangeEmail.class);
                Profile.this.startActivity(i);
            }
        });

    }
}
