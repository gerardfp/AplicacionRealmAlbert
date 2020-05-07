package com.example.aplicacionrealm;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicacionrealm.Model.Empleat;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertarFragment extends MyFragment {

    private EditText idEditText, nomEditText, cognomsEditText, categoriaEditText, edadEditText, antiguetatEditText;
    private Button btnInsertar;
    public InsertarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_insertar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        idEditText = view.findViewById(R.id.idEditText);
        nomEditText = view.findViewById(R.id.nomEditText);
        cognomsEditText = view.findViewById(R.id.cognomsEditText);
        categoriaEditText = view.findViewById(R.id.categoriaEditText);
        edadEditText = view.findViewById(R.id.edadEditText);
        antiguetatEditText = view.findViewById(R.id.antiguetatEditText);
        btnInsertar = view.findViewById(R.id.btnInsertar);

        btnInsertar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!validateForm()){
                    Toast toast1 =
                            Toast.makeText(requireActivity(),
                                    "Faltan datos por introducir !", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER | Gravity.LEFT, 250, 0);
                    toast1.show();
                    return;
                }

                writerDades();
                System.out.println(" empleat registart: .............................................................");
                navController.navigate(R.id.homeFragment);
            }
        });
        System.out.println("dades inseridas ....................................sssssssssssssssssssss..................");
    }

    private void writerDades() {
        empleat = new Empleat();

        empleat.setId(Integer.parseInt(idEditText.getText().toString()));
        empleat.setNom(nomEditText.getText().toString());
        empleat.setCognoms(cognomsEditText.getText().toString());
        empleat.setGetCategoria(categoriaEditText.getText().toString());
        empleat.setEdad(Integer.parseInt(edadEditText.getText().toString()));
        empleat.setAntiguetat(Integer.parseInt(antiguetatEditText.getText().toString()));

        realm.beginTransaction();
        ;
        Empleat registrarEmpleat = realm.copyToRealmOrUpdate(empleat);
        realm.commitTransaction();
        System.out.println("ssssssssssssss...................... " + registrarEmpleat.toString());
    }

    private boolean validateForm() {
        boolean valid = true;

        String id = idEditText.getText().toString();
        if (TextUtils.isEmpty(id)) {
            idEditText.setError("Required.");
            valid = false;
        }
        String nom = nomEditText.getText().toString();
        if (TextUtils.isEmpty(nom)) {
            nomEditText.setError("Required.");
            valid = false;
        }
        String cognoms = cognomsEditText.getText().toString();
        if (TextUtils.isEmpty(cognoms)) {
            cognomsEditText.setError("Required.");
            valid = false;
        }
        String categoria = categoriaEditText.getText().toString();
        if (TextUtils.isEmpty(categoria)) {
            categoriaEditText.setError("Required.");
            valid = false;
        }
        String edad = edadEditText.getText().toString();
        if (TextUtils.isEmpty(edad)) {
            edadEditText.setError("Required.");
            valid = false;
        }
        String antiguetat = antiguetatEditText.getText().toString();
        if (TextUtils.isEmpty(antiguetat)) {
            antiguetatEditText.setError("Required.");
            valid = false;
        }
        return valid;
    }
}
