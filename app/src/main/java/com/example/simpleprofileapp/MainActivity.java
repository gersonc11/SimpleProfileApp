package com.example.simpleprofileapp;

import android.content.Intent;
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
    boolean created = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        submit = findViewById(R.id.submit_button);


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
                name = findViewById(R.id.name_field);
                username = findViewById(R.id.user_field);
                password = findViewById(R.id.password_field);
                description = findViewById(R.id.description_field);

                nameString = name.getText().toString();
                userString = username.getText().toString();
                passString = password.getText().toString();
                descString = description.getText().toString();



                Toast.makeText(MainActivity.this, "jj" + nameString + userString + passString + descString, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getBaseContext(), ProfileCard.class);
                intent.putExtra("name", nameString);
                intent.putExtra("username", userString);
                intent.putExtra("password", passString);
                intent.putExtra("description", descString);
                startActivity(intent);
            }
        });
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
