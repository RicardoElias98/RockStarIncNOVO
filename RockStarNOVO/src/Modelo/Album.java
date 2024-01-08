package Modelo;

public class Album extends ConjuntoDeMusicas {
        private String albumGenero;

    public Album(String nome, String albumGenero) {
        super(nome);
        this.albumGenero = albumGenero;
    }

    public String getAlbumGenero() {
        return albumGenero;
    }
}
