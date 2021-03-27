package com.example.dz1tp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class NumbersAdapter extends RecyclerView.Adapter<NumbersVH> {
    List<ModelNumber> data=Data.getInstance().get();

    @NonNull
    @Override
    public NumbersVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_item, parent, false);
        return new NumbersVH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NumbersVH holder, int position) {
        ModelNumber model = data.get(position);
        holder.bind(model);
}

    @Override
    public int getItemCount() {
        return data.size();
    }



}
