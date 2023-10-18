package com.example.atitividad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lista;

    private Button btnAdicionar;

    private EditText txtNome;

     SQLiteDatabase cleide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista=findViewById(R.id.tarafes);
        btnAdicionar=findViewById(R.id.coloca);
        txtNome=findViewById(R.id.campo);
        cleide = openOrCreateDatabase("picanha", Context.MODE_PRIVATE, null);
        cleide.execSQL("CREATE TABLE IF NOT EXISTS tasks (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR)");


        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                inserir();
            }
        });
    }

    private void inserir() {
        ContentValues cv = new ContentValues();
        cv.put("name", txtNome.getText().toString());
        cleide.insert("tasks", null, cv);

        att();
    }
    private void att(){
        Cursor c = cleide.rawQuery("SELECT * FROM users", null);
        c.moveToFirst();
        ArrayList<String> chek = new ArrayList<>();

        while (!c.isAfterLast()) {
            chek.add(c.getString(c.getColumnIndex("name")));

            c.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, chek);
        lista.setAdapter(adapter);

    }

    }
