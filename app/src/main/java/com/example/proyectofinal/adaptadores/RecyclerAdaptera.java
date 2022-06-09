package com.example.proyectofinal.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.proyectofinal.Activitys.ItemLista;
import com.example.proyectofinal.R;


import java.util.List;

public class RecyclerAdaptera extends RecyclerView.Adapter<RecyclerAdaptera.RecyclerHolder> {
    private List<ItemLista> itemsa;

    public RecyclerAdaptera(List<ItemLista> itemsa) {
        this.itemsa = itemsa;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewa = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardiewa, parent, false);
        return new RecyclerHolder(viewa);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ItemLista item = itemsa.get(position);
        holder.imgItemcamdos.setImageResource(item.getImgresourcescamdos());
        holder.imgItema.setImageResource(item.getImgresourcea());
        holder.tvTituloa.setText(item.getTituloa());
        holder.tvDescripciona.setText(item.getDescripciona());
    }

    @Override
    public int getItemCount() {
        return itemsa.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItema;
        private ImageView imgItemcamdos;
        private TextView tvTituloa;
        private TextView tvDescripciona;

        public RecyclerHolder(@NonNull View itemViewa){
            super(itemViewa);
            imgItema = itemViewa.findViewById(R.id.imgItema);
            imgItemcamdos = itemView.findViewById(R.id.imgItemcamdos);
            tvTituloa = itemViewa.findViewById(R.id.tvTituloa);
            tvDescripciona = itemViewa.findViewById(R.id.tvDescripciona);
        }
    }
}
