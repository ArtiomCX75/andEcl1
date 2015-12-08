package com.example.andecl1;

import android.widget.TextView;

public class Timer implements Runnable{
	public static Thread t;
	public int i2=0;
public Timer(int i){
	i2=i;
	t = Thread.currentThread();
	t.start();
}
	@Override
	public void run() {
		TextView text1 = MainActivity.text1;
		
		text1.setText("uitybyufuyfbuyfviuivuiuy");
		
	}

}
