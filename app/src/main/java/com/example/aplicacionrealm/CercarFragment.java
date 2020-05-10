package com.example.aplicacionrealm;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.aplicacionrealm.Model.Empleat;


public class CercarFragment extends MyFragment {
    Button  btCercar;
    EditText id, nom, cognoms, categoria, edad, antiguetat;

    public CercarFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
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
                if (!validateForm()){
                    Toast toast1 =
                            Toast.makeText(requireActivity(),
                                    "Faltan datos por introducir !", Toast.LENGTH_SHORT);
                    toast1.setGravity(Gravity.CENTER | Gravity.LEFT, 250, 0);
                    toast1.show();
                    return;
                }

                appViewModel.empleatAModifcarOBuscar.setValue(new Empleat(
                        id.getText().toString().isEmpty() ? -1 : Integer.parseInt(id.getText().toString()),
                        cognoms.getText().toString(),
                        categoria.getText().toString(),
                        nom.getText().toString(),
                        edad.getText().toString().isEmpty() ? -1 : Integer.parseInt(edad.getText().toString()),
                        antiguetat.getText().toString().isEmpty() ? -1 : Integer.parseInt(antiguetat.getText().toString())));

                navController.navigate(R.id.empleatListFragment);
            }
        });
    }
    private boolean validateForm() {
        boolean valid = true;

        String idt = id.getText().toString();
        if (!TextUtils.isEmpty(idt) ) {
            try{
                int num = Integer.parseInt(idt);
            }catch (Exception e){
                edad.setError("Solo números");
                valid = false;
            }
        }

        String edadt = edad.getText().toString();
        if (!TextUtils.isEmpty(edadt) ) {
            try{
                int num = Integer.parseInt(edadt);
            }catch (Exception e){
                edad.setError("Solo números");
                valid = false;
            }
        }
        String antiguetatt = antiguetat.getText().toString();
        if (!TextUtils.isEmpty(antiguetatt)) {
            try{
                int num = Integer.parseInt(antiguetatt);
            }catch (Exception e){
                antiguetat.setError("Solo números");
                valid = false;
            }
        }
        return valid;
    }
}