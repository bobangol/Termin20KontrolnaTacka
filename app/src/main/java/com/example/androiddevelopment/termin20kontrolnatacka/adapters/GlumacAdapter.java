package com.example.androiddevelopment.termin20kontrolnatacka.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.androiddevelopment.termin20kontrolnatacka.R;
import com.example.androiddevelopment.termin20kontrolnatacka.fragments.MasterFragment;
import com.example.androiddevelopment.termin20kontrolnatacka.model.Glumac;

import java.util.List;

public class GlumacAdapter extends RecyclerView.Adapter<GlumacAdapter.ViewHolder> {
        private List<Glumac> glumci;
        private MasterFragment.OnProductSelectedListener listener;

        public GlumacAdapter(List<Glumac> glumci, MasterFragment.OnProductSelectedListener listener) {
            this.glumci = glumci;
            this.listener = listener;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.cardview_glumac, parent, false);

            ViewHolder vh = new ViewHolder(v);
            return vh;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, final int position) {
            final int pos = position;
            holder.textView.setText(glumci.get(position).getIme() + " " + glumci.get(position).getPrezime());
            holder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onProductSelected(position);
                }
            });
        }

        @Override
        public int getItemCount() {
            return glumci.size();
        }



        public static class ViewHolder extends RecyclerView.ViewHolder {
            public TextView textView;

            public ViewHolder(View v) {
                super(v);
                textView = (TextView) v.findViewById(R.id.text);
            }
        }

    public interface OnProductClickedListener{
        void onProductClicked(int id);
    }
}


