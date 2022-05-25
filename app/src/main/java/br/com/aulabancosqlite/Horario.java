package br.com.aulabancosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Horario extends AppCompatActivity implements View.OnClickListener {

    Button btnSobre2, btnContato2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horario);

        btnSobre2 = (Button) findViewById(R.id.btnSobre2);
        btnContato2 = (Button) findViewById(R.id.btnContato2);

        btnSobre2.setOnClickListener(this);
        btnContato2.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnSobre2) {
            Intent Sobre = new Intent(this, Sobre.class);
            startActivity(Sobre);
        }
        if (v.getId() == R.id.btnContato2) {
            Intent Informacoes = new Intent(this, Contato.class);
            startActivity(Informacoes);
        }

    }
}