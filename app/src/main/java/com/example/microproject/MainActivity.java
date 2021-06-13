package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
        EditText username ,password;
        signupdb helper;
        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            username = findViewById(R.id.editText);
            password = findViewById(R.id.editText2);
            helper = new signupdb(this);
        }

        public void checklogin(View v)
        {
            String t1 = username.getText().toString();
            String t2 = password.getText().toString();
            if (t1.equals("") || t2.equals(""))
            {
                message.message(getApplicationContext(),"Invalid Credentials");
            }
            else {
                boolean data = helper.getData(t1, t2);
                if (data == true)
                {
                    message.message(getApplicationContext(),"Login Successfull");
                    dash();
                }else
                {
                    message.message(getApplicationContext(),"Login Failed");
                }
            }

        }

    public void signup(View v)
    {
        Intent intent = new Intent(this, redgear.class);
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
    public void dash()
    {
        Intent intent = new Intent(this, dashboardj.class);
        startActivity(intent);
    }

}