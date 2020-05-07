package com.example.aplicacionrealm;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.aplicacionrealm.Model.Empleat;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public abstract class MyFragment extends Fragment {
    public NavController navController;
    public Realm realm;
    public Empleat empleat;
    public static AtomicInteger idEmpleat = new AtomicInteger();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        realm = Realm.getDefaultInstance();
        idEmpleat = getIdEmpleat(realm, Empleat.class);
        //realm.close();
    }
    private <T extends RealmObject> AtomicInteger getIdEmpleat (Realm realm , Class<T> anyClass){
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size()>0) ? new AtomicInteger(results.max("id").intValue()) : new AtomicInteger();

    }
}
