package com.example.tapdawg02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ServerValue;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.Random;

import static java.sql.DriverManager.println;

public class MenuActivity extends AppCompatActivity {

    int ctrl = 0;
    private DatabaseReference mDatabase;
    private TextView showbalance, lastlogin, showname;
    LinearLayout constraintLayout;
    String bal, pasttime;
    Date currentTime;
    long max ;
    long temp;
    String key;
    String benefname, benefaccount;
    Button yesqp, noqp;
    Bundle extras;
    int id, control, rand1;
    ImageButton transfer, creditcard, billpayments, bankstatements;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        constraintLayout = (LinearLayout) findViewById(R.id.layout);

        transfer = (ImageButton) findViewById(R.id.p2p);
        currentTime = Calendar.getInstance().getTime();
    //    DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
     //   String strDate = dateFormat.format(currentTime);

        //register checking button with Event Listener class, and Event handler method

        mDatabase = FirebaseDatabase.getInstance().getReference();
        yesqp = (Button) findViewById(R.id.yesquickpay);
   //     noqp = (Button) findViewById(R.id.noquickpay);
        showname = (TextView) findViewById(R.id.benefname);
        showbalance = (TextView) findViewById(R.id.showbalance);
        max = -1;
        control = 0;
        Random rand = new Random();
        rand1 = (rand.nextInt(9)+1)*1000;


        mDatabase.child("Transactions").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    temp = data.getChildrenCount();
                    if(max<temp)
                    {
                        max = temp;
                        key = data.getKey();
                    }
                }
                Log.d("In database 01 ", " max " + max);
                Log.d("In database 02", "key " + key);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("In onCancelled" , "Firebase");
            }
        });

        mDatabase.child("Beneficiary").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()) {
                    Log.d("In yoboy database 03 ", " data key " + data.getKey());
                    if (key.equals(data.getKey())) {
                        Log.d("In database 03 ", " data key matched key " + data.getKey());
                        benefname = String.valueOf(data.getValue());
                        benefaccount = data.getKey();
                        break;
                    }
                }
                Log.d("In database 04 ", " Name " + benefname);
                showname.setText(" Pay : " + benefname + "\n Rs " + rand1 + " ?");

                yesqp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (id != 5) {
                            control = 0;
                            reset(id);
                            id = 5;
                        }
                        control++;
                        if(control==2) {
                            yesqp.setBackgroundResource(R.drawable.roundbutton);
                            Intent menuintent = new Intent(MenuActivity.this, PayeeInfo.class);
                            extras = new Bundle();
                            extras.putString("To field", benefname);
                            extras.putInt("finalamount", rand1);
                            extras.putString("Account number", benefaccount);
                            menuintent.putExtras(extras);
                            startActivity(menuintent);
                        }
                        else{
                            yesqp.setBackgroundResource(R.drawable.roundbuttonforbackground);
                        }
                    }
                });

             /*   noqp.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MenuActivity.this, "OKkkkkkkkkkkkkkkkk.", Toast.LENGTH_SHORT).show();
                    }
                });*/
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("In onCancelled" , "Firebase");
            }
        });

        mDatabase.child("Balance").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                bal = String.valueOf(dataSnapshot.getValue());
                Log.d("In firebase", " " + bal);
                showbalance.setText("Balance : \nRs " +bal);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("In onCancelled" , "Firebase");
            }

        });

       /* mDatabase.child("DateAndTime").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                pasttime = String.valueOf(dataSnapshot.getValue());
                Log.d("In firebase", " " + pasttime);
                lastlogin.setText("You last logged in : " +pasttime);
                mDatabase.child("DateAndTime").setValue(ServerValue.TIMESTAMP);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("In onCancelled" , "Firebase");
            }

        });*/

        transfer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != 1) {
                    control = 0;
                    reset(id);
                    id = 1;
                }
                control++;
                if(control==2) {
                    transfer.setBackgroundResource(0);
                    Intent checkingIntent = new Intent(MenuActivity.this, contactspage.class);
                    startActivity(checkingIntent);
                }
                else{
                    transfer.setBackgroundColor(Color.parseColor("#07689f"));
                }
            }
        });

        creditcard = (ImageButton) findViewById(R.id.cc);

        //register checking button with Event Listener class, and Event handler method
        creditcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != 2) {
                    control = 0;
                    reset(id);
                    id = 2;
                }
                control++;
                if(control==2) {
                    creditcard.setBackgroundResource(0);
                }
                else{
                    creditcard.setBackgroundColor(Color.parseColor("#07689f"));
                }
            }
        });
         billpayments = (ImageButton) findViewById(R.id.billpayments);

        //register checking button with Event Listener class, and Event handler method
        billpayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != 3) {
                    control = 0;
                    reset(id);
                    id = 3;
                }
                control++;
                if(control==2) {
                    billpayments.setBackgroundResource(0);
                }
                else{
                    billpayments.setBackgroundColor(Color.parseColor("#07689f"));
                }
            }
        });
        bankstatements = (ImageButton) findViewById(R.id.bankstatements);

        //register checking button with Event Listener class, and Event handler method
        bankstatements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != 4) {
                    control = 0;
                    reset(id);
                    id = 4;
                }
                control++;
                if(control==4) {
                    bankstatements.setBackgroundResource(0);
                }
                else{
                    bankstatements.setBackgroundColor(Color.parseColor("#07689f"));
                }
            }
        });

        constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               reset(id);
               control = 0;
            }
        });
    }

    public void reset(int idno)
    {
        switch(idno){
            case 1: transfer.setBackgroundResource(0);break;
            case 2: creditcard.setBackgroundResource(0);break;
            case 3: billpayments.setBackgroundResource(0);break;
            case 4: bankstatements.setBackgroundResource(0);break;
            case 5: yesqp.setBackgroundResource(R.drawable.roundbutton);break;

        }
    }
}
