package com.company.Dio.dominio;

import java.util.*;

public class FilmeImplService implements FilmeService{
    private String horasCompletas;
    Set<Filme> listFilme = new LinkedHashSet<>();

    CinemaImplService cinemaImplService;


    public Set<Filme> getListFilme() {
        return listFilme;
    }

    public void setListFilme(Set<Filme> listFilme) {
        this.listFilme = listFilme;
    }

    @Override
    public void calcularDuracaoEmHoras(String nomeFilme, Filme filme) {
      try {
          listFilme.add(filme) ;
          for (Filme l: listFilme) {
              if (l.getTitulo().equalsIgnoreCase(nomeFilme)){
                  horasCompletas = calculoHora(l.getDuracaoEmMinutos());
              }
          }

          System.out.println("Duracao da sessão é: "+ horasCompletas+"hs");
      }catch (NullPointerException e){
          System.out.println("Lista vazia");
      }

    }

    @Override
    public void retornaHoraQueAcaba(String nomeFilme, Filme filme) {
        int minutRes;
        int horaRes;
        int[] horaInt = {0,0};
        int[] minInt = {0,0};

        listFilme.add(filme);
        for (Filme l: listFilme) {
            if (l.getTitulo().equalsIgnoreCase(nomeFilme)){

                String duracaoSessaoHora = calculoHora(l.getDuracaoEmMinutos());

                String[] strHora = duracaoSessaoHora.split(":");
                String[] strHoraSe = l.getHorarioSessao().split(":");

                int horaIntSoma = Integer.parseInt(strHora[0])+Integer.parseInt(strHoraSe[0]);
                int horaMin = Integer.parseInt(strHoraSe[1])+Integer.parseInt(strHora[1]);
                if (horaMin>=60){
                    horaMin= horaMin-60;
                    horaIntSoma = horaIntSoma + 1;
                }
                if (horaIntSoma>23){
                    horaIntSoma = 0;
                }
                System.out.printf("A sessão irá terminar às "+ horaIntSoma + "Hs e " + horaMin +"minutos");
            }
        }


    }

    private String calculoHora(int duracaoEmMinutos){
        int sessaoEmHoras;
        String horas;
        String minutos;
        String horasCompleta;


        sessaoEmHoras = duracaoEmMinutos/60;

        int min = duracaoEmMinutos -(sessaoEmHoras*60);


        if (duracaoEmMinutos>=(sessaoEmHoras*60)){

            horas = String.valueOf(sessaoEmHoras);
            minutos = String.valueOf(min);
            horasCompleta = horas +":"+minutos;
        }else{
            int minu = (sessaoEmHoras*60) - duracaoEmMinutos;
            horas = String.valueOf(sessaoEmHoras);
            minutos = String.valueOf(min);
            horasCompleta = horas +":"+minutos;
        }

        return horasCompleta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmeImplService that = (FilmeImplService) o;
        return Objects.equals(horasCompletas, that.horasCompletas) && Objects.equals(listFilme, that.listFilme) && Objects.equals(cinemaImplService, that.cinemaImplService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horasCompletas, listFilme, cinemaImplService);
    }
}
