package com.example.androiddevelopment.termin20kontrolnatacka.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.androiddevelopment.termin20kontrolnatacka.R;
import com.example.androiddevelopment.termin20kontrolnatacka.adapters.GlumacAdapter;
import com.example.androiddevelopment.termin20kontrolnatacka.model.Glumac;
import com.example.androiddevelopment.termin20kontrolnatacka.providers.GlumacProvider;

import java.util.List;

    public class MasterFragment extends Fragment{

        public interface OnProductSelectedListener {
            void onProductSelected(int id);
        }

        OnProductSelectedListener listener;
        RecyclerView rvProducts;

        // onCreate method is a life-cycle method that is called when creating the fragment.
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
 //           rvProducts = (RecyclerView) getView().findViewById(R.id.listaGlumaca);
 //           new GetProductsAsyncTask().execute();
        }

        private void setupProductList(List<Glumac> glumci ) {
            rvProducts.setLayoutManager(new LinearLayoutManager(getActivity()));
            GlumacAdapter adapter = new GlumacAdapter(glumci, (OnProductSelectedListener) this);
            rvProducts.setAdapter(adapter);
        }

        // onCreateView method is a life-cycle method that is called to have the fragment instantiate its user interface view.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if (container == null) {
                return null;
            }

            View view = inflater.inflate(R.layout.master_fragment, container, false);
            return view;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

   //         try {
    //            listener = (OnProductSelectedListener) activity;
   //         } catch (ClassCastException e) {
   //             throw new ClassCastException(activity.toString() + " must implement OnProductSelectedListener");
   //         }
        }

    }
