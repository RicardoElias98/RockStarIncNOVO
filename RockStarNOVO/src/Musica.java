import java.time.LocalDate;
import java.util.ArrayList;

public class Musica {
    private String titulo;
    private String autor;
    private LocalDate data;
    private ArrayList <Integer> registoDeValores;

    private boolean disponibilidade;
    private String album;

    private int idMuscia;
    private ArrayList <Integer> registodeRating;

    public Musica(String titulo, String autor, LocalDate data, ArrayList<Integer> registoDeValores, boolean disponibilidade, String album, int idMuscia, ArrayList<Integer> registodeRating) {
        this.titulo = titulo;
        this.autor = autor;
        this.data = data;
        this.registoDeValores = registoDeValores;
        this.disponibilidade = disponibilidade;
        this.album = album;
        this.idMuscia = idMuscia;
        this.registodeRating = registodeRating;
    }

    // private double mediaDoRating () {    //está comentado porque falta o return


//    }
    }

