package com.example.androiddevelopment.termin20kontrolnatacka.providers;

import com.example.androiddevelopment.termin20kontrolnatacka.model.Film;
import com.example.androiddevelopment.termin20kontrolnatacka.model.Glumac;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GlumacProvider {
    public static List<Glumac> getGlumci() {
        List<Glumac> glumci = new ArrayList<>();

        glumci.add(new Glumac(1,"Dragan", "Nikolic", "biografija", "dragan.jpg", 10, new Date(1950, 12, 05), new Date(1950, 12, 05), FilmProvider.getFilmovi()));
        glumci.add(new Glumac(2, "Petar", "Nikolic", "biografija 1", "dragan.jpg", 10, new Date(1950, 12, 05), new Date(1950, 12, 05), FilmProvider.getFilmovi()));
        glumci.add(new Glumac(3, "Djole", "Nikolic", "biografija 2", "dragan.jpg", 10, new Date(1950, 12, 05), new Date(1950, 12, 05), FilmProvider.getFilmovi()));
        return  glumci;
    }

    public static List<String> getGlumacNames() {

        List<String> names = new ArrayList<>();
        names.add("Dragan");
        names.add("Petar");
        names.add("Djole");
        return names;
    }

    public static Glumac getGlumacById(int id) {

        switch (id) {
            case 1:
                return new Glumac(1, "Dragan", "Nikolic", "biografija", "dragan.jpg", 10, new Date(1950, 12, 05), new Date(1950, 12, 05), FilmProvider.getFilmovi());
            case 2:
                return new Glumac(2, "Petar", "Nikolic", "biografija 1", "dragan.jpg", 10, new Date(1950, 12, 05), new Date(1950, 12, 05), FilmProvider.getFilmovi());
            case 3:
                return new Glumac(3,"Djole", "Nikolic", "biografija 2", "dragan.jpg", 10, new Date(1950, 12, 05), new Date(1950, 12, 05), FilmProvider.getFilmovi());
            default:
                return null;
        }
    }
}
