import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Cliente extends Utilizador implements Serializable {

    private ArrayList<Playlist> playlist;
    private ArrayList<Musica> aquisicoes;
    private ArrayList<Aquisicao> aquisicoesEmEsperaPorValidacao;

    public Cliente(String username, String password, double saldo, ArrayList<Playlist> playlist, ArrayList<Musica> aquisicoes, ArrayList<Aquisicao> aquisicoesEmEsperaPorValidacao) {
        super(username, password, saldo);
        this.playlist = playlist;
        this.aquisicoes = aquisicoes;
        this.aquisicoesEmEsperaPorValidacao = aquisicoesEmEsperaPorValidacao;
    }

    private void adicionarMusicaAplaylist(Musica musica, Playlist playlist) {

    }

    private void criarPlaylist(String genero, int numMusicas) {

    }

    private void criarPlaylist() {

    }

   /*  private Playlist verPlaylist () { //está comentado porque falta o return


    } */

    private void removerPlaylist(Playlist nomePlaylist) {

    }

    private void mudarVisibilidade() {

    }

    private void adicionarRating(int pontuacao) {

    }

    private void adicionarMusicasAoCarrinho(Musica musica) {

    }

    private void finalizarCarrinho() {

    }

    private void cancelarCarrinho() {

    }

    private void alterarSaldo() {

    }

    public boolean login(String username, String password, Programa programa) {
        int contadorParaLogin = 0;

        String passEmString = new String(password);

        for (Cliente c : programa.getClientes()) {
            if (username.equals(c.getUsername())) {
                contadorParaLogin++;
            }
            if (passEmString.equals(c.getPassword())) {
                contadorParaLogin++;
            }
        }
        if (contadorParaLogin == 2) {
            return true;
        } else return false;
    }

    public boolean registar (String username, Programa programa) {
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

    public ArrayList<Musica> getAquisicoes() {
        return aquisicoes;
    }
}
