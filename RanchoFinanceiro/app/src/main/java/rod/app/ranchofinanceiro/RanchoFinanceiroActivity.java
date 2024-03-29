package rod.app.ranchofinanceiro;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class RanchoFinanceiroActivity extends AppCompatActivity {

    Button btAdicionarTransacao;
    Button btConsultarTransacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rancho_financeiro);
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

        btAdicionarTransacao = (Button) findViewById(R.id.btAdicionarTransacao);
        btConsultarTransacao = (Button) findViewById(R.id.btConsultaTransacao);

        btAdicionarTransacao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent AdicionarTransacaoActivity = new Intent(RanchoFinanceiroActivity.this, AdicionarTransacaoActivity.class);
                RanchoFinanceiroActivity.this.startActivity(AdicionarTransacaoActivity);
            }
        });

        btConsultarTransacao.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0){
                Intent ConsultarTransacaoActivity = new Intent(RanchoFinanceiroActivity.this, ConsultarTransacaoActivity.class);
                RanchoFinanceiroActivity.this.startActivity(ConsultarTransacaoActivity);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rancho_financeiro, menu);
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
