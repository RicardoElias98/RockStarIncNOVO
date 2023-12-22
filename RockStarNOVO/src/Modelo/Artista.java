package Modelo;

import java.util.ArrayList;

public class Artista extends Utilizador {

    private int pin;
    private ArrayList<Musica> musicas;
    private ArrayList<Album> albuns;

    public Artista(String username, String password, double saldo, int pin, ArrayList<Musica> musicas, ArrayList<Album> albuns) {
        super(username, password, saldo);
        this.pin = pin;
        this.musicas = musicas;
        this.albuns = albuns;
    }

    private void adicionarMusica() {

    }

    private void corrigirTitulo(int idDaMusica) {

    }

    private void alterarPreco(int idDaMusica) {

    }

    private void alterarVisibilidade(int idDaMusica) {

    }

    private void verEstatistias() {

    }

    @Override
    protected void listarMusicas() {
        super.listarMusicas();
    }

    @Override
    protected void pesquisarMusicas() {
        super.pesquisarMusicas();
    }


    public boolean loginArtista(String username, String password, int pin, Programa programa) {
        int contadorParaLogin = 0;

        String passEmString = new String(password);


        for (Artista a : programa.getArtistas()) {
            if (username.equals(a.getUsername()) & passEmString.equals(a.getPassword()) & pin == a.getPin()) {
                contadorParaLogin++;
            }
        }
        if (contadorParaLogin != 0) {
            return true;
        } else return false;
    }

    public boolean registarArtista(String username, Programa programa) {
        int contadorParaRegisto = 0;

        for (Cliente c : programa.getClientes()) {
            if (username.equals(c.getUsername())) {
                contadorParaRegisto++;
            }
        }
        if (contadorParaRegisto == 0) {
            return true;
        } else return false;
    }


    public int getPin() {
        return pin;
    }

    // método para verificar se o pin é válido

    public boolean verificaPin(int pin) {
        if (pin == this.pin) {
            return true;
        } else return false;
    }
}


