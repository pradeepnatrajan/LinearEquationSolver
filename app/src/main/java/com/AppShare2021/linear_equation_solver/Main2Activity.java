package com.AppShare2021.linear_equation_solver;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Main2Activity extends Activity {

    private AdView mAdView;
    EditText text,text2,text3,text4,text5,text6;
    TextView view,view2;
    Button calculate;
    float x1,x2,y1,y2,c1,c2;
    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        MobileAds.initialize(this, "ca-app-pub-6423354376649677~3257272167");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        calculate =(Button) findViewById(R.id.button);
        text = (EditText) findViewById(R.id.editText);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6= (EditText) findViewById(R.id.editText6);
        view = (TextView) findViewById(R.id.textView11);
        view2 = (TextView) findViewById(R.id.textView13);

        text.addTextChangedListener(loginTextWatcher);
        text2.addTextChangedListener(loginTextWatcher);
        text3.addTextChangedListener(loginTextWatcher);
        text4.addTextChangedListener(loginTextWatcher);
        text5.addTextChangedListener(loginTextWatcher);
        text6.addTextChangedListener(loginTextWatcher);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x1= Float.parseFloat(text.getText().toString());
                x2= Float.parseFloat(text4.getText().toString());
                y1= Float.parseFloat(text2.getText().toString());
                y2= Float.parseFloat(text5.getText().toString());
                c1= Float.parseFloat(text3.getText().toString());
                c2= Float.parseFloat(text6.getText().toString());

                float w = (x1*y2) - (y1*x2);
                float a[][] = {{y2,-y1},{-x2,x1}};
                float b[][] = {{c1,0},{c2,0}};
                float c[][] = new float[2][2];

                for(int i=0;i<2;i++){
                    for(int j=0;j<2;j++)
                    {
                        c[i][j] =0;
                        for(int k=0;k<2;k++)
                        {
                            c[i][j]+= a[i][k]*b[k][j];
                        }
                    }
                }

                if(w!=0) {
                    // float  x = ((c1 * y2) - (c2 * y1))/((x1 * y2) - (x2 * y1));
                    float x = (1/w)*c[0][0];
                    view.setText(" X = " + x);

                    // float y = ((c1 * x2) - (c2 * x1)) / ((x2 * y1) - (x1 * y2));
                    float y = (1/w)*c[1][0];
                    view2.setText(" Y = " +y );
                }

                 else {
                 view.setText("either the eq has no solution ");
                 view2.setText("or infinitly many solution");
                 }


                CloseKeyboard();
            }


        });

    }


    private void CloseKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken() , 0);
        }
    }
    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String x1 = text.getText().toString().trim();
            String x2 = text4.getText().toString().trim();
            String y1 = text2.getText().toString().trim();
            String y2 = text5.getText().toString().trim();
            String c1 = text3.getText().toString().trim();
            String c2 = text6.getText().toString().trim();

            calculate.setEnabled(!x1.isEmpty() && !x2.isEmpty() && !y1.isEmpty() && !y2.isEmpty() && !c1.isEmpty() && !c2.isEmpty());


        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


}
