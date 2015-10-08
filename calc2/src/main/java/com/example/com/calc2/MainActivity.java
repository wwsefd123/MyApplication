package com.example.com.calc2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    EditText Edit1,Edit2;
    Button btn1,btn2,btn3,btn4;
    TextView TextResult;
    String num1,num2;
    Integer result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = { R.id.b0, R.id.b1 , R.id.b2, R.id.b3 , R.id.b4, R.id.b5, R.id.b6, R.id.b7,R.id.b8,R.id.b9 };
    int i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드레이아웃 계산기");

        Edit1 = (EditText) findViewById(R.id.Edit1);
        Edit2 = (EditText) findViewById(R.id.Edit2);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        TextResult = (TextView) findViewById(R.id.TextResult);
        for(i=0 ; i <numBtnIDs.length; i++){
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);
        }

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Edit1.getText().toString();
                num2 = Edit2.getText().toString();
                if(num1.equals("") || num2.equals("")){
                    Toast.makeText(getApplicationContext(), "값을 입력해 주세요",Toast.LENGTH_SHORT).show();
                }
                else {
                    result = Integer.parseInt(num1)+Integer.parseInt(num2);
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
                    result = Integer.parseInt(num1)-Integer.parseInt(num2);
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
                    result = Integer.parseInt(num1)*Integer.parseInt(num2);
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
                    result = Integer.parseInt(num1)/Integer.parseInt(num2);
                    TextResult.setText("계산결과 = " + result.toString());
                }
            }
        });

        for(i=0;i<numBtnIDs.length;i++){
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(Edit1.isFocused() == true){
                        num1 = Edit1.getText().toString() + numButtons[index].getText().toString();
                        Edit1.setText(num1);
                    }
                    else if(Edit2.isFocused() == true){
                        num2 = Edit2.getText().toString() + numButtons[index].getText().toString();
                        Edit2.setText(num2);
                    } else{
                        Toast.makeText(getApplicationContext(),"먼저 에디드텍스트를 선택하세요", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }




}
