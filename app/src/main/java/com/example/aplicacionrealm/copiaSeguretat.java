package com.example.aplicacionrealm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.aplicacionrealm.Model.Empleat;

import java.util.HashSet;
import java.util.Set;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;


/**
 * A simple {@link Fragment} subclass.
 */
public class copiaSeguretat extends MyFragment {
    private boolean inDeletionMode = false;
    private Set<Integer> countersToDelete = new HashSet<>();
    private Realm realm;

    public copiaSeguretat() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empleat_list, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView empleatsRecyclerView = view.findViewById(R.id.itemList);
        realm = Realm.getDefaultInstance();
        RealmResults<Empleat> listEmpleat = realm.where(Empleat.class)
                .sort("id")
                .findAllAsync();
        empleatsRecyclerView.setAdapter(new EmpleatAdapter(listEmpleat, false));
    }

    public class EmpleatAdapter extends RealmRecyclerViewAdapter<Empleat, EmpleatAdapter.MyViewHolder> {
        public EmpleatAdapter(@Nullable OrderedRealmCollection<Empleat> data, boolean autoUpdate) {
            super(data, autoUpdate);
        }
        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_empleats, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

            RealmResults<Empleat> listEmpleat = realm.where(Empleat.class)
                    .sort("id")
                    .findAllAsync();

            holder.id.setText(listEmpleat.get(position).getId());
            holder.nom.setText(listEmpleat.get(position).getNom());
            holder.cognoms.setText(listEmpleat.get(position).getCognoms());
            holder.categoria.setText(listEmpleat.get(position).getGetCategoria());
            holder.edad.setText(listEmpleat.get(position).getEdad());
            holder.antiguetat.setText(listEmpleat.get(position).getAntiguetat());
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
}
