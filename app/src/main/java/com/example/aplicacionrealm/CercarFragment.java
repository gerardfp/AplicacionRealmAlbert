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
    private String dato;
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
                    System.out.println("....................vacio campo");
//            if (TextUtils.isEmpty(nom.getText().toString())){
//                System.out.println(".....................dos");
//                if (TextUtils.isEmpty(cognoms.getText().toString())){
//                    System.out.println("......................tres");
//                    if (TextUtils.isEmpty(categoria.getText().toString())){
//                        System.out.println("..............................cuatro");
//                        if (TextUtils.isEmpty(edad.getText().toString())){
//                            System.out.println("..........................cinco");
//                            if (TextUtils.isEmpty(antiguetat.getText().toString())){
//                                System.out.println("..........................seis");
//                                id.setError("Introueix alguna dada");
//                            }else appViewModel.dato.setValue(antiguetat.getText().toString());
//                        }else appViewModel.dato.setValue(edad.getText().toString());
//                    }else appViewModel.dato.setValue(categoria.getText().toString());
//                }else appViewModel.dato.setValue(cognoms.getText().toString());
//            }else appViewModel.dato.setValue(nom.getText().toString());
                }else appViewModel.dato.setValue(id.getText().toString());





                navController.navigate(R.id.listBusquedaFragment);

            }
        });
    }

}
