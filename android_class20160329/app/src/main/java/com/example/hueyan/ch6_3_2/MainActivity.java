package com.example.hueyan.ch6_3_2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.Random;


public class MainActivity extends ActionBarActivity {
    private ImageButton imgBtn1, imgBtn2, imgBtn3;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] imgBtnArray= new int[]{R.id.imgBtn1,R.id.imgBtn2,R.id.imgBtn3};
        imgBtnArray=shuffleArray(imgBtnArray);

        imgBtn1 = (ImageButton) findViewById(imgBtnArray[0]);
        imgBtn2 = (ImageButton) findViewById(imgBtnArray[1]);
        imgBtn3 = (ImageButton) findViewById(imgBtnArray[2]);

        // 建立事件處理的傾聽者物件
        imgBtn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                imgBtn1.setImageResource(R.drawable.h11);
            }
        });
        imgBtn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                imgBtn2.setImageResource(R.drawable.d8);
            }
        });
        imgBtn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                imgBtn3.setImageResource(R.drawable.h7);
            }
        });
    }

    int[] shuffleArray(int[] ar) {
        // If running on Java 6 or older, use `new Random()` on RHS here
        Random rnd = new Random();
        for (int i = ar.length - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            // Simple swap
            int a = ar[index];
            ar[index] = ar[i];
            ar[i] = a;
        }

        return ar;
    }
}
