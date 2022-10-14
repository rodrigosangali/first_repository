package rod.app.aplicacaobancodados;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class BancoDeDadosActivity extends AppCompatActivity {

    Button btcriabanco, btcadastrardados, btcadastrardados2, btconsultardados, btalterardados;
    Button btalterardados2, btexcluirdados, btexcluirdados2;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banco_de_dados);
        btcriabanco = (Button) findViewById(R.id.btcriarbanco);
        btcadastrardados = (Button) findViewById(R.id.btcadastrardados);
        btcadastrardados2 = (Button) findViewById(R.id.btcadastrardados2);
        btconsultardados = (Button) findViewById(R.id.btconsultardados);
        btalterardados = (Button) findViewById(R.id.btalterardados);
        btalterardados2 = (Button) findViewById(R.id.btalterardados2);
        btexcluirdados = (Button) findViewById(R.id.btexcluirdados);
        btexcluirdados2 = (Button) findViewById(R.id.btexcluirdados2);


        btcriabanco.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                try {
                    db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);

                    db.execSQL("create table if not exists " +
                            " usuarios(numreg integer primary key " +
                            " autoincrement, nome text not null, telefone text " +
                            "not null," +
                            "email text not null)");

                    db.execSQL("create table if not exists " +
                            "categoria(numreg integer primary key " +
                            " autoincrement, catprincipal text not null, catsub text " +
                            "not null,");


                    AlertDialog.Builder dialogo = new AlertDialog.Builder(BancoDeDadosActivity.this);

                    dialogo.setTitle("Aviso")
                            .setMessage("Banco de dados criado com sucesso")
                            .setNeutralButton("OK", null)
                            .show();
                } catch (Exception e) {
                }

            }

        });

        btcadastrardados.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent gravaRegistroActivity = new Intent(BancoDeDadosActivity.this, GravaRegistrosActivity.class);
                BancoDeDadosActivity.this.startActivity(gravaRegistroActivity);
            }

        });

        btcriabanco.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

            }
        });

        btcadastrardados2.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                   // TODO Auto-generated method stub
                Intent gravaRegistro2Activity = new Intent(BancoDeDadosActivity.this,GravaRegistros2Activity.class);
                BancoDeDadosActivity.this.startActivity(gravaRegistro2Activity);
            }
        });

        btconsultardados.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                Intent consultaDadosActivity = new Intent(BancoDeDadosActivity.this,ConsutaDadosActivity.class);
                BancoDeDadosActivity.this.startActivity(consultaDadosActivity);
            }
        });

        btalterardados.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                   // TODO Auto-generated method stub
                Intent alterarDadosActivity = new Intent(BancoDeDadosActivity.this, AlterarDadosActivity.class);
                BancoDeDadosActivity.this.startActivity(alterarDadosActivity);
            }
        });


        btalterardados2.setOnClickListener(new
        View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
              // TODO Auto-generated method stub
              Intent alterarDados2Activity = new
              Intent(BancoDeDadosActivity.this,
              AlterarDados2Activity.class);
              BancoDeDadosActivity.this.
              startActivity(alterarDados2Activity);
            }
        });


        btexcluirdados.setOnClickListener(new          View.OnClickListener(){
            @Override   public void onClick(View arg0) {
                            // TODO Auto-generated method stub
                Intent excluirDadosActivity = new
                Intent(BancoDeDadosActivity.this,
                ExcluirDadosActivity.class);
                BancoDeDadosActivity.this.
                startActivity(excluirDadosActivity);
            }
        });


        btexcluirdados2.setOnClickListener(new          View.OnClickListener(){       @Override   public void onClick(View arg0) {
               // TODO Auto-generated method stub
            Intent excluirDados2Activity = new
                    Intent(BancoDeDadosActivity.this,
                    ExcluirDados2Activity.class);

            BancoDeDadosActivity.this.
                    startActivity(excluirDados2Activity);
        }   });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_banco_de_dados, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
