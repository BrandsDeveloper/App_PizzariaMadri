package br.com.aulabancosqlite;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.widget.ListView;
import android.widget.Toast;
import java.util.LinkedList;
import java.util.List;

public class ConsultaLista extends Activity {

    ListView lista;
    String nome;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_lista);

        Intent intencao = getIntent();
        Bundle parametros = intencao.getExtras();
        nome = parametros.getString("nome");

        List<UsuariosModelo> listaUsuarios = null ;
        listaUsuarios = consultarTodosUsuarios(nome);

        UsuariosAdapter adaptador = new UsuariosAdapter(this,  listaUsuarios);

        lista = (ListView) findViewById(R.id.lista);
        lista.setAdapter(adaptador);
    }


    public List<UsuariosModelo> consultarTodosUsuarios(String vnome) {
        List<UsuariosModelo> lista = new LinkedList<UsuariosModelo>();

        BancoController bd = new BancoController(getBaseContext());
        Cursor dados = bd.carregaTodosDados(vnome) ;

        if(dados != null) {
            do  {
                UsuariosModelo item = new UsuariosModelo();
                item.setCodigo(dados.getInt(0));
                item.setNome(dados.getString(1));
                item.setEmail(dados.getString(2));
                lista.add(item);
            } while(dados.moveToNext());
        }else{
            String msg= "Não há nenhum usuário cadastrado!!";
            mensagem(msg);
        }
        return  lista ;
    }

    public void mensagem(String msg) {
        Context contexto = getApplicationContext();
        int duracao = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(contexto, msg, duracao);
        toast.show();
    }

}
