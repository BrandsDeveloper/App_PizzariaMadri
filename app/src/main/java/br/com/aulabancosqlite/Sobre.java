package br.com.aulabancosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sobre extends AppCompatActivity implements View.OnClickListener{

    Button btnContato1, btnHorario2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sobre);
        btnContato1 = (Button) findViewById(R.id.btnContato1);
        btnHorario2 = (Button) findViewById(R.id.btnHorario2);

        btnContato1.setOnClickListener(this);
        btnHorario2.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnContato1) {
            Intent Informacoes = new Intent(this, Contato.class);
            startActivity(Informacoes);
        }
        if (v.getId() == R.id.btnHorario2) {
            Intent Horario = new Intent(this, Horario.class);
            startActivity(Horario);
        }

    }
}