package com.example.marcelo.recetasdecocina.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.marcelo.recetasdecocina.R;
import com.example.marcelo.recetasdecocina.model.Receta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marcelo on 20/09/2017.
 */

public class RecetaAdapter extends RecyclerView.Adapter<RecetaAdapter.DeviveViewHolder>{

    private Context context;
    private List<Receta> dataset;
    private OnRecetaSelectedListener onRecetaSelectedListener;

    public interface OnRecetaSelectedListener {
        void onRecetaSelected(Receta comida);
    }

    public RecetaAdapter(Context context, OnRecetaSelectedListener onRecetaSelectedListener) {
        this.dataset = new ArrayList<>();
        this.context = context;
        this.onRecetaSelectedListener = onRecetaSelectedListener;
    }

    @Override
    public DeviveViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_receta, parent, false);
        return new DeviveViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DeviveViewHolder holder, int position) {
        Receta u = dataset.get(position);
        holder.nombre.setText(u.getTitle());
        String url = u.getImageURL();
        Glide.with(context).load(url).into(holder.imagen);

        holder.setDeviceSelectedListener(u, onRecetaSelectedListener);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public static class DeviveViewHolder extends RecyclerView.ViewHolder {

        View cardView;

        ImageView imagen;
        TextView nombre;

        public DeviveViewHolder(View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.card_receta);
            imagen = (ImageView) itemView.findViewById(R.id.imagen_receta);
            nombre = (TextView) itemView.findViewById(R.id.texto_receta);
        }

        public void setDeviceSelectedListener(final Receta receta, final OnRecetaSelectedListener onRecetaSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecetaSelectedListener.onRecetaSelected(receta);
                }
            });
        }
    }

    public void add(Receta receta) {
        dataset.add(receta);
        notifyDataSetChanged();
    }

    public void setDataset(List<Receta> recetas) {
        if (recetas == null) {
            dataset = new ArrayList<>();
        } else {
            dataset = recetas;
        }
        notifyDataSetChanged();
    }

    public void clear() {
        dataset.clear();
        notifyDataSetChanged();
    }
}
