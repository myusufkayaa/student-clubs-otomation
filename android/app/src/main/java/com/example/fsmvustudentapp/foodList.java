package com.example.fsmvustudentapp;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;


public class foodList extends Fragment {

    static ArrayList<Foods> arrayOfFoods = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_food_list, container, false);
    }

    public void getRates (){
        downloadData dD = new downloadData();
        try {
            String url = "https://sheets.googleapis.com/v4/spreadsheets/1kgxnFxb9pOkPvKHMAqsMFbh5LrMYTrftUKyJQuBkR1o/values/yemekhane?key=AIzaSyDaIfxBmmFG875woD1RuKYugqCy5ZWMF48";
            dD.execute(url);
        }catch (Exception e){

        }
    }

    private class downloadData extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String result = "";
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
                        arrayOfFoods.add(row);
                }
            }
            catch (Exception e){

            }
        }
    }
}
