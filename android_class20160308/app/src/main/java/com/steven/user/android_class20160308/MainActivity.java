package com.steven.user.android_class20160308;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView txtOutput=(TextView)findViewById(R.id.txtOutput);
        Button run=(Button)findViewById(R.id.run);
        run.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str="";
                for(int i=1;i<=4;i++)
                {
                    for(int j=(4-i);j>0;j--)
                    {
                        str+="　";
                    }

                    for(int j=1;j<=(2*i-1);j++)
                    {
                        str+="＊";
                    }
                    str+="\n";
                }
                txtOutput.setText(str);
            }
        });
    }
}
