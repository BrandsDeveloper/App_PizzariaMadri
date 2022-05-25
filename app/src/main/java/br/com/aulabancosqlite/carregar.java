package br.com.aulabancosqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class carregar extends AppCompatActivity implements OnClickListener {

    Button btSalvar, btConsultar, btAlterar, btExcluir;
    EditText codigo, nome, email;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        codigo = (EditText) findViewById(R.id.txtCodigo);
        nome = (EditText) findViewById(R.id.txtNome);
        email = (EditText) findViewById(R.id.txtEmail);

        btSalvar = (Button) findViewById(R.id.btSalvar);
        btConsultar = (Button) findViewById(R.id.btConsultar);
        btAlterar = (Button) findViewById(R.id.btAlterar);
        btExcluir = (Button) findViewById(R.id.btExcluir);

        btSalvar.setOnClickListener(this);
        btConsultar.setOnClickListener(this);
        btAlterar.setOnClickListener(this);
        btExcluir.setOnClickListener(this);
    }

    public void onClick(View v) {
        // TODO Auto-generated method stub
        if (v.getId() == R.id.btSalvar) {
            salvar();
        }

        if (v.getId() == R.id.btConsultar) {
            consultar();
        }

        if (v.getId() == R.id.btAlterar) {
            alterar();
        }

        if (v.getId() == R.id.btExcluir) {
            excluir();
        }
    }

    private void consultar() {
        int txtCodigo = Integer.parseInt(codigo.getText().toString());

        BancoController bd = new BancoController(getBaseContext());

        Cursor dados = bd.carregaDadoPeloCodigo(txtCodigo) ;

        if(dados.moveToFirst()){
            nome.setText( dados.getString(1) );
            email.setText( dados.getString(2) );
        }else{
            String msg= "Código não cadastrado";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }

    }

    public void salvar() {

        String txtNome = nome.getText().toString();
        String txtEmail = email.getText().toString();

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDado( txtNome, txtEmail);

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();
    }


    public void alterar() {
        int id = Integer.parseInt(codigo.getText().toString()) ;
        String txtNome  = nome.getText().toString() ;
        String txtEmail = email.getText().toString() ;

        BancoController bd = new BancoController(getBaseContext());

        String msg;
        msg = bd.alteraDado(id, txtNome, txtEmail ) ;

        Toast.makeText(getApplicationContext(),
                msg, Toast.LENGTH_LONG).show();
        limpar();
    }


    public void excluir() {
        int id = Integer.parseInt(codigo.getText().toString());

        BancoController bd = new BancoController(getBaseContext());

        String res ;
        res = bd.excluirDado(id) ;

        Toast.makeText(getApplicationContext(), res,
                Toast.LENGTH_LONG).show() ;
        limpar() ;
    }

    public void limpar(){
        codigo.setText("") ;
        nome.setText("") ;
        email.setText("") ;

    }
}