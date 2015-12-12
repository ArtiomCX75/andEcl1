package com.example.andecl1;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Menu implements OnClickListener {
	public Button btnCalc;
	// public OnClickListener btnCalcLis;
	// public Button btnClear;
	// public OnClickListener btnClearLis;
	public TextView res;
	public static EditText edTxt[][];
	public LinearLayout lin[];
	public LinearLayout l0;
	public LinearLayout l1;
	public LinearLayout l2;
	public LinearLayout baseLay;
	public static double matrix[][];
	public Button b2;
	public static double tempMatrix[][];
	public int sizeM = 0;
	// public int n = 3;
	private LayoutParams edTxtPar;

	public static Button btnMsize[];

	@Override
	protected void onRestart() {

		if (sizeM > 0) {
			btnMsize[sizeM].performClick();
			MainActivity.setMatrix(tempMatrix);
			Toast.makeText(getApplicationContext(), "read succes", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(getApplicationContext(), "can't read", Toast.LENGTH_SHORT).show();
		}
		super.onRestart();

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onRestart();
	}

	@Override
	protected void onPause() {
		sizeM = 0;
		try {
			tempMatrix = getMatrix();
			sizeM = tempMatrix.length;
			Toast.makeText(getApplicationContext(), "save succes", Toast.LENGTH_SHORT).show();
		} catch (Exception e) {
			sizeM = 0;
			Toast.makeText(getApplicationContext(), "can't save", Toast.LENGTH_SHORT).show();
		}
		super.onPause();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		super.onCreate(savedInstanceState);

		// setContentView(R.layout.act2);
		baseLay = new LinearLayout(this);
		baseLay.setOrientation(LinearLayout.VERTICAL);
		LayoutParams linLayPar = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(baseLay, linLayPar);
		edTxtPar = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT, 1);

		addTop();

	}

	private void createEditText(int kolvo) {
		edTxt = null;
		edTxt = new EditText[kolvo][kolvo];
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				edTxt[i1][i2] = new EditText(this);
				edTxt[i1][i2].setLayoutParams(edTxtPar);
				edTxt[i1][i2].setInputType(EditorInfo.TYPE_CLASS_NUMBER | EditorInfo.TYPE_NUMBER_FLAG_DECIMAL
						| EditorInfo.TYPE_NUMBER_FLAG_SIGNED);
				// edTxt[i1][i2].setText(Integer.valueOf(i1 + 1).toString() + "
				// " + Integer.valueOf(i2 + 1).toString());
				// edTxt[i1][i2].setFreezesText(true);
			}
		}

		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				lin[i1].addView(edTxt[i1][i2]);
			}
		}

	}

	protected void matrixGen(int id) {

	}

	public static double[][] getMatrix() {
		matrix = new double[edTxt.length][edTxt[0].length];
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				matrix[i1][i2] = getNum(edTxt[i1][i2]);
			}
		}
		return matrix;
	}

	public static void setMatrix(double[][] d) {
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				setNum(edTxt[i1][i2], d[i1][i2]);
				matrix[i1][i2] = getNum(edTxt[i1][i2]);
			}
		}
	}

	public static double getNum(EditText edit) {
		String s = edit.getText().toString();
		double i;
		try {
			i = Double.valueOf(s);
		} catch (Exception e) {
			i = 0;
		}
		return i;
	}

	public static void setNum(TextView edit, double i) {
		edit.setText(Double.valueOf(i).toString());
	}

	public int genID() {
		return Integer.valueOf((int) (Math.random() * 1000));
	}

	public void createLinLay(int kolvo) {
		lin = null;
		lin = new LinearLayout[kolvo];
		for (int i = 0; i < lin.length; i++) {
			lin[i] = new LinearLayout(this);
			lin[i].setOrientation(LinearLayout.HORIZONTAL);
			baseLay.addView(lin[i]);
		}

	}

	public void addButt() {
		l1 = new LinearLayout(this);
		LinearLayout.LayoutParams ll = (android.widget.LinearLayout.LayoutParams) edTxtPar;
		ll.topMargin = 20;
		l2 = new LinearLayout(this);
		baseLay.addView(l1);
		baseLay.addView(l2);

		btnCalc = new Button(this);
		btnCalc.setId(genID());
		btnCalc.setLayoutParams(edTxtPar);
		btnCalc.setText("Calculate!");
		b2 = new Button(this);
		b2.setLayoutParams(edTxtPar);

		b2.setText("Clear");
		b2.setId(genID());
		b2.setOnClickListener(this);
		l1.addView(btnCalc);
		l2.addView(b2);

		btnCalc.setOnClickListener(this);
	}

	public void addTop() {
		l0 = new LinearLayout(this);
		baseLay.addView(l0);
		btnMsize = new Button[8];
		for (int i = 2; i < 8; i++) {
			btnMsize[i] = new Button(this);
			btnMsize[i].setLayoutParams(edTxtPar);
			btnMsize[i].setText(i + "*" + i);
			btnMsize[i].setOnClickListener(this);
			btnMsize[i].setId(genID());
			l0.addView(btnMsize[i]);
		}
	}

	public String toStr(Number n) {
		String s = "";
		s = Double.valueOf(n.doubleValue()).toString();
		return s;
	}

	@Override
	public void onClick(View v) {
		/*
		 * if (v.getId() == btnCalc.getId()) setNum(edTxt[0][0], 4);
		 */
		if (v.getId() == btnMsize[2].getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(2);
			createEditText(2);
			addButt();
		}
		if (v.getId() == btnMsize[3].getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(3);
			createEditText(3);
			addButt();
		}
		if (v.getId() == btnMsize[4].getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(4);
			createEditText(4);
			addButt();
		}
		if (v.getId() == btnMsize[5].getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(5);
			createEditText(5);
			addButt();
		}
		if (v.getId() == btnMsize[6].getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(6);
			createEditText(6);
			addButt();
		}
		if (v.getId() == btnMsize[7].getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(7);
			createEditText(7);
			addButt();

		}
		if (v.getId() == b2.getId()) {
			for (int i1 = 0; i1 < edTxt.length; i1++) {
				for (int i2 = 0; i2 < edTxt[0].length; i2++) {
					edTxt[i1][i2].setText("");
				}
			}
		}
		if (v.getId() == btnCalc.getId()) {
			matrix = getMatrix();
			double res = 0;
			if ((matrix.length == 2) & (matrix[0].length == 2)) {
				res = Matrix.calc2x2(matrix);
				b2.setText("Res: " + toStr(res));
			} else if ((matrix.length > 2) & (matrix[0].length > 2)) {
				res = Matrix.calcM(matrix);
				b2.setText("Res: " + toStr(res));
			} else {
				Toast.makeText(getApplicationContext(), "error matrix size", Toast.LENGTH_LONG).show();
			}

		}
	}

}
