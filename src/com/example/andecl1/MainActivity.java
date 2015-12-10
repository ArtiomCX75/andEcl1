package com.example.andecl1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	public Button btnCalc;
	public OnClickListener btnCalcLis;
	public Button btnClear;
	public OnClickListener btnClearLis;
	public TextView res;
	public EditText edTxt[][];
	public LinearLayout lin[];
	public LinearLayout l1;
	public LinearLayout l2;
	public LinearLayout baseLay;
	public double matrix[][];
	public Button b2;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.act2);
		baseLay = new LinearLayout(this);
		baseLay.setOrientation(LinearLayout.VERTICAL);
		LayoutParams linLayPar = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(baseLay, linLayPar);
		LayoutParams edTxtPar = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1);

		lin = new LinearLayout[3];
		for (int i = 0; i < lin.length; i++) {
			lin[i] = new LinearLayout(this);
			lin[i].setOrientation(LinearLayout.HORIZONTAL);
			baseLay.addView(lin[i]);
		}

		edTxt = new EditText[3][3];
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				edTxt[i1][i2] = new EditText(this);
				edTxt[i1][i2].setLayoutParams(edTxtPar);
				edTxt[i1][i2].setInputType(EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_FLAG_DECIMAL| EditorInfo.TYPE_NUMBER_FLAG_SIGNED);
				edTxt[i1][i2].setText(Integer.valueOf(i1 + 1).toString() + "" + Integer.valueOf(i2 + 1).toString());
			}
		}

		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				lin[i1].addView(edTxt[i1][i2]);
			}
		}
		l1 = new LinearLayout(this);
		LinearLayout.LayoutParams ll = (android.widget.LinearLayout.LayoutParams) edTxtPar;
		ll.topMargin = 20;
		l2 = new LinearLayout(this);
		baseLay.addView(l1);
		baseLay.addView(l2);

		btnCalc = new Button(this);
		btnCalc.setLayoutParams(edTxtPar);
		btnCalc.setText("Calculate!");
		b2 = new Button(this);
		b2.setLayoutParams(edTxtPar);

		b2.setText("ololo");
		l1.addView(btnCalc);
		l2.addView(b2);

		btnCalcLis = new OnClickListener() {
			@Override
			public void onClick(View v) {
				setMatrix(getMatrix());
			}
		};
		btnCalc.setOnClickListener(btnCalcLis);
		

	}

	public double[][] getMatrix() {
		matrix = new double[edTxt.length][edTxt[0].length];
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				matrix[i1][i2] = getNum(edTxt[i1][i2])+1;
			}
		}
		return matrix;
	}

	public void setMatrix(double[][] d) {
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				setNum(edTxt[i1][i2], d[i1][i2]);
				matrix[i1][i2] = getNum(edTxt[i1][i2]);
			}
		}
	}

	public double getNum(EditText edit) {
		String s = edit.getText().toString();
		double i;
		try {
			i = Double.valueOf(s);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	public void setNum(TextView edit, double i) {
		edit.setText(Double.valueOf(i).toString());
	}
}
