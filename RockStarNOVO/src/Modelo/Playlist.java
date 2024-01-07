package Modelo;

import java.util.ArrayList;

public class Playlist extends ConjuntoDeMusicas {
    private boolean visibilidade;
    private String descricao;

    // criar playlist vazia
    public Playlist(String nome,String descricao, boolean visibilidade) {
        super(nome);
        this.visibilidade = visibilidade;
        this.descricao = descricao;
        this.musicas=new ArrayList<>();
    }
    // criar playlist com género e numero de playlists




    public Playlist(String nome, String descricao, boolean visibilidade, int numeroMusicas, String genero) {
        super(nome);
        this.musicas = new ArrayList<>();
        this.visibilidade = visibilidade;
        this.descricao = descricao;

    }

    public boolean isVisibilidade() {
        return visibilidade;
    }

    public String getDescricao() {
        return descricao;
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




