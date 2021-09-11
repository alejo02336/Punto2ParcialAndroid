package com.example.problemtwo.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.example.problemtwo.entidades.Personas;

import java.util.ArrayList;

public class DbPersonas extends DbHelper{

    Context context;

    public DbPersonas(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long insertarPersona (String nombre, String apellido, String hemoglobina, String edad, String correo, String sexo, String estado){
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues values = new ContentValues();
            values.put("nombre", nombre);
            values.put("apellido", apellido);
            values.put("hemoglobina", hemoglobina);
            values.put("edad", edad);
            values.put("correo", correo);
            values.put("sexo", sexo);
            values.put("estado", estado);

            id = db.insert(TABLE_PERSONAS, null,values );
        } catch (Exception ex){
            ex.toString();
        }

        return id;

    }


    public ArrayList<Personas> mostrarPersonas (){
        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ArrayList<Personas> listaPersonas = new ArrayList<>();
        Personas persona = null;
        Cursor cursorPersonas = null;

        cursorPersonas = db.rawQuery("SELECT * FROM " + TABLE_PERSONAS, null);

        if(cursorPersonas.moveToFirst()){
            do {
                persona= new Personas();
                persona.setId(cursorPersonas.getInt(0));
                persona.setNombre(cursorPersonas.getString(1));
                persona.setApellido(cursorPersonas.getString(2));
                persona.setHemoglobina(cursorPersonas.getString(3));
                persona.setEdad(cursorPersonas.getString(4));
                persona.setCorreo(cursorPersonas.getString(5));
                persona.setSexo(cursorPersonas.getString(6));
                persona.setEstado(cursorPersonas.getString(7));
                listaPersonas.add(persona);

            } while (cursorPersonas.moveToNext());
        }

        cursorPersonas.close();

        return listaPersonas;
    }

}
