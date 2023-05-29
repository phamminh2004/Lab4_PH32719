package com.minhpt.lab4_ph32719;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class Bai1_1 extends AppCompatActivity {
    private final String TAG = "Status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bai1_1);
        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Bai1_1.this, Bai1_2.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "OnStart");
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "OnResume");
    }


    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
    }

}
