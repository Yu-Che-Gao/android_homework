package com.example.hueyan.ch10_4_2;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private static String DATABASE_TABLE = "students";
    private SQLiteDatabase db;
    private MyDBHelper dbHelper;
    private EditText txtTitle, txtPrice, txtNewPrice;

    private EditText name, address, phone, birth, email;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // 建立SQLiteOpenHelper物件
        dbHelper = new MyDBHelper(this);
        db = dbHelper.getWritableDatabase(); // 開啟資料庫
        // 取得TextView元件
        output = (TextView) findViewById(R.id.lblOutput);
        // 取得EditText元件

        name = (EditText) findViewById(R.id.name);
        address = (EditText) findViewById(R.id.address);
        phone = (EditText) findViewById(R.id.phone);
        birth = (EditText) findViewById(R.id.birth);
        email = (EditText) findViewById(R.id.email);

    }

    @Override
    protected void onStop() {
        super.onStop();
        db.close(); // 關閉資料庫
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_insert) { // 新增
            ContentValues cv = new ContentValues();
//            cv.put("name", txtTitle.getText().toString());
//            cv.put("address", )
//            double price = Double.parseDouble(txtPrice.getText().toString());
//            cv.put("price", price);
//            long new_id = db.insert(DATABASE_TABLE, null, cv);
//            output.setText("新增記錄成功: " + new_id);

            cv.put("name", name.getText().toString());
            cv.put("address", address.getText().toString());
            cv.put("phone", phone.getText().toString());
            cv.put("birth", birth.getText().toString());
            cv.put("email", email.getText().toString());
            long newId = db.insert(DATABASE_TABLE, null, cv);
            output.setText("新增記錄成功: " + newId); //TODO 確認新增沒問題

            return true;
        }

        //TODO 加入更新跟刪除
//        if (id == R.id.action_update) {  // 更新
//            String title = txtTitle.getText().toString();
//            ContentValues cv = new ContentValues();
//            double price = Double.parseDouble(txtNewPrice.getText().toString());
//            cv.put("price", price);
//            int count = db.update(DATABASE_TABLE, cv, "title='" + title + "'", null);
//            output.setText("更新記錄成功: " + count);
//            return true;
//        }
//        if (id == R.id.action_delete) {  // 刪除
//            String title = txtTitle.getText().toString();
//            int count = db.delete(DATABASE_TABLE, "title='" + title + "'", null);
//            output.setText("刪除記錄成功: " + count);
//            return true;
//        }
        if (id == R.id.action_queryAll) {  // 顯示全部記錄
//            String[] colNames=new String[]{"_id","name","address"};
//            String str = "";
//            Cursor c = db.query(DATABASE_TABLE, colNames,null, null, null, null,null);
//            // 顯示欄位名稱
//            for (int i = 0; i < colNames.length; i++)
//                str += colNames[i] + "\t\t";
//            str += "\n";
//            c.moveToFirst();  // 第1筆
//            // 顯示欄位值
//            for (int i = 0; i < c.getCount(); i++) {
//                str += c.getString(c.getColumnIndex(colNames[0])) + "\t\t";
//                str += c.getString(1) + "\t\t";
//                str += c.getString(2) + "\n";
//                c.moveToNext();  // 下一筆
//            }
//            output.setText(str.toString());

            String[] colNames=new String[]{"_id", "name"};//TODO 加入欄位
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
