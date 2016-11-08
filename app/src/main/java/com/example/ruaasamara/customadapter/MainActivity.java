package com.example.ruaasamara.customadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<CellContent> cells;
    String[] urlStrings;
    String[] titles;
    String[] subTitles;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView)findViewById(R.id.listView);
        cells = new ArrayList<CellContent>();

        urlStrings =  getResources().getStringArray(R.array.urls);
        titles =  getResources().getStringArray(R.array.pics);
        subTitles =  getResources().getStringArray(R.array.subTitles);

        for (int i = 0; i < 10; i++ ){
           CellContent cell = new CellContent(titles[i],subTitles[i], urlStrings[i]);
            cells.add(cell);
        }
        CustomAdapter customAdapter = new CustomAdapter(this, cells);
        listView.setAdapter(customAdapter);
    }
}
