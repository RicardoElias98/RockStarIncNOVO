package Modelo;

import java.util.ArrayList;

public class Artista extends Utilizador {

    private int pin = 12345;
    private ArrayList<Musica> musicas;
    private ArrayList<Album> albuns;

    public Artista(String username, String password) {
        super(username, password);
        musicas = new ArrayList<>();
        albuns = new ArrayList<>();
    }


    @Override
    public boolean existe(Programa programa) {
        for (Artista a : programa.getArtistas()) {
            if(this.getUsername().equals(a.getUsername())){
                return true;
            }
        }
        return false;}


    public ArrayList<Musica> getMusicas() {
        return musicas;
    }

    public int getPin() {
        return pin;
    }
    public ArrayList<Album> getAlbuns() {
        return albuns;
    }




}


