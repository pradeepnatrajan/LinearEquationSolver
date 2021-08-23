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

public class Main5Activity extends Activity {

    private AdView mAdView;

    EditText text,text2,text3,text4,text5,text6,text7,text8,text9,text10,text11,text12,text13,text14,text15,
            text16,text17,text18,text19,text20,text21,text22,text23,text24,text25,text26,text27,text28,text29,text30;
    TextView view,view2,view3,view4,view5;
    Button calculate;
    double a1,a2,a3,a4,a5,b1,b2,b3,b4,b5,c1,c2,c3,c4,c5,d1,d2,d3,d4,d5,e1,e2,e3,e4,e5,f1,f2,f3,f4,f5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

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
        text21 = (EditText) findViewById(R.id.editText21);
        text22 = (EditText) findViewById(R.id.editText22);
        text23 = (EditText) findViewById(R.id.editText23);
        text24 = (EditText) findViewById(R.id.editText24);
        text25 = (EditText) findViewById(R.id.editText25);
        text26= (EditText) findViewById(R.id.editText26);
        text27 = (EditText) findViewById(R.id.editText27);
        text28 = (EditText) findViewById(R.id.editText28);
        text29 = (EditText) findViewById(R.id.editText29);
        text30 = (EditText) findViewById(R.id.editText30);
        view = (TextView) findViewById(R.id.textView9);
        view2 = (TextView) findViewById(R.id.textView10);
        view3 = (TextView) findViewById(R.id.textView11);
        view4 = (TextView) findViewById(R.id.textView12);
        view5 = (TextView) findViewById(R.id.textView3);

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
        text21.addTextChangedListener(TextWt);
        text22.addTextChangedListener(TextWt);
        text23.addTextChangedListener(TextWt);
        text24.addTextChangedListener(TextWt);
        text25.addTextChangedListener(TextWt);
        text26.addTextChangedListener(TextWt);
        text27.addTextChangedListener(TextWt);
        text28.addTextChangedListener(TextWt);
        text29.addTextChangedListener(TextWt);
        text30.addTextChangedListener(TextWt);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                a1= Double.parseDouble(text.getText().toString());
                b1=  Double.parseDouble(text2.getText().toString());
                c1=  Double.parseDouble(text3.getText().toString());
                d1=  Double.parseDouble(text4.getText().toString());
                e1=  Double.parseDouble(text5.getText().toString());
                f1=  Double.parseDouble(text6.getText().toString());
                a2= Double.parseDouble(text7.getText().toString());
                b2=  Double.parseDouble(text8.getText().toString());
                c2=  Double.parseDouble(text9.getText().toString());
                d2=  Double.parseDouble(text10.getText().toString());
                e2=  Double.parseDouble(text11.getText().toString());
                f2=  Double.parseDouble(text12.getText().toString());
                a3= Double.parseDouble(text13.getText().toString());
                b3=  Double.parseDouble(text14.getText().toString());
                c3=  Double.parseDouble(text15.getText().toString());
                d3=  Double.parseDouble(text16.getText().toString());
                e3=  Double.parseDouble(text17.getText().toString());
                f3=  Double.parseDouble(text18.getText().toString());
                a4= Double.parseDouble(text19.getText().toString());
                b4=  Double.parseDouble(text20.getText().toString());
                c4=  Double.parseDouble(text21.getText().toString());
                d4=  Double.parseDouble(text22.getText().toString());
                e4=  Double.parseDouble(text23.getText().toString());
                f4=  Double.parseDouble(text24.getText().toString());
                a5= Double.parseDouble(text25.getText().toString());
                b5=  Double.parseDouble(text26.getText().toString());
                c5=  Double.parseDouble(text27.getText().toString());
                d5=  Double.parseDouble(text28.getText().toString());
                e5=  Double.parseDouble(text29.getText().toString());
                f5=  Double.parseDouble(text30.getText().toString());

                double [][]a ={{a1,b1,c1,d1,e1},{a2,b2,c2,d2,e2},{a3,b3,c3,d3,e3},{a4,b4,c4,d4,e4},{a5,b5,c5,d5,e5}};
                double [][]b = {{f1,0,0,0,0},{f2,0,0,0,0},{f3,0,0,0,0},{f4,0,0,0,0},{f5,0,0,0,0}};
                double [][]CInv = new double[5][5];
                double [][]result = new double[5][5];

                double det = determinant(a);
                CInv = inverse(a);

                if(det!=0)
                {
                    Mult(CInv,b,result);
                    double x= result[0][0];
                    double y = result[1][0];
                    double fr = result[2][0];
                    double t = result[3][0];
                    double w = result[4][0];

                    view.setText(" X = " +x);
                    view2.setText(" Y = " +y);
                    view3.setText(" Z = "+fr);
                    view4.setText(" t = " +t);
                    view5.setText(" w = "+w);
                }else
                {
                    view.setText(" Determinant = 0 ");
                    view2.setText("So, Either the eq has ");
                    view3.setText("no sol, or has");
                    view4.setText("infinitely many sol  ");
                    view5.setText("...... thanks..... ");
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
            String f1 = text6.getText().toString().trim();
            String a2 = text7.getText().toString().trim();
            String b2 = text8.getText().toString().trim();
            String c2 = text9.getText().toString().trim();
            String d2 = text10.getText().toString().trim();
            String e2 = text11.getText().toString().trim();
            String f2 = text12.getText().toString().trim();
            String a3 = text13.getText().toString().trim();
            String b3 = text14.getText().toString().trim();
            String c3 = text15.getText().toString().trim();
            String d3 = text16.getText().toString().trim();
            String e3 = text17.getText().toString().trim();
            String f3 = text18.getText().toString().trim();
            String a4 = text19.getText().toString().trim();
            String b4 = text20.getText().toString().trim();
            String c4 = text21.getText().toString().trim();
            String d4 = text22.getText().toString().trim();
            String e4 = text23.getText().toString().trim();
            String f4 = text24.getText().toString().trim();
            String a5 = text25.getText().toString().trim();
            String b5 = text26.getText().toString().trim();
            String c5 = text27.getText().toString().trim();
            String d5 = text28.getText().toString().trim();
            String e5 = text29.getText().toString().trim();
            String f5 = text30.getText().toString().trim();


            calculate.setEnabled(!a1.isEmpty() && !a2.isEmpty() && !a3.isEmpty() && !b1.isEmpty() &&
                    !b2.isEmpty() && !b3.isEmpty() && !c1.isEmpty() && !c2.isEmpty()&& !c3.isEmpty()
                    && !d1.isEmpty() && !d2.isEmpty() && !d3.isEmpty() && !a4.isEmpty() && !b4.isEmpty()
                    && !c4.isEmpty() && !d4.isEmpty() && !e1.isEmpty() && !e2.isEmpty() && !e3.isEmpty()
                    && !f1.isEmpty() && !f2.isEmpty() && !f3.isEmpty() && !f4.isEmpty()
                    && !f5.isEmpty() && !a5.isEmpty() && !e5.isEmpty() && !d5.isEmpty() && !c5.isEmpty() && !b5.isEmpty()
                    && !e4.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    private static double determinant(double[][] matrix) {
        if (matrix.length != matrix[0].length)
            throw new IllegalStateException("invalid dimensions");

        if (matrix.length == 2)
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        double det = 0;
        for (int i = 0; i < matrix[0].length; i++)
            det += Math.pow(-1, i) * matrix[0][i]
                    * determinant(minor(matrix, 0, i));
        return det;
    }

    private static double[][] inverse(double[][] matrix) {
        double[][] inverse = new double[matrix.length][matrix.length];

        // minors and cofactors
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < matrix[i].length; j++)
                inverse[i][j] = Math.pow(-1, i + j)
                        * determinant(minor(matrix, i, j));

        // adjugate and determinant
        double det = 1.0 / determinant(matrix);
        for (int i = 0; i < inverse.length; i++) {
            for (int j = 0; j <= i; j++) {
                double temp = inverse[i][j];
                inverse[i][j] = inverse[j][i] * det;
                inverse[j][i] = temp * det;
            }
        }

        return inverse;
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
        for ( int i = 0; i < 5; i++)
        {
            for (int j = 0; j < 5; j++)
            {
                res[i][j] = 0;
                for (int k = 0; k < 5; k++)
                    res[i][j] += M1[i][k]*M2[k][j];

            }
        }
    }



}
