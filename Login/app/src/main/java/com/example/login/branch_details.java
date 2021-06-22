package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class branch_details extends AppCompatActivity {

    TextView b1,b2,b3,b4,b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_branch_details);

        b1 = (TextView)findViewById(R.id.bd1);
        b2 = (TextView)findViewById(R.id.bd2);
        b3 = (TextView)findViewById(R.id.bd3);
        b4 = (TextView)findViewById(R.id.bd4);
        b5 = (TextView)findViewById(R.id.bd5);
    }
}