package com.example.com.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    RadioGroup rGroup;
    RadioButton btnAdd,btnSub,btnMul,btnDiv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");


        rGroup = (RadioGroup) findViewById(R.id.rGroup);
        btnAdd = (RadioButton)findViewById(R.id.btnAdd);
        btnSub = (RadioButton)findViewById(R.id.btnSub);
        btnMul = (RadioButton)findViewById(R.id.btnMul);
        btnDiv = (RadioButton)findViewById(R.id.btnDiv);

        Button  btnOK = (Button)findViewById(R.id.btnOK);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
                EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
                switch (rGroup.getCheckedRadioButtonId()){
                    case R.id.btnAdd:
                        intent.putExtra("a","+");
                        break;
                    case R.id.btnSub:
                        intent.putExtra("a","-");
                        break;
                    case R.id.btnDiv:
                        intent.putExtra("a","/");
                        break;
                    case R.id.btnMul:
                        intent.putExtra("a","*");
                        break;
                    default:
                        Toast.makeText(getApplicationContext(),"선택하세요",Toast.LENGTH_SHORT).show();
                }
                intent.putExtra("Num1",Integer.parseInt(edtNum1.getText().toString()));
                intent.putExtra("Num2",Integer.parseInt(edtNum2.getText().toString()));
                startActivityForResult(intent, 0);
            }
        });
    }

    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        if(resultCode == RESULT_OK){
            int hap = data.getIntExtra("Hap",0);
            Toast.makeText(getApplicationContext(),"결과 :"+hap,Toast.LENGTH_SHORT).show();
        }
    }
}
