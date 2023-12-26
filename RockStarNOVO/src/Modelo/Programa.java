package Modelo;


import java.util.ArrayList;

public class Programa {

    private ArrayList<Cliente> clientes ;
    private ArrayList<Artista> artistas;
    private ArrayList<Musica> musicasTotais;
    private ArrayList<Playlist> playlistsTotais;

    public Programa() {
        this.clientes = new ArrayList<>();
        this.artistas = new ArrayList<>();
        this.musicasTotais = new ArrayList<>();
        this.playlistsTotais = new ArrayList<>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    public ArrayList<Musica> getMusicasTotais() {
        return musicasTotais;
    }

    private void run () {   //como usar?
        // invocar aqui a criação da JFRAME?
    }
}
