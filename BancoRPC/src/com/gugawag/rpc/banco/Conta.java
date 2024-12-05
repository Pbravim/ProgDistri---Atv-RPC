package com.gugawag.rpc.banco;
import java.rmi.Remote;
import java.rmi.RemoteException;

class Conta {
    public String numero;
    public double saldo;

    public Conta(String numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    @Override
    public String toString(){
        return "Conta{numero ='" + numero + "', saldo =" + saldo + "}";
    }
}