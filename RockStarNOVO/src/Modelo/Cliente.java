package Modelo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class Cliente extends Utilizador {

    private ArrayList<Playlist> playlist;
    private ArrayList<Musica> aquisicoes;
    private ArrayList<Musica> aquisicoesEmEsperaPorValidacao;
    private ArrayList<Compra> historicocompras;

    public Cliente(String username, String password) {
        super(username, password);
        playlist = new ArrayList<>();
        aquisicoes = new ArrayList<>();
        aquisicoesEmEsperaPorValidacao = new ArrayList<>();
        historicocompras = new ArrayList<>();
    }

    @Override
    public ArrayList<Musica> listarMusicas(Programa programa) {
        return programa.getMusicasTotais();
    }

    @Override
    public void pesquisarMusicas(Programa programa) {

    }

    @Override

    public boolean existe(Programa programa) {
        for (Cliente c : programa.getClientes()) {
            if (this.getUsername().equals(c.getUsername())) {
                return true;
            }
        }
        return false;
    }


    @Override
    public void verificaLogin(Programa programa) {

    }


    public ArrayList<Musica> getAquisicoes() {
        return aquisicoes;
    }

    public ArrayList<Compra> getHistoricocompras() {
        return historicocompras;
    }

    public void adicionarMusicaAplaylist(Playlist playlist1, JTable tabelaMusicas, DefaultTableModel tabelaPlaylists, int linha, int coluna) {
        //Obter o objeto música de onde se clica
        Object objetoNaLinha = tabelaMusicas.getValueAt(linha, coluna);
        String objetoString = (String) objetoNaLinha;

        //Método para adicionar música à playlist
        for (Musica m : this.getAquisicoes()) {
            if (objetoString.equals(m.getTitulo())) {
                playlist1.musicas.add(m);
                for (int linhaTabela = 0; linhaTabela < tabelaPlaylists.getRowCount(); linhaTabela++) {
                    for (int colunaTabela = 0; colunaTabela < tabelaPlaylists.getColumnCount(); colunaTabela++) {
                        Object valor = tabelaPlaylists.getValueAt(linhaTabela, colunaTabela);
                        if (valor.equals(playlist1.getNome())) {
                            tabelaPlaylists.setValueAt(contarNumMusicas(playlist1), linhaTabela, colunaTabela + 2);
                        }
                    }

                }
            }
        }
    }

    public Playlist criarPlaylist(String genero, int numMusicas, Programa programa, String nome, String descricao) {
        Playlist playlistCriada = new Playlist("aaa", "aaa", true);
        ArrayList<Musica> arrayListDoGenero = new ArrayList<>();
        ArrayList<Musica> musicasJaAdicionadas = new ArrayList<>();
        int contador = 0;
        int contadorTamanho = 0;
        for (Musica pro : programa.getMusicasTotais()) {
            if (pro.getGenero().equals(genero)) {
                arrayListDoGenero.add(pro);
            }
        }
        while (contador < numMusicas && contadorTamanho < arrayListDoGenero.size()) {
            for (Musica m : arrayListDoGenero) {
                {
                    int aleatorio = numeroAleatorio(arrayListDoGenero);
                    if (arrayListDoGenero.indexOf(m) == aleatorio && !musicasJaAdicionadas.contains(m)) {
                        playlistCriada.musicas.add(m);
                        musicasJaAdicionadas.add(m);
                        contador++;
                    }
                    contadorTamanho++;
                }
            }
        }
        return playlistCriada;
    }
/*
    public Playlist criarPlaylist() {

        return pl;
    }

   /*  private Playlist verPlaylist () { //está comentado porque falta o return
    } */

    public void removerPlaylist(Playlist nomePlaylist, int linha, int coluna, JTable tabelaPlaylists, DefaultTableModel tabelaPlaylist, JPanel minhasPlaylistsClientePainel) {
        Object objetoNaLinha = tabelaPlaylists.getValueAt(linha, coluna);
        String objetoString = (String) objetoNaLinha;

        if (objetoString.equals(nomePlaylist.getNome())) {
            this.getPlaylist().remove(nomePlaylist);
            tabelaPlaylist.removeRow(linha);
            System.out.println(nomePlaylist + "removida com sucesso");
            minhasPlaylistsClientePainel.revalidate();
            minhasPlaylistsClientePainel.repaint();
        }
    }

    public void mudarVisibilidade(boolean visibilidade, Playlist pl) {
        if (visibilidade) {
            pl.setVisibilidade(false);
        } else pl.setVisibilidade(true);
    }

    public void adicionarRating(Musica musica, int pontuacao) {

    }

    public boolean adicionarMusicasAoCarrinho(Musica musica) {
        if (!aquisicoesEmEsperaPorValidacao.contains(musica) && !aquisicoes.contains(musica)) {
            aquisicoesEmEsperaPorValidacao.add(musica);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Música já adicionada/comprada", "Ups", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public void finalizarCarrinho(Programa rockstar) {
        double precoTotal = 0;
        for (Musica musicas : aquisicoesEmEsperaPorValidacao) {
            precoTotal = precoTotal + musicas.getPreco();
        }

        if (this.saldo > precoTotal) {
            for (Musica mus : aquisicoesEmEsperaPorValidacao) {
                this.saldo = this.getSaldo() - mus.getPreco();
                aquisicoes.add(mus);

                for (Artista art : rockstar.getArtistas()) {
                    if (mus.getAutoria().equals(art.getUsername())) {
                        art.saldo = art.getSaldo() + mus.getPreco();
                    }
                }

            }
        } else JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Ups", JOptionPane.WARNING_MESSAGE);
    }

    private void cancelarCarrinho() {
        for (Musica mus : aquisicoesEmEsperaPorValidacao) {
            aquisicoesEmEsperaPorValidacao.remove(mus);
        }
    }

    public double alterarSaldo(double valorAdepostiar) {
        return valorAdepostiar + saldo;
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

    public boolean registar(String username, Programa programa) {
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

    public ArrayList<Playlist> getPlaylist() {
        return playlist;
    }

    public int contarNumMusicas(Playlist playlist) {
        int contador = 0;
        for (Musica m : playlist.getMusicas()) {
            if (!m.getTitulo().equals("")) {
                contador++;
            }
        }
        return contador;
    }

    private int numeroAleatorio(ArrayList arrayList) {
        double numeroGerado = Math.random();
        int numeroGeradoFinal = (int) (numeroGerado * (arrayList.size()));
        return numeroGeradoFinal;
    }

    public ArrayList<Musica> getAquisicoesEmEsperaPorValidacao() {
        return aquisicoesEmEsperaPorValidacao;
    }


}
