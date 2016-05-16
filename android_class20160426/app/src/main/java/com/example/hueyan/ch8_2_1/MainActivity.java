package com.example.hueyan.ch8_2_1;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // 事件處理程序
    public void button_Click(View view) {
        myDialog dialogOfIntro = new myDialog(this);
        dialogOfIntro.setMessage("我是高宇哲,今年21歲");
        dialogOfIntro.setImage(R.drawable.head_image);
        dialogOfIntro.show();  // 顯示對話方塊
    }
}

class myDialog extends Dialog {

    private TextView messageTextView;
    private ImageView myHeadImage;
    private Animation animFadein;

    private String message = "";
    private int src = 0;

    public myDialog(Context context) {
        super(context);
        setContentView(R.layout.dialog_of_intro);
        initilizeControls(context);
        startAnimFadein(myHeadImage);
    }

    public void setMessage(String message) {
        this.message = message;
        setMessageTextView();
    }

    public void setImage(int src) {
        this.src = src;
        setMyHeadImage();
    }

    private void initilizeControls(Context context) {
        messageTextView = (TextView) findViewById(R.id.messageTextView);
        myHeadImage = (ImageView) findViewById(R.id.myHeadImage);
        animFadein = AnimationUtils.loadAnimation(context, R.anim.fade_in);
    }

    private void setMessageTextView() {
        messageTextView.setText(this.message);
    }

    private void setMyHeadImage() {
        myHeadImage.setImageResource(this.src);
    }

    private void startAnimFadein(View view) {
        view.startAnimation(animFadein);
    }
}
