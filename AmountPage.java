package com.example.tapdawg02;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class AmountPage extends AppCompatActivity {

    int amount = 0;
    Button amount100;
    Button amount200;
    Button amount500;
    Button amount1000;
    Button amount2000;
    Button amount5000;
    Button amount10000;
    Button amount20000;
    Button amount50000;
    Button done;
    int ishowamount;
    Intent amountpageintent;
    EditText showamount;
    String sshowamount;
    //   int ctr100, ctr200, ctr500, ctr1000, ctr2000, ctr5000, ctr10000, ctr20000, ctr50000;
    int control;
    int id;
    LinearLayout amountpagelayout;
    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amount_page);

        amount100 = (Button) findViewById(R.id.a100);
        amount200 = (Button) findViewById(R.id.a200);
        amount500 = (Button) findViewById(R.id.a500);
        amount1000 = (Button) findViewById(R.id.a1000);
        amount2000 = (Button) findViewById(R.id.a2000);
        amount5000 = (Button) findViewById(R.id.a5000);
        amount10000 = (Button) findViewById(R.id.a10000);
        amount20000 = (Button) findViewById(R.id.a20000);
        amount50000 = (Button) findViewById(R.id.a50000);
        done = (Button) findViewById(R.id.done);
      /*  ctr100 = 0;
        ctr200 = 0;
        ctr500 = 0;
        ctr1000 = 0;
        ctr2000 = 0;
        ctr5000 = 0;
        ctr10000 = 0;
        ctr20000 = 0;
        ctr50000 = 0;*/
        control = 0;
        id = 1;
        sshowamount = "";
        ishowamount = 0;
        showamount = (EditText) findViewById(R.id.amountentered);
        amountpagelayout = (LinearLayout) findViewById(R.id.amountpagelayout);

        extras = getIntent().getExtras();

        amount100.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ctr100++;
                if (ctr100 == 2) {
                    amount = 100;
                    ctr100 = 0;
                    amount100.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount100.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 1) {
                    control = 0;
                    reset(id);
                    id = 1;
                }
                control++;
                if (control == 2) {
                    amount = 100;
                    control = 0;
                    amount100.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount100.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });

        amount200.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ctr200++;
                if (ctr200 == 2) {
                    amount = 200;
                    ctr200 = 0;
                    amount200.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount200.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 2) {
                    control = 0;
                    reset(id);
                    id = 2;
                }
                control++;
                if (control == 2) {
                    amount = 200;
                    control = 0;
                    amount200.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount200.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });

        amount500.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ctr500++;
                if (ctr500 == 2) {
                    amount = 500;
                    ctr500 = 0;
                    amount500.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount500.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 3) {
                    control = 0;
                    reset(id);
                    id = 3;
                }
                control++;
                if (control == 2) {
                    amount = 500;
                    control = 0;
                    amount500.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount500.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });
        amount1000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  ctr1000++;
                if (ctr1000 == 2) {
                    amount = 1000;
                    //  showamount.setText("" + amount);
                    ctr1000 = 0;
                    amount1000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount1000.setBackgroundResource(R.drawable.circle_blue);
                }
            }*/
                if (id != 4) {
                    control = 0;
                    reset(id);
                    id = 4;
                }
                control++;
                if (control == 2) {
                    amount = 1000;
                    control = 0;
                    amount1000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount1000.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });
        amount2000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  ctr2000++;
                if (ctr2000 == 2) {
                    amount = 2000;
                    // showamount.setText("" + amount);
                    ctr2000 = 0;
                    amount2000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount2000.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 5) {
                    control = 0;
                    reset(id);
                    id = 5;
                }
                control++;
                if (control == 2) {
                    amount = 2000;
                    control = 0;
                    amount2000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount2000.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });
        amount5000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ctr5000++;
                if (ctr5000 == 2) {
                    amount = 5000;
                    //  showamount.setText("" + amount);
                    ctr5000 = 0;
                    amount5000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount5000.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 6) {
                    control = 0;
                    reset(id);
                    id = 6;
                }
                control++;
                if (control == 2) {
                    amount = 5000;
                    control = 0;
                    amount5000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount5000.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });

        amount10000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ctr10000++;
                if (ctr10000 == 2) {
                    amount = 10000;
                    //  showamount.setText("" + amount);
                    ctr10000 = 0;
                    amount10000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount10000.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 7) {
                    control = 0;
                    reset(id);
                    id = 7;
                }
                control++;
                if (control == 2) {
                    amount = 10000;
                    control = 0;
                    amount10000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount10000.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });
        amount20000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*ctr20000++;
                if (ctr20000 == 2) {
                    amount = 20000;
                    //  showamount.setText("" + amount);
                    ctr20000 = 0;
                    amount20000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount20000.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 8) {
                    control = 0;
                    reset(id);
                    id = 8;
                }
                control++;
                if (control == 2) {
                    amount = 20000;
                    control = 0;
                    amount20000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount20000.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });
        amount50000.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* ctr50000++;
                if (ctr50000 == 2) {
                    amount = 50000;
                    //  showamount.setText("" + amount);
                    ctr50000 = 0;
                    amount50000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount50000.setBackgroundResource(R.drawable.circle_blue);
                }*/
                if (id != 9) {
                    control = 0;
                    reset(id);
                    id = 9;
                }
                control++;
                if (control == 2) {
                    amount = 50000;
                    control = 0;
                    amount50000.setBackgroundResource(R.drawable.circle_button);
                    quickpayamount();
                } else {
                    amount50000.setBackgroundResource(R.drawable.circle_blue);
                }
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != 10) {
                    reset(id);
                    id = 10;
                    control = 0;
                }
                control++;
                if (control == 2) {
                    done.setBackgroundResource(R.drawable.roundbutton);
                    sshowamount = showamount.getText().toString();
                    if (!sshowamount.matches("")) {
                        ishowamount = Integer.parseInt(sshowamount);
                        if (ishowamount > 0) {
                            amountpageintent = new Intent(AmountPage.this, PayeeInfo.class);
                            extras.putInt("finalamount", ishowamount);
                            amountpageintent.putExtras(extras);
                            startActivity(amountpageintent);
                        }
                    } else {
                        Toast.makeText(AmountPage.this, "Please enter an amount greater than 0.", Toast.LENGTH_SHORT).show();
                    }

                }
                else{
                    done.setBackgroundResource(R.drawable.roundbuttonforbackground);
                }
            }
        });

        amountpagelayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset(id);
                control = 0;
            }
        });


    }

    public void quickpayamount() {
        amountpageintent = new Intent(AmountPage.this, PayeeInfo.class);
        extras.putInt("finalamount" , amount);
        amountpageintent.putExtras(extras);
        startActivity(amountpageintent);
    }

    public void reset(int idno)
    {
        switch(idno){
            case 1: amount100.setBackgroundResource(R.drawable.circle_button);break;
            case 2: amount200.setBackgroundResource(R.drawable.circle_button);break;
            case 3: amount500.setBackgroundResource(R.drawable.circle_button);break;
            case 4: amount1000.setBackgroundResource(R.drawable.circle_button);break;
            case 5: amount2000.setBackgroundResource(R.drawable.circle_button);break;
            case 6: amount5000.setBackgroundResource(R.drawable.circle_button);break;
            case 7: amount10000.setBackgroundResource(R.drawable.circle_button);break;
            case 8: amount20000.setBackgroundResource(R.drawable.circle_button);break;
            case 9: amount50000.setBackgroundResource(R.drawable.circle_button);break;
            case 10: done.setBackgroundResource(R.drawable.roundbutton);
        }
    }
}
