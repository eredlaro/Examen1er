package com.example.examen_1er_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ListView lista_planetas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista_planetas = (ListView) findViewById(R.id.list_planet);
        String[] nombres = {"Mercurio", "Venus", "Tierra", "Marte"};
        String[] descr_breve = {"Primer planeta", "Segundo planeta", "Tercer planeta", "Cuarto planeta"};
        Integer[] imag_planet = {R.drawable.mercurio, R.drawable.venus, R.drawable.tierra, R.drawable.marte};
        PlanetAdapter adpater = new PlanetAdapter(this, nombres, descr_breve, imag_planet);
        lista_planetas.setAdapter(adpater);

        lista_planetas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), DescripcionActivity.class);
                intent.putExtra("planeta", String.valueOf(position));
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(getApplicationContext(), "La aplicacion fue creada por alumnos de DAM2", Toast.LENGTH_LONG).show();
                return true;
            case R.id.salir:
                Toast.makeText(getApplicationContext(), "Saliste de la aplicacion bye ", Toast.LENGTH_LONG).show();

                return true;


            default:
                return super.onOptionsItemSelected(item);
        }
    }
}