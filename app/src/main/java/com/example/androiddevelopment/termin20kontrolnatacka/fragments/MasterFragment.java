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
import com.example.androiddevelopment.termin20kontrolnatacka.adapters.ProductsRecyclerViewAdapter;
import com.example.androiddevelopment.termin20kontrolnatacka.model.Glumac;
import com.example.androiddevelopment.termin20kontrolnatacka.providers.GlumacProvider;

import java.util.List;

    public class MasterFragment extends Fragment implements ProductsRecyclerViewAdapter.OnProductClickedListener {

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
            rvProducts = (RecyclerView) getView().findViewById(R.id.listaGlumaca);
            new GetProductsAsyncTask().execute();
        }

        private void setupProductList(List<Glumac> glumci ) {
            rvProducts.setLayoutManager(new LinearLayoutManager(getActivity()));
            ProductsRecyclerViewAdapter adapter = new ProductsRecyclerViewAdapter(glumci, this);
            rvProducts.setAdapter(adapter);
        }

        // onCreateView method is a life-cycle method that is called to have the fragment instantiate its user interface view.
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Shows a toast message (a pop-up message)
            Toast.makeText(getActivity(), "MasterFragment.onCreateView()", Toast.LENGTH_SHORT).show();

            if (container == null) {
                return null;
            }

            // Inflate fragment's layout
            return inflater.inflate(R.layout.master_fragment, container, false);
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);

            try {
                listener = (OnProductSelectedListener) activity;
            } catch (ClassCastException e) {
                throw new ClassCastException(activity.toString() + " must implement OnProductSelectedListener");
            }
        }

        @Override
        public void onProductClicked(int id) {
            if (listener != null){
                listener.onProductSelected(id);
            }
        }

        public class GetProductsAsyncTask extends AsyncTask<Void, Void, List<Glumac>> {

            ProgressDialog progressDialog;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                progressDialog = new ProgressDialog(MasterFragment.this.getActivity());
                progressDialog.setMessage("Loading glumci...");
                progressDialog.show();
            }

            @Override
            protected List<Glumac> doInBackground(Void... voids) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e){
                    e.printStackTrace();
                    return null;
                }
                return GlumacProvider.getGlumci();
            }

            @Override
            protected void onPostExecute(List<Glumac> glumci) {
                super.onPostExecute(glumci);
                if (progressDialog != null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                setupProductList(glumci);
            }
        }
    }
