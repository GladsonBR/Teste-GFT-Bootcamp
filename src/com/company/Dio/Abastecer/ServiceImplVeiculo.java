package com.company.Dio.Abastecer;

import java.io.PrintStream;

public class ServiceImplVeiculo {
    public PrintStream Abastecer(int qtnLitros, int capacidadeTanque){
        Veiculo veiculo;
        int quantidadeNoTanque, litrosExced;
        float valorPagar;

        if (qtnLitros > capacidadeTanque){
            System.out.println("Quantidade de litros excedido");

            quantidadeNoTanque= capacidadeTanque;
            litrosExced=qtnLitros-capacidadeTanque;
            valorPagar = quantidadeNoTanque*7f;

            return System.out.printf("Veiculo abastecido. \nQuantidade de litros no tanque: "+quantidadeNoTanque+" L" +"\nValor a pagar: "+"R$"+valorPagar+"\nQuantidade de litros execido: "+ litrosExced+"L \n" );
        }else{
            quantidadeNoTanque = qtnLitros;
            valorPagar = quantidadeNoTanque*7f;
            return System.out.printf("Veiculo abastecido. \nQuantidade de litros no tanque: "+quantidadeNoTanque+" L" +"\nValor a pagar: "+"R$"+valorPagar);
        }

    }
}
