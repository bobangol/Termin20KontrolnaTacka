package com.example.androiddevelopment.termin20kontrolnatacka.providers;

import com.example.androiddevelopment.termin20kontrolnatacka.model.Film;

import java.util.ArrayList;
import java.util.List;

public class FilmProvider {

    public static List<Film> getFilmovi() {
        List<Film> filmovi = new ArrayList<>();

        filmovi.add(new Film(0, "F1"));
        filmovi.add(new Film(1, "F2"));
        filmovi.add(new Film(2, "F3"));
        filmovi.add(new Film(3, "F4"));
        return filmovi;
        }

    public static List<String> getFilmsNames() {

        List<String> names = new ArrayList<>();
        names.add("F1");
        names.add("F2");
        names.add("F3");
        names.add("F4");
        return names;
    }

    public static Film getFilmById(int id) {

        switch (id) {
            case 0:
                return new Film(0, "F1");
            case 1:
                return new Film(1, "F2");
            case 2:
                return new Film(2, "F3");
            case 3:
                return new Film(2, "F3");
            default:
                return null;
        }
    }
}
