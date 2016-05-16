package com.example.hueyan.ch9_2_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 找出Button元件
        Button btn = (Button) findViewById(R.id.button);
        // 註冊傾聽者物件
        btn.setOnClickListener(listener);
    }
    // 建立傾聽者物件
    View.OnClickListener listener = new View.OnClickListener() {
        public void onClick(View v) {
            // 取得EditText元件
            EditText height = (EditText) findViewById(R.id.txtHeight);
            EditText weight = (EditText) findViewById(R.id.txtWeight);
            // 建立Intent物件
            Intent myIntent = new Intent();
            myIntent.setClass(MainActivity.this, BMIActivity.class);
            // 建立傳遞資料的Bundle物件
            Bundle bundle = new Bundle();
            bundle.putString("HEIGHT", height.getText().toString());
            bundle.putString("WEIGHT", weight.getText().toString());
            myIntent.putExtras(bundle);  // 加上資料
            startActivity(myIntent);     // 啟動活動
        }
    };
}