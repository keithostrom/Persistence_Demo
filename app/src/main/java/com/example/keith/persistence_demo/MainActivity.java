package com.example.keith.persistence_demo;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Random;


public class MainActivity extends Activity implements View.OnClickListener{
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    String dataName = "MyData";
    String stringName = "MyString";
    String defaultString = ":-(";
    String currentString = ""; //Empty string
    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Init preferences
        prefs = getSharedPreferences(dataName, MODE_PRIVATE);
        editor =prefs.edit();

        currentString = prefs.getString(stringName, defaultString);
        button1 = (Button) findViewById(R.id.button);
        button1.setOnClickListener(this);
        button1.setText(currentString);
    } //End onCreate

    @Override
    public void onClick(View view) {
        Random randInt = new Random();
        int ourRandom = randInt.nextInt(10);
        currentString = currentString + ourRandom;

        editor.putString(stringName, currentString);
        editor.commit();
        button1.setText(currentString);
    } //End onClick
} //End MainActivity
