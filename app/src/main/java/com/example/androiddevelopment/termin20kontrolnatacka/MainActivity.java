package com.example.androiddevelopment.termin20kontrolnatacka;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.androiddevelopment.termin20kontrolnatacka.fragments.DetailFragment;
import com.example.androiddevelopment.termin20kontrolnatacka.fragments.MasterFragment;

public class MainActivity extends AppCompatActivity implements MasterFragment.OnProductSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // If the activity is started for the first time create master fragment
        if (savedInstanceState == null) {
            // FragmentTransaction is a set of changes (e.g. adding, removing and replacing fragments) that you want to perform at the same time.
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MasterFragment masterFragment = new MasterFragment();
            ft.add(R.id.master_view, masterFragment, "Master_Fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }



    }

    @Override
    public void onProductSelected(int position) {
        DetailFragment detailFragment = new DetailFragment();
        detailFragment.setContent(position);
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.master_view, detailFragment, "Detail_Fragment_2");
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
    }


}
