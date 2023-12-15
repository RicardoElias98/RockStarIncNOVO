import java.util.ArrayList;

public class Cliente extends Utilizador {

    private ArrayList <Playlist> playlist;
    private ArrayList <Aquisicao> aquisicoes;
    private ArrayList <Aquisicao> aquisicoesEmEsperaPorValidacao;

    public Cliente(String username, String password, double saldo, ArrayList<Playlist> playlist, ArrayList<Aquisicao> aquisicoes, ArrayList<Aquisicao> aquisicoesEmEsperaPorValidacao) {
        super(username, password, saldo);
        this.playlist = playlist;
        this.aquisicoes = aquisicoes;
        this.aquisicoesEmEsperaPorValidacao = aquisicoesEmEsperaPorValidacao;
    }

    private void adicionarMusicaAplaylist (Musica musica, Playlist playlist) {

    }

    private void criarPlaylist (String genero, int numMusicas) {

    }

    private void criarPlaylist () {

    }

   /*  private Playlist verPlaylist () { //está comentado porque falta o return


    } */

    private void removerPlaylist (Playlist nomePlaylist) {

    }

    private void mudarVisibilidade () {

    }

    private void adicionarRating (int pontuacao) {

    }

    private void adicionarMusicasAoCarrinho (Musica musica) {

    }

    private void finalizarCarrinho () {

    }

    private void cancelarCarrinho () {

    }

    private void alterarSaldo () {

    }
}
