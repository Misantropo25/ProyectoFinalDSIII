package com.example.proyectofinal.adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.Activitys.ItemList;
import com.example.proyectofinal.Activitys.ItemPrincipal;
import com.example.proyectofinal.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerHolder> {

    private List<ItemList> items;

    public RecyclerAdapter(List<ItemList> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview, parent, false);
        return new RecyclerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ItemList item = items.get(position);
        holder.imgItem.setImageResource(item.getimgResource());
        holder.imgItemcam.setImageResource(item.getImgresourcescam());
        holder.tvTitulo.setText(item.getTitulo());
        holder.tvDescripcion.setText(item.getDescripcion());


    }

    @Override
    public int getItemCount() {
        return items.size();
    }



    public static class RecyclerHolder extends RecyclerView.ViewHolder{
        private ImageView imgItem;
        private ImageView imgItemcam;
        private TextView tvTitulo;
        private TextView tvDescripcion;


        public RecyclerHolder(@NonNull View itemView){
            super(itemView);
            imgItem = itemView.findViewById(R.id.imgItem);
            imgItemcam = itemView.findViewById(R.id.imgItemcam);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            tvTitulo= itemView.findViewById(R.id.tvTitulo);

        }
    }


}
