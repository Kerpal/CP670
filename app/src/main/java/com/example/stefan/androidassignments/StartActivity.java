package com.example.stefan.androidassignments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StartActivity extends Activity {

    protected static final String ACTIVITY_NAME = "StartActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Log.i(ACTIVITY_NAME, "In onCreate()");

        Button button = findViewById(R.id.button);
        Button startChat = findViewById(R.id.start);
        Button startToolbar = findViewById(R.id.toolbar_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, ListItemsActivity.class);
                startActivityForResult(intent, 10);
            }
        });

        startChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(ACTIVITY_NAME, "User clicked Start Chat");
                Intent intent = new Intent(StartActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        });

        startToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, TestToolbar.class);
                startActivity(intent);
            }
        });
    }

    protected void onActivityResult(int requestCode, int responseCode, Intent data) {
        if (requestCode == 10){
            Log.i(ACTIVITY_NAME, "Returned to StartActivity.onActivityResult");
        }
        if (responseCode == Activity.RESULT_OK) {
            String messagePassed = data.getStringExtra("Response");
            int duration = Toast.LENGTH_SHORT; //= Toast.LENGTH_LONG if Off

            Toast toast = Toast.makeText(this , messagePassed, duration); //this is the ListActivity
            toast.show(); //display your message box

        }
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
