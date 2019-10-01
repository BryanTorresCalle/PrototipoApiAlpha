package com.example.api;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class one extends AppCompatActivity {

    Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        btnSkip = findViewById(R.id.btnSkip);

        btnSkip.setOnClickListener( o ->  startActivity(new Intent(getApplicationContext(), autentication.class)));



    }
}
