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
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	public Button btnCalc;
	public OnClickListener btnCalcLis;
	public Button btnClear;
	public OnClickListener btnClearLis;
	public TextView res;
	public EditText edTxt[][];
	public LinearLayout lin[];
	public LinearLayout l0;
	public LinearLayout l1;
	public LinearLayout l2;
	public LinearLayout baseLay;
	public double matrix[][];
	public Button b2;
	public int n = 0;
	private LayoutParams edTxtPar;
	public Button btnM3;
	public Button btnM4;
	public Button btnM5;
	public Button btnM6;
	public Button btnM7;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
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
			//	edTxt[i1][i2].setText(Integer.valueOf(i1 + 1).toString() + " " + Integer.valueOf(i2 + 1).toString());
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

	public double[][] getMatrix() {
		matrix = new double[edTxt.length][edTxt[0].length];
		for (int i1 = 0; i1 < edTxt.length; i1++) {
			for (int i2 = 0; i2 < edTxt[i1].length; i2++) {
				matrix[i1][i2] = getNum(edTxt[i1][i2]);
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

	@Override
	public void onClick(View v) {
		/*
		 * if (v.getId() == btnCalc.getId()) setNum(edTxt[0][0], 4);
		 */
		if (v.getId() == btnM3.getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(3);
			createEditText(3);
			addButt();
		}
		if (v.getId() == btnM4.getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(4);
			createEditText(4);
			addButt();
		}
		if (v.getId() == btnM5.getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(5);
			createEditText(5);
			addButt();
		}
		if (v.getId() == btnM6.getId()) {
			baseLay.removeAllViews();
			addTop();
			createLinLay(6);
			createEditText(6);
			addButt();
		}
		if (v.getId() == btnM7.getId()) {
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
			matrix=getMatrix();
			double res = Matrix.calcM(matrix);
			String s = Double.valueOf(res).toString();
			b2.setText("Res: "+s);
		}
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

		btnM3 = new Button(this);
		btnM3.setLayoutParams(edTxtPar);
		btnM3.setText("3*3");
		btnM4 = new Button(this);
		btnM4.setLayoutParams(edTxtPar);
		btnM4.setText("4*4");
		btnM5 = new Button(this);
		btnM5.setLayoutParams(edTxtPar);
		btnM5.setText("5*5");
		btnM6 = new Button(this);
		btnM6.setLayoutParams(edTxtPar);
		btnM6.setText("6*6");
		btnM7 = new Button(this);
		btnM7.setLayoutParams(edTxtPar);
		btnM7.setText("7*7");

		btnM3.setOnClickListener(this);
		btnM4.setOnClickListener(this);
		btnM5.setOnClickListener(this);
		btnM6.setOnClickListener(this);
		btnM7.setOnClickListener(this);
		btnM3.setId(genID());
		btnM4.setId(genID());
		btnM5.setId(genID());
		btnM6.setId(genID());
		btnM7.setId(genID());
		l0.addView(btnM3);
		l0.addView(btnM4);
		l0.addView(btnM5);
		l0.addView(btnM6);
		l0.addView(btnM7);
	}
}
