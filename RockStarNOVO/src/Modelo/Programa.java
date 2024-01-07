package Modelo;


import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Programa implements Serializable {

    private ArrayList<Cliente> clientes;
    private ArrayList<Artista> artistas;
    private ArrayList<Musica> musicasTotais;
    private ArrayList<Playlist> playlistsTotais;
    private ArrayList<Album> albunsTotais;


    // a classe programa é a classe onde são guardadas as estruturas de dados que vão ser manipuladas
    public Programa() {
        this.clientes = new ArrayList<>();
        this.artistas = new ArrayList<>();
        this.musicasTotais = new ArrayList<>();
        this.playlistsTotais = new ArrayList<>();
        this.albunsTotais = new ArrayList<>();

        //// hardcode de objetos pra teste

        Artista a = new Artista("daniel", "123", 123);
        Cliente c = new Cliente("ricardo", "1234");
        artistas.add(a);
        clientes.add(c);

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

    public ArrayList<Playlist> getPlaylistsTotais() {
        return playlistsTotais;
    }

    public ArrayList<Album> getAlbunsTotais() {
        return albunsTotais;
    }


    // login cliente
    public boolean loginC(String username, String password) {
        // Verificar se o cliente existe e a password está correta
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username) && cliente.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

    public boolean login(String username, String password, int pin) {
        // Verificar se o artista existe, se a password e o pin estão corretos
        for (Artista artista : artistas) {
            if (artista.getUsername().equals(username) && artista.getPassword().equals(password) && artista.getPin() == pin) {
                return true;
            }
        }
        return false;
    }


    // método devolução user na array de utilizadores (clientes ou artistas)
    // usar sabendo que o user é valido, após execução de funcao login

    public Artista artistaNaArray(String username) {
        for (Artista artista : artistas) {
            if (artista.getUsername().equals(username)) {
                return artista;
            }
        }
        return null;
    }

    public Cliente clienteNaArray(String username) {
        for (Cliente cliente : clientes) {
            if (cliente.getUsername().equals(username)) {
                return cliente;
            }
        }
        return null;
    }


/// MÉTODO SAVE

    public void salvarDados() {
        try {
            // cria um fluxo de saída de objetos para o arquivo
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("RockstarInc.dat"));
            // escreve o objeto programa no arquivo
            out.writeObject(this);
            // fecha o fluxo de saída
            out.close();
            System.out.println("Programa salvo com sucesso!");


        } catch (IOException e) {
            // trata a exceção de entrada e saída
            e.printStackTrace();
        }

    }
}
