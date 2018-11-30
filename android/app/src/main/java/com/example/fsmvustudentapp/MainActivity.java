package com.example.fsmvustudentapp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void buttonPress(View v) {
        switch (v.getId()) {
            case R.id.button_yemek:
                Intent foodList = new Intent(this, foodList.class);
                startActivity(foodList);
                break;
            case R.id.button_kulup:
                Intent stuClubs = new Intent(this, stuClubs.class);
                startActivity(stuClubs);
                break;
            case R.id.button_etk:
                Intent cluEvents = new Intent(this, cluEvents.class);
                startActivity(cluEvents);
                break;
        }
    }

}
