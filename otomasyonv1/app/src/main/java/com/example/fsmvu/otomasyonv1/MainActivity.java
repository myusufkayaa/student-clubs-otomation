package com.example.fsmvu.otomasyonv1;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bnw= findViewById(R.id.bottom_navigation);
        bnw.setOnNavigationItemReselectedListener(navListenner);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();
        downloadData dD = new downloadData();
        try {
            String url = "https://sheets.googleapis.com/v4/spreadsheets/1kgxnFxb9pOkPvKHMAqsMFbh5LrMYTrftUKyJQuBkR1o/values/yemekhane?key=AIzaSyDaIfxBmmFG875woD1RuKYugqCy5ZWMF48";
            dD.execute(url);



        }catch (Exception e){

        }



    }
    BottomNavigationView.OnNavigationItemReselectedListener navListenner= new BottomNavigationView.OnNavigationItemReselectedListener() {
        @Override
        public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment=null;
            switch (menuItem.getItemId()){
                case R.id.navigation_home:
                    selectedFragment=new HomeFragment();
                    break;
                case R.id.navigation_food:
                    selectedFragment=new FoodFragment();
                    break;

            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,selectedFragment).commit();


        }
    };
    private class downloadData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result;
            URL url;
            HttpsURLConnection httpsURLConnection;

            try {
                url = new URL(strings[0]);

                httpsURLConnection = (HttpsURLConnection) url.openConnection();
                InputStream iS = httpsURLConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(iS));
                StringBuilder sb = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null){
                    sb.append(line+ "\n");
                }
                iS.close();
                result=sb.toString();

            }
            catch (Exception e){

                return null;
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray foods = jsonObject.getJSONArray("values");
                for (int i=1; i<foods.length(); i++){
                    JSONArray json_food = foods.getJSONArray(i);
                    Foods row = new Foods(json_food.getString(0),json_food.getString(1),json_food.getString(2),
                            json_food.getString(3),json_food.getString(4),json_food.getString(5),json_food.getString(6));
                    Foods.arrayOfFoods.add(row);
                }
            }
            catch (Exception e){

            }
        }
    }

}
