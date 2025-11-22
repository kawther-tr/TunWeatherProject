package com.example.tunweather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import java.util.List;
public class TempHumAdapter extends  RecyclerView.Adapter<TempHumAdapter.itemViewHolder> {
    List<temphum> datalist;
    Context context;

    public TempHumAdapter(Context context, List<temphum> list) {
        this.context = context;
        this.datalist = list;
    }

    @NonNull
    @Override
    public TempHumAdapter.itemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate((R.layout.recyclerview), parent, false);
        itemViewHolder itemViewHolder = new itemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TempHumAdapter.itemViewHolder holder, final int position) {
        final temphum data = datalist.get(position);
        holder.temp.setText((int) data.getTemp());
        holder.date.setText(data.getDate());
        holder.hum.setText((int) data.getHum());

    }

    public int getItemCount() {
        return datalist.size();
    }

    public static class itemViewHolder extends RecyclerView.ViewHolder {
        TextView temp,hum,date;

        public itemViewHolder(View itemView) {
            super(itemView);
            temp= itemView.findViewById(R.id.temp);
            date = itemView.findViewById(R.id.date);
            hum = itemView.findViewById(R.id.hum);
        }
    }
}
