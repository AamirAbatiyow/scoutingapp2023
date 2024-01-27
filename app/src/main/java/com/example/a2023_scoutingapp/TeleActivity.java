package com.example.a2023_scoutingapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TeleActivity extends AppCompatActivity {
    int points = RecordsActivity.Info.gamePieceScoring;
    int topPoints = RecordsActivity.Info.teleTopScoring;
    int midPoints = RecordsActivity.Info.teleMidScoring;
    int lowPoints = RecordsActivity.Info.teleBotScoring;
    TextView topPointsText;
    TextView midPointsText;
    TextView lowPointsText;
    TextView pointsText;
    EditText teleComments;
    CheckBox diedCheck, restartedCheck, brokeCheck, playedDefenseCheck, facedDefenseCheck, fellOverCheck, rightedCheck, conesCheck, cubesCheck, groundGrabCheck, substationGrabCheck, shelfGrabCheck;
    boolean died = RecordsActivity.Info.died;
    boolean restarted = RecordsActivity.Info.restarted;
    boolean broke = RecordsActivity.Info.broke;
    boolean playedDefense = RecordsActivity.Info.playedDefense;
    boolean facedDefense = RecordsActivity.Info.facedDefense;
    boolean fellOver = RecordsActivity.Info.fellOver;
    boolean righted = RecordsActivity.Info.righted;
    boolean cones = RecordsActivity.Info.cones;
    boolean cubes = RecordsActivity.Info.cubes;
    boolean groundGrab = RecordsActivity.Info.groundGrab;
    boolean substationGrab = RecordsActivity.Info.substationGrab;
    boolean shelfGrab = RecordsActivity.Info.shelfGrab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tele);
        pointsText = (TextView) findViewById(R.id.gamePiecePointsTextView);
        topPointsText = (TextView) findViewById(R.id.topPointsText);
        midPointsText = (TextView) findViewById(R.id.midPointsText);
        lowPointsText = (TextView) findViewById(R.id.lowPointsText);
        diedCheck = (CheckBox) findViewById(R.id.diedCheckBox);
        restartedCheck = (CheckBox) findViewById(R.id.restartedCheckBox);
        brokeCheck = (CheckBox) findViewById(R.id.brokeCheckBox);
        playedDefenseCheck = (CheckBox) findViewById(R.id.playedDefenseCheckBox);
        facedDefenseCheck = (CheckBox) findViewById(R.id.facedDefenseCheckBox);
        fellOverCheck = (CheckBox) findViewById(R.id.fellOverCheckBox);
        rightedCheck = (CheckBox) findViewById(R.id.rightedCheckBox);
        conesCheck = (CheckBox) findViewById(R.id.conesCheckBox);
        cubesCheck = (CheckBox) findViewById(R.id.cubesCheckBox);
        groundGrabCheck = (CheckBox) findViewById(R.id.groundGrabCheckBox);
        substationGrabCheck = (CheckBox) findViewById(R.id.substationGrabCheckBox);
        shelfGrabCheck = (CheckBox) findViewById(R.id.shelfGrabCheckBox);
        teleComments = findViewById(R.id.teleCommentsEditText);
        topPoints = RecordsActivity.Info.teleTopScoring;
        topPointsText.setText(String.valueOf(topPoints));
        midPoints = RecordsActivity.Info.teleMidScoring;
        midPointsText.setText(String.valueOf(midPoints));
        lowPoints = RecordsActivity.Info.teleBotScoring;
        lowPointsText.setText(String.valueOf(lowPoints));
        points = RecordsActivity.Info.gamePieceScoring;
        pointsText.setText(String.valueOf(points));
        teleComments.setText(RecordsActivity.Info.teleComment);
        diedCheck.setChecked(died);
        restartedCheck.setChecked(restarted);
        brokeCheck.setChecked(broke);
        playedDefenseCheck.setChecked(playedDefense);
        facedDefenseCheck.setChecked(facedDefense);
        fellOverCheck.setChecked(fellOver);
        rightedCheck.setChecked(righted);
        conesCheck.setChecked(cones);
        cubesCheck.setChecked(cubes);
        groundGrabCheck.setChecked(groundGrab);
        substationGrabCheck.setChecked(substationGrab);
        shelfGrabCheck.setChecked(shelfGrab);
    }
    public void pointsIncrement(View view) {
        points++;
        pointsText.setText(String.valueOf(points));
    }
    public void pointsDecrement(View view) {
        if(points > 0){
            points--;
        }
        pointsText.setText(String.valueOf(points));

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
    //
    public void backAuto(View view){
        Intent next = new Intent(this, AutoActivity.class);
        startActivity(next);
        saveData();
    }
    public void toEndgame(View view){
        Intent next = new Intent(this, EndgameActivity.class);
        startActivity(next);
        saveData();
    }
    public void saveData(){
        RecordsActivity.Info.teleTopScoring = topPoints;
        RecordsActivity.Info.teleMidScoring = midPoints;
        RecordsActivity.Info.teleBotScoring = lowPoints;
        RecordsActivity.Info.gamePieceScoring = points;
        RecordsActivity.Info.teleComment = teleComments.getText().toString();
        CheckBox diedCheck = (CheckBox) findViewById(R.id.diedCheckBox);
        CheckBox restartedCheck = (CheckBox) findViewById(R.id.restartedCheckBox);
        CheckBox brokeCheck = (CheckBox) findViewById(R.id.brokeCheckBox);
        CheckBox playedDefenseCheck = (CheckBox) findViewById(R.id.playedDefenseCheckBox);
        CheckBox facedDefenseCheck = (CheckBox) findViewById(R.id.facedDefenseCheckBox);
        CheckBox fellOverCheck = (CheckBox) findViewById(R.id.fellOverCheckBox);
        CheckBox rightedCheck = (CheckBox) findViewById(R.id.rightedCheckBox);
        CheckBox conesCheck = (CheckBox) findViewById(R.id.conesCheckBox);
        CheckBox cubesCheck = (CheckBox) findViewById(R.id.cubesCheckBox);
        CheckBox groundGrabCheck = (CheckBox) findViewById(R.id.groundGrabCheckBox);
        CheckBox substationGrabCheck = (CheckBox) findViewById(R.id.substationGrabCheckBox);
        CheckBox shelfGrabCheck = (CheckBox) findViewById(R.id.shelfGrabCheckBox);
        died = diedCheck.isChecked();
        restarted = restartedCheck.isChecked();
        broke = brokeCheck.isChecked();
        playedDefense = playedDefenseCheck.isChecked();
        facedDefense = facedDefenseCheck.isChecked();
        fellOver = fellOverCheck.isChecked();
        righted = rightedCheck.isChecked();
        cones = conesCheck.isChecked();
        cubes = cubesCheck.isChecked();
        groundGrab = groundGrabCheck.isChecked();
        substationGrab = substationGrabCheck.isChecked();
        shelfGrab = shelfGrabCheck.isChecked();
        RecordsActivity.Info.died = died;
        RecordsActivity.Info.restarted = restarted;
        RecordsActivity.Info.broke = broke;
        RecordsActivity.Info.playedDefense = playedDefense;
        RecordsActivity.Info.facedDefense = facedDefense;
        RecordsActivity.Info.fellOver = fellOver;
        RecordsActivity.Info.righted = righted;
        RecordsActivity.Info.cones = cones;
        RecordsActivity.Info.cubes = cubes;
        RecordsActivity.Info.groundGrab = groundGrab;
        RecordsActivity.Info.substationGrab = substationGrab;
        RecordsActivity.Info.shelfGrab = shelfGrab;
    }
}
