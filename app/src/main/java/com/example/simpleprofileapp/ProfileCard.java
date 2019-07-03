package com.example.simpleprofileapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class ProfileCard extends AppCompatActivity {

    ImageView backButton;
    TextView textView;
    public final static String MyPREFERENCES = "MyPREFERENCES";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Profile userProfile = (Profile) getIntent().getSerializableExtra(Constants.USER_PROFILE_KEY);

        sharedPreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        String jsonString = sharedPreferences.getString("profileJson", "");
        Profile profile = new Gson().fromJson(jsonString, Profile.class);

        Toast.makeText(ProfileCard.this, " " + jsonString, Toast.LENGTH_LONG ).show();



        Toast.makeText(ProfileCard.this, "wow", Toast.LENGTH_SHORT).show();

        textView = findViewById(R.id.text_view);
        backButton = findViewById(R.id.back_button);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });


        if (userProfile != null) {
            textView.setText("Name: " + userProfile.getName() + "\n Username: " + userProfile.getUserName() + "\n Password: " + userProfile.getPassword() + "\n Description: " + userProfile.getDescription());
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
