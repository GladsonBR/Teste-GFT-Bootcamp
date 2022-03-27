package com.company.Dio.dominio;


import java.util.ArrayList;
import java.util.List;


public class Cinema {

    private String nome;
    private String endereco;
    private List<Filme> filmesEmCar= new ArrayList<>();

    public Cinema() {
    }

    public Cinema(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;

    }

    @Override
    public String toString() {
        return "Cinema{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", filmesEmCar=" + filmesEmCar +
                '}';
    }



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }



    public List<Filme> getFilmesEmCar() {
        return filmesEmCar;
    }

    public void setFilmesEmCar(List<Filme> filmesEmCar) {
        this.filmesEmCar = filmesEmCar;
    }



    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }






}
