package com.example.problemtwo.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.problemtwo.R;
import com.example.problemtwo.entidades.Personas;

import java.util.ArrayList;

public class ListaPersonasAdapter extends RecyclerView.Adapter<ListaPersonasAdapter.PersonaViewHolder> {

    ArrayList<Personas> listaPersonas;

    public ListaPersonasAdapter(ArrayList<Personas> listaPersonas){
        this.listaPersonas =  listaPersonas;
    }


    @NonNull
    @Override
    public PersonaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_item_persona, null, false);
        return new PersonaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonaViewHolder holder, int position) {
        holder.viewNombre.setText(listaPersonas.get(position).getNombre());
        holder.viewApellido.setText(listaPersonas.get(position).getApellido());
        holder.viewNivel.setText(listaPersonas.get(position).getHemoglobina());
        holder.viewCorreo.setText(listaPersonas.get(position).getCorreo());
        holder.viewEdad.setText(listaPersonas.get(position).getEdad());
        holder.viewSexo.setText(listaPersonas.get(position).getSexo());
        holder.viewEstado.setText(listaPersonas.get(position).getEstado());
    }

    @Override
    public int getItemCount() {
        return  listaPersonas.size();

    }

    public class PersonaViewHolder extends RecyclerView.ViewHolder {

        TextView viewNombre, viewApellido, viewNivel, viewCorreo, viewEdad, viewSexo, viewEstado;

        public PersonaViewHolder(@NonNull View itemView) {
            super(itemView);

            viewNombre = itemView.findViewById(R.id.viewNombre);
            viewApellido = itemView.findViewById(R.id.viewApellido);
            viewNivel = itemView.findViewById(R.id.viewNivel);
            viewCorreo = itemView.findViewById(R.id.viewCorreo);
            viewEdad = itemView.findViewById(R.id.viewEdad);
            viewSexo = itemView.findViewById(R.id.viewSexo);
            viewEstado = itemView.findViewById(R.id.viewEstado);

        }
    }
}
