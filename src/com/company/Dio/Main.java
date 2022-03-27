package com.company.Dio;

import com.company.Dio.Abastecer.ServiceImplVeiculo;
import com.company.Dio.Abastecer.Veiculo;
import com.company.Dio.FilmesEmCartaz.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        int opt=0;
        Scanner ler = new Scanner(System.in);
        Scanner lerStr = new Scanner(System.in);
        System.out.printf("Digite Qual programa deseja rodar\n" +
                "1-Quantidade de pares número inteiro \n"+
                "2-Multiplicando (Intervalo/Resto)\n"+
                "3-Cinema\n4-Abastecer veículo\n");

        Scanner leitor = new Scanner(System.in);
        int optDesafio = leitor.nextInt();
        switch (optDesafio) {

            case 1:
                String[] numStr;
                do {
                    String leitorStr = leitor.next();
                    numStr = leitorStr.split("");
                    int contPar = 0;
                    if (numStr.length == 4) {

                        for (int i = 0; i < numStr.length; i++) {
                            if (Integer.parseInt(numStr[i]) % 2 == 0) contPar++;
                        }
                        System.out.println("A quantidade de digitos pares é " + contPar);
                        break;
                    }
                    System.out.printf("O numero deve conter 4 digitos \n");
                } while (numStr.length != 4);

            case 2:
                int mult, intIni, intFin ;
                System.out.printf("digite o multiplicando: ");
                mult = leitor.nextInt();
                System.out.printf("digite o intervalo inicial: ");
                intIni = leitor.nextInt();
                System.out.printf("digite o intervalo Final: ");
                intFin = leitor.nextInt();
                int intervalo = intFin - intIni;
                if (intervalo>0 & intervalo<10 & intIni<intFin){
                    for (int i=0;i<=intervalo;i++){
                        System.out.println(mult+" x "+(intIni+i)+ " = " + (mult*(intIni+i)));
                    }
                }else if(intervalo<=0 || intervalo>10){
                    System.out.println("O intervalo entre eles tem que ser de 1 até 10");
                }else{
                    System.out.println("O inicio deve ser menor que seu fim");
                }

            case 3:
                CinemaService cinemaMetodos = new CinemaImplService();
                Cinema cinema = new Cinema();
                FilmeService filmeMetodos = new FilmeImplService();
                Filme filme = new Filme();


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

            case 4:
                Veiculo veiculo = new Veiculo();
                ServiceImplVeiculo serviceImplVeiculo = new ServiceImplVeiculo();
                String nomeVeiculo, marca ;
                int capacidaTanque, qtnAbastecido;

                System.out.println("Digite o nome do veiculo");
                nomeVeiculo=lerStr.nextLine();
                System.out.println("Digite a marca do veiculo");
                marca = ler.nextLine();
                System.out.println("Digite a capacidade do modelo");
                capacidaTanque = ler.nextInt();
                System.out.println("Digite a quantidade a abastecer");
                qtnAbastecido= ler.nextInt();

                veiculo.setNome(nomeVeiculo);
                veiculo.setMarca(marca);
                veiculo.setCapacidadeDoTanque(capacidaTanque);

                System.out.println(veiculo);
                System.out.println(serviceImplVeiculo.Abastecer(qtnAbastecido, capacidaTanque));


        }


    }
}
