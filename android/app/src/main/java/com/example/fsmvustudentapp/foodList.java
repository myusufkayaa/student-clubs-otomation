package com.example.fsmvustudentapp;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import de.codecrafters.tableview.TableView;
import de.codecrafters.tableview.listeners.TableDataClickListener;
import de.codecrafters.tableview.toolkit.SimpleTableDataAdapter;
import de.codecrafters.tableview.toolkit.SimpleTableHeaderAdapter;

public class foodList extends AppCompatActivity {

    static ArrayList<Foods> arrayOfFoods = new ArrayList<>();
    String[] spaceProbeHolders = {"Tarih","Çorba","Ana Yemek1","Ana Yemek2","Ana Yemek3","Meze","Aperatif"};
    String[][] spaceProbes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
                  super.onCreate(savedInstanceState);
           setContentView(R.layout.activity_food_list);
           getRates();
            final TableView<String[]> tb = findViewById(R.id.tableView);
            fillTheTable();
            tb.setHeaderAdapter(new SimpleTableHeaderAdapter(this, spaceProbeHolders));
            tb.setDataAdapter(new SimpleTableDataAdapter(this, spaceProbes));
            tb.addDataClickListener(new TableDataClickListener<String[]>() {
                @Override
                public void onDataClicked(int rowIndex, String[] clickedData) {
                    Toast.makeText(foodList.this, ((String[])clickedData)[1], Toast.LENGTH_SHORT).show();
                }
            });

        }

    public void getRates (){
        downloadData dD = new downloadData();
        try {
            String url = "https://sheets.googleapis.com/v4/spreadsheets/1kgxnFxb9pOkPvKHMAqsMFbh5LrMYTrftUKyJQuBkR1o/values/yemekhane?key=AIzaSyDaIfxBmmFG875woD1RuKYugqCy5ZWMF48";

            dD.execute(url);
        }catch (Exception e){

        }
    }
    private void fillTheTable(){
        spaceProbes = new String[arrayOfFoods.size()][7];

        for (int i=0;i<arrayOfFoods.size();i++){
            Foods s = arrayOfFoods.get(i);
            spaceProbes[i][0] = s.getDay();
            spaceProbes[i][1] = s.getSoup();
            spaceProbes[i][2] = s.getMain_course();
            spaceProbes[i][3] = s.getMain_course2();
            spaceProbes[i][4] = s.getMain_course3();
            spaceProbes[i][5] = s.getMeze();
            spaceProbes[i][6] = s.getAperitif();

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
