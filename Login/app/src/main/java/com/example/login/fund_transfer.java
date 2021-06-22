package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class fund_transfer extends AppCompatActivity {

    EditText acc,amt,tpas;
    TextView ft;
    Button send;
    Context ctx = this;
    Context ctx1 = this;
    String racc,rbal,bal,sacc,sbal,td;
    String saccount_no,spass,strans,raccount_no,rpass,rtrans;
    int irbal,iamt,isbal,success;
    Boolean x,y;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fund_transfer);

        ft = (TextView)findViewById(R.id.ft1);
        acc = (EditText)findViewById(R.id.ft2);
        amt = (EditText)findViewById(R.id.ft3);
        tpas = (EditText)findViewById(R.id.ft5);
        send = (Button)findViewById(R.id.ft4);

        //racc = acc.getText().toString();
        //bal = amt.getText().toString();
        DatabaseOperations DOP = new DatabaseOperations(ctx);
        Cursor CR = DOP.getInformation(DOP);
        DatabaseOperations DOP1 = new DatabaseOperations(ctx1);
        Cursor CR1 = DOP1.getInformation(DOP1);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                racc = acc.getText().toString();
                bal = amt.getText().toString();
                td = tpas.getText().toString();
                iamt = Integer.parseInt(bal);

                Intent i2 = getIntent();
                sacc = i2.getStringExtra("Account_No");



                CR.moveToFirst();
                while (CR.moveToNext()) {
                    if (sacc.equals(CR.getString(0))) {
                        //racc=racc;
                        saccount_no = CR.getString(0);
                        spass = CR.getString(1);
                        strans = CR.getString(2);
                        sbal = CR.getString(3);
                        success=1;
                    }
                }

                //Toast.makeText(getBaseContext(),"Wrong",Toast.LENGTH_LONG).show();
                if(strans.equals(td)) {
                    isbal = Integer.parseInt(sbal);
                    int nisbal = isbal - iamt;
                    sbal = String.valueOf(nisbal);
                    Toast.makeText(getBaseContext(),"Transaction Successfull",Toast.LENGTH_LONG).show();
                    y = DOP.updateData(DOP, saccount_no, spass, strans, sbal);

                    }
                else
                {
                    Toast.makeText(getBaseContext(),"Wrong Transaction Password",Toast.LENGTH_LONG).show();
                    tpas.setText("");
                }


                CR1.moveToFirst();
                while (CR1.moveToNext()) {
                    if (racc.equals(CR1.getString(0))) {
                        //racc = racc;
                        raccount_no = CR1.getString(0);
                        rpass = CR1.getString(1);
                        rtrans = CR1.getString(2);
                        rbal = CR1.getString(3);
                    }
                }


                    //if (rbal.equals("")) {
                    //  Toast.makeText(getBaseContext(), "No such account exists", Toast.LENGTH_LONG);
                    //} else {
                if(racc.equals(CR1.getString(0))) {
                    irbal = Integer.parseInt(rbal);
                    //iamt = Integer.parseInt(bal);
                    int nirbal = irbal + iamt;
                    rbal = String.valueOf(nirbal);
                    x = DOP1.updateData(DOP1, raccount_no, rpass, rtrans, rbal);
                }
                //}

                /*DatabaseOperations DOP2 = new DatabaseOperations(ctx);
                Cursor CR2 = DOP2.getInformation(DOP2);
                CR2.moveToFirst();
                while (CR2.moveToNext()) {
                    if (racc.equals(CR2.getString(1))) {
                        account_no = CR2.getString(0);
                        pass = CR2.getString(1);
                        trans = CR2.getColumnName(2);
                        //DatabaseOperations DB = new DatabaseOperations(ctx);
                        //x = DOP2.updateData(DOP2, account_no, pass, trans, rbal);
                        //DOP2.putInformation(DOP2,account_no,pass,trans,rbal);
                    }
                }
                x = DOP2.updateData(DOP2, account_no, pass, trans, rbal);

                DatabaseOperations DOP3 = new DatabaseOperations(ctx);
                Cursor CR3 = DOP3.getInformation(DOP3);
                CR3.moveToFirst();
                while (CR3.moveToNext()) {
                    if (sacc.equals(CR3.getString(1))) {
                        account_no = CR3.getString(0);
                        pass = CR3.getString(1);
                        trans = CR3.getColumnName(2);
                        //DatabaseOperations DB = new DatabaseOperations(ctx);
                        //y = DOP3.updateData(DOP3, account_no, pass, trans, sbal);
                        //DOP3.putInformation(DOP3,account_no,pass,trans,rbal);
                    }
                }
                y = DOP3.updateData(DOP3, account_no, pass, trans, sbal);
                //}

                 */



                if(x==true&&y==true)
                {
                    Toast.makeText(getBaseContext(),"Money Sent",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getBaseContext(),"Transaction Error",Toast.LENGTH_LONG).show();
                }
                //Intent i = new Intent(fund_transfer.this,Home.class);
                //i.putExtra("Account_Number", sacc);
                //finish();
                //startActivity(i);


            }
        });
    }}


