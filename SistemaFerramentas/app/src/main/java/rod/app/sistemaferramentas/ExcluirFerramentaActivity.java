package rod.app.sistemaferramentas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle; import android.app.Activity; import android.app.AlertDialog; import android.content.ContentValues; import android.content.Context; import android.content.DialogInterface; import android.database.Cursor; import android.database.sqlite.SQLiteDatabase; import android.view.Menu; import android.view.View; import android.widget.Button; import android.widget.TextView;


public class ExcluirFerramentaActivity extends AppCompatActivity {

    TextView txtnome_ferramenta, txtfabricante, txtpreco,txtcor,     txtreferencia;

    Button btfechar;

    Button btexcluir_ferramenta;

    SQLiteDatabase db;

    Cursor c;

    int numreg;

    @Override     protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);         setContentView(R.layout.activity_excluir_ferramenta);

        Bundle b = getIntent().getExtras();

        txtnome_ferramenta = (TextView)         findViewById(R.id.txtnome_ferramenta);         txtfabricante = (TextView)         findViewById(R.id.txtfabricante);         txtpreco = (TextView) findViewById(R.id.txtpreco);         txtcor = (TextView) findViewById(R.id.txtcor);         txtreferencia = (TextView)         findViewById(R.id.txtreferencia);

        btexcluir_ferramenta = (Button)         findViewById(R.id.btexcluir_ferramenta);         btfechar = (Button) findViewById(R.id.btfechar);

        numreg = b.getInt("numreg");

        db = openOrCreateDatabase("banco_dados",         Context.MODE_PRIVATE, null);

        c = db.query("ferramentas", new String[] {         "nome_ferramenta", "fabricante", "preco","cor",         "referencia" },"numreg = " + numreg, null, null, null,null);

        c.moveToFirst();

        txtnome_ferramenta.setText(c.getString(0));         txtfabricante.setText(c.getString(1));         txtpreco.setText(c.getString(2));         txtcor.setText(c.getString(3));         txtreferencia.setText(c.getString(4));


        btexcluir_ferramenta.setOnClickListener(new         View.OnClickListener() {

            @Override               public void onClick(View view) {

                db.delete("ferramentas", "numreg=" + numreg, null);                   AlertDialog.Builder dialogo = new AlertDialog.Builder                   (ExcluirFerramentaActivity.this);                   dialogo.setTitle("Aviso");                   dialogo.setMessage("Dados excluidos com sucesso!");


                dialogo.setNeutralButton("OK", new               DialogInterface.OnClickListener() {

                    @Override                    public void onClick(DialogInterface dialog, int                    which) {

                        ExcluirFerramentaActivity.this.finish();                    }                });                dialogo.show();

            }         });

        btfechar.setOnClickListener(new View.OnClickListener() {

            @Override             public void onClick(View view) {                 ExcluirFerramentaActivity.this.finish();             }         });

    }

}


