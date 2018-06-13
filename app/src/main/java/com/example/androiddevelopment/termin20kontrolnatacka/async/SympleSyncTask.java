package com.example.androiddevelopment.termin20kontrolnatacka.async;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.example.androiddevelopment.termin20kontrolnatacka.fragments.MasterFragment;
import com.example.androiddevelopment.termin20kontrolnatacka.tools.ReviewerTools;

class SimpleSyncTask extends AsyncTask<Integer, Void, Integer> {

        private Context context;
        private MasterFragment.OnProductSelectedListener listener;

        public SimpleSyncTask(Context context) {
            this.context = context;
            listener = (MasterFragment.OnProductSelectedListener) context;
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
        protected Integer doInBackground(Integer... params) {
            try {
                //simulacija posla koji se obavlja u pozadini i traje duze vreme
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return params[0];
        }

        /**
         *
         * Kada se posao koji se odvija u pozadini zavrsi, poziva se ova metoda
         * Ako je potrebno osloboditi resurse ili obrisati elemente koji vise ne trebaju.
         */
        @Override
        protected void onPostExecute(Integer type) {
            //Toast.makeText(context, ReviewerTools.getConnectionType(type), Toast.LENGTH_SHORT).show();
            /**
             * Da bi poslali poruku BroadcastReceiver-u poterbno je da definisiemo Intent sa sadrzajem.
             * Definisemo intent i sa njim nasu akciju SYNC_DATA. Ovo radimo da bi BroadcastReceiver
             * znao kako da reaguje kada dobije poruku tog tipa.
             * Uz poruku mozemo vezati i neki sadrazaj RESULT_CODE u ovom slucaju.
             * Jedan BroadcastReceiver moze da prima vise poruka iz aplikacije i iz tog razloga definisanje
             * akcije je bitna stvar.
             *
             * Voditi racuna o tome da se naziv akcije kada korisnik salje Intent mora poklapati sa
             * nazivom akcije kada akciju proveravamo unutar BroadcastReceiver-a. Isto vazi i za podatke.
             * Dobra praksa je da se ovi nazivi izdvoje unutar neke staticke promenljive.
             * */
            Intent ints = new Intent("SYNC_DATA");
            ints.putExtra("RESULT_CODE", type);
            context.sendBroadcast(ints);
            String msg = "Uredjaj nije povezan na mrezu";
            switch (type){
                case ReviewerTools.TYPE_MOBILE:
                    msg = "Uredjaj je povezan preko mobilne mreze";
                    break;
                case ReviewerTools.TYPE_WIFI:
                    msg = "Uredjaj je povezan preko WIFI";
                    break;
        }

}
