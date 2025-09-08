package com.example.apppracticaoop;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.VH> {

    private ArrayList<Persona> data;

    // Constructor solo con la lista
    public PersonaAdapter(ArrayList<Persona> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflamos el layout para cada elemento de la lista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_persona, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        // Obtenemos el objeto Persona en la posición actual
        final Persona p = data.get(position); // 'final' para poder usar dentro del OnClick

        // Asignamos datos a los TextViews
        holder.tvNombre.setText(p.getNombre());
        holder.tvDetalle.setText(p.getEdad() + " años • " + p.getCiudad());

        // Manejo del click directamente en el Adapter (versión sin lambda)
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Creamos un Intent para ir a DetalleActivity
                Intent i = new Intent(v.getContext(), DetalleActivity.class);
                i.putExtra("persona", p); // Enviamos el objeto Persona
                v.getContext().startActivity(i); // Iniciamos la nueva actividad
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    // ViewHolder interno para almacenar referencias de vistas
    static class VH extends RecyclerView.ViewHolder {
        TextView tvNombre, tvDetalle;

        VH(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDetalle = itemView.findViewById(R.id.tvDetalle);
        }
    }
}
