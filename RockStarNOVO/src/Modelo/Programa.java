package Modelo;

import Modelo.Artista;
import Modelo.Cliente;
import Modelo.Musica;
import Modelo.Playlist;

import java.util.ArrayList;

public class Programa {

    private ArrayList<Cliente> clientes ;
    private ArrayList<Artista> artistas;
    private ArrayList<Musica> musicasTotais;
    private ArrayList<Playlist> playlistsTotais;

    public Programa(ArrayList<Cliente> clientes, ArrayList<Artista> artistas, ArrayList<Musica> musicasTotais, ArrayList<Playlist> playlistsTotais) {
        this.clientes = clientes;
        this.artistas = artistas;
        this.musicasTotais = musicasTotais;
        this.playlistsTotais = playlistsTotais;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public ArrayList<Artista> getArtistas() {
        return artistas;
    }

    private void run () {   //como usar?
        // invocar aqui a criação da JFRAME?
    }
}
