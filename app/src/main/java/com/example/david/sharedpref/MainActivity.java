package com.example.david.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    final String MyPREFERENCES = "MyPREFERENCES";
    final String NAME_KEY = "namekey";

    EditText nameField;
    TextView displayNameField;

    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameField = findViewById(R.id.edit);
        displayNameField = findViewById(R.id.text);

        sharedPref = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String savedName = sharedPref.getString(NAME_KEY, null);

        if (savedName != null )
            displayNameField.setText(savedName);

    }

    public void saveName(View view) {
        String name = "";

        if(nameField != null) {
            name = nameField.getText().toString();
        }

        if(displayNameField != null) {
            displayNameField.setText(name);
        }

        SharedPreferences.Editor editPref = sharedPref.edit();

        editPref.putString(NAME_KEY, name);
        editPref.commit();



    }



}
