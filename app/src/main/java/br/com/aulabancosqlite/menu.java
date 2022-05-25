package br.com.aulabancosqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class menu extends AppCompatActivity  implements View.OnClickListener {

    Button btnContato, btnMeusDados, btnFaca, btnPedido;
    TextView txtNomeUsuario;
    String nome="";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        // recebendo os dados da tela de login
        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        btnContato = (Button) findViewById(R.id.btnContato);
        btnMeusDados = (Button) findViewById(R.id.btnMeusDados);
        btnPedido = (Button) findViewById(R.id.btnPedido);
        btnFaca = (Button) findViewById(R.id.btnFaca);


        txtNomeUsuario = (TextView) findViewById(R.id.txtNomeUsuario);
        // apresentando o nome do usuario
        txtNomeUsuario.setText("Seja Bem Vindo: " + nome);

        btnContato.setOnClickListener(this);
        btnMeusDados.setOnClickListener(this);
        btnFaca.setOnClickListener(this);
        btnPedido.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnFaca) {
            Intent FacaSeuPedido = new Intent(this, Lista.class);
            startActivity(FacaSeuPedido);
        }
        if (v.getId() == R.id.btnPedido) {
            Intent MeusPedidos = new Intent(this, pedido.class);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            MeusPedidos.putExtras(parametros);
            startActivity(MeusPedidos);
        }
        if (v.getId() == R.id.btnContato) {
            Intent Informacoes = new Intent(this, Contato.class);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            Informacoes.putExtras(parametros);
            startActivity(Informacoes);
        }
        if (v.getId() == R.id.btnMeusDados) {
            Intent Dados = new Intent(this, meusdados.class);
            Bundle parametros = new Bundle();
            parametros.putString("nome",nome);
            Dados.putExtras(parametros);
            startActivity(Dados);
        }
    }
}
