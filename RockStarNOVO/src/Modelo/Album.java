package Modelo;

import java.util.ArrayList;

public class Album extends ConjuntoDeMusicas {
        private String genero;  //PODEMOS USAR O ENUM????

    public Album(String nome, ArrayList<Musica> musicas, String genero) {
        super(nome);
        this.genero = genero;
    }
}
