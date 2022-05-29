package model.entities;

import model.excecoes.Excecoes;

public class Conta {
    private Integer numero;
    private String nome;
    private double saldo;
    private double limiteSaque;

    public Conta(){

    }

    public Conta(Integer numero, String nome, double saldo, double limiteSaque) {
        this.numero = numero;
        this.nome = nome;
        this.saldo = saldo;
        this.limiteSaque = limiteSaque;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteEmprestimo() {
        return limiteSaque;
    }

    public void deposito(double deposito){
        this.saldo  += deposito;
    }
    public void saque(double retirada) throws Excecoes {
        if(retirada > this.saldo){
            throw new Excecoes("Saldo insuficiente!");
        }
        else if(retirada > this.limiteSaque){
            throw new Excecoes("O valor excede o limite de saque!");
        }
        else if(retirada <= this.limiteSaque){
            this.saldo -= retirada;
        }
    }

    @Override
    public String toString(){
        return "Novo Saldo "
                + getSaldo();
    }
}
