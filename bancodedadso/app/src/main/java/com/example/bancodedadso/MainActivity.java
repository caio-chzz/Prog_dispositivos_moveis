package com.example.bancodedadso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;

    ListView listview ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listview= (ListView) findViewById(R.id.use);
        db = openOrCreateDatabase("mydatabase", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS users (id INTEGER PRIMARY KEY AUTOINCREMENT," +
                " name VARCHAR)");
        ContentValues cv = new ContentValues();
        cv.put("name", "John");
        db.insert("users", null, cv);

        Cursor c = db.rawQuery("SELECT * FROM users", null);
        c.moveToFirst();
        ArrayList<String> listu = new ArrayList<>();


        while (!c.isAfterLast()) {
            listu.add(c.getString(c.getColumnIndex("name")));
            Log.d("users", (c.getString(c.getColumnIndex("id")) +
                    c.getString(c.getColumnIndex("name"))));

            c.moveToNext();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, listu);
        listview.setAdapter(adapter);



    }



}