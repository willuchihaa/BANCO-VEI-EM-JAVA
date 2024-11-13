package atividadejavos.atividade3banco;

import java.util.ArrayList;
import java.util.Scanner;

class Conta {
    private double saldo;
    private int agencia;
    private String titular;

    public Conta(String titular, int agencia, double saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        saldo += valor;
    }

    public boolean sacar(double valor) {
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean transferirPara(Conta destino, double valor) {
        if (sacar(valor)) {
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Titular: %s, Agência: %d, Saldo: %.2f", titular, agencia, saldo);
    }
}

