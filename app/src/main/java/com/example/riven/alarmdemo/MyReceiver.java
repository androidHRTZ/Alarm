package com.example.riven.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
        Time time=new Time();
        time.setToNow();
        Log.e("onReceive------",time.year+"/"+(time.month+1)+"/"+time.monthDay+"   "+time.hour+":"+time.minute+":"+time.second);
         Toast.makeText(context, System.currentTimeMillis()+"", Toast.LENGTH_SHORT).show();
         context.startService(new Intent(context,AlarmClockService.class));
	}

}
