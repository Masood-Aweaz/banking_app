package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    TextView home,welcome,acc,accno,bal,balno;
    String accs,bals,temp;
    int bali;
    Button accd,bd,upi,ft;
    Context ctx1=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home =(TextView)findViewById(R.id.e2);
        welcome =(TextView)findViewById(R.id.e3);
        acc =(TextView)findViewById(R.id.e4);
        accno =(TextView)findViewById(R.id.e6);
        bal =(TextView)findViewById(R.id.e5);
        balno =(TextView)findViewById(R.id.e7);

        accd = (Button)findViewById(R.id.e8);
        ft = (Button)findViewById(R.id.e9);
        bd = (Button)findViewById(R.id.e10);
        upi = (Button)findViewById(R.id.e11);


        Intent i = getIntent();
        accs = i.getStringExtra("Account_Number");
        temp=accs;
        //bali = i.getIntExtra("Balance_amount",0);
        //bals = String.valueOf(bali);
        //bals = i.getStringExtra("Balance_amount");
        accno.setText(accs);
        //balno.setText(String.valueOf(bals));
        //balno.setText(bals);

        DatabaseOperations DOP1 = new DatabaseOperations(ctx1);
        Cursor CR1 = DOP1.getInformation(DOP1);
        CR1.moveToFirst();
        do{
            if(accs.equals(CR1.getString(0))){
                bals=CR1.getString(3);
            }
        }while(CR1.moveToNext());
        balno.setText(bals);

        accd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,account_details.class);
                intent.putExtra("Account_No", temp);
                startActivity(intent);

            }

        });
        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,branch_details.class);
                startActivity(intent);
            }
        });

        ft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Home.this,fund_transfer.class);
                intent.putExtra("Account_No",temp);
                //finish();
                startActivity(intent);
            }
        });

        upi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"Contact your UPI Service provider for initiating this feature",Toast.LENGTH_LONG).show();
            }
        });

        //finish();



    }
}