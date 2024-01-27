package com.example.a2023_scoutingapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.example.qrgenearator.QRGContents;
import com.example.qrgenearator.QRGEncoder;
import android.widget.ImageView;
import android.graphics.Bitmap;

public class QrActivity extends AppCompatActivity {
    QRGEncoder qrgEncoder;
    Bitmap bitmap;
    ImageView qrImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr);
        String json = RecordsActivity.Info.CreateJSON();
        qrImage = findViewById(R.id.qrImageView);

        qrgEncoder = new QRGEncoder(json, null, QRGContents.Type.TEXT, 200);
        try {
            // Getting QR-Code as Bitmap
            //Log.i("Yellow",tdYellow.toString());
            qrgEncoder.setColorBlack(this.getResources().getColor(R.color.backgroundGray));
            qrgEncoder.setColorWhite(this.getResources().getColor(R.color.testYellow));
            bitmap = qrgEncoder.getBitmap();
            qrImage.setImageBitmap(bitmap);
            // Setting Bitmap to ImageView
            qrImage.setImageBitmap(bitmap);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void toMain(View view){
        Intent next = new Intent(this, MainActivity.class);
        startActivity(next);
        RecordsActivity.Info.clear();
    }
}
