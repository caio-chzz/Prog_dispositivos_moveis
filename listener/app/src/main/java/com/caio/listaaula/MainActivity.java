package com.caio.listaaula;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String[] names;
    ListView listview;

    private Button salva;
    private EditText txtcoisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        salva=findViewById(R.id.salve);
        txtcoisa=findViewById(R.id.telha);
        listview=findViewById(R.id.listview);
        names=new String[] {};
        ArrayAdapter<String> aradp=new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                names
                );

        salva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vw) {





            listview.setAdapter(aradp);
            listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(MainActivity.this, "radoken"+Integer.toString(i),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}