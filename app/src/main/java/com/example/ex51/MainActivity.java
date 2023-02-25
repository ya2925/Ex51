package com.example.ex51;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //declarations
    TextView R1_TV1,R1_TV2,R2_TV1,R2_TV2,R3_TV1,R3_TV2;
    EditText R1_ET,R2_ET,R3_ET;
    ImageView R1_IV,R2_IV,R3_IV;
    Button R1_BTN,R2_BTN,R3_BTN;
    Random rnd;
    int column = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //marry with XML
        R1_TV1 = (TextView) findViewById(R.id.R1_TV1);
        R1_TV2 = (TextView) findViewById(R.id.R1_TV2);
        R2_TV1 = (TextView) findViewById(R.id.R2_TV1);
        R2_TV2 = (TextView) findViewById(R.id.R2_TV2);
        R3_TV1 = (TextView) findViewById(R.id.R3_TV1);
        R3_TV2 = (TextView) findViewById(R.id.R3_TV2);

        R1_ET = (EditText) findViewById(R.id.R1_ET);
        R2_ET = (EditText) findViewById(R.id.R2_ET);
        R3_ET = (EditText) findViewById(R.id.R3_ET);

        R1_IV = (ImageView) findViewById(R.id.R1_IV);
        R2_IV = (ImageView) findViewById(R.id.R2_IV);
        R3_IV = (ImageView) findViewById(R.id.R3_IV);

        R1_BTN = (Button) findViewById(R.id.R1_BTN);
        R2_BTN = (Button) findViewById(R.id.R2_BTN);
        R3_BTN = (Button) findViewById(R.id.R3_BTN);


        R1_BTN.setVisibility(View.INVISIBLE);
        R2_BTN.setVisibility(View.INVISIBLE);
        R3_BTN.setVisibility(View.INVISIBLE);


        rnd = new Random();
    }


    public static boolean checkSum(TextView tv1,TextView tv2,EditText et){
        return ((Integer.parseInt(tv1.getText().toString()) + Integer.parseInt(tv2.getText().toString())) == Integer.parseInt("0" + et.getText().toString()));
    }


    public static void putnumbers(TextView tv1,TextView tv2,int num1,int num2){
        tv1.setText("" +num1);
        tv2.setText("" + num2);
    }
    public void buttonClick(View v){
        switch(column){
            case 1:
                if(checkSum(R1_TV1,R1_TV2,R1_ET)){
                    goodOrBadClick(R1_BTN,R1_IV,true);
                    putnumbers(R2_TV1,R2_TV2,Integer.parseInt(R1_ET.getText().toString()),rnd.nextInt((99 - 10) + 1) + 10);
                    R2_BTN.setVisibility(View.VISIBLE);
                }else{
                    goodOrBadClick(R1_BTN,R1_IV,false);
                }
                break;
            case 2:
                if(checkSum(R2_TV1,R2_TV2,R2_ET)){
                    goodOrBadClick(R2_BTN,R2_IV,true);
                    putnumbers(R3_TV1,R3_TV2,Integer.parseInt(R2_ET.getText().toString()),rnd.nextInt((99 - 10) + 1) + 10);
                    R3_BTN.setVisibility(View.VISIBLE);
                }else{
                    goodOrBadClick(R2_BTN,R2_IV,false);
                }
                break;
            case 3:
                if(checkSum(R3_TV1,R3_TV2,R3_ET)){
                    goodOrBadClick(R3_BTN,R3_IV,true);
                    Toast.makeText(this, "(3/3, 100%)", Toast.LENGTH_LONG).show();
                }else{
                    goodOrBadClick(R3_BTN,R3_IV,false);
                }
                break;

        }
    }
    public void goodOrBadClick(Button btn,ImageView iv,boolean isGood){
        if(isGood){
            iv.setImageResource(R.drawable.viimg);
            column++;
        }else{
            iv.setImageResource(R.drawable.xx);
        }
        iv.setVisibility(View.VISIBLE);
        btn.setVisibility(View.INVISIBLE);

    }

    public void reset(View v){
        R1_BTN.setVisibility(View.VISIBLE);
        R2_BTN.setVisibility(View.INVISIBLE);
        R3_BTN.setVisibility(View.INVISIBLE);
        column=1;
        R1_IV.setVisibility(View.INVISIBLE);
        R2_IV.setVisibility(View.INVISIBLE);
        R3_IV.setVisibility(View.INVISIBLE);
        putnumbers(R1_TV1,R1_TV2,rnd.nextInt((99 - 10) + 1) + 10,rnd.nextInt((99 - 10) + 1) + 10);
        putnumbers(R2_TV1,R2_TV2,0,0);
        putnumbers(R3_TV1,R3_TV2,0,0);

    }
}