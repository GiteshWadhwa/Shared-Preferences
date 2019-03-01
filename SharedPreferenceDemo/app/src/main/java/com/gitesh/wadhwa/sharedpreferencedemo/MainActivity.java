package com.gitesh.wadhwa.sharedpreferencedemo;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText name,age;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText)findViewById(R.id.edit1);
        age=(EditText)findViewById(R.id.edit2);
    }
    @Override
    protected void onResume(){
        super.onResume();
        @SuppressLint("WrongConstant") SharedPreferences sh1=getSharedPreferences("MyOwnShared",MODE_APPEND);
        String s1=sh1.getString("user","");
        int a1=sh1.getInt("age",0);
        name.setText(s1);
        age.setText(String.valueOf(a1));
    }
    @Override
    protected void onPause(){
        super.onPause();
        SharedPreferences sh=getSharedPreferences("MyOwnShared",MODE_PRIVATE);
        SharedPreferences.Editor myEditor=sh.edit();
        myEditor.putString("user",name.getText().toString());
        myEditor.putInt("age",Integer.parseInt(age.getText().toString()));
        myEditor.commit();
    }
}
