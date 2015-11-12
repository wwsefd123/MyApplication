package com.example.com.file;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.view.Display;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;

public class MainActivity extends Activity {
    TextView dateView;
    Button btnSave;
    EditText edtDiary;
    DatePicker datePicker;
    View dialogView;
    String fileName;
    int cYear, cMonth, cDay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("일기장");

        dateView = (TextView) findViewById(R.id.dateView);
        edtDiary = (EditText) findViewById(R.id.edtDiary);
        btnSave = (Button) findViewById(R.id.btnSave);

        Calendar cal = Calendar.getInstance();
        cYear = cal.get(Calendar.YEAR);
        cMonth = cal.get(Calendar.MONTH)+1;
        cDay = cal.get(Calendar.DATE);
        File f= getExternalFilesDir("myDiary");



        dateView.setText(cYear + " 년 " + cMonth + " 월 " + cDay + " 일");

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, dateSetListener, cYear, cMonth, cDay).show();
                String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                File myDiary = new File(path +"/FUCK");
                myDiary.mkdir();
            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_WORLD_WRITEABLE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(),fileName+" 이 저장됨",Toast.LENGTH_SHORT).show();
                }catch (IOException e){
                }
            }
        });

    }

    private DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateView.setText(year + " 년 " + monthOfYear + " 월 " + dayOfMonth + " 일");
            fileName = Integer.toString(year) + "_" + Integer.toString(monthOfYear)+ "_" + Integer.toString(dayOfMonth)+ ".txt";
            String str = readDiary(fileName);
            edtDiary.setText(str);
        }
    };

    String readDiary(String fName){
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = openFileInput(fName);
            byte[] txt = new byte[500];
            inFs.read(txt);
            inFs.close();
            diaryStr = (new String(txt)).trim();
            edtDiary.setText(txt.toString());
        }catch (IOException e){
            edtDiary.setHint("일기 없음");
        }
        return diaryStr;
    }


}