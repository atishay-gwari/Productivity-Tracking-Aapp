package com.example.projectaad;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    ArrayList<Event> ev;

    public MainAdapter(ArrayList<Event> events) {
        ev=events;
    }

    @NonNull
    @Override
    public MainAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.ViewHolder holder, int position) {
        holder.categ.setText("Category: "+ev.get(position).category);
        holder.desc.setText("Description: "+ev.get(position).description);
        holder.dur.setText("Duration: "+ev.get(position).duration+" hr");
    }

    @Override
    public int getItemCount() {
        return ev.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView categ;
        public TextView desc;
        public TextView dur;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            categ=itemView.findViewById(R.id.categ);
            desc=itemView.findViewById(R.id.desc);
            dur=itemView.findViewById(R.id.dur);
        }
    }
}
