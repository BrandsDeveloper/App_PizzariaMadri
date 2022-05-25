package br.com.aulabancosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity implements View.OnClickListener {

    Button btnAcessar, btnCadastrese;
    EditText txtLogin, txtSenhaLogin;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        btnAcessar = (Button) findViewById(R.id.btnAcessar);
        btnCadastrese = (Button) findViewById(R.id.btnCadastrar);
        txtLogin = (EditText) findViewById(R.id.txtLogin);
        txtSenhaLogin = (EditText) findViewById(R.id.txtSenhaLogin);

        btnAcessar.setOnClickListener(this);
        btnCadastrese.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnCadastrar) {
            // carregar a tela de cadastre-se
            Intent telaCadastreSe = new Intent(this, cadastrese.class);
            startActivity(telaCadastreSe);
        }
        if (v.getId() == R.id.btnAcessar) {
            // carrega o método para verificar se o usuário existe
            consultaUsuarioLogin();
        }
    }

    public void consultaUsuarioLogin()
    {
        // captando os dados digitados e armazenando em variáveis
        String Login = txtLogin.getText().toString();
        String SenhaLogin = txtSenhaLogin.getText().toString();

        // conectar com o banco de dados - criando um objeto do BD
        BancoController bd = new BancoController(getBaseContext());

        // chamando o método carregaDadosLogin que recebe o email e a senha para
        // buscar as informações no banco de dados
        Cursor dados = bd.carregaDadosLogin(Login, SenhaLogin) ;

        // se encontrou os dados do usuario e senha
        if(dados.moveToFirst()){
            // carregando uma nova tela
            // levando parametros (nome do usuario) para a tela de login
            Intent tela = new Intent(this, menu.class);
            String nome = dados.getString(1);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            tela.putExtras(parametros);
            startActivity(tela);
        }else{
            String msg= "Dados não encontrados no sistema, digite outro!!";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            limpar();
        }
    }
    public void limpar(){
        txtLogin.setText("");
        txtSenhaLogin.setText("");
        txtLogin.requestFocus();
    }
}
