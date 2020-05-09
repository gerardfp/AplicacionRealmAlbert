package com.example.aplicacionrealm.Model;

import io.realm.RealmObject;
import io.realm.annotations.Index;
import io.realm.annotations.PrimaryKey;

public class Empleat extends RealmObject {


    @PrimaryKey
    private int id;
    @Index
    private String cognoms, categoria, nom;
    private int edad, antiguetat;

    public Empleat() {
    }

    public Empleat(int id, String cognoms, String categoria, String nom, int edad, int antiguetat) {
        this.id = id;
        this.cognoms = cognoms;
        this.categoria = categoria;
        this.nom = nom;
        this.edad = edad;
        this.antiguetat = antiguetat;
    }

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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
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
