package com.example.hantaton;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        holder.courseIV.setImageResource(sch.getImage());
        holder.courseNameTV.setText(sch.getName());
        holder.courseRatingTV.setText(sch.getRisks());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ctx, MapActivity.class);
                ctx.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return warns.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ClipData.Item currentItem;

        private final ImageView courseIV;
        private final TextView courseNameTV;
        private final TextView courseRatingTV;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            courseIV = itemView.findViewById(R.id.idIVCourseImage);
            courseNameTV = itemView.findViewById(R.id.idTVCourseName);
            courseRatingTV = itemView.findViewById(R.id.idTVCourseRating);

        }
    }

}
