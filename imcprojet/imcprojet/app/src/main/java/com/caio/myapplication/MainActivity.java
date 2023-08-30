package com.caio.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText txtPeso;
    private EditText txtAltura;
    private Button calcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtPeso = findViewById(R.id.peso);
        txtAltura = findViewById(R.id.altura);
        calcular = findViewById(R.id.button);

        calcular.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                calcular();
            }
        });
    }

    private void calcular() {
        double peso = Double.parseDouble(txtPeso.getText().toString());
        double altura = Double.parseDouble(txtAltura.getText().toString());
        double imc = peso / (altura * altura);
        int recurso = retorna(imc);

        Bundle bundle = new Bundle();
        bundle.putDouble("peso", peso);
        bundle.putDouble("altura", altura);
        bundle.putDouble("imc", imc);
        bundle.putInt("recurso", recurso);

        Intent intent = new Intent(MainActivity.this, RstActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    private int retorna(double bmi) {
        if (bmi < 18.5) {
            return R.drawable.abaixopeso;
        } else if (bmi < 25) {
            return R.drawable.normal;
        } else if (bmi < 30) {
            return R.drawable.sobrepeso;
        } else if (bmi < 35) {
            return R.drawable.obesidade1;
        } else if (bmi < 40) {
            return R.drawable.obesidade2;
        } else {
            return R.drawable.obesidade3;
        }
    }
}