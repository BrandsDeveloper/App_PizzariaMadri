package br.com.aulabancosqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Contato extends AppCompatActivity implements View.OnClickListener{

    Button btnSobre1, btnHorario1, btnMapa, btnLigar;
    TextView number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contato);

        btnSobre1 = (Button) findViewById(R.id.btnSobre1);
        btnHorario1 = (Button) findViewById(R.id.btnHorario1);
        btnMapa = (Button) findViewById(R.id.btnMapa);


        btnSobre1.setOnClickListener(this);
        btnHorario1.setOnClickListener(this);
        btnMapa.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        if (v.getId() == R.id.btnSobre1) {
            Intent Sobre = new Intent(this, Sobre.class);
            startActivity(Sobre);
        }
        if (v.getId() == R.id.btnHorario1) {
            Intent Horario = new Intent(this, Horario.class);
            startActivity(Horario);
        }

        if (v.getId() == R.id.btnMapa) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/Pizzaria+Madri/@-23.466747,-46.5555969,17z/data=!3m1!4b1!4m5!3m4!1s0x94cef575c1a12c77:0x5f21bef7edc772b4!8m2!3d-23.4667514!4d-46.553407")));
        }

    }

    public  void Call(View v)
    {

        TextView e = (TextView)findViewById(R.id.number);

        Uri u = Uri.parse("tel:" + e.getText().toString());

        // Create the intent and set the data for the
        // intent as the phone number.
        Intent i = new Intent(Intent.ACTION_DIAL, u);

        try
        {
            // Launch the Phone app's dialer with a phone
            // number to dial a call.
            startActivity(i);
        }
        catch (SecurityException s)
        {
            // show() method display the toast with
            // exception message.
            Toast.makeText(this, "An error occurred", Toast.LENGTH_LONG)
                    .show();
        }

    }
}