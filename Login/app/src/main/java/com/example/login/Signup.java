package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.nfc.tech.NfcA;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    EditText ACCOUNT_NO,PASSWORD,CPASSWORD,BANK_ID,BAL,TRANS,CTRANS;
    Button signup;
    String account_no,pass,cpass,id,trans,ctrans;
    String bala;
    Context ctx = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ACCOUNT_NO = (EditText)findViewById(R.id.su1);
        PASSWORD = (EditText)findViewById(R.id.su2);
        CPASSWORD = (EditText)findViewById(R.id.su3);
        BANK_ID = (EditText)findViewById(R.id.su4);
        TRANS = (EditText)findViewById(R.id.su7);
        CTRANS = (EditText)findViewById(R.id.su8);
        BAL = (EditText)findViewById(R.id.su5);
        signup = (Button)findViewById(R.id.b3);
        //admin = (Button)findViewById(R.id.b4);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                account_no = ACCOUNT_NO.getText().toString();
                pass = PASSWORD.getText().toString();
                cpass = CPASSWORD.getText().toString();
                id = BANK_ID.getText().toString();
                trans = TRANS.getText().toString();
                ctrans = CTRANS.getText().toString();
                bala = BAL.getText().toString();

                if((!pass.equals(cpass))||(!trans.equals(ctrans))){
                    Toast.makeText(getBaseContext(),"Passwords not matching",Toast.LENGTH_LONG).show();
                    ACCOUNT_NO.setText("");
                    PASSWORD.setText("");
                    CPASSWORD.setText("");
                    BANK_ID.setText("");
                    BAL.setText("");
                    TRANS.setText("");
                    CTRANS.setText("");
                }
                else
                {
                    if(id.contentEquals("abcd1234")) {
                        DatabaseOperations DB = new DatabaseOperations(ctx);
                        DB.putInformation(DB,account_no,pass,trans,bala);
                        Toast.makeText(getBaseContext(), "Registration Sucessfull", Toast.LENGTH_LONG).show();
                        finish();
                    }
                    else
                    {
                        Toast.makeText(getBaseContext(), "Invalid Bank ID Visit the Bank", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

    }
}