package com.company.Dio.dominio;

public interface FilmeService {
    void calcularDuracaoEmHoras(String nomeFilme,Filme filme);
    void retornaHoraQueAcaba(String nomeFilme,Filme filme);

}
