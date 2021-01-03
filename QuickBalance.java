package com.example.tapdawg02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Map;

public class QuickBalance extends AppCompatActivity {

    private static int TIME_OUT = 4000; //Time to launch the another activity
    private DatabaseReference mDatabase;

    TextView showbalance;
    String bal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quick_balance);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        showbalance = (TextView) findViewById(R.id.Balance);

        mDatabase.child("Balance").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                    bal = String.valueOf(dataSnapshot.getValue());
                    Log.d("In firebase", " " + bal);
                    showbalance.setText("Rs " +bal);
                }
            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Log.d("In onCancelled" , "Firebase");
            }
        });


      //  final View myLayout = findViewById(R.id.MainActivity);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(QuickBalance.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, TIME_OUT);
    }
}
