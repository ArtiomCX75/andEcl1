package com.example.andecl1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

public class MainActivity2 extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.main_empty);
		
		LayoutInflater infl = getLayoutInflater();
		infl.inflate(R.layout.header, (ViewGroup) findViewById(R.id.header), true);
		infl.inflate(R.layout.m33, (ViewGroup) findViewById(R.id.body), true);
		infl.inflate(R.layout.footer, (ViewGroup) findViewById(R.id.footer), true);
		super.onCreate(savedInstanceState);
		Toast.makeText(getApplicationContext(), "oncreate", Toast.LENGTH_SHORT).show();
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
		Toast.makeText(getApplicationContext(), "pause", Toast.LENGTH_SHORT).show();}
	
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
		// TODO Auto-generated method stub

	}

}
