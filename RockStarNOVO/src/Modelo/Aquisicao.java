package Modelo;

import java.time.LocalDate;

public class Aquisicao {
    private Musica musica;
    private double precoDeAquisicao;

    private int rating;
    private LocalDate dataDeAquisicao;

    public Aquisicao(Musica musica, double precoDeAquisicao, int rating, LocalDate dataDeAquisicao) {
        this.musica = musica;
        this.precoDeAquisicao = precoDeAquisicao;
        this.rating = rating;
        this.dataDeAquisicao = dataDeAquisicao;
    }

    public Musica getMusica() {
        return musica;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
