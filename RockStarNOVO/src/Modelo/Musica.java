package Modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

public class Musica implements Serializable {
    private UUID idMusica;
    private String titulo;
    private String autoria;

    // data da musica. não é a data em que é adicionada ao sistema, é atributo "real"
    private LocalDateTime data;

    private double preco;

    // mete-se no construtor para já definir qd adiciona musica se fica visivel ou nao
    private boolean adicionarAPlaylist;

    // string que vai ser usada só dps com setter na criação de álbum
    private String nomeAlbum;
    // verficar sé é necessario


    // hashmap vai ligar cliente.getNome() e o valor que ele avalia a música
    // qd for retorno, se ele não tiver avaliado, dizer nao avaliado
    private HashMap<Cliente, Integer> avaliacao = new HashMap<>();

    // historico de preços.
    private HashMap<LocalDateTime, Double> historicoprecos = new HashMap<>();
    ;

    // hashmap de quanto ganhou por musica por exemplo
    // usar pelo artista


    //USAR Jcombo box que mete genero normalizado
    private String genero;

    // para calcular quanto ganhou o artista com a sua música
    private double receita;



    public Musica(String titulo, String autoria, LocalDateTime data, boolean adicionarAPlaylist, String genero, double preco) {
        this.idMusica = UUID.randomUUID();
        this.titulo = titulo;
        this.autoria = autoria;
        this.data = data;
        this.adicionarAPlaylist = adicionarAPlaylist;
        // atribuição em album só depois
        // this.nomeAlbum = album;
        this.genero = genero;
        this.preco = preco;
    }

    public UUID getIdMusica() {
        return idMusica;
    }

    public LocalDateTime getData() {
        return data;
    }

    public String getAutoria() {
        return autoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }


    public String getGenero() {
        return genero;
    }

    public double getPreco() {
        return preco;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPreco(double preco) {
        this.preco = preco;
        historicoprecos.put(LocalDateTime.now(), preco);
    }

    public void setAdicionarAPlaylist(boolean adicionarAPlaylist) {
        this.adicionarAPlaylist = adicionarAPlaylist;
    }

    // metodo adicionar rating (cliente)

    public void adicionarRating(Cliente cliente, Integer valor) {
        this.avaliacao.put(cliente, valor);
    }

    public boolean isAdicionarAPlaylist() {
        return adicionarAPlaylist;
    }
    // método pra artista saber quanto fez por música
    public double getReceita() {
        return receita;
    }
    // incrementa a cada venda
    public void novaVenda(double venda) {
        this.receita += venda;
    }

    // metodo a ser chmado quando se adiciona a musica a album
    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    // metodo cliente ver rating que deu
    public Integer verRatingDado(Cliente cliente) {
        Integer rating = avaliacao.getOrDefault(cliente, 0);
        return rating;
    }

    // metodo rating médio (tratar o 0.0 na parte visual)
    public double obterRatingMedio() {
        if (avaliacao.isEmpty()) {
            return 0.0;
        }
        double soma = 0;
        for (int valor : avaliacao.values()) {
            soma += valor;
        }
        return soma / avaliacao.size();
    }

    public HashMap<LocalDateTime, Double> getHistoricoprecos() {
        return historicoprecos;
    }

    public HashMap<Cliente, Integer> getAvaliacao() {
        return avaliacao;
    }

}

