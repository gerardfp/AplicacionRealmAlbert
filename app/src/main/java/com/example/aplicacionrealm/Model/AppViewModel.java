package com.example.aplicacionrealm.Model;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class AppViewModel extends AndroidViewModel {
    public AppViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Boolean> modificar = new MutableLiveData<>(false);
    public MutableLiveData<Integer> idSeleccion = new MutableLiveData<>();
    public MutableLiveData<String> dato = new MutableLiveData<>();
}
