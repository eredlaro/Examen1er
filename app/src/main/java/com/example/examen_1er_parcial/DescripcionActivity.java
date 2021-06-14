package com.example.examen_1er_parcial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DescripcionActivity extends AppCompatActivity {
    private ImageView imagen;
    private TextView descripcion,titulo;
    private Button regresar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        titulo=(TextView)findViewById(R.id.titulo);
       imagen=(ImageView)findViewById(R.id.imagen);
       descripcion=(TextView)findViewById(R.id.descripcion);
       regresar=(Button)findViewById(R.id.regresar);

       final String[] titulos={"Mercurio","Venus","Tierra","Marte"};
       final Integer[] imagenes={R.drawable.mercurio,R.drawable.venus,R.drawable.tierra,R.drawable.marte};
       final String[] descripciones={"Aqui va la descripcion del primer planeta el planeta mercurio","Aqui va la descripcion del primer planeta el planeta venus","Aqui va la descripcion del primer planeta el planeta tierra","Aqui va la descripcion del primer planeta el planeta marte"};
        String position;
       Bundle bundle = getIntent().getExtras();
       if(bundle!=null){
           position=bundle.getString("planeta");
           titulo.setText(titulos[Integer.valueOf(position)]);
           imagen.setImageResource(imagenes[Integer.valueOf(position)]);
           descripcion.setText(descripciones[Integer.valueOf(position)]);
       }
       else{
           Toast.makeText(getApplicationContext(),"No hay informacion para mostrar",Toast.LENGTH_LONG).show();
       }
       regresar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),MainActivity.class);
               startActivity(intent);
           }
       });

    }
}