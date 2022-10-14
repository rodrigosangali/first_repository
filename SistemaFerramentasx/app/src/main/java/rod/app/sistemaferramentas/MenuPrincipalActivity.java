package rod.app.sistemaferramentas;


import android.app.AlertDialog;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MenuPrincipalActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Button btcadastrar_ferramenta;  Button btconsultar_ferramenta;  Button btalterar_dados;  Button btexcluir_ferramenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);
        btcadastrar_ferramenta = (Button)   findViewById(R.id.btcadastrar_ferramenta);
        btalterar_dados = (Button)
                findViewById(R.id.btalterar_dados);
        btconsultar_ferramenta = (Button)
                findViewById(R.id.btconsultar_ferramenta);
        btexcluir_ferramenta = (Button)
                findViewById(R.id.btexcluir_ferramenta);
        btcadastrar_ferramenta.setOnClickListener(new
                                                          View.OnClickListener() {
                                                              @Override
                                                              public void onClick(View arg0) {
                                                                  Intent cadastrarFerramentaActivity = new Intent(MenuPrincipalActivity.this,    CadastrarFerramentasActivity.class);                 MenuPrincipalActivity.this.startActivity                    (cadastrarFerramentaActivity);       }   });                          btalterar_dados.setOnClickListener(new View.OnClickListener() {        @Override    public void onClick(View arg0) {                              Intent consultaFerramentaActivity = new                          Intent(MenuPrincipalActivity.this,           BuscaFerramentasActivity.class);



        consultaFerramentaActivity.putExtra                        ("opcao_dados", 1);                                   MenuPrincipalActivity.this.startActivity                        (consultaFerramentaActivity);    }    });                btconsultar_ferramenta.setOnClickListener(new        View.OnClickListener() {        @Override    public void onClick(View arg0) {                             Intent consultaFerramentaActivity = new                          Intent(MenuPrincipalActivity.this,                         BuscaFerramentasActivity.class);                              consultaFerramentaActivity.putExtra                         ("opcao_dados", 2);                              MenuPrincipalActivity.this.startActivity                         (consultaFerramentaActivity);    }   });                 btexcluir_ferramenta.setOnClickListener(new         View.OnClickListener() {        @Override    public void onClick(View arg0) {                             Intent consultaFerramentaActivity = new                           Intent(MenuPrincipalActivity.this,                         BuscaFerramentasActivity.class);                             consultaFerramentaActivity.putExtra                         ("opcao_dados", 3);                MenuPrincipalActivity.this.startActivity                         (consultaFerramentaActivity);    }  });                try {        db = openOrCreateDatabase("banco_dados",          Context.MODE_PRIVATE, null);           db.execSQL("create table if not exists "  +                "ferramentas(numreg integer primary key " +    "autoincrement, nome_ferramenta text not null, " +               "fabricante text not null," + "preco float not null, " +               "cor text not null, referencia text not null)");         }




        catch(Exception e)         {          MostraMensagem("Erro " + e.toString());         }     }

    public void MostraMensagem(String str)     {   AlertDialog.Builder dialogo = new AlertDialog.Builder             (MenuPrincipalActivity.this);      dialogo.setTitle("Aviso");   dialogo.setMessage(str);   dialogo.setNeutralButton("OK", null);   dialogo.show();     }
}
