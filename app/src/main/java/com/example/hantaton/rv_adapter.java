package com.example.hantaton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class rv_adapter extends RecyclerView.Adapter<rv_adapter.ViewHolder> {

    private final List<warn_schemas> warns;
    private Context ctx;

    public rv_adapter(List<warn_schemas> warns, Context ctx) {
        this.warns = warns;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public rv_adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull rv_adapter.ViewHolder holder, int position) {
        warn_schemas sch = warns.get(position);
    }

    @Override
    public int getItemCount() {
        return warns.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

}
