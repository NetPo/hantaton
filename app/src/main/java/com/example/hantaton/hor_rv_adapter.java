package com.example.hantaton;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.davemorrissey.labs.subscaleview.ImageSource;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

import java.util.List;

public class hor_rv_adapter extends RecyclerView.Adapter<hor_rv_adapter.ViewHolder>{
    private final List<Picts> pics;
    private Context ctx;

    public hor_rv_adapter(List<Picts> pics, Context ctx) {
        this.pics = pics;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_rv_layout, parent, false);
        return new hor_rv_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Picts pictures = pics.get(position);
        holder.schemview.setImage(ImageSource.resource(pictures.getImage()));
    }

    @Override
    public int getItemCount() {
        return pics.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        private final SubsamplingScaleImageView schemview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            schemview = itemView.findViewById(R.id.SchemView);
        }
    }

}
