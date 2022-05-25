package br.com.aulabancosqlite;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class pedido extends AppCompatActivity implements View.OnClickListener {
    TextView txtqtdMadrid, txtqtdToscana, txtqtdCalabresa, txtTotalPedido;
    Button  btnMaisMadrid, btnMenosMadrid, btnMenosCalabresa, btnMaisCalabresa;
    Button  btnMenosToscana, btnMaisToscana, btnGravarPedido;
    String nome ="";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pedido);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        txtqtdMadrid = (TextView) findViewById(R.id.txtqtdMadrid);
        txtqtdToscana = (TextView) findViewById(R.id.txtqtdToscana);
        txtqtdCalabresa = (TextView) findViewById(R.id.txtqtdCalabresa);
        txtTotalPedido= (TextView) findViewById(R.id.txtTotalPedido);

        btnMaisMadrid = (Button) findViewById(R.id.btnMaisMadrid);
        btnMenosMadrid = (Button) findViewById(R.id.btnMenosMadrid);
        btnMaisToscana = (Button) findViewById(R.id.btnMaisToscana);
        btnMenosToscana = (Button) findViewById(R.id.btnMenosToscana);
        btnMaisCalabresa = (Button) findViewById(R.id.btnMaisCalabresa);
        btnMenosCalabresa = (Button) findViewById(R.id.btnMenosCalabresa);
        btnGravarPedido = (Button) findViewById(R.id.btnGravarPedido);

        btnMaisMadrid.setOnClickListener(this);
        btnMenosMadrid.setOnClickListener(this);
        btnMaisToscana.setOnClickListener(this);
        btnMenosToscana.setOnClickListener(this);
        btnMaisCalabresa.setOnClickListener(this);
        btnMenosCalabresa.setOnClickListener(this);
        btnGravarPedido.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        int qtdMadrid = 0, qtdToscana = 0, qtdCalabresa = 0;
        float valorMadrid = (float) 30.90;
        float valorToscana = (float) 34.99;
        float valorCalabresa = (float) 29.90;
        float subTotalMadrid = 0;
        float subTotalToscana = 0;
        float subTotalCalabresa = 0;
        qtdMadrid = Integer.parseInt(txtqtdMadrid.getText().toString());
        qtdToscana = Integer.parseInt(txtqtdToscana.getText().toString());
        qtdCalabresa = Integer.parseInt(txtqtdCalabresa.getText().toString());

        if (v.getId() == R.id.btnMaisMadrid) {
            qtdMadrid += 1;
            txtqtdMadrid.setText(""+qtdMadrid);
        }
        if (v.getId() == R.id.btnMenosMadrid) {
            qtdMadrid -= 1;
            if (qtdMadrid<=0)
            {
                qtdMadrid = 0;
            }
            txtqtdMadrid.setText(""+qtdMadrid);
        }

        if (v.getId() == R.id.btnMaisToscana) {
            qtdToscana += 1;
            txtqtdToscana.setText(""+qtdToscana);
        }
        if (v.getId() == R.id.btnMenosToscana) {
            qtdToscana -= 1;
            if (qtdToscana<=0)
            {
                qtdToscana = 0;
            }
            txtqtdToscana.setText(""+qtdToscana);
        }

        if (v.getId() == R.id.btnMaisCalabresa) {
            qtdCalabresa += 1;
            txtqtdCalabresa.setText(""+qtdCalabresa);
        }
        if (v.getId() == R.id.btnMenosCalabresa) {
            qtdCalabresa -= 1;
            if (qtdCalabresa<=0)
            {
                qtdCalabresa = 0;
            }
            txtqtdCalabresa.setText(""+qtdCalabresa);
        }
        subTotalMadrid = qtdMadrid * valorMadrid;
        subTotalToscana = qtdToscana * valorToscana;
        subTotalCalabresa = qtdCalabresa * valorCalabresa;

        float total = subTotalMadrid + subTotalToscana + subTotalCalabresa;
        txtTotalPedido.setText("" + total);

        if (v.getId() == R.id.btnGravarPedido) {
            gravarPedido();
        }
    }

    public void gravarPedido()
    {
        float valorBolacha = (float) 2.89;
        float valorLeite = (float) 3.45;
        float valorCafe = (float) 10.80;

        int qtdBolacha = Integer.parseInt(txtqtdMadrid.getText().toString());
        int qtdLeite = Integer.parseInt(txtqtdToscana.getText().toString());
        int qtdCafe = Integer.parseInt(txtqtdCalabresa.getText().toString());

        float subTotalBolacha = qtdBolacha * valorBolacha;
        float subTotalLeite = qtdLeite * valorLeite;
        float subTotalCafe = qtdCafe * valorCafe;

        float total = subTotalBolacha + subTotalLeite + subTotalCafe;

        BancoController bd = new BancoController(getBaseContext());
        String resultado;

        resultado = bd.insereDadosPedido(nome, qtdBolacha, qtdLeite, qtdCafe, valorBolacha, valorLeite, valorCafe, total );

        Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
        limpar();

    }
    public void limpar()
    {
        txtqtdMadrid.setText("0");
        txtqtdCalabresa.setText("0");
        txtqtdToscana.setText("0");
        txtTotalPedido.setText("0");
    }
}
