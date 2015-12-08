package com.example.andecl1;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	public int i = 0;
	public static TextView text1;
	public static TextView text2;
	public static Button but1;
	public static Button but2;
	public static Button but3;
	public static Button but4;
	public int j = 0;
	public static Thread mthread = Thread.currentThread();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		text1 = (TextView) findViewById(R.id.textView1);
		text2 = (TextView) findViewById(R.id.textView2);
		text1.setText(Integer.valueOf(i).toString());
		but1 = (Button) findViewById(R.id.button1);
		OnClickListener lis1 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				i += 10;
				text1.setText(Integer.valueOf(i).toString());
			}
		};
		but1.setOnClickListener(lis1);

		but2 = (Button) findViewById(R.id.button2);
		OnClickListener lis2 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				i += 1;
				text1.setText(Integer.valueOf(i).toString());
			}
		};
		but2.setOnClickListener(lis2);

		but3 = (Button) findViewById(R.id.button3);
		OnClickListener lis3 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				j = 0;
				//Timer tim = new Timer(199999999);
				

				
				text2.setText("THE END");
			}
		};
		but3.setOnClickListener(lis3);

		but4 = (Button) findViewById(R.id.button4);
		OnClickListener lis4 = new OnClickListener() {

			@Override
			public void onClick(View v) {
				text2.setText("Sorry, I'm too lazy...");
			}
		};
		but4.setOnClickListener(lis4);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
