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
import android.view.SubMenu;
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
    String fileName;
    int cYear, cMonth, cDay;
    String path = null;
    File f;
    String newDate;


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
        f= getExternalFilesDir("myDiary");
        path = f.getPath().toString()+"/";

        newDate = Integer.toString(cYear) + "_" + Integer.toString(cMonth)+ "_" + Integer.toString(cDay)+ ".txt";
        fileName = path + newDate;
        String str = readDiary(fileName);
        edtDiary.setText(str);

        dateView.setText(cYear + " 년 " + cMonth + " 월 " + cDay + " 일");
        dateView.setTextSize(30);

        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(MainActivity.this, dateSetListener, cYear, cMonth, cDay).show();

            }
        });

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{

                    FileOutputStream outFs = new FileOutputStream(fileName);
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
            fileName = path + Integer.toString(year) + "_" + Integer.toString(monthOfYear)+ "_" + Integer.toString(dayOfMonth)+ ".txt";
            String str = readDiary(fileName);
            edtDiary.setText(str);
        }
    };

    String readDiary(String fName){
        String diaryStr = null;
        FileInputStream inFs;
        try {
            inFs = new FileInputStream(fName);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        super.onCreateOptionsMenu(menu);

        menu.add(0, 1, 0, "다시 읽기");
        menu.add(0,2,0,"일기 삭제");

        SubMenu sMenu = menu.addSubMenu("글씨 크기");
        sMenu.add(0,3,0,"크게");
        sMenu.add(0,4,0,"보통");
        sMenu.add(0,5,0,"작게");

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case 1:
                String str = readDiary(fileName);
                edtDiary.setText(str);
                return true;
            case 2:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setMessage(dateView.getText() + " 일기를 삭제 하시겠습니까?");
                dlg.setPositiveButton("네", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        File fi = new File(fileName);
                        fi.delete();
                        edtDiary.setText(null);
                    }
                });
                dlg.setNegativeButton("아니오",null);
                dlg.show();

                return true;
            case 3:
                edtDiary.setTextSize(30);
                return true;
            case 4:
                edtDiary.setTextSize(20);
                return true;
            case 5:
                edtDiary.setTextSize(10);
                return true;

        }

        return  false;
    }
}