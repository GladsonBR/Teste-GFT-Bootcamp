package com.company.Dio.dominio;


import java.util.ArrayList;
import java.util.List;

public class Filme {

    private String titulo;
    private Enum genero;
    private int duracaoEmMinutos;
    String horarioSessao;


    public Filme(String titulo, Enum genero, int duracaoEmMinutos, String horarioSessao) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracaoEmMinutos = duracaoEmMinutos;
        this.horarioSessao = horarioSessao;

    }

    public Filme() {

    }


    public Enum getGenero() {
        return genero;
    }

    public void setGenero(Enum genero) {
        this.genero = genero;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public String getHorarioSessao() {
        return horarioSessao;
    }

    public void setHorarioSessao(String horarioSessao) {
        this.horarioSessao = horarioSessao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return  "Nome do Filme='" + titulo + '\'' +
                ", Genero=" + genero +
                ", duracaoEmMinutos=" + duracaoEmMinutos +
                ", horarioSessao='" + horarioSessao + '\'';
    }
}
