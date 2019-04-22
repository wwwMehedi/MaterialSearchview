package com.tolet.sajib.materialsearchview.adapter;



import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tolet.sajib.materialsearchview.R;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder>{
    private List<String> countries;
    private Context context;

    public RecyclerAdapter(List<String> countries, Context context) {
        this.countries = countries;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).
                inflate(R.layout.listitem, viewGroup, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.ViewHolder viewHolder, int i) {
        String country = countries.get(i);
        viewHolder.text.setText(country);
    }

    @Override
    public int getItemCount() {
        return countries.size();
    }
    public void setCountries(List<String> countries) {
        this.countries = countries;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView text;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            text=itemView.findViewById(R.id.mytextid);
        }
    }

}
