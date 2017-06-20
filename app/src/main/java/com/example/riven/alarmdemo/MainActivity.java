package com.example.riven.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import java.sql.Time;
import java.util.Calendar;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bt_create_alarm)
    protected void onClickCreateAlarm() {
        setAlarm();
    }

    @OnClick(R.id.bt_cancel_alarm)
    protected void onClickCancelAlarm() {
        deleteAlarm();
    }

    private void setAlarm() {
        Calendar c = Calendar.getInstance();
//		c.set(2017, 6, 12, 15, 31, 10);  這個好坑，可能不行的
        c.set(Calendar.YEAR,2017);
        c.set(Calendar.MONTH,Calendar.JUNE);//也可以填数字，0-11,一月为0
        c.set(Calendar.DAY_OF_MONTH, 20);
        c.set(Calendar.HOUR_OF_DAY, 14);
        c.set(Calendar.MINUTE, 46);
        c.set(Calendar.SECOND, 1);

        if (c.getTimeInMillis() < System.currentTimeMillis()) {
            Toast.makeText(MainActivity.this, "设置时间必须大于当前时间", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent("ALARM_CLOCK");
        intent.putExtra("msg", "hello");
        PendingIntent p = PendingIntent.getBroadcast(this, 500000005, intent, 000);
        AlarmManager a = (AlarmManager) getSystemService(ALARM_SERVICE);
        a.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), p);
    }

    private void deleteAlarm() {
        Intent i = new Intent("ALARM_CLOCK");
        PendingIntent p = PendingIntent.getBroadcast(this, 500000005, i, 000);
        AlarmManager a = (AlarmManager) getSystemService(ALARM_SERVICE);
        a.cancel(p);
    }

}
