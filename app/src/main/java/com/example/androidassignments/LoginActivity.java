package com.example.androidassignments;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;import android.widget.Button;import android.view.View;import android.content.Intent;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    protected static final String ACTIVITY_NAME = "MainActivity";
//    Button submitButton = findViewById(R.id.submit_button);

    public void submitLogin(View view){

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.clear();

        EditText text = (EditText)findViewById(R.id.email);

        String address = text.getText().toString();

        edit.putString("DefaultEmail",address);

        edit.commit();



        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        SharedPreferences sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();

        EditText text = (EditText)findViewById(R.id.email);

        String defaultEmail = sharedPreferences.getString("DefaultEmail","email@domain.com");

        text.setText(defaultEmail);


    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.i(ACTIVITY_NAME, "In onResume()");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart()");

    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause()");

    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(ACTIVITY_NAME, "In onStop()");

    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, "In onDestroy()");

    }
}
