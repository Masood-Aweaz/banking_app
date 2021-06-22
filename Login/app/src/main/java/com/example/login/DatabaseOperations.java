package com.example.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.google.android.material.tabs.TabLayout;

public class DatabaseOperations extends SQLiteOpenHelper {

    public static final int database_version = 1;
    public String CREATE_QUERY = " CREATE TABLE "+TableData.TableInfo.TABLE_NAME+"("+TableData.TableInfo.ACCOUNT_NUMBER+" TEXT,"+TableData.TableInfo.PASSWORD+" TEXT,"+ TableData.TableInfo.TRANSACTION_PASSWORD+" TEXT,"+TableData.TableInfo.BALANCE+" TEXT );";

    public DatabaseOperations(@Nullable Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations","Database Created");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_QUERY);
        Log.d("Database Operations","Table Created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void putInformation(DatabaseOperations dop,String accno,String pass,String tpass,String balance){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.ACCOUNT_NUMBER,accno);
        cv.put(TableData.TableInfo.PASSWORD,pass);
        cv.put(TableData.TableInfo.TRANSACTION_PASSWORD,tpass);
        cv.put(TableData.TableInfo.BALANCE,balance);

        long k = SQ.insert(TableData.TableInfo.TABLE_NAME,null,cv);
        Log.d("Database Operations","One row Inserted");
    }

    public Cursor getInformation(DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] columns = {TableData.TableInfo.ACCOUNT_NUMBER, TableData.TableInfo.PASSWORD, TableData.TableInfo.TRANSACTION_PASSWORD, TableData.TableInfo.BALANCE};
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME,columns,null,null,null,null,null);
        return CR;

    }

    public boolean updateData(DatabaseOperations dop,String acc,String pass,String tpass,String bal){
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.ACCOUNT_NUMBER,acc);
        cv.put(TableData.TableInfo.PASSWORD,pass);
        cv.put(TableData.TableInfo.TRANSACTION_PASSWORD,tpass);
        cv.put(TableData.TableInfo.BALANCE,bal);
        SQ.update(TableData.TableInfo.TABLE_NAME,cv,"acc = ?",new String[] { bal });
        return true;
    }
}
