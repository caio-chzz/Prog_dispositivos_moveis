package com.example.appdehoje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edmin, edmax;
    TextView txtv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("Ciclo de Vida Activity ", "onCreate ");
        Toast.makeText(this, "OnCreate", Toast.LENGTH_LONG).show();
        setContentView(R.layout.activity_main);
       // edmin=findViewById(R.id.edMin);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d("Ciclo de Vida Activity ", "onStart ");
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("Ciclo de Vida Activity ", "onResume ");
        Toast.makeText(this, "OnResume", Toast.LENGTH_LONG).show();
    }


    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ciclo de Vida Activity ", "onPause ");
        Toast.makeText(this, "OnPause", Toast.LENGTH_LONG).show();

    }

    public void Sortear(View v){
        int min, max;
        min=Integer.parseInt(edmin.getText().toString());
        max=Integer.parseInt(edmax.getText().toString());

        int sorteado= (int) (min+(Math.random()+(max-min)));

        txtv.setText(sorteado);
    }




}