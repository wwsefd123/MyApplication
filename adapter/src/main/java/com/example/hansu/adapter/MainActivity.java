package com.example.hansu.adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드뷰 영화 포스터");

        final GridView gv = (GridView) findViewById(R.id.gridView1);
        MyGridAdapter gAdapter = new MyGridAdapter(this);
        gv.setAdapter(gAdapter);
    }

    public class MyGridAdapter extends BaseAdapter{
        Context context;
        public MyGridAdapter(Context c){
            context = c;
        }

        public int getCount(){
            return posterID.length;
        }

        public Object getItem(int arg0){
            return null;
        }

        public long getItemId(int arg0){
            return 0;
        }

        Integer[] posterID = { R.drawable.mov1 , R.drawable.mov2 , R.drawable.mov3,
                R.drawable.mov4, R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9 ,R.drawable.mov10,
                R.drawable.mov1 , R.drawable.mov2 , R.drawable.mov3,
                R.drawable.mov4, R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9 ,R.drawable.mov10,
                R.drawable.mov1 , R.drawable.mov2 , R.drawable.mov3,
                R.drawable.mov4, R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9 ,R.drawable.mov10,
                R.drawable.mov1 , R.drawable.mov2 , R.drawable.mov3,
                R.drawable.mov4, R.drawable.mov5, R.drawable.mov6, R.drawable.mov7, R.drawable.mov8, R.drawable.mov9 ,R.drawable.mov10};

        String[] posterName = {"영화1","영화2","영화3","영화1","영화2","영화3","영화1","영화2","영화3","영화4",
                "영화1","영화2","영화3","영화1","영화2","영화3","영화1","영화2","영화3","영화4",
                "영화1","영화2","영화3","영화1","영화2","영화3","영화1","영화2","영화3","영화4",
                "영화1","영화2","영화3","영화1","영화2","영화3","영화1","영화2","영화3","영화4"};

        public View getView(int position, View convertView, ViewGroup parent){
            ImageView imageView = new ImageView(context);
            imageView.setLayoutParams(new GridView.LayoutParams(100, 150));
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            imageView.setPadding(5, 5, 5, 5);

            imageView.setImageResource(posterID[position]);
            final int pos = position;
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    View dialogView = (View) View.inflate(MainActivity.this, R.layout.dialog,null);
                    AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                    ImageView ivPoster = (ImageView) dialogView.findViewById(R.id.ivPoster);
                    ivPoster.setImageResource(posterID[pos]);
                    dlg.setTitle(posterName[pos]);
                    dlg.setIcon(R.drawable.ic_launcher);
                    dlg.setView(dialogView);
                    dlg.setNegativeButton("닫기", null);
                    dlg.show();
                }
            });

            return imageView;
        }
    }



}
