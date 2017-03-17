package com.example.john.studentrecordrequest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RequestList_Registrar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_list__registrar);

        final Button button20 = (Button) findViewById(R.id.button20);
        final Button button19 = (Button) findViewById(R.id.button19);
        final Button button8 = (Button) findViewById(R.id.button8);

        button20.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent Pending1Intent = new Intent(RequestList_Registrar.this, Pending_Registrar.class);
                RequestList_Registrar.this.startActivity(Pending1Intent);
            }
        });
        button19.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent ServedIntent = new Intent(RequestList_Registrar.this, Reserved_Registrar.class);
                RequestList_Registrar.this.startActivity(ServedIntent);
            }
        });  button8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent ClaimedIntent = new Intent(RequestList_Registrar.this, Claimed_Registrar.class);
                RequestList_Registrar.this.startActivity(ClaimedIntent);
            }
        });
    }}
