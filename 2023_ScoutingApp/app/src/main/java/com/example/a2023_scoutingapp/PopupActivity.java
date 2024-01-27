package com.example.a2023_scoutingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class PopupActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
    }
    public void backEndgame(View view){
        Intent next = new Intent(this, EndgameActivity.class);
        startActivity(next);
    }
    public void toQr(View view){
        Intent next = new Intent(this, QrActivity.class);
        startActivity(next);
    }
}
