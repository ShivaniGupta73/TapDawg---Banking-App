package com.example.tapdawg02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class PayeeInfo extends AppCompatActivity {

    DatabaseReference mDatabase;
    int finalamount;
    String bal;
    int ibal;
    int moneyafterdeduction;
    String smoneyafterdeduction;
    String tofieldname, accountno;
    Bundle extras;
    TextView fromfield, tofield, showamount;
    Button confirm;
    LinearLayout paylinearlayout;
    int ctr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payee_info);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        paylinearlayout = (LinearLayout) findViewById(R.id.payeeinfolayout);
        ctr = 0;

        extras = getIntent().getExtras();
        tofieldname = extras.getString("To field");
        accountno = extras.getString("Account number");
        finalamount = extras.getInt("finalamount");
        Log.d("Name", ": " + tofieldname);
        Log.d("Account Number justwork", ": " + finalamount);

        fromfield = (TextView) findViewById(R.id.From);
        tofield = (TextView) findViewById(R.id.To);
        showamount = (TextView) findViewById(R.id.Amount);
        confirm = (Button) findViewById(R.id.Confirmbutton);
        Log.i("Outside Balance change", "Balance to be deducted " + finalamount);

        mDatabase.child("Balance").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bal = String.valueOf(dataSnapshot.getValue());
             //   Log.i("Inside Balance change", "Balance in account " + bal);
                ibal = Integer.parseInt(bal);
                moneyafterdeduction = ibal - finalamount;
                smoneyafterdeduction = String.valueOf(moneyafterdeduction);
                Log.i("Inside Balance change" , "Balance in account " + bal );
                Log.i("Inside Balance change" , "Balance after conversion " + smoneyafterdeduction );
                if(moneyafterdeduction < 0)
                {
                    Toast.makeText(PayeeInfo.this, "Account Balance Insufficient" , Toast.LENGTH_SHORT).show();
                    whenpressedback();
                }
                else {
                    mDatabase.child("Balance").setValue(smoneyafterdeduction);
                   /* .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Log.d("firebase", "value added");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                        }
                    });*/

                    fromfield.setText(" From : Rakshit Sharma");
                    tofield.setText(" To : "+tofieldname);
                    showamount.setText(" Amount : Rs " + finalamount);

                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("In onCancelled", "Firebase");
            }
        });

        Log.i("Outside Balance change", "Balance in account " + bal);
        Log.i("Outside Balance change" , "Balance in account " + bal );
        Log.i("Outside Balance change" , "Balance after conversion " + smoneyafterdeduction );

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctr++;
                if (ctr == 2) {
                    confirm.setBackgroundResource(R.drawable.roundbuttonl);
                    Intent payeeintent = new Intent(PayeeInfo.this, AuthenticationPage.class);
                    payeeintent.putExtras(extras);
                    startActivity(payeeintent);
                    ctr = 0;
                } else {
                    confirm.setBackgroundResource(R.drawable.roundbuttonforbackground);
                }
            }
        });

        paylinearlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ctr=0;
                confirm.setBackgroundResource(R.drawable.roundbutton);
            }
        });

    }
    public void whenpressedback() {
        Intent intent = new Intent(getApplicationContext(),MenuActivity.class);
        startActivity(intent);
        finish();
    }

}

