package com.company.Dio.FilmesEmCartaz;

import java.util.List;

public class CinemaImplService implements CinemaService {
    Cinema cinema = new Cinema();
    FilmeImplService filmeImplService = new FilmeImplService();
    Filme filme;


    @Override
    public void adicionarFilme(String tituloF, String horarioSessao, Enum generoFilme, int duracaoEmMinutos) {

        filme = new Filme(tituloF, generoFilme, duracaoEmMinutos, horarioSessao);

        cinema.getFilmesEmCar().add(filme);

        List<Filme> filmesCartaz = cinema.getFilmesEmCar();
        for (Filme l: filmesCartaz) {
           System.out.println(l);
        }

    }

    @Override
    public void removerFilme(String id) {
        List<Filme> cinemaRemovido = cinema.getFilmesEmCar();
        cinemaRemovido.removeIf(cinemaRemov -> cinemaRemov.getTitulo().equalsIgnoreCase(id));

        for (Filme lista : cinema.getFilmesEmCar()) {
            System.out.println(lista);
        }
    }

}