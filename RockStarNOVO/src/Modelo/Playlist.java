package Modelo;

import Modelo.ConjuntoDeMusicas;
import Modelo.Musica;

import java.util.ArrayList;

public class Playlist extends ConjuntoDeMusicas {
    private boolean visibilidade;
    private String descricao;

    public Playlist(String nome, ArrayList<Musica> musicas, boolean visibilidade, String descricao) {
        super(nome, musicas);
        this.visibilidade = visibilidade;
        this.descricao = descricao;
    }
}
