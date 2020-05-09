package com.example.aplicacionrealm;

import android.app.AlertDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aplicacionrealm.Model.Empleat;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class CercarFragment extends MyFragment {
    Button  btCercar;
    EditText id, nom, cognoms, categoria, edad, antiguetat;
    private String[] busqueda = new String[2];
    public CercarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cercar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        id = view.findViewById(R.id.idCerca);
        nom = view.findViewById(R.id.nomCerca);
        cognoms = view.findViewById(R.id.cognomsCerca);
        categoria = view.findViewById(R.id.categoriaCerca);
        edad = view.findViewById(R.id.edadCerca);
        antiguetat = view.findViewById(R.id.antiguetatCerca);
        btCercar = view.findViewById(R.id.btnCerca);

        btCercar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (TextUtils.isEmpty(id.getText().toString())){
                    if (TextUtils.isEmpty(nom.getText().toString())){
                        if (TextUtils.isEmpty(cognoms.getText().toString())){
                            if (TextUtils.isEmpty(categoria.getText().toString())){
                                if (TextUtils.isEmpty(edad.getText().toString())){
                                    if (TextUtils.isEmpty(antiguetat.getText().toString())){
                                        id.setError("Introueix alguna dada");
                                    }else{
                                        busqueda[0] = antiguetat.getText().toString();
                                        busqueda[1] = "antiguetat";
                                    }
                                }else {
                                    busqueda[0] = edad.getText().toString();
                                    busqueda[1] = "edad";
                                }
                            }else {
                                busqueda[0] = categoria.getText().toString();
                                busqueda[1] = "categoria";
                            }
                        }else {
                            busqueda[0] = cognoms.getText().toString();
                            busqueda[1] = "cognoms";
                        }
                    }else {
                        busqueda[0] = nom.getText().toString();
                        busqueda[1] = "nom";
                    }
                }else {
                    busqueda[0] = id.getText().toString();
                    busqueda[1] = "id";
                }
                appViewModel.busqueda.setValue(busqueda);
                navController.navigate(R.id.listBusquedaFragment);
            }
        });
    }
}
