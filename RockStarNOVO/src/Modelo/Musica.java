package Modelo;

import java.time.LocalDate;
import java.util.ArrayList;

public class Musica {
    private String titulo;
    private String autor;
    private LocalDate data;
    private ArrayList <Integer> registoDeValores;

    private boolean disponibilidade;
    private String album;

    private int idMusica;
    private ArrayList <Integer> registodeRating; //HASMAP

    private String genero; //USAR ENUM

    private double preco;

    public Musica(String titulo, String autor, LocalDate data, ArrayList<Integer> registoDeValores, boolean disponibilidade, String album, int idMuscia, ArrayList<Integer> registodeRating, String genero, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.registoDeValores = registoDeValores;
        this.disponibilidade = disponibilidade;
        this.album = album;
        this.idMusica = idMusica;
        this.registodeRating = registodeRating;
        this.genero = genero;
        this.preco = preco;
    }

    public String getAutor() {
        return autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public LocalDate getData() {
        return data;
    }

    public String getAlbum() {
        return album;
    }

    public void setRegistodeRating(ArrayList<Integer> registodeRating) {
        this.registodeRating = registodeRating;
    }

    public ArrayList<Integer> getRegistodeRating() {
        return registodeRating;
    }

    @Override
    public String toString() {
        return "Modelo.Musica{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", data=" + data +
                ", registoDeValores=" + registoDeValores +
                ", disponibilidade=" + disponibilidade +
                ", album='" + album + '\'' +
                ", idMuscia=" + idMusica +
                ", registodeRating=" + registodeRating +
                '}';
    }

    public String getGenero() {
        return genero;
    }

    public double getPreco() {
        return preco;
    }

    public int getIdMuscia() {
        return idMusica;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    // private double mediaDoRating () {    //está comentado porque falta o return


//    }
    }

