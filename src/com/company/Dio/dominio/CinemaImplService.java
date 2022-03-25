package com.company.Dio.dominio;

import java.util.ArrayList;
import java.util.List;

public class CinemaImplService implements CinemaService {
    Cinema cinema = new Cinema();
    FilmeImplService filmeImplService = new FilmeImplService();


    int i=0;
    @Override
    public void adicionarFilme(Filme filme,int i) {
       cinema.getFilmesEmCar().add(filme);

         if(cinema.getFilmesEmCar().size()==i) {
             for (Filme lista:cinema.getFilmesEmCar()) {
                 System.out.println(lista);
             }

        }

    }

    @Override
    public void removerFilme(String id) {
        List<Filme> cinemaRemovido = cinema.getFilmesEmCar();
        cinemaRemovido.removeIf(cinemaRemov -> cinemaRemov.getTitulo().equalsIgnoreCase(id));

        for (Filme lista:cinema.getFilmesEmCar()) {
            System.out.println(lista);              
        }                                              
    }

    public int tamanhoArray(){
        return cinema.getFilmesEmCar().size();
    }
}
