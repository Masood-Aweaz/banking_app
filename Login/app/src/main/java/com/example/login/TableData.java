package com.example.login;

import android.content.SyncRequest;
import android.provider.BaseColumns;

public class TableData {

    public TableData()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String ACCOUNT_NUMBER = "account_number";
        public static final String PASSWORD ="password";
        public static final String TRANSACTION_PASSWORD ="transaction_password";
        public static final String BALANCE = "balance";
        public static final String DATABASE_NAME = "account_info";
        public static final String TABLE_NAME = "reg_info";




    }
}
