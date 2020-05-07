//package com.example.aplicacionrealm;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ListAdapter;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.annotation.Nullable;
//import androidx.fragment.app.Fragment;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.aplicacionrealm.Model.Empleat;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import io.realm.OrderedRealmCollection;
//import io.realm.Realm;
//import io.realm.RealmBaseAdapter;
//import io.realm.RealmResults;
//
//
///**
// * A simple {@link Fragment} subclass.
// */
//public class Empleat_List extends MyFragment {
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return super.onCreateView(inflater, container, savedInstanceState);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        RealmResults<Empleat> listEmpleat = realm.where(Empleat.class)
//                .sort("id")
//                .findAllAsync();
//
//    }
//}
