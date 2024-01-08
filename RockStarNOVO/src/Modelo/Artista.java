package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Artista extends Utilizador {

    private int pin = 12345;
    private ArrayList<Musica> musicas;
    private ArrayList<Album> albuns;

    public Artista(String username, String password) {
        super(username, password);
        musicas = new ArrayList<>();
        albuns = new ArrayList<>();
    }




    @Override
    public ArrayList<Musica> listarMusicas(Programa programa) {
        return getMusicas();
    }

    @Override
    public void pesquisarMusicas(Programa programa) {

    }

    @Override
    public boolean existe(Programa programa) {
        for (Artista a : programa.getArtistas()) {
            if(this.getUsername().equals(a.getUsername())){
                return true;
            }
        }
        return false;}

    @Override
    public void verificaLogin(Programa programa) {

    }


    private void adicionarMusica(Musica musica, Programa programa) {
        this.musicas.add(musica);
        programa.getMusicasTotais().add(musica);
    }

   /* private void corrigirTitulo(Musica mus, Programa programa, String novoTitulo) {
        for (Musica mus : programa.getMusicasTotais()){
            if (mus.getIdMusica() == idDaMusica) {
                mus.setTitulo(novoTitulo);
            }
        }
    }

    private void alterarPreco(int idDaMusica, Programa programa, double novoPreco) {
        for (Musica mus : programa.getMusicasTotais()){
            if (mus.getIdMuscia() == idDaMusica) {
                mus.setPreco(novoPreco);
            }
        }
    }

    private void alterarDisponiblidade(int idDaMusica, Programa programa, boolean visibilidade ) {
        for (Musica mus : programa.getMusicasTotais()){
            if (mus.getIdMuscia() == idDaMusica) {
                mus.adicionarAPlaylist(visibilidade);
            }
        }
    }*/

    private void verEstatisticasPessoais() {


        System.out.println("Total de músicas: " + this.contarMusicas() + "Valor total das músicas: " + this.valorTotalMusicas() + "");

//FALTAM ESTES -->
// Ver estatísticas: total de utilizadores,
// valor total das vendas,
// total de álbuns por género musical
// . Para além destes valores, apresente mais dois valores à sua escolha,
// que considere úteis num sistema deste tipo.
    }

    public double adicionarSaldo(double valorAadicionar) {
        return saldo + valorAadicionar;
    }


    // esta expressao passa para verifica login
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


    public ArrayList<Musica> getMusicas() {
        return musicas;
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

    public ArrayList<Album> getAlbuns() {
        return albuns;
    }

    private int contarMusicas() {
        int contador = 0;
        for (Musica mus : this.getMusicas()) {
            if (mus != null) {
                contador++;
            }
        }
        return contador;
    }

    private double valorTotalMusicas() {
        double valor = 0;
        for (Musica mus : this.getMusicas()) {
            if (mus != null) {
                valor = valor + mus.getPreco();
            }
        }
        return valor;
    }
}


