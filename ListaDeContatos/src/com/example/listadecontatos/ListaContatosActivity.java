package com.example.listadecontatos;

import android.app.Activity;
import android.os.Bundle;
import android.widget.*;
import android.view.*;
import android.app.*;

public class ListaContatosActivity extends Activity {
	
	ListView lista_contatos;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_contatos);
		lista_contatos = (ListView) findViewById(R.id.lista_contatos);
		lista_contatos.setOnItemClickListener(new
		AdapterView.OnItemClickListener() {
		    @Override
		    public void onItemClick(AdapterView<?> parent, View view,
		    int position, long id) {
		  
		     String nome = ((TextView) view).getText().toString();
		      AlertDialog.Builder dialogo = new AlertDialog.Builder(
		      ListaContatosActivity.this);
		      dialogo.setTitle("Contato");
		      dialogo.setMessage("Contato selecionado: " + nome);
		      dialogo.setNeutralButton("OK", null);
		      dialogo.show();
		   	}
		   });
		  }
		 
		
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.lista_contatos, menu);
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
