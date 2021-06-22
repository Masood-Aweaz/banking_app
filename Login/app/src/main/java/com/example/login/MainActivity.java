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

public class MainActivity extends AppCompatActivity {

    EditText accno,pass;
    String acc,paswd,old_new="new";
    Button login,signup;
    TextView sign;
    Context ctx=this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = (Button)findViewById(R.id.b1);
        accno = (EditText)findViewById(R.id.e1);
        pass = (EditText)findViewById(R.id.p1);
        sign = (TextView)findViewById(R.id.s1) ;
        signup = (Button)findViewById(R.id.b2);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                acc = accno.getText().toString();
                paswd = pass.getText().toString();
                //old_new = old_new.toString();
                DatabaseOperations DOP = new DatabaseOperations(ctx);
                Cursor CR = DOP.getInformation(DOP);
                CR.moveToFirst();
                boolean login_status = false;
                String ACCNUMBER ="";
                /*do{
                    if(acc.equals(CR.getString(0))&&(paswd.equals(CR.getString(1))));
                    {
                        login_status = true;
                        ACCNUMBER = CR.getString(0);
                    }
                }while(CR.moveToNext());/*/
                while(CR.moveToNext())
                {
                    if(acc.equals(CR.getString(0))&&(paswd.equals(CR.getString(1))))
                    {
                        login_status = true;
                        ACCNUMBER = CR.getString(0);
                        break;
                    }
                }
                if((login_status==true))
                {
                    //if(paswd.equals(CR.getString(1)))
                    {
                        Toast.makeText(getBaseContext(), "Login Success-----\n Welcome " + ACCNUMBER, Toast.LENGTH_LONG).show();
                        Intent i = new Intent(MainActivity.this, Home.class);
                        i.putExtra("Account_Number", acc);
                        //i.putExtra("Balance_amount",CR.getString(3));
                        //finish();
                        startActivity(i);
                        //finish();
                    }
                    //else
                    //{
                      //  Toast.makeText(getBaseContext(),"Login Failed-----",Toast.LENGTH_LONG).show();
                    //}
                }
                else
                {
                    pass.setText("");
                    Toast.makeText(getBaseContext(),"Login Failed-----",Toast.LENGTH_LONG).show();
                    //finish();
                }


            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(MainActivity.this,Signup.class);
                //finish();
                startActivity(i);
            }
        });

    }
}