package com.example.tapdawg02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class FinalConfirmation extends AppCompatActivity {

    String tofieldname, accountno;
    Bundle extras;
    private DatabaseReference mDatabase, mDatabase1;
    int finalamount;
    Button homepage, anotherpaymentpage;
    LinearLayout finallayout;
    int control, id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_confirmation);

        extras = getIntent().getExtras();
        tofieldname = extras.getString("To field");
        accountno = extras.getString("Account number");
        finalamount = extras.getInt("finalamount");

        finallayout = (LinearLayout) findViewById(R.id.finallayout);

        homepage = (Button) findViewById(R.id.home);
        anotherpaymentpage = (Button) findViewById(R.id.Ap);
        Log.d("final confirmationyo ", "accountno" + accountno);
        Log.d("final confirmationyo ", "finalamount" + finalamount);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        mDatabase.child("Transactions").child(accountno).push().setValue(finalamount);

        homepage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (id != 1) {
                    reset(id);
                    control = 0;
                    id = 1;
                }
                control++;
                if (control == 2) {
                    homepage.setBackgroundResource(R.drawable.roundbutton);
                    Intent finalintent = new Intent(FinalConfirmation.this, MenuActivity.class);
                    startActivity(finalintent);
                }
                else{
                    homepage.setBackgroundResource(R.drawable.roundbuttonforbackground);
                }
            }
        });

        anotherpaymentpage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (id != 2) {
                        reset(id);
                        control = 0;
                        id = 2;
                    }
                    control++;
                    if (control == 2) {
                        anotherpaymentpage.setBackgroundResource(R.drawable.roundbutton);
                        Intent finalintent = new Intent(FinalConfirmation.this, contactspage.class);
                        startActivity(finalintent);
                    }
                    else
                    {
                        anotherpaymentpage.setBackgroundResource(R.drawable.roundbuttonforbackground);
                    }
            }
        });

        finallayout.setOnClickListener(new View.OnClickListener() {
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
            case 1: homepage.setBackgroundResource(R.drawable.roundbutton);break;
            case 2: anotherpaymentpage.setBackgroundResource(R.drawable.roundbutton);break;
        }
    }

}
