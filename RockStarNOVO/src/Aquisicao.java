import java.time.LocalDate;

public class Aquisicao {
    private Musica musica;
    private double precoDeAquisicao;

    private LocalDate dataDeAquisicao;

    public Aquisicao(Musica musica, double precoDeAquisicao, LocalDate dataDeAquisicao) {
        this.musica = musica;
        this.precoDeAquisicao = precoDeAquisicao;
        this.dataDeAquisicao = dataDeAquisicao;
    }
}
