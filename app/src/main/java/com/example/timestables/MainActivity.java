package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView timesTableListView;
    public void generateTimesTable(int timesTableNumber)
    {

        ArrayList<String> timesTableConetent=new ArrayList<String>();
        for(int j=1;j<=10;j++)
        {
            timesTableConetent.add(Integer.toString(j*timesTableNumber));
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,timesTableConetent);
        timesTableListView.setAdapter(arrayAdapter);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SeekBar timesTableSeekBar=findViewById(R.id.timesTableSeekBar);
         timesTableListView=findViewById(R.id.timesTableListView);
         int max=30;
         int start=10;
        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(start);
        generateTimesTable(start);
        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               int min=1;
               int timesTableNumber;
                if(i<min)
                {
                    timesTableNumber=min;
                }
                else
                {
                    timesTableNumber=i;
                }
                Log.i("SeekBar value" , Integer.toString(timesTableNumber));
                generateTimesTable(timesTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
