package com.example.aplicacionrealm;

import android.content.ClipData;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.aplicacionrealm.Model.Empleat;

import java.util.HashSet;
import java.util.Set;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmBaseAdapter;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class Empleat_List_Fragment extends RealmBaseAdapter<Empleat> implements ListAdapter {
    private Realm realm;
    private boolean inDeletionMode = false;
    private Set<Integer> countersToDelete = new HashSet<Integer>();

    Empleat_List_Fragment(OrderedRealmCollection<Empleat> realmResults) {
        super(realmResults);
    }

    void enableDeletionMode(boolean enabled) {
        inDeletionMode = enabled;
        if (!enabled) {
            countersToDelete.clear();
        }
        notifyDataSetChanged();
    }

    Set<Integer> getCountersToDelete() {
        return countersToDelete;
    }


    @Override
    public View getView(int position, final View view, ViewGroup parent) {
        MyViewHolder viewHolder  = new MyViewHolder(view);;
        realm = Realm.getDefaultInstance();
        RealmResults<Empleat> listEmpleat = realm.where(Empleat.class)
                .sort("id")
                .findAllAsync();

        viewHolder.id.setText(listEmpleat.get(position).getId());
        viewHolder.nom.setText(listEmpleat.get(position).getNom());
        viewHolder.cognoms.setText(listEmpleat.get(position).getCognoms());
        viewHolder.categoria.setText(listEmpleat.get(position).getGetCategoria());
        viewHolder.edad.setText(listEmpleat.get(position).getEdad());
        viewHolder.antiguetat.setText(listEmpleat.get(position).getAntiguetat());

        return view;
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
    TextView id, nom, cognoms, categoria, edad, antiguetat;

        public MyViewHolder(@NonNull View view) {
            super(view);
            id = view.findViewById(R.id.idText);
            nom = view.findViewById(R.id.nomText);
            cognoms = view.findViewById(R.id.cognomsText);
            categoria = view.findViewById(R.id.categoriaText);
            edad = view.findViewById(R.id.edadText);
            antiguetat = view.findViewById(R.id.antiguetatText);
        }
    }
}
