package com.example.riven.alarmdemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    public static final int ALARM_ONE = 00000;
    public static final int ALARM_TWO = 00001;
    public static final int ALARM_THREE = 00002;

    @BindView(R.id.et_year_one)
    protected EditText et_year_one;
    @BindView(R.id.et_month_one)
    protected EditText et_month_one;
    @BindView(R.id.et_day_one)
    protected EditText et_day_one;
    @BindView(R.id.et_hour_one)
    protected EditText et_hour_one;
    @BindView(R.id.et_minute_one)
    protected EditText et_minute_one;
    @BindView(R.id.et_second_one)
    protected EditText et_second_one;
    @BindView(R.id.et_year_two)
    protected EditText et_year_two;
    @BindView(R.id.et_month_two)
    protected EditText et_month_two;
    @BindView(R.id.et_day_two)
    protected EditText et_day_two;
    @BindView(R.id.et_hour_two)
    protected EditText et_hour_two;
    @BindView(R.id.et_minute_two)
    protected EditText et_minute_two;
    @BindView(R.id.et_second_two)
    protected EditText et_second_two;
    @BindView(R.id.et_year_three)
    protected EditText et_year_three;
    @BindView(R.id.et_month_three)
    protected EditText et_month_three;
    @BindView(R.id.et_day_three)
    protected EditText et_day_three;
    @BindView(R.id.et_hour_three)
    protected EditText et_hour_three;
    @BindView(R.id.et_minute_three)
    protected EditText et_minute_three;
    @BindView(R.id.et_second_three)
    protected EditText et_second_three;

    private Context mContext;
    private DBHelper mDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;
        mDBHelper = new DBHelper(this, DBHelper.DB_NAME, null, DBHelper.DB_VERSION);
    }

    @OnClick(R.id.btn_set_one)
    protected void onClickSetOne() {
        AlarmUtils.setAlarm(
                mContext,
                ALARM_ONE,
                Integer.valueOf(et_year_one.getText().toString().trim()),
                Integer.valueOf(et_month_one.getText().toString().trim()),
                Integer.valueOf(et_day_one.getText().toString().trim()),
                Integer.valueOf(et_hour_one.getText().toString().trim()),
                Integer.valueOf(et_minute_one.getText().toString().trim()),
                Integer.valueOf(et_second_one.getText().toString().trim()));
    }

    @OnClick(R.id.btn_del_one)
    protected void onClickDelOne() {
        AlarmUtils.deleteAlarm(mContext, ALARM_ONE);
    }

    @OnClick(R.id.btn_set_two)
    protected void onClickSetTwo() {
        AlarmUtils.setAlarm(
                mContext,
                ALARM_TWO,
                Integer.valueOf(et_year_two.getText().toString().trim()),
                Integer.valueOf(et_month_two.getText().toString().trim()),
                Integer.valueOf(et_day_two.getText().toString().trim()),
                Integer.valueOf(et_hour_two.getText().toString().trim()),
                Integer.valueOf(et_minute_two.getText().toString().trim()),
                Integer.valueOf(et_second_two.getText().toString().trim()));
    }

    @OnClick(R.id.btn_del_two)
    protected void onClickDelTwo() {
        AlarmUtils.deleteAlarm(mContext, ALARM_TWO);
    }

    @OnClick(R.id.btn_set_three)
    protected void onClickSetThree() {
        AlarmUtils.setAlarm(
                mContext,
                ALARM_THREE,
                Integer.valueOf(et_year_three.getText().toString().trim()),
                Integer.valueOf(et_month_three.getText().toString().trim()),
                Integer.valueOf(et_day_three.getText().toString().trim()),
                Integer.valueOf(et_hour_three.getText().toString().trim()),
                Integer.valueOf(et_minute_three.getText().toString().trim()),
                Integer.valueOf(et_second_three.getText().toString().trim()));
    }

    @OnClick(R.id.btn_del_three)
    protected void onClickDelThree() {
        AlarmUtils.deleteAlarm(mContext, ALARM_THREE);
    }

    @OnClick(R.id.bt_add_data)
    protected void onClickAddData() {
        ContentValues values = new ContentValues();
        values.put(DBHelper.TABLE_ID, 001);
        values.put(DBHelper.TABLE_USER_ID, 11111);
        values.put(DBHelper.TABLE_TRIGGER_TIME, 56565656);
        values.put(DBHelper.TABLE_LAST_DATE, 5566999);
        mDBHelper.insert(values);
    }

    @OnClick(R.id.bt_search_all)
    protected void onClickSearchAll() {
        Cursor cursor = mDBHelper.query();
        while (cursor.moveToNext()){
            Log.e("id is ", cursor.getColumnName(0));
            Log.e("user'id is ", cursor.getColumnName(1));
            Log.e("trigger time is ", cursor.getColumnName(2));
            Log.e("last date is ", cursor.getColumnName(3));

        }
        mDBHelper.closeDB();
    }
}
