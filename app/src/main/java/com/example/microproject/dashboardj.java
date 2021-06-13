package com.example.microproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;

public class dashboardj extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
    }

    public void addMoney(View v)
    {
        Intent intent = new Intent(this, module1j.class);
        startActivity(intent);
    }

    public void Recharge(View v)
    {
        Intent intent = new Intent(this, module2j.class);
        startActivity(intent);
    }

    public void checkbalance(View v)
    {
        Intent intent = new Intent(this, module3j.class);
        startActivity(intent);
    }

    public void logout(View v)
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
