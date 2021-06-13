package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.widget.EditText;

public class module1j extends AppCompatActivity
{
    EditText mobilenumber,cardnumber,cvv,expiry,amount;
    maindb helper;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addmoney);

        mobilenumber = findViewById(R.id.editText);
        cardnumber = findViewById(R.id.editText1);
        cvv = findViewById(R.id.editText2);
        expiry = findViewById(R.id.editText3);
        amount = findViewById(R.id.editText4);
        helper = new maindb(this);
    }

    public void addmoney(View v)
    {
        String t1 = mobilenumber.getText().toString();
        String t2 = cardnumber.getText().toString();
        String t3 = cvv.getText().toString();
        String t4 = expiry.getText().toString();
        String t5 = amount.getText().toString();
        String t6 = "";

        if (t1.equals("") || t2.equals("") || t3.equals("") || t4.equals("") || t5.equals(""))
        {
            message.message(getApplicationContext(),"Please Enter all details");
        }else
        {
            Boolean data = helper.insertData(t1,t2,t3,t4,t5,t6);
            if (data == true)
            {
                message.message(getApplicationContext(), "Money Added successfully");
                backtohome();
            }
            else
            {
                message.message(getApplicationContext(), "Some error occured");
            }
        }
    }

    public void facebook(View v)
    {
        Uri uri = Uri.parse("https://www.facebook.com/prasad.labde.54");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void twitter(View v)
    {
        Uri uri = Uri.parse("https://twitter.com/prasad_labade");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void insta(View V) {
        Uri uri = Uri.parse("https://www.instagram.com/the_cartoongram/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
    public void backtohome()
    {
        Intent intent = new Intent(this, dashboardj.class);
        startActivity(intent);
    }
}
