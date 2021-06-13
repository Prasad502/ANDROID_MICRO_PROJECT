package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class module3j extends AppCompatActivity {
    EditText mobilenumber;
    TextView t2,t3,t4,t5;
    maindb helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkbalance);
        mobilenumber = findViewById(R.id.editText2);
        t2 = findViewById(R.id.textView2);
        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        helper = new maindb(this);
    }

    public void balance(View v)
    {
        String t1 = mobilenumber.getText().toString();
        if (t1.equals(""))
        {
            message.message(getApplicationContext(),"Please Enter Mobile Number");
        }
        else
        {
            ArrayList<String> data = helper.getDetails(t1);
            message.message(getApplicationContext(),"Data Retrieved");
            t2.setText("Mobile Number : " + t1);
            t3.setText("Amount in Wallet: "+ data.get(0));
            t4.setText("last Transaction Date : "+data.get(1));
            t5.setText("Last Transaction Time : "+data.get(2));
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
    public void insta(View V)
    {
        Uri uri = Uri.parse("https://www.instagram.com/the_cartoongram/");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
