package com.example.sistemadecompras;

import android.os.Bundle;
import android.app.Activity; 
import android.view.Menu;
import android.widget.*;
import android.view.*;
import android.R;
import android.app.*; 

public class ComprasActivity extends Activity {
	
	 CheckBox chkarroz, chkleite, chkcarne, chkfeijao;

	 Button bttotal; 
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compras);
		
		chkarroz = (CheckBox)
		findViewById(R.id.chkarroz);
		chkleite = (CheckBox)
		findViewById(R.id.Chkleite);
		chkcarne = (CheckBox)
		findViewById(R.id.Chkcarne);
		chkfeijao = (CheckBox)
		findViewById(R.id.Chkfeijao);
		
		Button bttotal = (Button) findViewById(R.id.Bttotal); 
		
		bttotal.setOnClickListener(new View.OnClickListener() {

			 @Override
			 public void onClick(View arg0) { 
				 
				 double total =0;
				 if(chkarroz.isChecked())
				 total += 2.69;

				 if(chkleite.isChecked())
				 total += 5.00;
				 if(chkcarne.isChecked())
				 total += 9.7;
				 if(chkfeijao.isChecked())
				 total += 2.30;

				 AlertDialog.Builder dialogo = new
				 AlertDialog.Builder(ComprasActivity.this);
				 dialogo.setTitle("Aviso");
				 dialogo.setMessage("Valor total da compra :" +
				 String.valueOf(total));
				 dialogo.setNeutralButton("OK", null);

				 dialogo.show(); 
			 }
		});		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.compras, menu);
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
