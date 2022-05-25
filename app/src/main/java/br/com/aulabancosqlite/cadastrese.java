package br.com.aulabancosqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class cadastrese extends AppCompatActivity  implements View.OnClickListener {

    Button btnSalvar;
    EditText txtNomeCad, txtEmailCad, txtSenhaCad, txtConfSenhaCad;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cadastrese);

        btnSalvar = (Button) findViewById(R.id.btnSalvar);
        txtNomeCad = (EditText) findViewById(R.id.txtNomeCad);
        txtEmailCad = (EditText) findViewById(R.id.txtEmailCad);
        txtSenhaCad = (EditText) findViewById(R.id.txtSenhaCad);
        txtConfSenhaCad = (EditText) findViewById(R.id.txtConfSenhaCad);

        // quando der um click no botão salvar, carrega os comandos do click
        btnSalvar.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        // capturando os dados digitados e armazenando nas variáveis
        String NomeCad = txtNomeCad.getText().toString();
        String EmailCad = txtEmailCad.getText().toString();
        String SenhaCad = txtSenhaCad.getText().toString();
        String ConfSenhaCad = txtConfSenhaCad.getText().toString();


        // Criando a conexão com o banco de dados
        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        // validando os campos - o preenchimento
        if (txtNomeCad.length()==0)
        {
            String msg = "Preencha o campo nome";
            Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
        }else{
            if (txtEmailCad.length()==0)
            {
                String msg = "Preencha o campo e-mail";
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
            else
            {
                if (txtSenhaCad.length()==0)
                {
                    String msg = "Preencha o campo de senha";
                    Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (SenhaCad.equals(ConfSenhaCad)) {

                        // se nome preenchido, senha e confirmação de senha são iguais
                        // manda inserir no banco de dados (funcao está no bancocontroller.java)
                        resultado = bd.insereDadosUsuario(NomeCad, EmailCad, SenhaCad);

                        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                        limpar();
                        Intent telaListaUsuarios = new Intent(this, login.class);
                    }else{
                        String msg = "As senhas digitadas não são iguais, digite novamente!";
                        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
                    }
                }
            }

        }
    }
    public void limpar()
    {
        txtNomeCad.setText("");
        txtEmailCad.setText("");
        txtSenhaCad.setText("");
        txtConfSenhaCad.setText("");
        txtNomeCad.requestFocus();
    }
}
