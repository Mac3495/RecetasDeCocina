package com.example.marcelo.recetasdecocina.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marcelo.recetasdecocina.R;
import com.example.marcelo.recetasdecocina.model.TipoComida;

import java.util.ArrayList;

/**
 * Created by Marcelo on 14/09/2017.
 */

public class TipoComidaAdapter extends RecyclerView.Adapter<TipoComidaAdapter.DeviceViewHolder>
implements View.OnClickListener{

    private ArrayList<TipoComida> dataset;
    private View.OnClickListener listener;

    public TipoComidaAdapter(ArrayList<TipoComida> tipoComidas){
        this.dataset = tipoComidas;
    }

    @Override
    public DeviceViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_main, parent, false);

        view.setOnClickListener(this);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviceViewHolder holder, int position) {
        TipoComida tipoComida = dataset.get(position);
        holder.nombre.setText(tipoComida.getNombre());
        holder.imagen.setImageResource(tipoComida.getImagen());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!=null){
            listener.onClick(v);
        }
    }


    public static class DeviceViewHolder extends RecyclerView.ViewHolder{

        View cardView;

        TextView nombre;
        ImageView imagen;

        public DeviceViewHolder(View itemView){
            super(itemView);

            cardView = itemView.findViewById(R.id.card_main);

            nombre = (TextView) itemView.findViewById(R.id.texto_main);
            imagen = (ImageView) itemView.findViewById(R.id.imagen_main);

        }
    }
}
