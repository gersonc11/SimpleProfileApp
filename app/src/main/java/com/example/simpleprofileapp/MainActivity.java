package com.example.simpleprofileapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton submit;
    TextInputEditText name, username, password, description;
    String nameString, userString, passString, descString;

    public static final String MyPREFERENCES = "MyPrefsFile";
    public static final String typeName = "namekey";
    public static final String typeUser = "userkey";
    public static final String typePass = "passkey";
    public static final String typeDesc = "desckey";

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit_button);

        name = findViewById(R.id.name_field);
        username = findViewById(R.id.user_field);
        password = findViewById(R.id.password_field);
        description = findViewById(R.id.description_field);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String oldName = sharedPreferences.getString(typeName, nameString);
        String oldUser = sharedPreferences.getString(typeUser, userString);
        String oldPass = sharedPreferences.getString(typePass, passString);
        String oldDesc = sharedPreferences.getString(typeDesc, descString);

        name.setText(oldName);
        username.setText(oldUser);
        password.setText(oldPass);
        description.setText(oldDesc);
    }

    @Override
    protected void onStart() {

        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                nameString = name.getText().toString();
                userString = username.getText().toString();
                passString = password.getText().toString();
                descString = description.getText().toString();


                Intent intent = new Intent(getBaseContext(), ProfileCard.class);
                intent.putExtra("name", nameString);
                intent.putExtra("username", userString);
                intent.putExtra("password", passString);
                intent.putExtra("description", descString);
                startActivity(intent);

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("namekey", nameString);
                editor.putString("userkey", userString);
                editor.putString("passkey", passString);
                editor.putString("desckey", descString);
                editor.commit();
            }
        });

    }

    @Override public void onSaveInstanceState(Bundle outState) {

        outState.putString("name_key", nameString);
        outState.putString("username_key", userString);
        outState.putString("password_key", passString);
        outState.putString("description_key", descString);

        super.onSaveInstanceState(outState);
    }


    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
