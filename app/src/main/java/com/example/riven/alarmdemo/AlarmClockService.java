package com.example.riven.alarmdemo;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class AlarmClockService extends Service{

	private MediaPlayer mPlayer;
	
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		mPlayer = MediaPlayer.create(this, R.raw.alarm_clock);
		mPlayer.start();
		return super.onStartCommand(intent, flags, startId);
	}
	
	@Override
	public void onDestroy() {
		if (mPlayer != null) {
			mPlayer.stop();
			mPlayer.release();
		}
		super.onDestroy();
	}
}
