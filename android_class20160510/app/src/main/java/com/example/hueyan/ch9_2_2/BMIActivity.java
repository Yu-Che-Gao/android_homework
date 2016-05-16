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
        double[] returnNumber = new double[4];
        returnNumber[0] = Double.parseDouble(bundle.getString("HEIGHT"));
        returnNumber[1] = Double.parseDouble(bundle.getString("WEIGHT"));
        returnNumber[2] = Double.parseDouble(bundle.getString("AGE"));
        if (bundle.getString("SEX").equals("男")) {
            returnNumber[3] = 0;
        } else {
            returnNumber[3] = 1;
        }
        return returnNumber;
    }

    private void displayBMI() {
        double height, weight, age, bmi;
        String sex = "", result;
        Bundle bundle = this.getIntent().getExtras();
        if (bundle != null) {
            height = getFromBundle(bundle)[0];
            weight = getFromBundle(bundle)[1];
            //TODO 加入年齡性別
            age = getFromBundle(bundle)[2];
            if (getFromBundle(bundle)[3] == 0) {
                sex = "男";
            } else {
                sex = "女";
            }

            bmi = calculateBMI(weight, height);
            result = attributeBMI(bmi, (int) age, sex);
            showBMI("BMI值: " + Double.toString(bmi) + "\n" + "計算結果:" + result);
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

    private String attributeBMI(double BMI, int year, String sex) {
        String result = "";
        String[][] rule =
                {{"２歲", "15.2~17.7", "14.9~17.3"},
                        {"３歲", "14.8~17.7", "14.5~17.2"},
                        {"４歲", "14.4~17.7", "14.2~17.1"},
                        {"５歲", "14.0~17.7", "13.9~17.1"},
                        {"６歲", "13.9~17.9", "13.6~17.2"},
                        {"７歲", "14.7~18.6", "14.4~18.0"},
                        {"８歲", "15.0~19.3", "14.6~18.8"},
                        {"９歲", "15.2~19.7", "14.9~19.3"},
                        {"１０歲", "15.4~20.3", "15.2~20.1"},
                        {"１１歲", "15.8~21.0", "15.8~20.9"},
                        {"１２歲", "16.4~21.5", "16.4~21.6"},
                        {"１３歲", "17.0~22.2", "17.0~22.2"},
                        {"１４歲", "17.6~22.7", "17.6~22.7"},
                        {"１５歲", "18.2~23.1", "18.0~22.7"},
                        {"１６歲", "18.6~23.4", "18.2~22.7"},
                        {"１７歲", "19.0~23.6", "18.3~22.7"},
                        {"１８歲", "19.2~23.7", "18.3~22.7"}};
        if (sex.equals("男")) {
            String sexRule = rule[year - 2][1];
            double lowerBound = Double.parseDouble(sexRule.split("~")[0]);
            double upperBond = Double.parseDouble(sexRule.split("~")[1]);
            if (BMI < lowerBound) {
                result = "過瘦";
            } else if (BMI >= lowerBound && BMI <= upperBond) {
                result = "正常";
            } else {
                result = "過胖";
            }
        } else {
            String sexRule = rule[year - 2][2];
            double lowerBound = Double.parseDouble(sexRule.split("~")[0]);
            double upperBond = Double.parseDouble(sexRule.split("~")[1]);
            if (BMI < lowerBound) {
                result = "過瘦";
            } else if (BMI >= lowerBound && BMI <= upperBond) {
                result = "正常";
            } else {
                result = "過胖";
            }
        }
        return result;
    }
}
