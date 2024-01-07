package Modelo;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class ConjuntoDeMusicas implements Serializable {
    protected String nome;
    protected ArrayList<Musica> musicas;

    public ConjuntoDeMusicas(String nome){
        this.nome = nome;
    }


    public String getNome() {
        return nome;
    }

    public ArrayList<Musica> getMusicas() {
        return musicas;
    }



}
