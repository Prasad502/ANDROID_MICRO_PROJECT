package com.example.microproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class maindb {
    maindb.myDbHelper myhelper;
    public maindb(Context context) {
        myhelper = new myDbHelper(context);
    }
    public Boolean insertData(String mobilenumber,String cardnumber,String cvv, String expiry,String amount,String nul)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.MOBILENUMBER, mobilenumber);
        contentValues.put(myDbHelper.CARDNUMBER, cardnumber);
        contentValues.put(myDbHelper.CVV, cvv);
        contentValues.put(myDbHelper.EXPIRY, expiry);
        contentValues.put(myDbHelper.AMOUNT, amount);
        contentValues.put(myDbHelper.TRANSACTION_DATE, nul);
        contentValues.put(myDbHelper.TRANSACTION_TIME, nul);
        long id = dbb.insert(maindb.myDbHelper.TABLE_NAME, null , contentValues);
        return true;
    }

    public Boolean update(String mobilenumber , String time ,String date, String amount)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        String x = getAmount(mobilenumber);
        int y = Integer.parseInt(x);
        int z = Integer.parseInt(amount);
        int a = y-z;
        contentValues.put(myDbHelper.AMOUNT,a);
        contentValues.put(myDbHelper.TRANSACTION_TIME,time);
        contentValues.put(myDbHelper.TRANSACTION_DATE,date);
        String[] whereArgs= {mobilenumber};
        int count =db.update(maindb.myDbHelper.TABLE_NAME,contentValues, myDbHelper.MOBILENUMBER+" = ?",whereArgs );
        return true;
    }

    public String getAmount(String mobilenumber)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.AMOUNT};
        String[] whereArgs= {mobilenumber};
        Cursor cursor =db.query(maindb.myDbHelper.TABLE_NAME,columns,myhelper.MOBILENUMBER+" = ? " , whereArgs ,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        String oldamount = "";
        while (cursor.moveToNext())
        {
            oldamount = cursor.getString(cursor.getColumnIndex(myDbHelper.AMOUNT));
        }
        return oldamount;
    }

    public ArrayList<String> getDetails(String mobilenumber)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.AMOUNT,myDbHelper.TRANSACTION_TIME,myDbHelper.TRANSACTION_DATE};
        String[] whereArgs= {mobilenumber};
        Cursor cursor =db.query(maindb.myDbHelper.TABLE_NAME,columns,myhelper.MOBILENUMBER+" = ? " , whereArgs,null,null,null,null);
        StringBuffer buffer= new StringBuffer();
        ArrayList<String> datalist = new ArrayList<String>();
        while (cursor.moveToNext())
        {
            String amount = cursor.getString(cursor.getColumnIndex(myDbHelper.AMOUNT));
            datalist.add(amount);
            String date = cursor.getString(cursor.getColumnIndex(myDbHelper.TRANSACTION_DATE));
            datalist.add(date);
            String time = cursor.getString(cursor.getColumnIndex(myDbHelper.TRANSACTION_TIME));
            datalist.add(time);
        }
        return datalist;
    }


    static class myDbHelper extends SQLiteOpenHelper {
        private static final String DATABASE_NAME = "ProjectDatabase";    // Database Name
        private static final String TABLE_NAME = "maindb";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID = "_id";     // Column I (Primary Key)
        private static final String MOBILENUMBER = "MobileNumber";    //Column III
        private static final String CARDNUMBER = "CardNumber";    //Column II
        private static final String CVV = "CVV";    //Column II
        private static final String EXPIRY = "Expiry";    // Column III
        private static final String AMOUNT = "Amount";    // Column
        private static final String TRANSACTION_TIME = "Transaction_time";    // Column III
        private static final String TRANSACTION_DATE = "Transaction_date";    // Column III
        private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
                " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + MOBILENUMBER + " VARCHAR(255) ," + CARDNUMBER + " VARCHAR(255)," + CVV + " VARCHAR(255)," + EXPIRY + " VARCHAR(225)," + AMOUNT + " VARCHAR(255)," + TRANSACTION_DATE + " VARCHAR(225) , " + TRANSACTION_TIME + " VARCHAR(225))";
        private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context = context;
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                message.message(context, "" + e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                message.message(context, "OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            } catch (Exception e) {
                message.message(context, "" + e);
            }
        }
    }
}
