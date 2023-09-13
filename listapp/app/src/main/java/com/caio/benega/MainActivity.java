package com.caio.benega;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ItemChurras> listinhabagual = new ArrayList<ItemChurras>();
    ListView lstv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstv=findViewById(R.id.listaveu);

        listinhabagual.add(new ItemChurras(  1, "carne", R.drawable.carne ));
        listinhabagual.add(new ItemChurras(  2, "batata", R.drawable.btt ));
        listinhabagual.add(new ItemChurras(  3, "reiniken", R.drawable.heiniken ));
        listinhabagual.add(new ItemChurras(  4, "frango", R.drawable.frango ));
        listinhabagual.add(new ItemChurras(  5, "cigarro", R.drawable.malboro ));
        ItemChurraAdapta ad = new ItemChurraAdapta(
                this, R.layout.carvao, listinhabagual);
        lstv.setAdapter();
    }
}