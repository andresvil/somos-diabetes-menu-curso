package com.example.andresvil.menucurso;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    int[] img_resource = {R.drawable.m1, R.drawable.m2, R.drawable.m3, R.drawable.m4, R.drawable.m5};

    String[] modulos = {"Modulo 1:", "Modulo 2:", "Modulo 3:", "Modulo 4:", "Modulo 5:"};

    String[] nombreCapitulos = {"¿Qué es la Diabetes?", "Dieta y el Plato del Bien Comer",
                "Complicaciones de la Diabetes", "La Diabetes y el Control de Emociones",
                "Plan de Autocuidado"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.listView);
        MyAdapter adapter = new MyAdapter(getApplicationContext(), R.layout.row_layout);
        listView.setAdapter(adapter);

        for(int i = 0; i < modulos.length; i++)
        {
            Modulo m = new Modulo(img_resource[i], modulos[i], nombreCapitulos[i]);
            adapter.add(m);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
