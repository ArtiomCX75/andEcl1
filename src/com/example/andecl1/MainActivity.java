package com.example.andecl1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	public Button btnCalc;
	public OnClickListener btnCalcLis;
	public TextView res;
	public EditText a11;
	public EditText a12;
	public EditText a13;
	public EditText a21;
	public EditText a22;
	public EditText a23;
	public EditText a31;
	public EditText a32;
	public EditText a33;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.act2);
		btnCalc = (Button) findViewById(R.id.btnCalc);
		res = (TextView) findViewById(R.id.res);
		a11 = (EditText) findViewById(R.id.a11);
		a12 = (EditText) findViewById(R.id.a12);
		a13 = (EditText) findViewById(R.id.a13);
		a21 = (EditText) findViewById(R.id.a21);
		a22 = (EditText) findViewById(R.id.a22);
		a23 = (EditText) findViewById(R.id.a23);
		a31 = (EditText) findViewById(R.id.a31);
		a32 = (EditText) findViewById(R.id.a32);
		a33 = (EditText) findViewById(R.id.a33);

		// registerForContextMenu(but1);
		// but1.setOnCreateContextMenuListener(this);
		btnCalc.setOnClickListener(btnCalcLis);
		btnCalcLis = new OnClickListener() {
			@Override
			public void onClick(View v) {
				// int i=getInt(a11)*getInt(a22)-getInt(a12)*getInt(a21);
				int i1 = getInt(a11) * getInt(a22) * getInt(a33);
				int i2 = getInt(a12) * getInt(a23) * getInt(a31);
				int i3 = getInt(a13) * getInt(a21) * getInt(a32);
				int i4 = getInt(a13) * getInt(a22) * getInt(a31);
				int i5 = getInt(a11) * getInt(a23) * getInt(a32);
				int i6 = getInt(a12) * getInt(a21) * getInt(a33);
				int i = i1 + i2 + i3 - i4 - i5 - i6;
				setInt(res, i);
			}
		};
		btnCalc.setOnClickListener(btnCalcLis);
		/*
		 * but2 = (Button) findViewById(R.id.button2); OnClickListener lis2 =
		 * new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { i += 1;
		 * text1.setText(Integer.valueOf(i).toString()); } };
		 * but2.setOnClickListener(lis2);
		 */

	}

	public int getInt(EditText edit) {
		String s = edit.getText().toString();
		int i;
		try {
			i = Integer.valueOf(s);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	public void setInt(TextView edit, int i) {
		edit.setText(Integer.valueOf(i).toString());
	}
}
