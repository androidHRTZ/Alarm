package com.example.riven.alarmdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver{
	
	@Override
	public void onReceive(Context context, Intent intent) {
         Log.e("onReceive", "onclock............."+System.currentTimeMillis()+"   "+ intent.getStringExtra("msg"));
         Toast.makeText(context, System.currentTimeMillis()+"", Toast.LENGTH_SHORT).show();
         context.startService(new Intent(context,AlarmClockService.class));
	}

}
