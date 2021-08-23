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

public class Main4Activity extends Activity {

    private AdView mAdView;

    EditText text,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,text16,text17,text18,text19,text20;
    TextView view,view2,view3,view4;
    Button calculate;
    double a1,a2,a3,a4,b1,b2,b3,b4,c1,c2,c3,c4,d1,d2,d3,d4,e1,e2,e3,e4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

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
        text7 = (EditText) findViewById(R.id.editText7);
        text8 = (EditText) findViewById(R.id.editText8);
        text9 = (EditText) findViewById(R.id.editText9);
        text10 = (EditText) findViewById(R.id.editText10);
        text11 = (EditText) findViewById(R.id.editText11);
        text12= (EditText) findViewById(R.id.editText12);
        text13 = (EditText) findViewById(R.id.editText13);
        text14 = (EditText) findViewById(R.id.editText14);
        text15 = (EditText) findViewById(R.id.editText15);
        text16= (EditText) findViewById(R.id.editText16);
        text17 = (EditText) findViewById(R.id.editText17);
        text18 = (EditText) findViewById(R.id.editText18);
        text19 = (EditText) findViewById(R.id.editText19);
        text20 = (EditText) findViewById(R.id.editText20);
        view = (TextView) findViewById(R.id.textView9);
        view2 = (TextView) findViewById(R.id.textView10);
        view3 = (TextView) findViewById(R.id.textView11);
        view4 = (TextView) findViewById(R.id.textView12);

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
        text13.addTextChangedListener(TextWt);
        text14.addTextChangedListener(TextWt);
        text15.addTextChangedListener(TextWt);
        text16.addTextChangedListener(TextWt);
        text17.addTextChangedListener(TextWt);
        text18.addTextChangedListener(TextWt);
        text19.addTextChangedListener(TextWt);
        text20.addTextChangedListener(TextWt);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a1= Double.parseDouble(text.getText().toString());
                b1=  Double.parseDouble(text2.getText().toString());
                c1=  Double.parseDouble(text3.getText().toString());
                d1=  Double.parseDouble(text4.getText().toString());
                e1=  Double.parseDouble(text5.getText().toString());
                a2= Double.parseDouble(text6.getText().toString());
                b2=  Double.parseDouble(text7.getText().toString());
                c2=  Double.parseDouble(text8.getText().toString());
                d2=  Double.parseDouble(text9.getText().toString());
                e2=  Double.parseDouble(text10.getText().toString());
                a3= Double.parseDouble(text11.getText().toString());
                b3=  Double.parseDouble(text12.getText().toString());
                c3=  Double.parseDouble(text13.getText().toString());
                d3=  Double.parseDouble(text14.getText().toString());
                e3=  Double.parseDouble(text15.getText().toString());
                a4= Double.parseDouble(text16.getText().toString());
                b4=  Double.parseDouble(text17.getText().toString());
                c4=  Double.parseDouble(text18.getText().toString());
                d4=  Double.parseDouble(text19.getText().toString());
                e4=  Double.parseDouble(text20.getText().toString());

                double [][]a ={{a1,b1,c1,d1},{a2,b2,c2,d2},{a3,b3,c3,d3},{a4,b4,c4,d4}};
                double [][]b = {{e1,0,0,0},{e2,0,0,0},{e3,0,0,0},{e4,0,0,0}};
                double [][]CInv = new double[4][4];
                double [][]result = new double[4][4];

                double det = determinant(a);

                if(det!=0)
                {
                    inverse(det, a, CInv);
                    Mult(CInv,b,result);
                    double x= result[0][0];
                    double y = result[1][0];
                    double z = result[2][0];
                    double t = result[3][0];

                    view.setText(" X = " +x);
                    view2.setText(" Y = " +y);
                    view3.setText(" Z = " +z);
                    view4.setText(" t = " +t);
                }else
                {
                    view.setText(" Determinant = 0 ");
                    view2.setText("Either the eq has No sol,");
                    view3.setText(" or infinatily many sol");
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



    private TextWatcher TextWt = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String a1 = text.getText().toString().trim();
            String b1 = text2.getText().toString().trim();
            String c1 = text3.getText().toString().trim();
            String d1 = text4.getText().toString().trim();
            String e1 = text5.getText().toString().trim();
            String a2 = text6.getText().toString().trim();
            String b2 = text7.getText().toString().trim();
            String c2 = text8.getText().toString().trim();
            String d2 = text9.getText().toString().trim();
            String e2 = text10.getText().toString().trim();
            String a3 = text11.getText().toString().trim();
            String b3 = text12.getText().toString().trim();
            String c3 = text13.getText().toString().trim();
            String d3 = text14.getText().toString().trim();
            String e3 = text15.getText().toString().trim();
            String a4 = text16.getText().toString().trim();
            String b4 = text17.getText().toString().trim();
            String c4 = text18.getText().toString().trim();
            String d4 = text19.getText().toString().trim();
            String e4 = text20.getText().toString().trim();


            calculate.setEnabled(!a1.isEmpty() && !a2.isEmpty() && !a3.isEmpty() && !b1.isEmpty() &&
                    !b2.isEmpty() && !b3.isEmpty() && !c1.isEmpty() && !c2.isEmpty()&& !c3.isEmpty()
                    && !d1.isEmpty() && !d2.isEmpty() && !d3.isEmpty() && !a4.isEmpty() && !b4.isEmpty()
                    && !c4.isEmpty() && !d4.isEmpty() && !e1.isEmpty() && !e2.isEmpty() && !e3.isEmpty() && !e4.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };







    private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    public void inverse(double d,double a[][],double inv[][])
    {
        double temp;
        int order=4;
        for (int i = 0; i < order; i++) {

            for (int j = 0; j < 2 * order; j++) {
                if (j == (i + order))
                    a[i][j] = 1;
            }
        }

        for (int i = order - 1; i > 0; i--) {

            if (a[i - 1][0] < a[i][0])
            {
                int x =i-1;
                int y=i;
                for(int j = 0; j <order; j++)
                {
                    double  c = a[(x-1)][j];
                    a[x-1][j] = a[y-1][j];
                    a[y-1][j] = c;
                }
            }
        }
        for (int i = 0; i < order; i++) {

            for (int j = 0; j < order; j++) {

                if (j != i) {

                    temp = a[j][i] / a[i][i];
                    for (int k = 0; k < 2 * order; k++) {

                        a[j][k] -= a[i][k] * temp;
                    }
                }
            }
        }
        for (int i = 0; i < order; i++) {

            temp = a[i][i];
            for (int j = 0; j < 2 * order; j++) {

                a[i][j] = a[i][j] / temp;
            }
        }
        inv= a.clone();

    }
    private static double[][] minor(double[][] matrix, int row, int column) {
        double[][] minor = new double[matrix.length - 1][matrix.length - 1];

        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; i != row && j < matrix[i].length; j++)
                if (j != column)
                    minor[i < row ? i : i - 1][j < column ? j : j - 1] = matrix[i][j];
        return minor;
    }

    public void Mult(double [][] M1,double [][]M2 , double [][]res)
    {
        for ( int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                res[i][j] = 0;
                for (int k = 0; k < 4; k++)
                    res[i][j] += M1[i][k]*M2[k][j];

            }
        }
    }



}
