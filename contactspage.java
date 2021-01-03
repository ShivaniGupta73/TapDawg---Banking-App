package com.example.tapdawg02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Map;

public class contactspage extends AppCompatActivity {

    ImageButton contact1, contact2, contact3, contact4, contact5, contact6, contact7, contact8, contact9;
    DatabaseReference mDatabase;
    String accountno;
   // private SharedPreferences mySharedPreferences;
    Intent contactpageintent, intent;
    SharedPreferences.Editor editor;
    Bundle extras;
    TextView c1, c2, c3, c4, c5, c6, c7, c8, c9;
    int control, id;
    LinearLayout layoutpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactspage);

        contact1 = (ImageButton) findViewById(R.id.contact1);
        contact2 = (ImageButton) findViewById(R.id.contact2);
        contact3 = (ImageButton) findViewById(R.id.contact3);
        contact4 = (ImageButton) findViewById(R.id.contact4);
        contact5 = (ImageButton) findViewById(R.id.contact5);
        contact6 = (ImageButton) findViewById(R.id.contact6);
        contact7 = (ImageButton) findViewById(R.id.contact7);
        contact8 = (ImageButton) findViewById(R.id.contact8);
        contact9 = (ImageButton) findViewById(R.id.contact9);

        mDatabase = FirebaseDatabase.getInstance().getReference();
        layoutpage = (LinearLayout) findViewById(R.id.contactlayout);

        int prefMode = Activity.MODE_PRIVATE;
        control = 0;

        c1 = (TextView) findViewById(R.id.contact1text);
        c2 = (TextView) findViewById(R.id.contact2text);
        c3 = (TextView) findViewById(R.id.contact3text);
        c4 = (TextView) findViewById(R.id.contact4text);
        c5 = (TextView) findViewById(R.id.contact5text);
        c6 = (TextView) findViewById(R.id.contact6text);
        c7 = (TextView) findViewById(R.id.contact7text);
        c8 = (TextView) findViewById(R.id.contact8text);
        c9 = (TextView) findViewById(R.id.contact9text);

        contact1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=1){
                    control = 0;
                    reset(id);
                    id = 1;
                }
                control++;
                if(control==2) {
                    c1.setBackgroundResource(R.drawable.normalcontacts);
                    mDatabase.child("BeneficiaryName").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.getKey().equals("Malvin Kiman")) {
                                    accountno = String.valueOf(data.getValue());
                                }
                            }
                            Log.d("yoboy contact 1", " Account no. : " + accountno);
                            intent = new Intent(contactspage.this, AmountPage.class);
                            extras = new Bundle();
                            extras.putString("To field", "Malvin Kiman");
                            extras.putString("Account number", accountno);
                            intent.putExtras(extras);
                        /*editor = mySharedPreferences.edit();
                        editor.putString("Name1", "Shivani Gupta");
                        editor.putString("Account", accountno);
                        editor.commit();*/
                            startActivity(intent);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d("In onCancelled", "Firebase");
                        }
                    });
                }
                else{
                    c1.setBackgroundResource(R.drawable.forcontacts);
                }
            }
        });

        contact2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=2){
                    reset(id);
                    control = 0;
                    id = 2;
                }
                control++;
                if(control==2) {
                    c2.setBackgroundResource(R.drawable.normalcontacts);
                    mDatabase.child("BeneficiaryName").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.getKey().equals("Meghansh Khanna")) {
                                    accountno = String.valueOf(data.getValue());
                                }
                            }
                            Log.d("contact 2", " Account no. : " + accountno);
                            intent = new Intent(contactspage.this, AmountPage.class);
                            extras = new Bundle();
                            extras.putString("To field", "Meghansh Khanna");
                            extras.putString("Account number", accountno);
                            intent.putExtras(extras);
                        /*editor = mySharedPreferences.edit();
                        editor.putString("Name1", "Shivani Gupta");
                        editor.putString("Account", accountno);
                        editor.commit();*/
                            startActivity(intent);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d("In onCancelled", "Firebase");
                        }
                    });
                }
                else{
                    c2.setBackgroundResource(R.drawable.forcontacts);
                }
            }
        });

        contact3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=3){
                    reset(id);
                    id = 3;
                    control = 0;
                }
                control++;
                if(control==2) {
                    c3.setBackgroundResource(R.drawable.normalcontacts);
                    mDatabase.child("BeneficiaryName").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.getKey().equals("Shivani Gupta")) {
                                    accountno = String.valueOf(data.getValue());
                                }
                            }
                            Log.d("Yoboy3 contact 3", " Account no. : " + accountno);
                            intent = new Intent(contactspage.this, AmountPage.class);
                            extras = new Bundle();
                            extras.putString("To field", "Shivani Gupta");
                            extras.putString("Account number", accountno);
                            intent.putExtras(extras);
                        /*editor = mySharedPreferences.edit();
                        editor.putString("Name1", "Shivani Gupta");
                        editor.putString("Account", accountno);
                        editor.commit();*/
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d("In onCancelled", "Firebase");
                        }
                    });
                }
                else{
                    c3.setBackgroundResource(R.drawable.forcontacts);
                }
            }
        });
        contact4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=4){
                    reset(id);
                    control = 0;
                    id = 4;
                }
                control++;
                if(control==2) {
                    c4.setBackgroundResource(R.drawable.normalcontacts);
                    mDatabase.child("BeneficiaryName").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.getKey().equals("Vanshraj Singh")) {
                                    accountno = String.valueOf(data.getValue());
                                }
                            }
                            Log.d("Yoboy3 contact 3", " Account no. : " + accountno);
                            intent = new Intent(contactspage.this, AmountPage.class);
                            extras = new Bundle();
                            extras.putString("To field", "Vanshraj Singh");
                            extras.putString("Account number", accountno);
                            intent.putExtras(extras);
                        /*editor = mySharedPreferences.edit();
                        editor.putString("Name1", "Shivani Gupta");
                        editor.putString("Account", accountno);
                        editor.commit();*/
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d("In onCancelled", "Firebase");
                        }
                    });
                }
                else{
                    c4.setBackgroundResource(R.drawable.forcontacts);
                }
            }
        });


        contact5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=5)
                {
                    reset(id);
                    id = 5;
                    control = 0;
                }
                control++;
                if(control==2) {
                    c5.setBackgroundResource(R.drawable.normalcontacts);
                    mDatabase.child("BeneficiaryName").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.getKey().equals("Wellington Chirigo")) {
                                    accountno = String.valueOf(data.getValue());
                                }
                            }
                            Log.d("Yoboy3 contact 3", " Account no. : " + accountno);
                            intent = new Intent(contactspage.this, AmountPage.class);
                            extras = new Bundle();
                            extras.putString("To field", "Wellington Chirigo");
                            extras.putString("Account number", accountno);
                            intent.putExtras(extras);
                        /*editor = mySharedPreferences.edit();
                        editor.putString("Name1", "Shivani Gupta");
                        editor.putString("Account", accountno);
                        editor.commit();*/
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d("In onCancelled", "Firebase");
                        }
                    });
                }
                else
                {
                    c5.setBackgroundResource(R.drawable.forcontacts);
                }
            }
        });


        contact6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(id!=6)
                {
                    reset(id);
                    id = 6;
                    control = 0;
                }
                control++;
                if(control==2) {
                    c6.setBackgroundResource(R.drawable.forcontacts);
                    mDatabase.child("BeneficiaryName").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                if (data.getKey().equals("David McKenna")) {
                                    accountno = String.valueOf(data.getValue());
                                }
                            }
                            Log.d("Yoboy3 contact 3", " Account no. : " + accountno);
                            intent = new Intent(contactspage.this, AmountPage.class);
                            extras = new Bundle();
                            extras.putString("To field", "David McKenna");
                            extras.putString("Account number", accountno);
                            intent.putExtras(extras);
                        /*editor = mySharedPreferences.edit();
                        editor.putString("Name1", "Shivani Gupta");
                        editor.putString("Account", accountno);
                        editor.commit();*/
                            startActivity(intent);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {
                            Log.d("In onCancelled", "Firebase");
                        }
                    });
                }
                else{
                    c6.setBackgroundResource(R.drawable.forcontacts);
                }
            }
        });

        layoutpage.setOnClickListener(new View.OnClickListener() {
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
            case 1: c1.setBackgroundResource(R.drawable.normalcontacts);break;
            case 2: c2.setBackgroundResource(R.drawable.normalcontacts);break;
            case 3: c3.setBackgroundResource(R.drawable.normalcontacts);break;
            case 4: c4.setBackgroundResource(R.drawable.normalcontacts);break;
            case 5: c5.setBackgroundResource(R.drawable.normalcontacts);break;
            case 6: c6.setBackgroundResource(R.drawable.normalcontacts);break;
            case 7: c7.setBackgroundResource(R.drawable.normalcontacts);break;
            case 8: c8.setBackgroundResource(R.drawable.normalcontacts);break;
            case 9: c9.setBackgroundResource(R.drawable.normalcontacts);break;
        }
    }

}

