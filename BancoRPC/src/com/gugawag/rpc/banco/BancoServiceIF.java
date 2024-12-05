package com.gugawag.rpc.banco;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BancoServiceIF extends Remote {

    double saldo(String conta) throws RemoteException;
    int quantidadeContas() throws RemoteException;
    String cadastrarConta(String numero, double saldo) throws RemoteException;
    String getConta(String numero) throws RemoteException;
    String removeConta(String numero) throws RemoteException;
}
