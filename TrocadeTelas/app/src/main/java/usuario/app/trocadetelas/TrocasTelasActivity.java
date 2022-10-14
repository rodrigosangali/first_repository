package usuario.app.trocadetelas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class TrocasTelasActivity extends AppCompatActivity {

    Button bttelaprincipal, bttela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        CarregarTelaPrincipal();
        }
        public void CarregarTelaPrincipal()
        {
            setContentView(R.layout.tela_principal);
            bttela2 = (Button) findViewById(R.id.bttela2);

            bttela2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                            CarregarTela2();
                }
            });
        }

        public void CarregarTela2()
        {
            setContentView(R.layout.tela2);
            bttelaprincipal = (Button) findViewById(R.id.bttelaprincipal);
            bttelaprincipal.setOnClickListener(new View.OnClickListener(){

                @Override
                public  void onClick(View v){
                    CarregarTelaPrincipal();
                }
           });
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_trocas_telas, menu);
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
