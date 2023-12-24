package Modelo;

import java.util.ArrayList;

public class Playlist extends ConjuntoDeMusicas {
    private boolean visibilidade;
    private String descricao;

    public Playlist(String nome, ArrayList<Musica> musicas, boolean visibilidade, String descricao) {
        super(nome, musicas);
        this.visibilidade = visibilidade;
        this.descricao = descricao;
    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public String getDescricao() {
        return descricao;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "nome='" + nome + '\'' +
                '}';
    }

    public boolean atribuirVisibilidade(String visibilidade) {
        if (visibilidade.equals("Sim")) {
            return true;
        } else return false;
    }

    public void setVisibilidade(boolean visibilidade) {
        this.visibilidade = visibilidade;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}

