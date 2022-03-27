package com.company.Dio;

import com.company.Dio.dominio.*;

import java.awt.*;
import java.util.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        CinemaService cinemaMetodos = new CinemaImplService();
        Cinema cinema = new Cinema();
        FilmeService filmeMetodos = new FilmeImplService();
        Filme filme = new Filme();

        int opt=0;
        Scanner ler = new Scanner(System.in);
        Scanner lerStr = new Scanner(System.in);

        String tituloF = "";
        String horarioSessao="" , genero="";
        Enum generoFilme = null;
        int duracaoEmMinutos=0;
        int i=0;
        Enum Generos;


        String nomeCin = "GFT Filmes";
        String enderecoCin = "Av Carlos Antonio 2415 Pumpalha";
        cinema = new Cinema(nomeCin, enderecoCin);
        System.out.println(cinema);
        do {

            try {
                System.out.println(" ================== ");
                System.out.println("Voce deseja adicionar um Filme? tecle 'S' para SIM e 'N' para Não");
                String optStr = lerStr.nextLine();
                if (optStr.equalsIgnoreCase("S")){


                    try {
                        System.out.println("Digite o nome do Filme");
                        tituloF = lerStr.nextLine();
                        System.out.println("Digite o horario da Sessão");
                        horarioSessao = lerStr.nextLine();
                        System.out.println("Digite a duração em minutos");
                        duracaoEmMinutos = ler.nextInt();
                        System.out.println("Digite o Gênero do Filmes: \n Terror \nRomance \nAção \nComedia");

                        genero = lerStr.nextLine();
                        if (genero.equalsIgnoreCase("Terror")) {
                            generoFilme = GeneroTipo.TERROR;
                        } else if (genero.equalsIgnoreCase("Romance")) {
                            generoFilme = GeneroTipo.ROMANCE;
                        } else if (genero.equalsIgnoreCase("Ação")) {
                            generoFilme = GeneroTipo.ACAO;
                        } else if (genero.equalsIgnoreCase("Comédia")) {
                            generoFilme = GeneroTipo.COMEDIA;
                        }

                        cinemaMetodos.adicionarFilme(tituloF, horarioSessao, generoFilme, duracaoEmMinutos);
                        i++;

                    } catch (NullPointerException e) {
                        System.out.println("Digite dados válidos");

                    }

                }else {
                    System.out.println("Digite a opção desejada:\n 1_Remover filme"+
                            " \n2_Calcular Duração\n3_retornar Hora de encerramento da sessão\n" +
                            "4_Sair\n");


                    opt = ler.nextInt();

                    switch (opt) {
                        case 1:
                            System.out.println("Digite o nome do filme para deletar: ");
                            String tituloFl = ler.next();
                            System.out.println("Deseja mesmo remover o filme? Digite 'S' para sim e 'N' para não");
                            if (ler.next().equalsIgnoreCase("S"))
                                cinemaMetodos.removerFilme(tituloFl);

                            else {
                                System.out.println("Filme não deletado");
                            }
                            break;

                        case 2:

                            System.out.println("Digite o nome do filme para calcular duração");
                            String nome = ler.next();
                            filme= new Filme(tituloF, generoFilme, duracaoEmMinutos, horarioSessao);

                            filmeMetodos.calcularDuracaoEmHoras(nome,filme);


                            break;
                        case 3:
                            System.out.println("Digite o nome do filme para saber horario que terminará");
                            String nomeFil = ler.next();
                            filmeMetodos.retornaHoraQueAcaba(nomeFil, filme);


                            break;

                    }
                }

            } catch (InputMismatchException e) {
               System.out.println("Favor digitar uma opção válida");

            }
            System.out.println("\nDigite S para Sair");
        } while (opt != 4);
    }
}
