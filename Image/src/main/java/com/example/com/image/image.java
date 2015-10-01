package com.example.com.image;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class image extends Activity {
    TextView Text1,Text2;
    CheckBox ChkAgree;
    RadioGroup Rgroup1;
    RadioButton imgA,imgB,imgC;
    Button btnOK;
    ImageView ImgFlower;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        setTitle("꽃사진 보기");

        Text1 = (TextView) findViewById(R.id.Text1);
        ChkAgree = (CheckBox) findViewById(R.id.ChkAgree);
        Text2 = (TextView) findViewById(R.id.Text2);
        Rgroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        imgA = (RadioButton) findViewById(R.id.imgA);
        imgB = (RadioButton) findViewById(R.id.imgB);
        imgC = (RadioButton) findViewById(R.id.imgC);
        btnOK = (Button) findViewById(R.id.btnOK);
        ImgFlower = (ImageView) findViewById(R.id.ImgFlower);

        ChkAgree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
                if(ChkAgree.isChecked() == true){
                    Text2.setVisibility(android.view.View.VISIBLE);
                    Rgroup1.setVisibility(android.view.View.VISIBLE);
                    btnOK.setVisibility(android.view.View.VISIBLE);
                    ImgFlower.setVisibility(android.view.View.VISIBLE);

                }
                else
                {
                    Text2.setVisibility(android.view.View.INVISIBLE);
                    Rgroup1.setVisibility(android.view.View.INVISIBLE);
                    btnOK.setVisibility(android.view.View.INVISIBLE);
                    ImgFlower.setVisibility(android.view.View.INVISIBLE);
                }
            }
        });

        btnOK.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0){
                switch (Rgroup1.getCheckedRadioButtonId()) {
                    case R.id.imgA:
                        ImgFlower.setImageResource(R.drawable.a);
                        break;
                    case R.id.imgB:
                        ImgFlower.setImageResource(R.drawable.b);
                        break;
                    case R.id.imgC:
                        ImgFlower.setImageResource(R.drawable.c);
                        break;
                    default:
                        Toast.makeText(getApplicationContext(), "꽃 먼저 선택하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }



}
