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

    private void run () {   //como usar?

    }
}