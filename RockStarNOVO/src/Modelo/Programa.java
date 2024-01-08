package Modelo;


import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
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
        /////////////////////////////////////


        /*Cliente cliente1 = new Cliente("Daniel", "senha1");
        Cliente cliente2 = new Cliente("Rita", "senha2");
        Cliente cliente3 = new Cliente("Ana", "senha3");
        Cliente cliente4 = new Cliente("Lucas", "senha4");
        Cliente cliente5 = new Cliente("Mariana", "senha5");
        Cliente cliente6 = new Cliente("Tiago", "senha6");
        Cliente cliente7 = new Cliente("Carla", "senha7");
        Cliente cliente8 = new Cliente("Pedro", "senha8");
        Cliente cliente9 = new Cliente("Laura", "senha9");
        Cliente cliente10 = new Cliente("Mateus", "senha10");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);
        clientes.add(cliente4);
        clientes.add(cliente5);
        clientes.add(cliente6);
        clientes.add(cliente7);
        clientes.add(cliente8);
        clientes.add(cliente9);
        clientes.add(cliente10);


        Artista artista1 = new Artista("David Bowie", "DavidBowie");
        artistas.add(artista1);
        Artista artista2 = new Artista("Adele", "Adele");
        artistas.add(artista2);
        Artista artista3 = new Artista("Bob Dylan", "BobDylan");
        artistas.add(artista3);
        Artista artista4 = new Artista("Beyoncé", "Beyonce");
        artistas.add(artista4);
        Artista artista5 = new Artista("Elton John", "EltonJohn");
        artistas.add(artista5);
        Artista artista6 = new Artista("Madonna", "Madonna");
        artistas.add(artista6);
        Artista artista7 = new Artista("Kanye West", "KanyeWest");
        artistas.add(artista7);
        Artista artista8 = new Artista("Taylor Swift", "TaylorSwift");
        artistas.add(artista8);
        Artista artista9 = new Artista("Jay-Z", "JayZ");
        artistas.add(artista9);
        Artista artista10 = new Artista("Rihanna", "Rihanna");
        artistas.add(artista10);

// David Bowie
        Musica m1 = new Musica("Space Oddity", "David Bowie", LocalDateTime.of(1969, 7, 11, 0, 0), true, "Rock", 1.99);
        getMusicasTotais().add(m1);
        artistaNaArray(m1.getAutoria()).getMusicas().add(m1);

        Musica m2 = new Musica("Heroes", "David Bowie", LocalDateTime.of(1977, 9, 23, 0, 0), false, "Rock", 0.00);
        getMusicasTotais().add(m2);
        artistaNaArray(m2.getAutoria()).getMusicas().add(m2);

        Musica m3 = new Musica("Life on Mars?", "David Bowie", LocalDateTime.of(1971, 6, 4, 0, 0), true, "Rock", 1.99);
        getMusicasTotais().add(m3);
        artistaNaArray(m3.getAutoria()).getMusicas().add(m3);

        Musica m4 = new Musica("Starman", "David Bowie", LocalDateTime.of(1972, 4, 28, 0, 0), false, "Rock", 0.00);
        getMusicasTotais().add(m4);
        artistaNaArray(m4.getAutoria()).getMusicas().add(m4);

// Adele
        Musica m5 = new Musica("Hello", "Adele", LocalDateTime.of(2015, 10, 23, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m5);
        artistaNaArray(m5.getAutoria()).getMusicas().add(m5);

        Musica m6 = new Musica("Someone Like You", "Adele", LocalDateTime.of(2011, 1, 24, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m6);
        artistaNaArray(m6.getAutoria()).getMusicas().add(m6);

        Musica m7 = new Musica("Rolling in the Deep", "Adele", LocalDateTime.of(2010, 11, 29, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m7);
        artistaNaArray(m7.getAutoria()).getMusicas().add(m7);

        Musica m8 = new Musica("Set Fire to the Rain", "Adele", LocalDateTime.of(2011, 7, 4, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m8);
        artistaNaArray(m8.getAutoria()).getMusicas().add(m8);

// Bob Dylan
        Musica m9 = new Musica("Like a Rolling Stone", "Bob Dylan", LocalDateTime.of(1965, 7, 20, 0, 0), true, "Folk", 1.99);
        getMusicasTotais().add(m9);
        artistaNaArray(m9.getAutoria()).getMusicas().add(m9);

        Musica m10 = new Musica("Blowin' in the Wind", "Bob Dylan", LocalDateTime.of(1963, 8, 13, 0, 0), false, "Folk", 0.00);
        getMusicasTotais().add(m10);
        artistaNaArray(m10.getAutoria()).getMusicas().add(m10);

        Musica m11 = new Musica("Mr. Tambourine Man", "Bob Dylan", LocalDateTime.of(1965, 3, 22, 0, 0), true, "Folk", 1.99);
        getMusicasTotais().add(m11);
        artistaNaArray(m11.getAutoria()).getMusicas().add(m11);

        Musica m12 = new Musica("The Times They Are a-Changin'", "Bob Dylan", LocalDateTime.of(1964, 1, 13, 0, 0), false, "Folk", 0.00);
        getMusicasTotais().add(m12);
        artistaNaArray(m12.getAutoria()).getMusicas().add(m12);

// Beyoncé
        Musica m13 = new Musica("Single Ladies", "Beyoncé", LocalDateTime.of(2008, 10, 13, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m13);
        artistaNaArray(m13.getAutoria()).getMusicas().add(m13);

        Musica m14 = new Musica("Halo", "Beyoncé", LocalDateTime.of(2008, 1, 20, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m14);
        artistaNaArray(m14.getAutoria()).getMusicas().add(m14);

        Musica m15 = new Musica("Crazy in Love", "Beyoncé", LocalDateTime.of(2003, 5, 18, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m15);
        artistaNaArray(m15.getAutoria()).getMusicas().add(m15);

// Beyoncé
        Musica m16 = new Musica("Formation", "Beyoncé", LocalDateTime.of(2016, 2, 6, 0, 0), false, "Hip Hop", 0.00);
        getMusicasTotais().add(m16);
        artistaNaArray(m16.getAutoria()).getMusicas().add(m16);

// Elton John
        Musica m17 = new Musica("Your Song", "Elton John", LocalDateTime.of(1970, 10, 26, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m17);
        artistaNaArray(m17.getAutoria()).getMusicas().add(m17);

        Musica m18 = new Musica("Rocket Man", "Elton John", LocalDateTime.of(1972, 4, 17, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m18);
        artistaNaArray(m18.getAutoria()).getMusicas().add(m18);

        Musica m19 = new Musica("Tiny Dancer", "Elton John", LocalDateTime.of(1971, 2, 7, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m19);
        artistaNaArray(m19.getAutoria()).getMusicas().add(m19);

        Musica m20 = new Musica("Candle in the Wind", "Elton John", LocalDateTime.of(1973, 1, 6, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m20);
        artistaNaArray(m20.getAutoria()).getMusicas().add(m20);

// Madonna
        Musica m21 = new Musica("Like a Virgin", "Madonna", LocalDateTime.of(1984, 11, 6, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m21);
        artistaNaArray(m21.getAutoria()).getMusicas().add(m21);

        Musica m22 = new Musica("Material Girl", "Madonna", LocalDateTime.of(1984, 11, 30, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m22);
        artistaNaArray(m22.getAutoria()).getMusicas().add(m22);

        Musica m23 = new Musica("Vogue", "Madonna", LocalDateTime.of(1990, 3, 20, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m23);
        artistaNaArray(m23.getAutoria()).getMusicas().add(m23);

        Musica m24 = new Musica("Frozen", "Madonna", LocalDateTime.of(1998, 2, 23, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m24);
        artistaNaArray(m24.getAutoria()).getMusicas().add(m24);

// Kanye West
        Musica m25 = new Musica("Gold Digger", "Kanye West", LocalDateTime.of(2005, 7, 5, 0, 0), true, "Hip Hop", 1.99);
        getMusicasTotais().add(m25);
        artistaNaArray(m25.getAutoria()).getMusicas().add(m25);

        Musica m26 = new Musica("Stronger", "Kanye West", LocalDateTime.of(2007, 7, 31, 0, 0), false, "Hip Hop", 0.00);
        getMusicasTotais().add(m26);
        artistaNaArray(m26.getAutoria()).getMusicas().add(m26);

        Musica m27 = new Musica("Heartless", "Kanye West", LocalDateTime.of(2008, 11, 4, 0, 0), true, "Hip Hop", 1.99);
        getMusicasTotais().add(m27);
        artistaNaArray(m27.getAutoria()).getMusicas().add(m27);

        Musica m28 = new Musica("Runaway", "Kanye West", LocalDateTime.of(2010, 9, 12, 0, 0), false, "Hip Hop", 0.00);
        getMusicasTotais().add(m28);
        artistaNaArray(m28.getAutoria()).getMusicas().add(m28);

// Taylor Swift
        Musica m29 = new Musica("Love Story", "Taylor Swift", LocalDateTime.of(2008, 9, 15, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m29);
        artistaNaArray(m29.getAutoria()).getMusicas().add(m29);

        Musica m30 = new Musica("Shake It Off", "Taylor Swift", LocalDateTime.of(2014, 8, 18, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m30);
        artistaNaArray(m30.getAutoria()).getMusicas().add(m30);

        Musica m31 = new Musica("Blank Space", "Taylor Swift", LocalDateTime.of(2014, 11, 10, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m31);
        artistaNaArray(m31.getAutoria()).getMusicas().add(m31);

        Musica m32 = new Musica("Bad Blood", "Taylor Swift", LocalDateTime.of(2015, 5, 17, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m32);
        artistaNaArray(m32.getAutoria()).getMusicas().add(m32);

// Jay-Z
        Musica m33 = new Musica("Empire State of Mind", "Jay-Z", LocalDateTime.of(2009, 10, 20, 0, 0), true, "Hip Hop", 1.99);
        getMusicasTotais().add(m33);
        artistaNaArray(m33.getAutoria()).getMusicas().add(m33);

        Musica m34 = new Musica("99 Problems", "Jay-Z", LocalDateTime.of(2003, 9, 11, 0, 0), false, "Hip Hop", 0.00);
        getMusicasTotais().add(m34);
        artistaNaArray(m34.getAutoria()).getMusicas().add(m34);

        Musica m35 = new Musica("Numb/Encore", "Jay-Z", LocalDateTime.of(2004, 11, 16, 0, 0), true, "Hip Hop", 1.99);
        getMusicasTotais().add(m35);
        artistaNaArray(m35.getAutoria()).getMusicas().add(m35);

        Musica m36 = new Musica("Run This Town", "Jay-Z", LocalDateTime.of(2009, 8, 24, 0, 0), false, "Hip Hop", 0.00);
        getMusicasTotais().add(m36);
        artistaNaArray(m36.getAutoria()).getMusicas().add(m36);

// Rihanna
        Musica m37 = new Musica("Umbrella", "Rihanna", LocalDateTime.of(2007, 3, 29, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m37);
        artistaNaArray(m37.getAutoria()).getMusicas().add(m37);

        Musica m38 = new Musica("Diamonds", "Rihanna", LocalDateTime.of(2012, 9, 27, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m38);
        artistaNaArray(m38.getAutoria()).getMusicas().add(m38);

        Musica m39 = new Musica("We Found Love", "Rihanna", LocalDateTime.of(2011, 9, 22, 0, 0), true, "Pop", 1.99);
        getMusicasTotais().add(m39);
        artistaNaArray(m39.getAutoria()).getMusicas().add(m39);

        Musica m40 = new Musica("Work", "Rihanna", LocalDateTime.of(2016, 1, 27, 0, 0), false, "Pop", 0.00);
        getMusicasTotais().add(m40);
        artistaNaArray(m40.getAutoria()).getMusicas().add(m40);*/


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
    // são  os métodos de getter de cliente específico

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
