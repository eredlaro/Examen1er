package com.example.examen_1er_parcial;

import android.app.Activity;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class PlanetAdapter extends ArrayAdapter<String> {
   private final Activity context;
   private final String[] nombres;
   private final String[] desc_breve;
   private final Integer[] img;

    public PlanetAdapter(Activity context, String[] nombres, String[] desc_breve, Integer[] img) {
        super(context, R.layout.item_planet,nombres);
        this.context = context;
        this.nombres = nombres;
        this.desc_breve = desc_breve;
        this.img = img;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.item_planet,null);
        TextView _nombre=(TextView)rowView.findViewById(R.id.nombre);
        TextView _desc_breve=(TextView)rowView.findViewById(R.id.precio);
        ImageView _img=(ImageView)rowView.findViewById(R.id.logo);
        _nombre.setText(nombres[position]);
        _desc_breve.setText(desc_breve[position]);
        _img.setImageResource(img[position]);
        return rowView;
    }
}
