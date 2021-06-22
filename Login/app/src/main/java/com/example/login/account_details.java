package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class account_details extends AppCompatActivity {

    TextView ad,accn,pas,tpas,bal;
    EditText no,pasd,tpasd,baln;
    String accss,pass,tpass,ba;
    Context ctx2 = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_details);

        ad = (TextView)findViewById(R.id.ad1);
        accn = (TextView)findViewById(R.id.ad2);
        pas = (TextView)findViewById(R.id.ad4);
        tpas = (TextView)findViewById(R.id.ad6);
        bal = (TextView)findViewById(R.id.ad8);
        no = (EditText)findViewById(R.id.ad3);
        pasd = (EditText)findViewById(R.id.ad5);
        tpasd = (EditText)findViewById(R.id.ad7);
        baln = (EditText)findViewById(R.id.ad9);

        Intent i2 = getIntent();
        accss = i2.getStringExtra("Account_No");
        no.setText(accss);
        DatabaseOperations DOP2 = new DatabaseOperations(ctx2);
        Cursor CR2 = DOP2.getInformation(DOP2);
        CR2.moveToFirst();
        do{
            if(accss.equals(CR2.getString(0))){
                pass=CR2.getString(1);
                tpass=CR2.getString(2);
                ba=CR2.getString(3);
            }
        }while(CR2.moveToNext());
        pasd.setText(pass);
        tpasd.setText(tpass);
        baln.setText(ba);





    }
}