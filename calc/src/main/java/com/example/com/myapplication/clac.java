package com.example.com.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class clac extends Activity {
    EditText Edit1,Edit2;
    Button btn1,btn2,btn3,btn4,btn5;
    TextView TextResult;
    String num1,num2;
    Double result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clac);
        setTitle("초간단 계산기");

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        TextResult = (TextView) findViewById(R.id.TextResult);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1)+Double.parseDouble(num2);
                    TextResult.setText("계산결과 = " + result.toString());
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1)-Double.parseDouble(num2);
                    TextResult.setText("계산결과 = " + result.toString());
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();

                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요",Toast.LENGTH_SHORT).show();

                }
                else {
                    result = Double.parseDouble(num1)*Double.parseDouble(num2);
                    TextResult.setText("계산결과 = " + result.toString());
                }
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();

                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요",Toast.LENGTH_SHORT).show();
                }
                else if(num2.equals("0")){
                    Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1)/Double.parseDouble(num2);
                    TextResult.setText("계산결과 = " + result.toString());
                }
            }
        });

        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();

                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요",Toast.LENGTH_SHORT).show();

                }
                else if(num2.equals("0")){
                    Toast.makeText(getApplicationContext(), "0으로 나눌수 없습니다",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Double.parseDouble(num1)%Double.parseDouble(num2);
                    TextResult.setText("계산결과 = " + result.toString());
                }
            }
        });


    }




}
