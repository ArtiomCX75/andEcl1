package com.example.andecl1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity implements OnClickListener {
	LayoutInflater infl;
	Button calc;
	OnClickListener lis;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_empty);

		infl = getLayoutInflater();
		infl.inflate(R.layout.header, (ViewGroup) findViewById(R.id.header), true);
		infl.inflate(R.layout.m33, (ViewGroup) findViewById(R.id.body), true);
		infl.inflate(R.layout.footer, (ViewGroup) findViewById(R.id.footer), true);
		Toast.makeText(getApplicationContext(), "oncreate", Toast.LENGTH_SHORT).show();

		calc = new Button(getApplicationContext());
		calc = (Button) findViewById(R.id.button1);
		
		calc.setOnClickListener(MainActivity2.this);
		calc.performClick();
		Toast.makeText(getApplicationContext(), "1111", Toast.LENGTH_SHORT).show();
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), "2222", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "destroy", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Toast.makeText(getApplicationContext(), "pause", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		super.onRestart();
		Toast.makeText(getApplicationContext(), "restart", Toast.LENGTH_SHORT).show();
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Toast.makeText(getApplicationContext(), "resume", Toast.LENGTH_SHORT).show();
	}
@Override
	public void onClick(View v) {
		Toast.makeText(getApplicationContext(), "cl222ick", Toast.LENGTH_SHORT).show();

		Toast.makeText(getApplicationContext(), "calc", Toast.LENGTH_SHORT).show();
		((TextView) findViewById(R.id.textView1)).setText(((EditText) findViewById(R.id.editText1)).getText());
		((TextView) findViewById(R.id.textView2)).setText(((EditText) findViewById(R.id.editText2)).getText());
	//	((TextView) findViewById(R.id.textView3)).setText(((EditText) findViewById(R.id.editText3)).getText());
	//	((TextView) findViewById(R.id.textView4)).setText(((EditText) findViewById(R.id.editText4)).getText());
	//	((TextView) findViewById(R.id.textView5)).setText(((EditText) findViewById(R.id.editText5)).getText());
	//	((TextView) findViewById(R.id.textView6)).setText(((EditText) findViewById(R.id.editText6)).getText());
	//	((TextView) findViewById(R.id.textView7)).setText(((EditText) findViewById(R.id.editText7)).getText());
	//	((TextView) findViewById(R.id.textView8)).setText(((EditText) findViewById(R.id.editText8)).getText());
	//	((TextView) findViewById(R.id.textView9)).setText(((EditText) findViewById(R.id.editText9)).getText());
		LinearLayout ll = (LinearLayout) findViewById(R.id.body);
		ll.removeAllViews();
		infl.inflate(R.layout.preview, ll, true);

	}

	

}
