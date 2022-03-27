package com.company.Dio.dominio;


import java.util.List;

public interface CinemaService {


    void adicionarFilme(String tituloF, String horarioSessao, Enum generoFilme, int duracaoEmMinutos);

    void removerFilme(String id);






}
