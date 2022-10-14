package rod.app.sistemaferramentas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import android.os.Bundle; import android.app.Activity; import android.app.AlertDialog; import android.content.ContentValues; import android.content.Context; import android.content.DialogInterface; import android.database.sqlite.SQLiteDatabase; import android.widget.*; import android.view.*;

public class CadastrarFerramentaActivity extends AppCompatActivity {

    EditText ednome_ferramenta, edfabricante, edpreco,edcor,     edreferencia;

    Button btcadastrar,btfechar;

    SQLiteDatabase db;

    @Override     protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_ferramenta);

        ednome_ferramenta = (EditText)


                findViewById(R.id.ednome_ferramenta);
        edfabricante = (EditText) findViewById(R.id.edfabricante);
        edpreco = (EditText) findViewById(R.id.edpreco);
        edcor = (EditText) findViewById(R.id.edcor);
        edreferencia = (EditText) findViewById(R.id.edreferencia);

        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        btcadastrar.setOnClickListener(new View.OnClickListener() {

                                           @Override
                                           public void onClick(View view) {

                                               String nome_ferramenta = ednome_ferramenta.getText().toString();
                                               String fabricante = edfabricante.getText().toString();
                                               String preco = edpreco.getText().toString();
                                               String cor = edcor.getText().toString();
                                               String referencia = edreferencia.getText().toString();

                                               ContentValues valor = new ContentValues();

                                               valor.put("nome_ferramenta", nome_ferramenta);
                                               valor.put("fabricante", fabricante);
                                               valor.put("preco", Float.parseFloat(preco));
                                               valor.put("cor", cor);
                                               valor.put("referencia", referencia);

                                               db.insert("ferramentas", null, valor);
                                               AlertDialog.Builder dialogo = new AlertDialog.Builder(CadastrarFerramentaActivity.this);
                                               dialogo.setTitle("Aviso");
                                               dialogo.setMessage("Dados cadastrados com sucesso!");
                                               dialogo.setNeutralButton("OK", new

                                                       DialogInterface.OnClickListener() {

                                                           @Override
                                                           public void onClick(DialogInterface arg0, int arg1) {

                                                               CadastrarFerramentaActivity.this.finish();
                                                           }
                                                       });

                                               dialogo.show();

                                           }
                                       }
        );

        btfechar = (Button) findViewById(R.id.btfechar);         btfechar.setOnClickListener(new View.OnClickListener() {             @Override             public void onClick(View arg0) {

            CadastrarFerramentaActivity.this.finish();

        }         });         try {

            db = openOrCreateDatabase("banco_dados",             Context.MODE_PRIVATE, null);

        }         catch(Exception e)         {             MostraMensagem("Erro " + e.toString());         }     }

    public void MostraMensagem(String str)     {         AlertDialog.Builder dialogo = new AlertDialog.Builder         (CadastrarFerramentaActivity.this);

        dialogo.setTitle("Aviso");         dialogo.setMessage(str);         dialogo.setNeutralButton("OK", null);         dialogo.show();     }

}
