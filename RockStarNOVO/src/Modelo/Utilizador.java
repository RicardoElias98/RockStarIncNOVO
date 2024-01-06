package Modelo;

import java.io.Serializable;

public abstract class Utilizador implements Serializable {
    protected String username;
    protected String password;
    protected double saldo;

    public Utilizador(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 0.00;
    }



    protected abstract void listarMusicas();

    protected abstract void pesquisarMusicas();

    protected abstract void verificaLogin();

    // LOGOUT PODERÁ NAO Ser necessario. a não ser tornar o user temporario da FRAME = null, para novo login
    ///protected void logout() {
    ///////

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
