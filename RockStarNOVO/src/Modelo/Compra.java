package Modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Compra {

    private LocalDateTime dataDaCompra;
    private ArrayList<Musica> musicasCompradas;
    private double custoCompra;

    public Compra(ArrayList<Musica> musicasCompradas, double custoCompra) {
        this.musicasCompradas = musicasCompradas;
        this.custoCompra = custoCompra;
        this.dataDaCompra = LocalDateTime.now();
    }

    public LocalDateTime getDataDaCompra() {
        return dataDaCompra;
    }

    public ArrayList<Musica> getMusicasCompradas() {
        return musicasCompradas;
    }

    public double getCustoCompra() {
        return custoCompra;
    }
}
