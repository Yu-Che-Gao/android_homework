package com.example.hueyan.ch9_2_2;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class BMIActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        displayBMI();
    }

    public void button2_Click(View view) {
        finish();
    }

    private double[] getFromBundle(Bundle bundle) {
        double[] returnNumber = new double[2];
        returnNumber[0] = Double.parseDouble(bundle.getString("HEIGHT"));
        returnNumber[1] = Double.parseDouble(bundle.getString("WEIGHT"));
        return returnNumber;
    }

    private void displayBMI() {
        double height, weight, bmi;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            height = getFromBundle(bundle)[0];
            weight = getFromBundle(bundle)[1];
            bmi = calculateBMI(weight, height);
            showBMI("BMI值: " + Double.toString(bmi));
        }
    }

    private double calculateBMI(double weight, double height) {
        height = height / 100.00;
        double bmi = weight / (height * height);
        return bmi;
    }

    private void showBMI(String string) {
        TextView output = (TextView) findViewById(R.id.lblOutput);
        output.setText(string);
    }

    private String attributeBMI(double BMI) {
        String result = "";
        String[] rule=
                {"２歲", "15.2~17.7", "17.7", "19.0", "14.9~17.3", "17.3", "18.3",
                "３歲", "14.8~17.7", "17.7", "19.1", "14.5~17.2", "17.2", "18.5",
                "４歲", "14.4~17.7", "17.7", "19.3", "14.2~17.1", "17.1", "18.6",
                "５歲", "14.0~17.7", "17.7", "19.4", "13.9~17.1", "17.1", "18.9",
                "６歲", "13.9~17.9", "17.9", "19.7", "13.6~17.2", "17.2", "19.1",
                "７歲", "14.7~18.6", "18.6", "21.2", "14.4~18.0", "18.0", "20.3",
                "８歲", "15.0~19.3", "19.3", "22.0", "14.6~18.8", "18.8", "21.0",
                "９歲", "15.2~19.7", "19.7", "22.5", "14.9~19.3", "19.3", "21.6",
                "１０歲", "15.4~20.3", "20.3", "22.9", "15.2~20.1", "20.1", "22.3",
                "１１歲", "15.8~21.0", "21.0", "23.5", "15.8~20.9", "20.9", "23.1",
                "１２歲", "16.4~21.5", "21.5", "24.2", "16.4~21.6", "21.6", "23.9",
                "１３歲", "17.0~22.2", "22.2", "24.8", "17.0~22.2", "22.2", "24.6",
                "１４歲", "17.6~22.7", "22.7", "25.2", "17.6~22.7", "22.7", "25.1",
                "１５歲", "18.2~23.1", "23.1", "25.5", "18.0~22.7", "22.7", "25.3",
                "１６歲", "18.6~23.4", "23.4", "25.6", "18.2~22.7", "22.7", "25.3",
                "１７歲", "19.0~23.6", "23.6", "25.6", "18.3~22.7", "22.7", "25.3",
                "１８歲", "19.2~23.7", "23.7", "25.6", "18.3~22.7", "22.7", "25.3"};//前三項: 男生, 後三項: 女生
        return result;
    }
}
