package com.example.aplicacionrealm.Model;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Empleat extends RealmObject {

    @PrimaryKey
    private int id;
    @Index
    private String cognoms, getCategoria, nom;
    private int edad, antiguetat;

    public String getCountString() {
        return Integer.toString(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognoms() {
        return cognoms;
    }

    public void setCognoms(String cognoms) {
        this.cognoms = cognoms;
    }

    public String getGetCategoria() {
        return getCategoria;
    }

    public void setGetCategoria(String getCategoria) {
        this.getCategoria = getCategoria;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getAntiguetat() {
        return antiguetat;
    }

    public void setAntiguetat(int antiguetat) {
        this.antiguetat = antiguetat;
    }
}
