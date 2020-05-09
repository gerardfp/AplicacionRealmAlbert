package com.example.aplicacionrealm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicacionrealm.Model.Empleat;

import java.util.function.Function;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class CercarFragment extends MyFragment {
    Button btCercar;
    EditText idText, nomText, cognomsText, categoriaText, edadText, antiguetatText;
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

        idText = view.findViewById(R.id.idCerca);
        nomText = view.findViewById(R.id.nomCerca);
        cognomsText = view.findViewById(R.id.cognomsCerca);
        categoriaText = view.findViewById(R.id.categoriaCerca);
        edadText = view.findViewById(R.id.edadCerca);
        antiguetatText = view.findViewById(R.id.antiguetatCerca);
        btCercar = view.findViewById(R.id.btnCerca);

        btCercar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!validateForm()) {
                    Toast toast1 = Toast.makeText(requireActivity(),
                            "Només pots introudir un camp !", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER | Gravity.LEFT, 250, 0);
                    toast1.show();
                    return;
                }

                appViewModel.empleatABuscar.setValue(new Empleat(
                        idText.getText().toString().isEmpty() ? -1 : Integer.parseInt(idText.getText().toString()),
                        nomText.getText().toString(),
                        cognomsText.getText().toString(),
                        categoriaText.getText().toString(),
                        edadText.getText().toString().isEmpty() ? -1 : Integer.parseInt(edadText.getText().toString()),
                        antiguetatText.getText().toString().isEmpty() ? -1 : Integer.parseInt(antiguetatText.getText().toString())
                        ));
                navController.navigate(R.id.listBusquedaFragment);
            }
        });
    }

// Validar que només entris una dade i els camps numèrics siguin números
    private boolean validateForm() {
        boolean valid = true;
        int contador = 0;

        String id = idText.getText().toString();
        if (!TextUtils.isEmpty(id)) {
            contador ++;
        }
        String nom = nomText.getText().toString();
        if (!nom.equals("")) {
            contador ++;
        }
        String cognoms = cognomsText.getText().toString();
        if (!cognoms.equals("")) {
            contador ++;
        }
        String categoria = categoriaText.getText().toString();
        if (!categoria.equals("")) {
            contador ++;
        }
        String edad = edadText.getText().toString();
        if (!TextUtils.isEmpty(edad)) {
            contador ++;
            try {
                int num = Integer.parseInt(edad);
            } catch (Exception e) {
                edadText.setError("Solo números");
                valid = false;
            }
        }
        String antiguetat = antiguetatText.getText().toString();
        if (!TextUtils.isEmpty(antiguetat)) {
            contador++;
            try {
                int num = Integer.parseInt(antiguetat);
            } catch (Exception e) {
                antiguetatText.setError("Solo números");
                valid = false;
            }
        }
        if (contador != 1) return valid = false;
        else return valid;
    }
}


// Aqui solo recoge un valor de un campo
//                if (TextUtils.isEmpty(idText.getText().toString())) {
//                    if (TextUtils.isEmpty(nomText.getText().toString())) {
//                        if (TextUtils.isEmpty(cognomsText.getText().toString())) {
//                            if (TextUtils.isEmpty(categoriaText.getText().toString())) {
//                                if (TextUtils.isEmpty(edadText.getText().toString())) {
//                                    if (TextUtils.isEmpty(antiguetatText.getText().toString())) {
//                                        idText.setError("Introueix alguna dada");
//                                    } else {
//                                        busqueda[0] = antiguetatText.getText().toString();
//                                        busqueda[1] = "antiguetat";
//                                    }
//                                } else {
//                                    busqueda[0] = edadText.getText().toString();
//                                    busqueda[1] = "edad";
//                                }
//                            } else {
//                                busqueda[0] = categoriaText.getText().toString();
//                                busqueda[1] = "getCategoria";
//                            }
//                        } else {
//                            busqueda[0] = cognomsText.getText().toString();
//                            busqueda[1] = "cognoms";
//                        }
//                    } else {
//                        busqueda[0] = nomText.getText().toString();
//                        busqueda[1] = "nom";
//                    }
//                } else {
//                    busqueda[0] = idText.getText().toString();
//                    busqueda[1] = "id";
//                }

//                appViewModel.busqueda.setValue(busqueda);
//                navController.navigate(R.id.listBusquedaFragment);