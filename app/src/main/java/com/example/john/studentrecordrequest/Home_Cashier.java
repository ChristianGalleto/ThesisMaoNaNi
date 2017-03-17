package com.example.john.studentrecordrequest;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home_Cashier extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__cashier);

        //start here

        final Button button13 = (Button) findViewById(R.id.button13);
        final Button button14 = (Button) findViewById(R.id.button14);
        final Button button15 = (Button) findViewById(R.id.button15);
        final Button button16 = (Button) findViewById(R.id.button16);
        final TextView display2 = (TextView) findViewById(R.id.textView5);

        Intent intent = getIntent();
        String firstname = intent.getStringExtra("firstname");
        String middlename = intent.getStringExtra("middlename");
        String lastname = intent.getStringExtra("lastname");
        String account = intent.getStringExtra("account");

        String cashier = firstname + " " + middlename + " " + lastname + "\n" +  account;
        display2.setText(cashier);


        button13.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_Cashier.this);
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

                Intent Notif2Intent = new Intent(Home_Cashier.this, Notif_Cashier.class);
                Home_Cashier.this.startActivity(Notif2Intent);
            }
        });
        button14.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_Cashier.this);
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

                Intent PayIntent = new Intent(Home_Cashier.this, Payment_Cashier.class);
                Home_Cashier.this.startActivity(PayIntent);
            }
        });  button15.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_Cashier.this);
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

                Intent Set2Intent = new Intent(Home_Cashier.this, Settings_Cashier.class);
                Home_Cashier.this.startActivity(Set2Intent);
            }
        });  button16.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                final ProgressDialog progressDialog = new ProgressDialog(Home_Cashier.this);
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

                Intent Back2Intent = new Intent(Home_Cashier.this, LogIn.class);
                Home_Cashier.this.startActivity(Back2Intent);
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
