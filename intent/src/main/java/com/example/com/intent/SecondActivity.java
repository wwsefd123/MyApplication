package com.example.com.intent;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by com on 2015-11-19.
 */
public class SecondActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("세컨드 액티비티");

        Intent inIntent = getIntent();
        final String aa = inIntent.getStringExtra("a");
        int h;
        if(aa.equals("+")) {
            h = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);}
        else if(aa.equals("-")){
            h = inIntent.getIntExtra("Num1",0) - inIntent.getIntExtra("Num2",0);}
        else if(aa.equals("*")){
            h = inIntent.getIntExtra("Num1",0) * inIntent.getIntExtra("Num2",0);}
        else if(aa.equals("/")) {
            h = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);}
        else
            h =0;
        final int hapValue = h;
        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent outIntent = new Intent(getApplicationContext(),MainActivity.class);
                outIntent.putExtra("Hap",hapValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });
    }
}
