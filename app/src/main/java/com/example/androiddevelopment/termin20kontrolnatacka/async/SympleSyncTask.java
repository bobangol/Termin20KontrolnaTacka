package com.example.androiddevelopment.termin20kontrolnatacka.async;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.androiddevelopment.termin20kontrolnatacka.fragments.MasterFragment;

public class SympleSyncTask {
    public class SimpleSyncTask extends AsyncTask<Void, Void, Void> {

        private Activity activity;
        private MasterFragment.OnProductSelectedListener listener;

        public SimpleSyncTask(Activity activity) {
            this.activity = activity;
            listener = (MasterFragment.OnProductSelectedListener) activity;
        }

        /**
         * Metoda se poziva pre samog starta pozadinskog zadatka
         * Sve pripreme odraditi u ovoj metodi, ako ih ima.
         */
        @Override
        protected void onPreExecute() {
        }

        /**
         * Posao koji se odvija u pozadini, ne blokira glavnu nit aplikacije.
         * Sav posao koji dugo traje izvrsavati unutar ove metode.
         */
        @Override
        protected Void doInBackground(Void... params) {
            try {
                //simulacija posla koji se obavlja u pozadini i traje duze vreme
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return null;
        }

        /**
         *
         * Kada se posao koji se odvija u pozadini zavrsi, poziva se ova metoda
         * Ako je potrebno osloboditi resurse ili obrisati elemente koji vise ne trebaju.
         */
        @Override
        protected void onPostExecute(Void products) {
            Toast.makeText(activity, "Sync done", Toast.LENGTH_SHORT).show();
        }
    }

}
