package com.example.riven.alarmdemo;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

import static android.content.Context.ALARM_SERVICE;

/**
 * Created by Riven on 2017/7/6.
 * Email : 1819485687@qq.com
 */

public class AlarmUtils {

    public static final String ALARM_CLOCK_ACTION = "ALARM_CLOCK_ACTION";   //修改的时候注意Manifest也要对应修改
    public static final int ALARM_CLOCK_FLAG = 000;

    public static void setAlarm(Context context ,int requestCode, int year, int month, int day, int hour, int minute, int second) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month - 1);//也可以填数字，0-11,一月为0
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);

        // c.set(2017, 6, 12, 15, 31, 10);  这样设置可能不行

        if (c.getTimeInMillis() < System.currentTimeMillis()) {
            Toast.makeText(context, "设置时间必须大于当前时间", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(ALARM_CLOCK_ACTION);
        PendingIntent p = PendingIntent.getBroadcast(context, requestCode, intent, ALARM_CLOCK_FLAG);
        AlarmManager a = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        // 华为荣耀8青春版、华为 PE-TL10、华为CAM-UL00小米Note 4X is ok； 小米3（闹钟不太准时）（小米论坛说无法解决wowowo，小米系统缘由）
        // !!!!!!  API>19后，没有重复设置闹铃的功能，只能每次在广播接收器
        // 因为安卓API19后的系统优化机制可能会导致闹铃不准时，以此解决
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            a.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), p);    //设置单次
        } else {
            a.set(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), p);   //设置单次
        }
        Toast.makeText(context, "闹铃设置成功", Toast.LENGTH_SHORT).show();
    }

    public static void deleteAlarm(Context context, int requestCode) {
        Intent i = new Intent(ALARM_CLOCK_ACTION);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, requestCode, i, ALARM_CLOCK_FLAG);
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(ALARM_SERVICE);
        alarmManager.cancel(pendingIntent);
        Toast.makeText(context, "闹铃删除成功", Toast.LENGTH_SHORT).show();
    }
}
