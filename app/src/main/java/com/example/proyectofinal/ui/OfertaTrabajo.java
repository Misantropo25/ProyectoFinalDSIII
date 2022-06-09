package com.example.proyectofinal.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.proyectofinal.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OfertaTrabajo#newInstance} factory method to
 * create an instance of this fragment.
 */
public class OfertaTrabajo extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button redireccionador,ubicacion;


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public OfertaTrabajo() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment OfertaTrabajo.
     */
    // TODO: Rename and change types and number of parameters
    public static OfertaTrabajo newInstance(String param1, String param2) {
        OfertaTrabajo fragment = new OfertaTrabajo();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_oferta_trabajo, container, false);
        redireccionador = view.findViewById(R.id.redireccionamiento);
        ubicacion = view.findViewById(R.id.Ubicacion);
        redireccionador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent whats = getContext().getPackageManager().getLaunchIntentForPackage("com.whatsapp");
                startActivity(whats);
            }
        });

        ubicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_nav_trabajo_to_mapsFragment);
            }
        });

        return view;
    }


}