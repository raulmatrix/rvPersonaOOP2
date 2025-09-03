package com.example.apppracticaoop;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetalleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        TextView tvNombre = findViewById(R.id.tvNombreDetalle);
        TextView tvEdad   = findViewById(R.id.tvEdadDetalle);
        TextView tvCiudad = findViewById(R.id.tvCiudadDetalle);

        Persona p = (Persona) getIntent().getSerializableExtra("persona");
        if (p != null) {
            tvNombre.setText("Nombre: " + p.getNombre());
            tvEdad.setText("Edad: " + p.getEdad());
            tvCiudad.setText("Ciudad: " + p.getCiudad());
        }
    }
}
