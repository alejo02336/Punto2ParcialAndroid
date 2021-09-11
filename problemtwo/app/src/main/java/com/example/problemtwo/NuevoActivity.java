package com.example.problemtwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.problemtwo.adaptadores.ListaPersonasAdapter;
import com.example.problemtwo.db.DbPersonas;
import com.example.problemtwo.entidades.Personas;

import java.util.ArrayList;

public class NuevoActivity extends AppCompatActivity {

    RecyclerView listaPersonas;
    ArrayList<Personas> listaArrayPersonas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo);

        listaPersonas = findViewById(R.id.listaPersonas);
        listaPersonas.setLayoutManager(new LinearLayoutManager(this));

        DbPersonas dbPersonas = new DbPersonas(NuevoActivity.this);

        listaArrayPersonas = new ArrayList<>();

        ListaPersonasAdapter adapter = new ListaPersonasAdapter(dbPersonas.mostrarPersonas());

        listaPersonas.setAdapter(adapter);


    }
}