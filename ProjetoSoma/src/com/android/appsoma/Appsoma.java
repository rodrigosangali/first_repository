package com.android.appsoma;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.*;
import android.view.*;

public class Appsoma extends Activity {

	EditText ednum1,ednum2,edres;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_appsoma);
		
		ednum1 = (EditText) findViewById(R.id.campo_num1);
		ednum2 = (EditText) findViewById(R.id.campo_num2);
		edres = (EditText) findViewById(R.id.campo_res);
		
		Button btMostrar = (Button) findViewById(R.id.botao_btmostrar);
		
		btMostrar.setOnClickListener(new View.OnClickListener(){
			public void onClick(View arg0) {
			double num1 = Double.parseDouble(ednum1.getText().toString());
			double num2 = Double.parseDouble(ednum2.getText().toString());
			double res = num1 + num2;
			edres.setText(String.valueOf(res));
			}
			});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.appsoma, menu);
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
