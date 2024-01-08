package Modelo;

import java.util.ArrayList;

public class Album extends ConjuntoDeMusicas {
        private String genero;

    public Album(String nome, String genero) {
        super(nome);
        this.genero = genero;
        //this.musicas = musicas;
    }
}
