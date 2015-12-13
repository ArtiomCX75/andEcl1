package com.example.andecl1;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.MenuItem;
import android.widget.Toast;

public class Menu extends Activity {
	public static double m1[][];
	public boolean readM1Flag = false;
	public static double m2[][];
	public boolean readM2Flag = false;

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		menu.add("MainActivity");
		menu.add("SecondAct");
		menu.add("Save M1");
		menu.add("Save M2");
		menu.add("Read M1");
		menu.add("Read M2");
		menu.add("W1");
		menu.add("R1");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getTitle() == "MainActivity") {
			Intent intent1 = new Intent(this, MainActivity.class);
			startActivity(intent1);
		}
		if (item.getTitle() == "SecondAct") {
			Intent intent2 = new Intent(this, SecondAct.class);
			startActivity(intent2);
		}
		if (item.getTitle() == "Save M1") {
			m1 = MainActivity.getMatrix();
			readM1Flag = true;
		}
		if (item.getTitle() == "Read M1") {
			if (readM1Flag) {
				MainActivity.btnMsize[m1.length].performClick();
				MainActivity.setMatrix(m1);
			} else {
				Toast.makeText(getApplicationContext(), "empty memory slot", Toast.LENGTH_LONG).show();
			}
		}
		if (item.getTitle() == "Save M2") {
			m2 = MainActivity.getMatrix();
			readM2Flag = true;
		}
		if (item.getTitle() == "Read M2") {
			if (readM2Flag) {
				MainActivity.btnMsize[m2.length].performClick();
				MainActivity.setMatrix(m2);
			} else {
				Toast.makeText(getApplicationContext(), "empty memory slot", Toast.LENGTH_LONG).show();
			}
		}
		
		if (item.getTitle() == "W1") {
	//		saveSmth();
		}
		if (item.getTitle() == "R1") {
	//		readSmth();
		}
		Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
		return super.onOptionsItemSelected(item);
	}

	public <T extends Number> void saveSmth(String name, T num) {
		
		SharedPreferences sPref = getPreferences(MODE_PRIVATE);
		Editor ed = sPref.edit();
		ed.putFloat(name, num.floatValue());
		ed.commit();
	}

	public double readSmth(String name) {

		SharedPreferences sPref = getPreferences(MODE_PRIVATE);
		return sPref.getFloat(name, 0);
	}

}
