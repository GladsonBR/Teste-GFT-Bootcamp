package com.company.Dio;

import com.company.Dio.dominio.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CinemaService cinemaMetodos = new CinemaImplService();
        Cinema cinema = new Cinema();
        FilmeService filmeMetodos = new FilmeImplService();
        Filme filme = new Filme();
        List<Filme> dadosFilme = new ArrayList<>();


        Scanner ler = new Scanner(System.in);
        int opt;
        cinema.setNome("GF Cinema");
        cinema.setEndereco("Rua Carlos Alberto 1254");

        Filme filme1 = new Filme();
        filme1.setTitulo("Sexto Sentido");
        filme1.setGenero(GeneroTipo.TERROR);
        filme1.setHorarioSessao("7:30");
        filme1.setDuracaoEmMinutos(120);
        int i=1;

        Filme filme2 = new Filme();
        filme2.setTitulo("Blade");
        filme2.setGenero(GeneroTipo.ACAO);
        filme2.setHorarioSessao("8:30");
        filme2.setDuracaoEmMinutos(120);
        i++;

        Filme filme3 = new Filme();
        filme3.setTitulo("Vingadores");
        filme3.setGenero(GeneroTipo.ACAO);
        filme3.setHorarioSessao("8:45");
        filme3.setDuracaoEmMinutos(150);
        i++;

        cinemaMetodos.adicionarFilme(filme1, i);
        cinemaMetodos.adicionarFilme(filme2, i);
        cinemaMetodos.adicionarFilme(filme3, i);


        do {

            System.out.println("...Filme  Adicionados automaticamente \n Digite a opção desejada:\n2_Remover filme\n3_Calcular Duração\n4_retornar Hora de encerramento da sessão\n6_Sair\n");
            opt = ler.nextInt();

            switch (opt) {
                case 2:
                    System.out.println("Digite o nome do filme para deletar: ");
                    String titulo = ler.next();
                    System.out.println("Deseja mesmo remover o filme? Digite 'S' para sim e 'N' para não");
                    if (ler.next().equalsIgnoreCase("S"))
                        cinemaMetodos.removerFilme(titulo);

                    else {
                        System.out.println("Filme não deletado");
                    }
                    break;
                case 3:

                    System.out.println(filme);
                    System.out.println("Digite o nome do filme para calcular duração");
                    String nome = ler.next();
                    int duracaoSessao = 0;


                    if (filme1.getTitulo().equalsIgnoreCase(nome)) {
                        duracaoSessao = filme1.getDuracaoEmMinutos();

                    } else if (filme2.getTitulo().equalsIgnoreCase(nome)){
                        duracaoSessao = filme2.getDuracaoEmMinutos();
                    }else if(filme3.getTitulo().equalsIgnoreCase(nome)){
                        duracaoSessao = filme3.getDuracaoEmMinutos();
                    }

                    filmeMetodos.calcularDuracaoEmHoras(duracaoSessao);
                    break;
                case 4:
                    System.out.println("Digite o nome do filme para saber horario que terminara o filme");
                    String nomeFil = ler.next();
                    String horaSecao="";
                    int duracao = 0;

                    if (filme1.getTitulo().equalsIgnoreCase(nomeFil)) {
                        horaSecao = filme1.getHorarioSessao();
                        duracao = filme1.getDuracaoEmMinutos();

                    } else if (filme2.getTitulo().equalsIgnoreCase(nomeFil)){
                        horaSecao = filme2.getHorarioSessao();
                        duracao = filme2.getDuracaoEmMinutos();
                    }else if(filme3.getTitulo().equalsIgnoreCase(nomeFil)){
                        horaSecao = filme3.getHorarioSessao();
                        duracao = filme3.getDuracaoEmMinutos();
                    }

                    filmeMetodos.retornaHoraQueAcaba(horaSecao, duracao);
                    break;
                case 5:
                    int qtnDados = cinemaMetodos.tamanhoArray();
                    System.out.printf("O numero de dados são %d", qtnDados);
            }
            System.out.println("\nDigite exit para Sair");
        } while (opt != 6);
    }

}
