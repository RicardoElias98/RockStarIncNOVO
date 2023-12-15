import java.util.ArrayList;

public class Artista extends Utilizador {

    private int pin;
    private ArrayList <Musica> musicas;
    private ArrayList<Album> albuns;

    public Artista(String username, String password, double saldo, int pin, ArrayList<Musica> musicas, ArrayList<Album> albuns) {
        super(username, password, saldo);
        this.pin = pin;
        this.musicas = musicas;
        this.albuns = albuns;
    }

    private void adicionarMusica () {

    }

    private void corrigirTitulo (int idDaMusica) {

    }

    private void alterarPreco (int idDaMusica) {

    }
    private void alterarVisibilidade (int idDaMusica) {

    }

    private void verEstatistias () {

    }

}
