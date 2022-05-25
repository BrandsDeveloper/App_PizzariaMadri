package br.com.aulabancosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class meusdados extends AppCompatActivity {
    String nome = "";
    EditText txtNomeMeusDados, txtEmailMeusDados, txtSenhaMeusDados;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.meusdados);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        txtNomeMeusDados = (EditText) findViewById(R.id.txtNomeMeusDados);
        txtEmailMeusDados= (EditText) findViewById(R.id.txtEmailMeusDados);
        txtSenhaMeusDados= (EditText) findViewById(R.id.txtSenhaMeusDados);

        consultaUsuarioNome();
    }

    public void consultaUsuarioNome()
    {
        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadoPeloNome(nome) ;

        if(dados.moveToFirst()){
            txtNomeMeusDados.setText( dados.getString(1) );
            txtEmailMeusDados.setText( dados.getString(2) );
            txtSenhaMeusDados.setText(dados.getString(3));
        }else{
            String msg= "Nome não cadastrado";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }
    }

}
