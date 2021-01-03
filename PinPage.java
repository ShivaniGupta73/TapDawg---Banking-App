package com.example.tapdawg02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PinPage extends AppCompatActivity {

    EditText pin;
    String pinconfirm;
    Bundle extras;
    Button confirmbutton;
    int pincontrol;
    ConstraintLayout pinlayout;
    int control;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin_page);

        control = 0;

        pin = (EditText) findViewById(R.id.pin);
        confirmbutton = (Button) findViewById(R.id.confirmpin);
        pinlayout = (ConstraintLayout) findViewById(R.id.pinlayout);

        pincontrol = 0;

        confirmbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                control++;
                if (control == 2) {
                    control = 0;
                    confirmbutton.setBackgroundResource(R.drawable.roundbutton);
                    pinconfirm = pin.getText().toString();
                    if (pinconfirm.equals("1234")) {
                        pincontrol = 1;
                    }

                    if (pincontrol == 1) {
                        Intent pinintent = new Intent(PinPage.this, FinalConfirmation.class);
                        extras = getIntent().getExtras();
                        pinintent.putExtras(extras);
                        startActivity(pinintent);
                        finish();
                    } else {
                        Toast.makeText(PinPage.this, " Signing out", Toast.LENGTH_SHORT).show();
                        Intent pinintent2 = new Intent(PinPage.this, MainActivity.class);
                        startActivity(pinintent2);
                        finish();
                    }
                }
                else{
                    confirmbutton.setBackgroundResource(R.drawable.roundbuttonforbackground);
                }
            }
        });

        pinlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                confirmbutton.setBackgroundResource(R.drawable.roundbutton);
                control = 0;
            }
        });
    }

}
