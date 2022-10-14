package com.example.calculodesalario;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;

public class SalarioActivity extends Activity {

	RadioGroup rgopcoes;
	Button btcalcular;
	EditText edsalario;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_salario);
		
		edsalario = (EditText)findViewById
				(R.id.Edsalario);
				
		rgopcoes = (RadioGroup) findViewById
				(R.id.Rgopcoes);
				
		btcalcular = (Button) findViewById(R.id.Btcalcular);
		
		
		btcalcular.setOnClickListener(new View.
				OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
				double salario = Double.parseDouble
						(edsalario.getText().toString());
				
				int op = rgopcoes.getCheckedRadioButtonId();
				
				double novo_salario = 0;
				
				if(op==R.id.rb40)
					novo_salario = salario + (salario * 0.4);
					else if(op==R.id.rb45)
					novo_salario = salario + (salario * 0.45);
					else
					novo_salario = salario + (salario * 0.5);
				
				AlertDialog.Builder dialogo = new
						AlertDialog.Builder(SalarioActivity.this);
				
				dialogo.setTitle("Novo salário");
				dialogo.setMessage("Seu novo salário é : R$" +
				String.valueOf(novo_salario));
				dialogo.setNeutralButton("OK", null);
				dialogo.show();
			}
				
			});
				
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.salario, menu);
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
