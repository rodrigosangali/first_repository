package rod.app.ranchofinanceiro;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ConsultarTransacaoActivity extends AppCompatActivity {

    SQLiteDatabase db;
    Cursor c;
    TextView tvconsulta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_transacao);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tvconsulta = (TextView) findViewById(R.id.tvconsulta);

        db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);

        c = db.query("transacao",(new String[]{"estabelecimento"}), null, null, null, null,null );
        c.moveToFirst();
        tvconsulta.setText(c.getString(0));
    }

}
