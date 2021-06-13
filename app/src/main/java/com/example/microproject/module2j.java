package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class module2j extends AppCompatActivity {
    RadioButton genderradioButton;
    RadioGroup radioGroup;
    EditText mobilenumber,serviceprovider,amount;
    maindb helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recharge);
        mobilenumber = findViewById(R.id.editText2);
        serviceprovider = findViewById(R.id.editText3);
        amount = findViewById(R.id.editText4);
        radioGroup=(RadioGroup)findViewById(R.id.radioGroup);
        helper = new maindb(this);
    }

    public void recharge(View v)
    {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat mdformat = new SimpleDateFormat("HH:mm:ss");
        String strTime = mdformat.format(calendar.getTime());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
        String currentDate = sdf.format(new Date());

        int selectedId = radioGroup.getCheckedRadioButtonId();
        genderradioButton = (RadioButton) findViewById(selectedId);
        String t1 = mobilenumber.getText().toString();
        String t2 = serviceprovider.getText().toString();
        String t3 = amount.getText().toString();
        if (t1.equals("") || t2.equals("") || t3.equals("") || currentDate.equals("") || strTime.equals(""))
        {
            message.message(getApplicationContext(),"Please Enter all details");
        }
        else {
            Boolean data = helper.update(t1,strTime,currentDate,t3);
            if (data == true)
            {
                message.message(getApplicationContext(), "Recharge successfully");
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
    public void insta(View V)
    {
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
