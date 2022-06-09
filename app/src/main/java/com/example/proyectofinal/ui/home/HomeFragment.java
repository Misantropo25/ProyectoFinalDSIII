package com.example.proyectofinal.ui.home;

import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.Activitys.ItemPrincipal;
import com.example.proyectofinal.AuthMenu;
import com.example.proyectofinal.MainActivity;
import com.example.proyectofinal.R;
import com.example.proyectofinal.adaptadores.RecyclerAdapter;
import com.example.proyectofinal.adaptadores.RecyclerAdapterPrincipal;
import com.example.proyectofinal.adaptadores.RecyclerAdaptera;
import com.example.proyectofinal.databinding.FragmentHomeBinding;
import com.example.proyectofinal.ui.gallery.GalleryFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private RecyclerView rvLista;
    private RecyclerAdapterPrincipal adapter;
    private List<ItemPrincipal> itemsa;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initViews(root);
        initValues(root);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void initViews(View root){
        rvLista = root.findViewById(R.id.rv_lista);
    }

    private void initValues(View root){
        LinearLayoutManager manager = new LinearLayoutManager(getContext());
        rvLista.setLayoutManager(manager);

        itemsa = getItems();
        adapter = new RecyclerAdapterPrincipal(itemsa);
        rvLista.setAdapter(adapter);

    }


    private List<ItemPrincipal> getItems() {
        List<ItemPrincipal> itemLists = new ArrayList<>();
        itemLists.add(new ItemPrincipal("Hola Mundo","Nos vemos pronto",R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemPrincipal("UI/UX Diseñador", "Buen trabajo ☻", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemPrincipal("Mejores compañias de trabajo", "Hola, gracias por ....", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemPrincipal("Fundamentos del diseño", "Iniciamos pronto", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemPrincipal("Se busca juan", "Lo han visto?☹", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemPrincipal("Ayuda vieron a juan?", "Se perdio juan en el Apex☹", R.drawable.notificacion,R.drawable.basura));

        return itemLists;
    }



}