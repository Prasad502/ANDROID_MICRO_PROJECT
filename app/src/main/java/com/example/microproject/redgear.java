package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.widget.EditText;

public class redgear extends AppCompatActivity
{
    EditText Name,MobileNumber,Username,Password;
    signupdb helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rsignup);

        Name = findViewById(R.id.editText);
        MobileNumber = findViewById(R.id.editText1);
        Username = findViewById(R.id.editText2);
        Password = findViewById(R.id.editText3);

        helper = new signupdb(this);
    }
        public void AddUser(View v)
        {
            String t1 = Name.getText().toString();
            String t2 = MobileNumber.getText().toString();
            String t3 = Username.getText().toString();
            String t4 = Password.getText().toString();
            if (t1.equals("") || t2.equals("") || t3.equals("") || t4.equals(""))
            {
                message.message(getApplicationContext(),"Please Enter all details");
            }
            else {
                long id = helper.insertData(t1, t2, t3, t4);
                if (id <= 0) {
                    message.message(getApplicationContext(), "Registration Unsuccessful");
                    Name.setText("");
                    MobileNumber.setText("");
                    Username.setText("");
                    Password.setText("");
                } else {
                    message.message(getApplicationContext(), "Registration Successful");
                    Name.setText("");
                    MobileNumber.setText("");
                    Username.setText("");
                    Password.setText("");
                }
            }
        }



    public void login(View v)
    {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
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
