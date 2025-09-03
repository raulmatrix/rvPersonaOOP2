package com.example.apppracticaoop;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private ArrayList<Persona> personas;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rvPersonas);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        // Lista de datos de ejemplo
        personas = new ArrayList<>();
        personas.add(new Persona("Ana", 22, "Cochabamba"));
        personas.add(new Persona("Luis", 28, "La Paz"));
        personas.add(new Persona("María", 24, "Santa Cruz"));
        personas.add(new Persona("Jorge", 30, "Tarija"));
        personas.add(new Persona("Camila", 27, "Oruro"));

        // Configuramos el Adapter
        PersonaAdapter adapter = new PersonaAdapter(personas);
        rv.setAdapter(adapter);
    }
}
