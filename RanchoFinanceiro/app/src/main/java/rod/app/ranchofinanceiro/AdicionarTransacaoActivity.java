package rod.app.ranchofinanceiro;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;


public class AdicionarTransacaoActivity extends AppCompatActivity {

    Button btadicionar, btdata;
    EditText edestabelecimento, eddata, edcategoria, edvalor;
    TextView tvdata;
    SQLiteDatabase db;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_transacao);

        btadicionar = (Button) findViewById(R.id.btAdicionar);
        btdata = (Button) findViewById(R.id.btData);
        edestabelecimento = (EditText) findViewById(R.id.edestabelecimento);
        edvalor = (EditText) findViewById(R.id.edvalor);
        tvdata = (TextView) findViewById(R.id.tvdata);
        edcategoria = (EditText) findViewById(R.id.edcategoria);


        db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);

        db.execSQL("create table if not exists" +
                " transacao(numreg integer primary key " +
                " autoincrement, estabelecimento text null, data date null, categoria text null," +
                " valor float null )");

       btadicionar.setOnClickListener(new View.OnClickListener(){

            @Override
          public void onClick(View arg0) {
              String estabelecimento = edestabelecimento.getText().toString();
              String data = tvdata.getText().toString();
              String categoria = edcategoria.getText().toString();
              String valor = edvalor.getText().toString();
              try {
                         ContentValues valores = new ContentValues();
                                  valores.put("estabelecimento", estabelecimento);
                                  valores.put("data", data);
                                  valores.put("categoria", categoria);
                                  valores.put("valor", Float.parseFloat(valor));

               // Dois tipos diferente de inseri na base de dados

                    db.insert("transacao", null, valores);

               //     db.execSQL("insert into tranacao(estabelecimento, categoria)" +
               //             " values('" + estabelecimento + "','" + categoria + "')");

                  MostraMensagem("Dados cadastrados com sucesso");
              } catch (Exception e) {
                  MostraMensagem("Erro : " + e.toString());
              }

          }
        });

        btdata.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                pegarData();
            }
        });

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    private void pegarData() {
        Calendar c = Calendar.getInstance();
        int dia = c.get(Calendar.DAY_OF_MONTH);
        int mes = c.get(Calendar.MONTH);
        int ano = c.get(Calendar.YEAR);
       String data = DateFormat.getDateInstance(DateFormat.FULL).format(c.getTime())  ;
        DatePickerDialog datePickerDialog = new DatePickerDialog(AdicionarTransacaoActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        tvdata.setText(String.format(dayOfMonth + "/" + month + year));
                //        tvdata.setText(String.format("" + dayOfMonth + (month + 1) + year));

                        btdata.setText(String.format("" + dayOfMonth + (month + 1) + year));

                    }

                }, ano, mes, dia);
        datePickerDialog.show();

    }

    public void MostraMensagem(String str) {
        AlertDialog.Builder dialogo = new
                AlertDialog.Builder(AdicionarTransacaoActivity.this);
        dialogo.setTitle("Aviso");
        dialogo.setMessage(str);
        dialogo.setNeutralButton("OK", null);
        dialogo.show();
    }


    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AdicionarTransacao Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://rod.app.ranchofinanceiro/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "AdicionarTransacao Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://rod.app.ranchofinanceiro/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
