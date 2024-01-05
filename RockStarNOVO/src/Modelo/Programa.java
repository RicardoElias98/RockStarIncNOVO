import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Programa implements Serializable {

    private ArrayList<Cliente> clientes;
    private  ArrayList<Artista> artistas;
    private  ArrayList<Musica> musicasTotais;
    private  ArrayList<Playlist> playlistsTotais;
    private ArrayList<Album> albunsTotais;


// a classe programa é a classe onde são guardadas as estruturas de dados que vão ser manipuladas
    public Programa() {
        this.clientes = new ArrayList<>();
        this.artistas = new ArrayList<>();
        this.musicasTotais = new ArrayList<>();
        this.playlistsTotais = new ArrayList<>();
        this.albunsTotais = new ArrayList<>();

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


// isto caso mude de GUI pra programa
    public void runPrograma() {
        // carrega o ficheiro do programa. caso não exista, cria novo
        // chama GUI
        // faz as operações que quiser com os dados
        // salva os dados no ficheiro antes de encerrar o programa
    }
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
