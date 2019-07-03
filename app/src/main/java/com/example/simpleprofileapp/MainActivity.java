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
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    FloatingActionButton submit;
    TextInputEditText name, username, password, description;

    Profile userProfile;

    String nameString, userString, passString, descString;

    SharedPreferences sharedPreferences;

    public final static String MyPREFERENCES = "MyPREFERENCES";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        userProfile = new Profile();

        init();

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                setTextString();

                editPreferences();

                goToNextActivity();

            }
        });

    }


    @Override
    protected void onStart() {

        super.onStart();

    }

    @Override
    protected void onResume() {
        super.onResume();

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

    private void init() {
        submit = findViewById(R.id.submit_button);
        name = findViewById(R.id.name_field);
        username = findViewById(R.id.user_field);
        password = findViewById(R.id.password_field);
        description = findViewById(R.id.description_field);
    }

    private void setTextString() {
        nameString = name.getText().toString();
        userString = username.getText().toString();
        passString = password.getText().toString();
        descString = description.getText().toString();
    }

    private void saveProfile() {

        userProfile.setName(nameString);
        userProfile.setUserName(userString);
        userProfile.setPassword(passString);
        userProfile.setDescription(descString);

    }

    private void editPreferences () {
        saveProfile();

        SharedPreferences.Editor editor = sharedPreferences.edit();
        String jsonString = new Gson().toJson(userProfile);
        editor.putString("profileJson", jsonString);

        editor.commit();
    }


    private void goToNextActivity() {
        Intent intent = new Intent(MainActivity.this, ProfileCard.class);
        intent.putExtra(Constants.USER_PROFILE_KEY, userProfile);
        startActivity(intent);
    }
}
