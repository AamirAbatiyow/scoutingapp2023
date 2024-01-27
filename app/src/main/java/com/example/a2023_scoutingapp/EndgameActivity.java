package com.example.a2023_scoutingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;

public class EndgameActivity extends AppCompatActivity {
    RadioButton engaged, docked, notParked, parked;
    boolean engagedCheck, dockedCheck, notParkedCheck, parkedCheck;
    EditText endgameComments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_endgame);
        engaged = findViewById(R.id.endgameEngagedRadioButton);
        docked = findViewById(R.id.endgameDockedRadioButton);
        notParked = findViewById(R.id.endgameNotParkedRadioButton);
        parked = findViewById(R.id.endgameParkedRadioButton);
        endgameComments = findViewById(R.id.endgameCommentsEditText);
        if (RecordsActivity.Info.endgameChargeStation==0){
            engaged.setChecked(true);
        } else if (RecordsActivity.Info.endgameChargeStation==1){
            docked.setChecked(true);
        } else if (RecordsActivity.Info.endgameChargeStation==2){
            notParked.setChecked(true);
        } else if (RecordsActivity.Info.endgameChargeStation==3){
            parked.setChecked(true);
        } else {
            engaged.setChecked(false);
            docked.setChecked(false);
            notParked.setChecked(false);
            parked.setChecked(false);
        }
        endgameComments.setText(RecordsActivity.Info.endgameComment);
    }
    public void backTele(View view){
        Intent next = new Intent(this, TeleActivity.class);
        startActivity(next);
        saveData();
    }
    public void toPopup(View view){
        Intent next = new Intent(this, PopupActivity.class);
        startActivity(next);
        saveData();
    }
    public void saveData(){
        engagedCheck = engaged.isChecked();
        dockedCheck = docked.isChecked();
        notParkedCheck = notParked.isChecked();
        parkedCheck = parked.isChecked();
        //engaged is 0
        if (engagedCheck){
            RecordsActivity.Info.endgameChargeStation = 0;
        }
        //docked is 1
        if (dockedCheck){
            RecordsActivity.Info.endgameChargeStation = 1;
        }
        //not parked is 2
        if (notParkedCheck){
            RecordsActivity.Info.endgameChargeStation = 2;
        }
        //parked is 3
        if (parkedCheck){
            RecordsActivity.Info.endgameChargeStation = 3;
        }
        RecordsActivity.Info.endgameComment = endgameComments.getText().toString();

    }
}
