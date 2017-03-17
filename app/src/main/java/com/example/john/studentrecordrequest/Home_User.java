package com.example.john.studentrecordrequest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Home_User extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__user);

        //start here

        final Button button2 = (Button) findViewById(R.id.button2);
        final Button button3 = (Button) findViewById(R.id.button3);
        final Button button4 = (Button) findViewById(R.id.button4);
        final Button button5 = (Button) findViewById(R.id.button5);
        final Button button6 = (Button) findViewById(R.id.button6);
        final Button button7 = (Button) findViewById(R.id.sendpayment);
        final TextView display1 = (TextView) findViewById(R.id.display);

        final Intent intent = getIntent();
        final String firstname = intent.getStringExtra("firstname");
        final String middlename = intent.getStringExtra("middlename");
        final String lastname = intent.getStringExtra("lastname");
        final String username = intent.getStringExtra("username");
        final String password = intent.getStringExtra("password");
        final String email = intent.getStringExtra("email");
        final String status = intent.getStringExtra("status");
        final String account = intent.getStringExtra("account");

        String user = firstname + " " + middlename + " " + lastname + "\n" +  status;
        display1.setText(user);


        button7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final ProgressDialog progressDialog = new ProgressDialog(Home_User.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();


                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 3000);


                Intent FormIntent = new Intent(Home_User.this, Image.class);
                Home_User.this.startActivity(FormIntent);
            }
        });

        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final ProgressDialog progressDialog = new ProgressDialog(Home_User.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();


                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 3000);


                Intent FormIntent = new Intent(Home_User.this, RequestForm.class);

                FormIntent.putExtra("firstname", firstname );
                FormIntent.putExtra("middlename", middlename );
                FormIntent.putExtra("lastname", lastname );
                FormIntent.putExtra("username", username );
                FormIntent.putExtra("password", password );
                FormIntent.putExtra("email", email );
                FormIntent.putExtra("status", status );
                FormIntent.putExtra("account", account );

                Home_User.this.startActivity(FormIntent);
            }
        });
        button3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_User.this);
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

                Intent NotifIntent = new Intent(Home_User.this, Notif_User.class);
                Home_User.this.startActivity(NotifIntent);
            }
        });  button4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_User.this);
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

                Intent DocIntent = new Intent(Home_User.this, List_User.class);
                Home_User.this.startActivity(DocIntent);
            }
        });


        button5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){


                final ProgressDialog progressDialog = new ProgressDialog(Home_User.this);
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


                    Intent SetIntent = new Intent(Home_User.this, Profile.class);
                SetIntent.putExtra("firstname", firstname );
                SetIntent.putExtra("middlename", middlename );
                SetIntent.putExtra("lastname", lastname );
                SetIntent.putExtra("username", username );
                SetIntent.putExtra("password", password );
                SetIntent.putExtra("email", email );
                SetIntent.putExtra("status", status );
                SetIntent.putExtra("account", account );



                Home_User.this.startActivity(SetIntent);
            }
        });  button6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_User.this);
                progressDialog.setIndeterminate(true);
                progressDialog.setMessage("Logging Out...");
                progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                progressDialog.show();


                new android.os.Handler().postDelayed(
                        new Runnable() {
                            public void run() {

                                progressDialog.dismiss();
                            }
                        }, 3000);


                Intent BackIntent = new Intent(Home_User.this, LogIn.class);
                Home_User.this.startActivity(BackIntent);
            }
        });
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("Logout?");

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
    }
}
