package com.example.a2023_scoutingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class AutoActivity extends AppCompatActivity{
    int topPoints = RecordsActivity.Info.autoTopScoring;
    TextView topPointsText;
    int midPoints = RecordsActivity.Info.autoMidScoring;
    TextView midPointsText;
    int lowPoints = RecordsActivity.Info.autoBotScoring;
    TextView lowPointsText;
    CheckBox mobilityCheck;
    boolean mobility = RecordsActivity.Info.mobility;
    RadioButton grid1, grid2, grid3;
    boolean grid1Check, grid2Check, grid3Check;
    RadioButton engaged, docked, notDocked;
    boolean engagedCheck, dockedCheck, notDockedCheck;
    EditText comments;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);
        topPointsText = (TextView) findViewById(R.id.autoTopTextView);
        midPointsText = (TextView) findViewById(R.id.autoMiddleTextView);
        lowPointsText = (TextView) findViewById(R.id.autoBottomTextView);
        mobilityCheck = (CheckBox) findViewById(R.id.mobilityCheckBox);
        grid1 = findViewById(R.id.gridOneRadioButton);
        grid2 = findViewById(R.id.gridTwoRadioButton);
        grid3 = findViewById(R.id.gridThreeRadioButton);
        engaged = findViewById(R.id.autoEngagedRadioButton);
        docked = findViewById(R.id.autoDockedRadioButton);
        notDocked = findViewById(R.id.autoNotDockedRadioButton);
        comments = findViewById(R.id.autoCommentEditText);
        mobilityCheck.setChecked(mobility);
        topPoints = RecordsActivity.Info.autoTopScoring;
        topPointsText.setText(String.valueOf(topPoints));
        midPoints = RecordsActivity.Info.autoMidScoring;
        midPointsText.setText(String.valueOf(midPoints));
        lowPoints = RecordsActivity.Info.autoBotScoring;
        lowPointsText.setText(String.valueOf(lowPoints));
        comments.setText(RecordsActivity.Info.autoComment);
        if (RecordsActivity.Info.gridScoring == 0){
            grid1.setChecked(true);
        } else if (RecordsActivity.Info.gridScoring == 1){
            grid2.setChecked(true);
        } else if (RecordsActivity.Info.gridScoring == 2){
            grid3.setChecked(true);
        } else {
            grid1.setChecked(false);
            grid2.setChecked(false);
            grid3.setChecked(false);
        }
        if (RecordsActivity.Info.autoChargeStation==0){
            engaged.setChecked(true);
        } else if (RecordsActivity.Info.autoChargeStation==1){
            docked.setChecked(true);
        } else if (RecordsActivity.Info.autoChargeStation==2){
            notDocked.setChecked(true);
        } else {
            engaged.setChecked(false);
            docked.setChecked(false);
            notDocked.setChecked(false);
        }
    }
    public void backMain(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        saveData();
    }
    public void toTele(View view){
        Intent next = new Intent(this, TeleActivity.class);
        startActivity(next);
        saveData();
    }
    //TOP_POINTS
    public void topPointsIncrement(View view) {
        topPoints++;
        topPointsText.setText(String.valueOf(topPoints));
    }
    public void topPointsDecrement(View view) {
        if(topPoints > 0){
            topPoints--;
        }
        topPointsText.setText(String.valueOf(topPoints));
    }
    //MID_POINTS
    public void midPointsIncrement(View view) {
        midPoints++;
        midPointsText.setText(String.valueOf(midPoints));
    }
    public void midPointsDecrement(View view) {
        if(midPoints > 0){
            midPoints--;
        }
        midPointsText.setText(String.valueOf(midPoints));
    }
    //LOW_POINTS
    public void lowPointsIncrement(View view) {
        lowPoints++;
        lowPointsText.setText(String.valueOf(lowPoints));
    }
    public void lowPointsDecrement(View view) {
        if(lowPoints > 0){
            lowPoints--;
        }
        lowPointsText.setText(String.valueOf(lowPoints));
    }
    public void saveData()
    {
        //EditText aCommentText = (EditText) findViewById(R.id.autoComment);
        CheckBox mobilityCheck = (CheckBox) findViewById(R.id.mobilityCheckBox);
        EditText editCommentsText = findViewById(R.id.autoCommentEditText);
        RecordsActivity.Info.autoComment = editCommentsText.getText().toString();
        mobility = mobilityCheck.isChecked();
        grid1Check = grid1.isChecked();
        grid2Check = grid2.isChecked();
        grid3Check = grid3.isChecked();
        engagedCheck = engaged.isChecked();
        dockedCheck = docked.isChecked();
        notDockedCheck = notDocked.isChecked();
        //storing variables into Records.Info variables
        RecordsActivity.Info.autoTopScoring = topPoints;
        RecordsActivity.Info.autoMidScoring = midPoints;
        RecordsActivity.Info.autoBotScoring = lowPoints;

        //Records.Info.autoComment = aCommentText.getText().toString();
        RecordsActivity.Info.mobility = mobility;
        //barrier is 0
        if (grid1Check){
            RecordsActivity.Info.gridScoring = 0;
        }
        //coop is 1
        if (grid2Check){
            RecordsActivity.Info.gridScoring = 1;
        }
        //sidewall is 2
        if (grid3Check){
            RecordsActivity.Info.gridScoring = 2;
        }
        //engaged is 0
        if (engagedCheck){
            RecordsActivity.Info.autoChargeStation = 0;
        }
        //docked is 1
        if (dockedCheck){
            RecordsActivity.Info.autoChargeStation = 1;
        }
        //not docked is 2
        if (notDockedCheck){
            RecordsActivity.Info.autoChargeStation = 2;
        }
    }
}
