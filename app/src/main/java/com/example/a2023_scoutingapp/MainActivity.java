package com.example.a2023_scoutingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Spinner driveStation;
    EditText scoutName, matchNumber, teamNumber;
    RadioButton pos1,pos2,pos3;
    RadioButton cone, cube;
    RadioButton[] positions;
    int checkedPos;
    boolean coneCheck,cubeCheck ;
    boolean pos1Check, pos2Check, pos3Check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        matchNumber = findViewById(R.id.matchNumberEditText);
        scoutName = findViewById(R.id.scoutNameEditText);
        teamNumber = findViewById(R.id.teamNumberEditText);
        driveStation = (Spinner) findViewById(R.id.driveStationSelectionSpinner);
        pos1 = findViewById(R.id.fieldPositionOne);
        pos2 = findViewById(R.id.fieldPositionTwo);
        pos3 = findViewById(R.id.fieldPositionThree);
        cone = findViewById(R.id.coneRadioButton);
        cube = findViewById(R.id.cubeRadioButton);
        positions = new RadioButton[]{pos1,pos2,pos3};
        scoutName.setText(RecordsActivity.Info.scoutName);
        matchNumber.setText(RecordsActivity.Info.matchNumber);
        teamNumber.setText(RecordsActivity.Info.teamNumber);
        if (RecordsActivity.Info.preloadedGamePiece == 0){
            cube.setChecked(true);
        }
        else if (RecordsActivity.Info.preloadedGamePiece == 1){
            cone.setChecked(true);
        } else {
            cone.setChecked(false);
            cube.setChecked(false);
        }
        if (RecordsActivity.Info.robotPosition == 0){
            pos1.setChecked(true);
        } else if (RecordsActivity.Info.robotPosition == 1){
            pos2.setChecked(true);
        } else if (RecordsActivity.Info.robotPosition == 2){
            pos3.setChecked(true);
        } else {
            pos1.setChecked(false);
            pos2.setChecked(false);
            pos3.setChecked(false);
        }
        /*
        if (RecordsActivity.Info.driverStation.contains("Red 1")){
            driveStation.setSelection(0);
        } else if (RecordsActivity.Info.driverStation.contains("Red 2")){
            driveStation.setSelection(1);
        } else if (RecordsActivity.Info.driverStation.contains("Red 3")){
            driveStation.setSelection(2);
        } else if (RecordsActivity.Info.driverStation.contains("Blue 1")){
            driveStation.setSelection(3);
        } else if (RecordsActivity.Info.driverStation.contains("Blue 2")){
            driveStation.setSelection(4);
        } else if (RecordsActivity.Info.driverStation.contains("Blue 3")){
            driveStation.setSelection(5);
        }*/

        initSpinner();
    }
    public void toAuto(View view){
        Intent next = new Intent(this, AutoActivity.class);
        startActivity(next);
        saveData();
    }
    private void initSpinner() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.spinner_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        driveStation.setAdapter(adapter);
    }
    private void clear() {
        pos1.setChecked(false);
        pos2.setChecked(false);
        pos3.setChecked(false);
    }
    public void clicked(View view) {
        for(int i = 0; i < positions.length;i++)
        {
            if(positions[i].isChecked())
            {
                if(checkedPos != i)
                {
                    checkedPos = i;
                    break;
                }
            }
        }
        clear();
        positions[checkedPos].setChecked(true);
    }
    public void saveData(){
        EditText editTeamNumberText = findViewById(R.id.teamNumberEditText);
        EditText editMatchNumberText = findViewById(R.id.matchNumberEditText);
        EditText editScoutNameText = findViewById(R.id.scoutNameEditText);
        RecordsActivity.Info.scoutName = editScoutNameText.getText().toString();
        RecordsActivity.Info.matchNumber = editMatchNumberText.getText().toString();
        RecordsActivity.Info.teamNumber = editTeamNumberText.getText().toString();
        coneCheck = cone.isChecked();
        cubeCheck = cube.isChecked();
        pos1Check = pos1.isChecked();
        pos2Check = pos2.isChecked();
        pos3Check = pos3.isChecked();
        //cone is 0
        if (coneCheck){
            RecordsActivity.Info.preloadedGamePiece = 0;
        }
        //cube is 1
        if (cubeCheck){
            RecordsActivity.Info.preloadedGamePiece = 1;
        }
        //barrier is 0
        if (pos1Check){
            RecordsActivity.Info.robotPosition = 0;
        }
        //chargestation is 1
        if (pos2Check){
            RecordsActivity.Info.robotPosition = 1;
        }
        //sidewall is 2
        if (pos3Check){
            RecordsActivity.Info.robotPosition = 2;
        }
        /*
        RecordsActivity.Info.driverStation = driveStation.getSelectedItem().toString();
        Log.i("Aamir","Aamir" + driveStation.getSelectedItem().toString());*/
    }
}