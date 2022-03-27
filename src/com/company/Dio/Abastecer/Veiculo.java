package com.company.Dio.Abastecer;

public class Veiculo {
    @Override
    public String toString() {
        return "Veiculo{" +
                "modelo='" + nome + '\'' +
                ", marca='" + marca + '\'' +
                ", capacidadeDoTanque=" + capacidadeDoTanque +
                '}';
    }

    private String nome;
    private String marca;
    private int capacidadeDoTanque;
    private int litrosNoTanque=0;

    public Veiculo() {

    }


    public int getLitrosNoTanque() {
        return litrosNoTanque;
    }



    public Veiculo(String nome, String marca, int capacidadeDoTanque) {
        this.nome = nome;
        this.marca = marca;
        this.capacidadeDoTanque = capacidadeDoTanque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getCapacidadeDoTanque() {
        return capacidadeDoTanque;
    }

    public void setCapacidadeDoTanque(int capacidadeDoTanque) {
        this.capacidadeDoTanque = capacidadeDoTanque;
    }




}
