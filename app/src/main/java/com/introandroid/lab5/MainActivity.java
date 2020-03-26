package com.introandroid.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    Button saveButton;
    String defaultValue;
    TextView defaultName;
    String finalName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        defaultName = (TextView) findViewById(R.id.defaultName);
        saveButton = (Button) findViewById(R.id.button);
        final EditText userName = (EditText) findViewById(R.id.newNameText);

        saveButton.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString(getString(R.string.defaultName), userName.getText().toString());
                editor.commit();
            }
        }));

        SharedPreferences mySharedPref = getPreferences(Context.MODE_PRIVATE);
        defaultValue = getResources().getString((R.string.defaultSavedName));
         finalName = mySharedPref.getString(userName.getText().toString(),defaultValue);
         defaultName.setText(finalName);


    }

}
