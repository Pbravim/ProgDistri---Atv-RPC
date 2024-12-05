package com.gugawag.rpc.banco;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BancoServiceServer extends UnicastRemoteObject implements BancoServiceIF {

    private Map<String, Double> saldoContas;
    private List<Conta> contas = new ArrayList<>();

    public BancoServiceServer() throws RemoteException {
        saldoContas = new HashMap<>();
        saldoContas.put("1", 100.0);
        saldoContas.put("2", 156.0);
        saldoContas.put("3", 950.0);
    }

    @Override
    public double saldo(String conta) throws RemoteException {
        return saldoContas.get(conta);
    }

    @Override
    public int quantidadeContas() throws RemoteException {
        return saldoContas.size();
    }

    @Override
    public String cadastrarConta(String numero, double saldo) throws RemoteException {
        Conta conta = new Conta(numero, saldo);

        contas.add(conta);
        return ("Conta cadastrada com sucesso");
    }

    @Override
    public String getConta(String numero) throws RemoteException {
        for (Conta conta : contas){
            if (conta.numero.equals(numero)){
                return conta.toString();
            }
        }
        throw new RemoteException("Account " + numero + " not found");
    }

    @Override
    public String removeConta(String numero) throws RemoteException {
        for (Conta conta : contas){
            if (conta.numero.equals (numero)){
                contas.remove(conta);
                return "Conta removida";
            } 
    }
    throw new RemoteException("Account " + numero + " not found");
}
}
