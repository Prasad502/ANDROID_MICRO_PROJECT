package com.example.microproject;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class signupdb {
    myDbHelper myhelper;
    public signupdb(Context context)
    {
        myhelper = new myDbHelper(context);
    }
    public long insertData(String name,String mobile,String usern, String pass)
    {
        SQLiteDatabase dbb = myhelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(myDbHelper.NAME, name);
        contentValues.put(myDbHelper.MOBILENUMBER, mobile);
        contentValues.put(myDbHelper.USERNAME, usern);
        contentValues.put(myDbHelper.PASSWORD, pass);
        long id = dbb.insert(myDbHelper.TABLE_NAME, null , contentValues);
        return id;
    }


    public Boolean getData(String usern,String pass)
    {
        SQLiteDatabase db = myhelper.getWritableDatabase();
        String[] columns = {myDbHelper.UID,myDbHelper.NAME,myDbHelper.MOBILENUMBER,myDbHelper.USERNAME,myDbHelper.PASSWORD};
        Cursor cursor = db.rawQuery("select * from signupd where UserName = ? and Password = ?",new String[]{usern,pass});
        if (cursor.getCount() > 0)
        {
            return true;
        }else
        {
            return false;
        }
    }




    static class myDbHelper extends SQLiteOpenHelper
    {
        private static final String DATABASE_NAME = "signupdetails";    // Database Name
        private static final String TABLE_NAME = "signupd";   // Table Name
        private static final int DATABASE_Version = 1;    // Database Version
        private static final String UID="_id";     // Column I (Primary Key)
        private static final String NAME = "Name";    //Column II
        private static final String MOBILENUMBER = "MobileNumber";    //Column III
        private static final String USERNAME = "UserName";    //Column II
        private static final String PASSWORD= "Password";    // Column III
        private static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME+
                " ("+UID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255) ,"+MOBILENUMBER+" VARCHAR(255),"+USERNAME+" VARCHAR(255),"+ PASSWORD+" VARCHAR(225));";
        private static final String DROP_TABLE ="DROP TABLE IF EXISTS "+TABLE_NAME;
        private Context context;

        public myDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_Version);
            this.context=context;
        }

        public void onCreate(SQLiteDatabase db) {

            try {
                db.execSQL(CREATE_TABLE);
            } catch (Exception e) {
                message.message(context,""+e);
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            try {
                message.message(context,"OnUpgrade");
                db.execSQL(DROP_TABLE);
                onCreate(db);
            }catch (Exception e) {
                message.message(context,""+e);
            }
        }
    }
}