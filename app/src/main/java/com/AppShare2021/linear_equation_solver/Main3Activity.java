package com.AppShare2021.linear_equation_solver;

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

public class Main3Activity extends Activity {

    private AdView mAdView;
    EditText text, text2, text3, text4, text5, text6, text7, text8, text9, text10, text11, text12;
    TextView view, view2, view3;
    Button calculate;
    double a1, a2, a3, b1, b2, b3, c1, c2, c3, d1, d2, d3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        MobileAds.initialize(this, "ca-app-pub-6423354376649677~3257272167");
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        calculate = (Button) findViewById(R.id.button);
        text = (EditText) findViewById(R.id.editText);
        text2 = (EditText) findViewById(R.id.editText2);
        text3 = (EditText) findViewById(R.id.editText3);
        text4 = (EditText) findViewById(R.id.editText4);
        text5 = (EditText) findViewById(R.id.editText5);
        text6 = (EditText) findViewById(R.id.editText6);
        text7 = (EditText) findViewById(R.id.editText7);
        text8 = (EditText) findViewById(R.id.editText8);
        text9 = (EditText) findViewById(R.id.editText9);
        text10 = (EditText) findViewById(R.id.editText10);
        text11 = (EditText) findViewById(R.id.editText11);
        text12 = (EditText) findViewById(R.id.editText12);
        view = (TextView) findViewById(R.id.textView6);
        view2 = (TextView) findViewById(R.id.textView7);
        view3 = (TextView) findViewById(R.id.textView8);

        //for button enabling
        text.addTextChangedListener(TextWt);
        text2.addTextChangedListener(TextWt);
        text3.addTextChangedListener(TextWt);
        text4.addTextChangedListener(TextWt);
        text5.addTextChangedListener(TextWt);
        text6.addTextChangedListener(TextWt);
        text7.addTextChangedListener(TextWt);
        text8.addTextChangedListener(TextWt);
        text9.addTextChangedListener(TextWt);
        text10.addTextChangedListener(TextWt);
        text11.addTextChangedListener(TextWt);
        text12.addTextChangedListener(TextWt);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                a1 = Double.parseDouble(text.getText().toString());
                a2 = Double.parseDouble(text5.getText().toString());
                a3 = Double.parseDouble(text9.getText().toString());
                b1 = Double.parseDouble(text2.getText().toString());
                b2 = Double.parseDouble(text6.getText().toString());
                b3 = Double.parseDouble(text10.getText().toString());
                c1 = Double.parseDouble(text3.getText().toString());
                c2 = Double.parseDouble(text7.getText().toString());
                c3 = Double.parseDouble(text11.getText().toString());
                d1 = Double.parseDouble(text4.getText().toString());
                d2 = Double.parseDouble(text8.getText().toString());
                d3 = Double.parseDouble(text12.getText().toString());

                double[][] a = {{a1, b1, c1, d1}, {a2, b2, c2, d2}, {a3, b3, c3, d3}};
                double[][] result ={{0},{0},{0}};;
                int signal =inverse( a, result);
                if (signal == 0) {
                    double x = result[0][0];
                    double y = result[1][0];
                    double z = result[2][0];
                    view.setText(" x =" + x);
                    view2.setText(" Y =" + y);
                    view3.setText(" Z =" + z);
                } else {
                    view.setText(" Determinant = 0 ");
                    view2.setText("Either the eq has No sol,");
                    view3.setText(" or infinatily many sol");
                }

                CloseKeyboard();
            }
        });

    }

    private void CloseKeyboard() {
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private TextWatcher TextWt = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String a1 = text.getText().toString().trim();
            String a2 = text4.getText().toString().trim();
            String a3 = text2.getText().toString().trim();
            String b1 = text5.getText().toString().trim();
            String b2 = text3.getText().toString().trim();
            String b3 = text6.getText().toString().trim();
            String c1 = text7.getText().toString().trim();
            String c2 = text8.getText().toString().trim();
            String c3 = text9.getText().toString().trim();
            String d1 = text10.getText().toString().trim();
            String d2 = text11.getText().toString().trim();
            String d3 = text12.getText().toString().trim();

            calculate.setEnabled(!a1.isEmpty() && !a2.isEmpty() && !a3.isEmpty() && !b1.isEmpty() &&
                    !b2.isEmpty() && !b3.isEmpty() && !c1.isEmpty() && !c2.isEmpty() && !c3.isEmpty()
                    && !d1.isEmpty() && !d2.isEmpty() && !d3.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    public  int inverse(double [][]a, double [][]res) {
        int i, j, k = 0, c, signal = 0;
        int n = 3;

        for (i = 0; i < n; i++) {
            if (a[i][i] == 0) {
                c = 1;
                while ((i + c) < n && a[i + c][i] == 0)
                    c++;
                if ((i + c) == n) {
                    signal = 1;
                    break;
                }
                for (j = i, k = 0; k <= n; k++) {
                    double temp = a[j][k];
                    a[j][k] = a[j + c][k];
                    a[j + c][k] = temp;
                }
            }

            for (j = 0; j < n; j++) {
                if (i != j) {
                    double p = a[j][i] / a[i][i];

                    for (k = 0; k <= n; k++)
                        a[j][k] = a[j][k] - (a[i][k]) * p;
                }
            }
        }
        if (signal == 1) {
            double sum;
           int l,m;
            signal = 3;
            for (l = 0; l < n; l++) {
                sum = 0;
                for (m = 0; m < n; m++)
                    sum = sum + a[l][m];
                if (sum == a[l][m])
                    signal = 2;
            }
        }
        else {
            res[0][0] = a[0][3] / a[0][0];
            res[1][0] = a[1][3] / a[1][1];
            res[2][0] = a[2][3] / a[2][2];
        }

       return signal;
    }
}
