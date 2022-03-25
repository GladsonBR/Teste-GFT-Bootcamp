package com.company.Dio.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FilmeImplService implements FilmeService{
    private String horasCompletas;


    @Override
    public void calcularDuracaoEmHoras(int duracaoMinutos) {

                horasCompletas = calculoHora(duracaoMinutos);
                System.out.println("Duracao da sessão é: "+ horasCompletas);
    }

    @Override
    public void retornaHoraQueAcaba(String horaSecao, int duracaoMin) {
        int minutRes;
        int horaRes;
        int[] horaInt = {0,0};
        int[] minInt = {0,0};

        String duracaoSessaoHora = calculoHora(duracaoMin);

        String[] strHora = duracaoSessaoHora.split(":");
        String[] strHoraSe = horaSecao.split(":");

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

    private String calculoHora(int duracaoEmMinutos){
        int soHora;
        String horas;
        String minutos;
        String horasCompleta;

        soHora = duracaoEmMinutos/60;

        int min = duracaoEmMinutos -(soHora*60);


        if (duracaoEmMinutos>=(soHora*60)){

            horas = String.valueOf(soHora);
            minutos = String.valueOf(min);
            horasCompleta = horas +":"+minutos;
        }else{
            int minu = (soHora*60) - duracaoEmMinutos;
            horas = String.valueOf(soHora);
            minutos = String.valueOf(min);
            horasCompleta = horas +":"+minutos;
        }

        return horasCompleta;
    }

}
