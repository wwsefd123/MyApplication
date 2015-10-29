package com.example.com.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class image extends Activity {
    TextView Text1,Text2;
    Switch ChkAgree;
    RadioGroup Rgroup1;
    RadioButton imgA,imgB,imgC;
    Button btnOK,btnRT;
    ImageView ImgFlower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        setTitle("안드로이드 사진 보기");

        Text1 = (TextView) findViewById(R.id.Text1);
        ChkAgree = (Switch) findViewById(R.id.ChkAgree);
        Text2 = (TextView) findViewById(R.id.Text2);
        Rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        imgA = (RadioButton) findViewById(R.id.imgA);
        imgB = (RadioButton) findViewById(R.id.imgB);
        imgC = (RadioButton) findViewById(R.id.imgC);
        btnOK = (Button) findViewById(R.id.btnOK);
        btnRT = (Button) findViewById(R.id.btnRT);
        ImgFlower = (ImageView) findViewById(R.id.ImgFlower);

        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if (ChkAgree.isChecked() == true) {
                    Text2.setVisibility(android.view.View.VISIBLE);
                    Rgroup1.setVisibility(android.view.View.VISIBLE);
                    btnOK.setVisibility(android.view.View.VISIBLE);
                    ImgFlower.setVisibility(android.view.View.VISIBLE);
                    btnRT.setVisibility(View.VISIBLE);
                } else {
                    Text2.setVisibility(android.view.View.INVISIBLE);
                    Rgroup1.setVisibility(android.view.View.INVISIBLE);
                    btnOK.setVisibility(android.view.View.INVISIBLE);
                    ImgFlower.setVisibility(android.view.View.INVISIBLE);
                    btnRT.setVisibility(View.INVISIBLE);
                }
            }
        });

        findViewById(R.id.imgA).setOnClickListener(new Button.OnClickListener() {
            public void onClick(View arg0) {
                ImgFlower.setImageResource(R.drawable.a);
            }
        });
        findViewById(R.id.imgB).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                ImgFlower.setImageResource(R.drawable.b);
            }
        });
        findViewById(R.id.imgC).setOnClickListener(new Button.OnClickListener(){
            public void onClick(View arg0){
                ImgFlower.setImageResource(R.drawable.c);
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                finish();
            }
        });

        btnRT.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                ChkAgree.setChecked(false);
                imgA.setChecked(false);
                imgB.setChecked(false);
                imgC.setChecked(false);
                ImgFlower.setImageResource(0);

            }
        });
    }
}