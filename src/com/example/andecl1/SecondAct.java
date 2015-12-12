package com.example.andecl1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;

public class SecondAct extends Menu {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// setContentView(R.layout.act2);
		LinearLayout baseLay = new LinearLayout(this);
		baseLay.setOrientation(LinearLayout.VERTICAL);
		LayoutParams linLayPar = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		setContentView(baseLay, linLayPar);
		LinearLayout.LayoutParams edTxtPar = new LinearLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT, 1);
		Button but1 = new Button(this);

		but1.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {
				startActivity(new Intent(SecondAct.this, MainActivity.class));
			}
		});
		baseLay.addView(but1);
	}

}
