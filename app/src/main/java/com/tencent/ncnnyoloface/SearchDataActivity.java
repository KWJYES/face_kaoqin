package com.tencent.ncnnyoloface;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.ai.aip.utils.BackTool;
import com.baidu.ai.aip.utils.MyHelper;
import com.baidu.ai.aip.utils.ThreadReturn;

import java.util.Calendar;
import java.util.concurrent.FutureTask;

public class SearchDataActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_search, btn_search_TI, btn_choosetime, btn_confirm;
    TextView search_sum;
    int flag;
    EditText IDS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_data);

        flag = 0;

        btn_search = (Button) findViewById(R.id.search_NI);
        btn_search.setOnClickListener(this);
        btn_search_TI = (Button) findViewById(R.id.search_ka);
        btn_search_TI.setOnClickListener(this);
        search_sum = (TextView) findViewById(R.id.tv_sum);

        btn_choosetime = (Button) findViewById(R.id.time);
        btn_choosetime.setOnClickListener(this);

        btn_confirm = (Button) findViewById(R.id.FINALLY);
        btn_confirm.setOnClickListener(this);

        IDS = (EditText) findViewById(R.id.ids);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.search_ka) {
            StringBuffer sum = new StringBuffer();
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(SearchDataActivity.this);
            db = ggg.getWritableDatabase();
            Cursor cursor = db.query("time_id", null,
                    null, null, null, null, null);
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                String id = cursor.getString(0);
                String name_time = cursor.getString(1);

                System.out.println("???????????????\n");
                System.out.println(id + ":" + name_time);
                sum.append("???????????????" + "\n    ID:" + id + "        time:" + name_time + "\n");

                while (cursor.moveToNext()) {
                    String id1 = cursor.getString(0);
                    String name_time1 = cursor.getString(1);
                    System.out.println("???????????????");
                    System.out.println(id1 + ":" + name_time1);
                    sum.append("    ID:" + id1 + "        time:" + name_time1 + "\n");
                }
            }
            cursor.close();
            db.close();
            search_sum.setText(sum.toString());

        } else if (v.getId() == R.id.search_NI) {   //face

            ThreadReturn td = new ThreadReturn();
            //1.?????? Callable ??????????????? FutureTask ????????????????????????????????????????????????
            FutureTask<String> result = new FutureTask<>(td);
            new Thread(result).start();

            //2.??????????????????????????????
            try {
                String BACK = result.get();  //FutureTask ????????? ?????? ?????????CountDownLatch??????????????????????????????????????????????????????????????????????????????
                String SSS = BackTool.unicodeToString(BACK);
                Log.d("BACKSTRING", SSS);
            } catch (Exception e) {
                e.printStackTrace();
            }

            StringBuffer sum = new StringBuffer();
            SQLiteDatabase db;
            MyHelper ggg = new MyHelper(SearchDataActivity.this);
            db = ggg.getWritableDatabase();
            Cursor cursor = db.query("name_id", null,
                    null, null, null, null, null);
            if (cursor.getCount() != 0) {
                cursor.moveToFirst();
                String id = cursor.getString(0);
                String name_time = cursor.getString(1);
                System.out.println("???????????????");
                System.out.println(id + ":" + name_time);
                sum.append("???????????????" + "\n    ID:" + id + "        name:" + name_time + "\n");

                while (cursor.moveToNext()) {
                    String id1 = cursor.getString(0);
                    String name_time1 = cursor.getString(1);
                    System.out.println("???????????????");
                    System.out.println(id1 + ":" + name_time1);
                    sum.append("    ID:" + id1 + "        name:" + name_time1 + "\n");
                }
            }
            cursor.close();
            db.close();
            search_sum.setText(sum.toString());
        } else if (v.getId() == R.id.time) {
            final Calendar c = Calendar.getInstance();
            DatePickerDialog dialog = new DatePickerDialog(SearchDataActivity.this, (view, year, monthOfYear, dayOfMonth) -> {
                c.set(year, monthOfYear, dayOfMonth);
                btn_choosetime.setText(DateFormat.format("yyy-MM-dd", c));
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
            dialog.show();
            flag = 1;

        } else if (v.getId() == R.id.FINALLY) {
            if (flag == 1) {    //????????????
                if (IDS.getText().toString().trim().equals("")) {      //???????????????
                    String TIMES = btn_choosetime.getText().toString().trim();   //????????????.
                    System.out.println("?????????????????????" + TIMES);

                    StringBuffer sum = new StringBuffer();
                    SQLiteDatabase db;
                    MyHelper ggg = new MyHelper(SearchDataActivity.this);
                    db = ggg.getWritableDatabase();
                    Cursor cursor = db.query("time_id", null,
                            null, null, null, null, null);

                    sum.append("???????????????");
                    if (cursor.getCount() != 0) {
                        cursor.moveToFirst();
                        String id = cursor.getString(0);
                        String name_time = cursor.getString(1);

                        if (TIMES.substring(0, TIMES.length()).equals
                                (name_time.substring(0, TIMES.length()))) {    //?????????????????????????????????2018-12-31
                            System.out.println("???????????????\n");
                            System.out.println(id + ":" + name_time);
                            sum.append("\n    ID:" + id + "        time:" + name_time + "\n");
                        }

                        while (cursor.moveToNext()) {
                            String id1 = cursor.getString(0);
                            String name_time1 = cursor.getString(1);

                            if (TIMES.substring(0, TIMES.length()).equals
                                    (name_time1.substring(0, TIMES.length()))) {
                                System.out.println(id + ":" + name_time);
                                sum.append("    ID:" + id1 + "        time:" + name_time1 + "\n");
                            }
                        }
                    }
                    cursor.close();
                    db.close();
                    search_sum.setText(sum.toString());
                } else {    //?????????????????????ID

                    String id = IDS.getText().toString().trim();
                    String TIMES = btn_choosetime.getText().toString().trim();   //????????????.
                    SQLiteDatabase db;
                    MyHelper ggg = new MyHelper(SearchDataActivity.this);
                    db = ggg.getWritableDatabase();

                    StringBuffer sum = new StringBuffer();

                    String sql = "select * from time_id where id=\"" + id + "\"";

                    System.out.println("????????????" + sql);

                    Cursor cursor = db.rawQuery(sql, null);
                    while (cursor.moveToNext()) {
                        String ID = cursor.getString(0); //?????????????????????,?????????????????????0??????
                        String TIME = cursor.getString(1);//?????????????????????

                        if (TIMES.equals(TIME.substring(0, TIMES.length()))) {
                            sum.append("    ID:" + ID + "        time:" + TIME + "\n");
                        }
                    }
                    cursor.close();
                    db.close();
                    search_sum.setText(sum.toString());
                }
            } else {     //flag=0???  //????????????
                if (IDS.getText().toString().trim().equals("")) {    //????????????
                    Toast.makeText(this, "?????????", Toast.LENGTH_SHORT).show();
                } else {       //?????????ID
                    String id = IDS.getText().toString().trim();    //??????id

                    SQLiteDatabase db;
                    MyHelper ggg = new MyHelper(SearchDataActivity.this);
                    db = ggg.getWritableDatabase();

                    StringBuffer sum = new StringBuffer();

                    String sql = "select * from time_id where id=\"" + id + "\"";
                    // System.out.println("????????????" + sql);
                    Cursor cursor = db.rawQuery(sql, null);
                    while (cursor.moveToNext()) {
                        String ID = cursor.getString(0); //?????????????????????,?????????????????????0??????
                        String TIME = cursor.getString(1);//?????????????????????
                        sum.append("    ID:" + ID + "        time:" + TIME + "\n");
                    }
                    cursor.close();
                    db.close();
                    search_sum.setText(sum.toString());
                }
            }
        }
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}