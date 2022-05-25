package br.com.aulabancosqlite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class UsuariosAdapter extends ArrayAdapter<UsuariosModelo>{


    private Context context;
    private List<UsuariosModelo> listaUsuarios = null;

    public UsuariosAdapter(Context context,  List<UsuariosModelo> listaUsuarios) {
        super(context,0, listaUsuarios);
        this.listaUsuarios = listaUsuarios;
        this.context = context;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        UsuariosModelo alunos = listaUsuarios.get(position);

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_lista, null);
        }

        TextView textViewCodigo = (TextView) view.findViewById(R.id.codigo);
        textViewCodigo.setText(String.valueOf(alunos.getCodigo()));

        TextView textViewNome = (TextView) view.findViewById(R.id.nome);
        textViewNome.setText(alunos.getNome());

        TextView textViewEmail = (TextView)view.findViewById(R.id.email);
        textViewEmail.setText(alunos.getEmail());

        return view;
    }
}
