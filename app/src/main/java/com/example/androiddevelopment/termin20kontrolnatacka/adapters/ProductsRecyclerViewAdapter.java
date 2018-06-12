package com.example.androiddevelopment.termin20kontrolnatacka.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddevelopment.termin20kontrolnatacka.R;
import com.example.androiddevelopment.termin20kontrolnatacka.model.Glumac;

import java.util.List;

public class ProductsRecyclerViewAdapter extends RecyclerView.Adapter<ProductsRecyclerViewAdapter.ViewHolder> {

    private List<Glumac> glumci;
    private OnProductClickedListener listener;

    public ProductsRecyclerViewAdapter(List<Glumac> productList, OnProductClickedListener listener){
        glumci = productList;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View tv = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(tv);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final int productId = glumci.get(position).getId();
        holder.tvIme.setText(glumci.get(position).getIme() + " " + glumci.get(position).getPrezime());
        holder.tvIme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onProductClicked(productId);
            }
        });
    }


    @Override
    public int getItemCount() {
        return glumci.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvIme;
        ViewHolder(View itemView) {
            super(itemView);
            tvIme = (TextView) itemView.findViewById(R.id.tvIme);
        }
    }

    public interface OnProductClickedListener{
        void onProductClicked(int id);
    }
}
