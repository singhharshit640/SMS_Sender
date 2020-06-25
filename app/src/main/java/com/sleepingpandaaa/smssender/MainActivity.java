package com.sleepingpandaaa.smssender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

//Made by Harshit

public class MainActivity extends AppCompatActivity {

    EditText etNumber, etMessage;
    Button btnSend;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumber = findViewById(R.id.etNumber);
        etMessage = findViewById(R.id.etMessage);
        btnSend = findViewById(R.id.btnSend);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS)!= PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.SEND_SMS}, 0);
        }


        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String message = etMessage.getText().toString();
                String number =etNumber.getText().toString();

                SmsManager smsManager= SmsManager.getDefault();
                smsManager.sendTextMessage(number,null,message,null,null);

                Toast.makeText(MainActivity.this, "Message sent to " + number, Toast.LENGTH_SHORT).show();


            }
        });




    }
}