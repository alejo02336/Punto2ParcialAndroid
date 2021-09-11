package com.example.problemtwo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.problemtwo.db.DbPersonas;

public class MainActivity extends AppCompatActivity {

    private EditText nombre, apellido, hemoglobina, correo, edad;
    private Spinner sexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombreu);
        apellido = findViewById(R.id.apellidou);
        hemoglobina = findViewById(R.id.hemou);
        correo = findViewById(R.id.correou);
        edad = findViewById(R.id.edadu);
        sexo = findViewById(R.id.spinneru);
        String [] opciones = {"Masculino", "Femenino"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, opciones);
        sexo.setAdapter(adapter);
    }

    public void condicion(View view){
        double age= Double.parseDouble(edad.getText().toString());
        double hemo = Double.parseDouble(hemoglobina.getText().toString());

        if( (age >= 0 && age <= 1) && (hemo >= 13.0 && hemo <= 26.0)){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else if((age > 1 && age <= 6) && (hemo >= 10.0 && hemo <= 18.0)){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else if((age > 6 && age <= 12) && (hemo >= 11.0 && hemo <= 15.0)){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else if((age > 12 && age <= 60) && (hemo >= 11.5 && hemo <= 15.0)){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else if((age > 60 && age <= 120) && (hemo >= 12.6 && hemo <= 15.5)){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else if((age > 180) && (hemo >= 12.0 && hemo <= 16.0) && (sexo.getSelectedItem().toString().equalsIgnoreCase("Femenino"))){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else if((age > 180) && (hemo >= 14.0 && hemo <= 18.0) && (sexo.getSelectedItem().toString().equalsIgnoreCase("Masculino"))){
            Toast.makeText(MainActivity.this, "NEGATIVO", Toast.LENGTH_LONG).show();
            insertar("NEGATIVO");
        }else {
            Toast.makeText(MainActivity.this, "POSITIVO", Toast.LENGTH_LONG).show();
            insertar("POSITIVO");
        }
    }


    public void insertar(String estado){
        DbPersonas dbPersonas = new DbPersonas(MainActivity.this);
        long id = dbPersonas.insertarPersona(nombre.getText().toString(),apellido.getText().toString(),hemoglobina.getText().toString(),correo.getText().toString(),edad.getText().toString(),sexo.getSelectedItem().toString(),estado);
        if(id > 0){
            Toast.makeText(MainActivity.this, "REGISTRO GUARDADO", Toast.LENGTH_LONG).show();
            limpiar();
        }else{
            Toast.makeText(MainActivity.this, "ERROR AL GUARDAR REGISTRO", Toast.LENGTH_LONG).show();
            limpiar();
        }
    }

    private void limpiar(){
        nombre.setText("");
        apellido.setText("");
        hemoglobina.setText("");
        correo.setText("");
        edad.setText("");
    }

    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.listaPersona:
                listaPersonas();
                return true;
            case R.id.cerrar:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    private void listaPersonas(){
        Intent intent = new Intent(this, NuevoActivity.class);
        startActivity(intent);
    }
}