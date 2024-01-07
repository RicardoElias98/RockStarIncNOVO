package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Utilizador implements Serializable {
    protected String username;
    protected String password;
    protected double saldo;

    public Utilizador(String username, String password) {
        this.username = username;
        this.password = password;
        this.saldo = 0.00;
    }


    public abstract ArrayList<Musica> listarMusicas(Programa programa);

    public abstract void pesquisarMusicas(Programa programa);

    public abstract void verificaLogin(Programa programa);

    //public abstract void verificaRegisto(Programa programa);


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
