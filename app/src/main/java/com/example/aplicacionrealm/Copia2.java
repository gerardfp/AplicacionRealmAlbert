//package com.example.aplicacionrealm;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import android.widget.TextView;
//
//import java.util.HashSet;
//import java.util.Set;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.aplicacionrealm.Model.Empleat;
//
//import io.realm.OrderedRealmCollection;
//import io.realm.RealmRecyclerViewAdapter;
//
//
//class Copia2 extends RealmRecyclerViewAdapter<Empleat, Copia2.MyViewHolder> {
//
//    private boolean inDeletionMode = false;
//    private Set<Integer> countersToDelete = new HashSet<>();
//
//    Copia2(OrderedRealmCollection<Empleat> data) {
//        super(data, true);
//        // Only set this if the model class has a primary key that is also a integer or long.
//        // In that case, {@code getItemId(int)} must also be overridden to return the key.
//        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#hasStableIds()
//        // See https://developer.android.com/reference/android/support/v7/widget/RecyclerView.Adapter.html#getItemId(int)
//        setHasStableIds(true);
//    }
//
//    void enableDeletionMode(boolean enabled) {
//        inDeletionMode = enabled;
//        if (!enabled) {
//            countersToDelete.clear();
//        }
//        notifyDataSetChanged();
//    }
//
//    Set<Integer> getCountersToDelete() {
//        return countersToDelete;
//    }
//
//    @Override
//    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_empleat_list, parent, false);
//        return new MyViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(MyViewHolder holder, int position) {
//        final Empleat obj = getItem(position);
//        holder.empleat = obj;
//        final int itemId = obj.getId();
//        //noinspection ConstantConditions
//        holder.id.setText(obj.getId());
//        holder.nom.setText(obj.getNom());
//        holder.cognoms.setText(obj.getCognoms());
//        holder.categoria.setText(obj.getGetCategoria());
//        holder.edad.setText(obj.getEdad());
//        holder.antiguetat.setText(obj.getAntiguetat());
//
//        //holder.deletedCheckBox.setChecked(countersToDelete.contains(itemId));
////        if (inDeletionMode) {
////            holder.deletedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
////                @Override
////                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
////                    if (isChecked) {
////                        countersToDelete.add(itemId);
////                    } else {
////                        countersToDelete.remove(itemId);
////                    }
////                }
////            });
////        } else {
////            holder.deletedCheckBox.setOnCheckedChangeListener(null);
////        }
//       // holder.deletedCheckBox.setVisibility(inDeletionMode ? View.VISIBLE : View.GONE);
//    }
//
//    @Override
//    public long getItemId(int index) {
//        //noinspection ConstantConditions
//        return getItem(index).getId();
//    }
//
//    class MyViewHolder extends RecyclerView.ViewHolder {
//        TextView id, nom, cognoms, categoria, edad, antiguetat;
//        public Empleat empleat;
//        public MyViewHolder(@NonNull View view) {
//            super(view);
//            id = view.findViewById(R.id.idText);
//            nom = view.findViewById(R.id.nomText);
//            cognoms = view.findViewById(R.id.cognomsText);
//            categoria = view.findViewById(R.id.categoriaText);
//            edad = view.findViewById(R.id.edadText);
//            antiguetat = view.findViewById(R.id.antiguetatText);
//        }
//    }
//}