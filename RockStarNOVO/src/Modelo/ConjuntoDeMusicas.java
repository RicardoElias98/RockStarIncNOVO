package Modelo;

import java.util.ArrayList;

public abstract class ConjuntoDeMusicas {
    protected String nome;
    public ArrayList<Musica> musicas;

    public ConjuntoDeMusicas(String nome, ArrayList<Musica> musicas) {
        this.nome = nome;
        this.musicas = musicas;
    }
}
