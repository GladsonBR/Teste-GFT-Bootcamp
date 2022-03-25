package com.company.Dio.dominio;

public interface FilmeService {
    void calcularDuracaoEmHoras(int duracaoEmMinutos);
    void retornaHoraQueAcaba(String horaSessao, int duracaoMin);

}
