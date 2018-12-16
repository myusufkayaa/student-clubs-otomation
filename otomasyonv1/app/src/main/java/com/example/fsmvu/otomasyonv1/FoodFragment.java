package com.example.fsmvu.otomasyonv1;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FoodFragment extends Fragment {
    Date today=new Date();
    DateFormat df= new SimpleDateFormat("dd.MM.yyyy");
    DateFormat day=new SimpleDateFormat("dd");
    TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.fragment_food, container, false);
        textView=view.findViewById(R.id.textView);

        textView.setText(Foods.arrayOfFoods.get(0).soup+"\n"+Foods.arrayOfFoods.get(0).main_course);





       return view;
    }
}