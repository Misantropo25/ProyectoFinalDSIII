package com.example.proyectofinal.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinal.Activitys.ItemList;
import com.example.proyectofinal.Activitys.ItemLista;
import com.example.proyectofinal.adaptadores.RecyclerAdapter;
import com.example.proyectofinal.adaptadores.RecyclerAdaptera;
import com.example.proyectofinal.databinding.FragmentGalleryBinding;
import com.example.proyectofinal.R;
import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;
    private RecyclerView rvLista;
    private RecyclerView rvlistaa;
    private RecyclerAdapter adapter;
    private RecyclerAdaptera adaptera;
    private List<ItemList> items;
    private List<ItemLista> itemsa;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initViews(root);
        initValues(root);
        init(root);;
        initValue(root);

        return root;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



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

        items = getItems();
        adapter = new RecyclerAdapter(items);
        rvLista.setAdapter(adapter);

    }
    private void init(View root){
        rvlistaa = root.findViewById(R.id.rv_listaan);
    }

    private void initValue(View root){
        LinearLayoutManager maganera = new LinearLayoutManager(getContext());
        rvlistaa.setLayoutManager(maganera);

        itemsa = getItemsa();
        adaptera = new RecyclerAdaptera(itemsa);
        rvlistaa.setAdapter(adaptera);
    }

    private List<ItemList> getItems() {
        List<ItemList> itemLists = new ArrayList<>();
        itemLists.add(new ItemList("Hola Mundo","Nos vemos pronto",R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemList("UI/UX Diseñador", "Buen trabajo ☻", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemList("Mejores compañias de trabajo", "Hola, gracias por ....", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemList("Fundamentos del diseño", "Iniciamos pronto", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemList("Se busca juan", "Lo han visto?☹", R.drawable.notificacion,R.drawable.basura));
        itemLists.add(new ItemList("Ayuda vieron a juan?", "Se perdio juan en el Apex☹", R.drawable.notificacion,R.drawable.basura));

        return itemLists;
    }

    private List<ItemLista> getItemsa(){
        List<ItemLista> itemListas = new ArrayList<>();
        itemListas.add(new ItemLista("UI/UX Diseñador","Urgente",R.drawable.notificacion,R.drawable.basura));
        itemListas.add(new ItemLista("Diseñador Grafico","Software para colegio",R.drawable.notificacion,R.drawable.basura));
        itemListas.add(new ItemLista("Iniciado Diseñador UI"," ☻ Diseñar a juan ☻",R.drawable.notificacion,R.drawable.basura));
        itemListas.add(new ItemLista("Iniciado Diseñador Ux","Urgente",R.drawable.notificacion,R.drawable.basura));
        itemListas.add(new ItemLista("UI/UX Diseñador","Se busca con urgencia",R.drawable.notificacion,R.drawable.basura));

        return itemListas;
    }
}