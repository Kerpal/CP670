package com.example.stefan.androidassignments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends Activity {

    protected static final String ACTIVITY_NAME = "LoginActivity";
    private Button loginButton;
    private TextView email;
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private String emailKey = "Email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        email = findViewById(R.id.email_text);
        loginButton = findViewById(R.id.button2);

        sharedPref = getSharedPreferences(ACTIVITY_NAME, Context.MODE_PRIVATE);
        editor = sharedPref.edit();
        String defaultEmail = sharedPref.getString("DefaultEmail", "email@domain.com");
        String lastEmail = sharedPref.getString(emailKey, "");

        editor.clear();
        editor.putString(emailKey, email.getText().toString());
        editor.commit();

        loginButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "Clicked Login Button");
                editor.putString(emailKey, email.getText().toString());
                editor.commit();
                String newEmail = sharedPref.getString(emailKey, " ");
                Log.i(ACTIVITY_NAME, newEmail);
                Intent intent = new Intent(LoginActivity.this, StartActivity.class);
                startActivity(intent);
            }

        });

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
