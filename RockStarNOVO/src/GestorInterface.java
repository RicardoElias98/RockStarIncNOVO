import Modelo.*;
import Visual.*;

import java.io.*;

public class GestorInterface {

    // carrega ou cria instância da classe Programa com as estruturas de dados e lógica
    private Programa rockstar;

    // frame a partir de qual são apresentados todos os painéis e respetivos subpaineis, com acesso
    // à parte lógica / dados
    private JanelaControlo janelaPrincipal;

    public GestorInterface() {

        // carrega (primeiro verifica a existência do objeto) Programa; caso este não exista, cria-o.
        this.rockstar = carregarPrograma();
        // cria a janela inicial.
        // os vários painéis são criados a partir da classe da janelaPrincipal.
        this.janelaPrincipal = new JanelaControlo("Rockstar.Inc", rockstar);
    }



    private Programa carregarPrograma() {

        Programa programa = null;

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("RockstarInc.dat"));
            programa = (Programa) in.readObject();
            in.close();
            // confirmação do carregamento, pode ser utilizada msg pop up
            System.out.println("Carregado com sucesso");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            programa = new Programa();
            // confirmação da criação de um novo objeto de dados/lógica, pode ser utilizada msg pop up
            System.out.println("Programa criado");
        }
        return programa;
    }



    // este método apenas pode ser usado na classe.
    // para ser usado fora, tornar metodo publico e arranjar forma de aceder a rockstar
    // resolver situação de que se for acedido por fora, tem de já existir o ficheiro DAT

   // rever


    public void iniciar() {
        janelaPrincipal.setVisible(true);

    }
    // métodos internos da classe

    // métodos para iniciar as estruturas de dados

    // tudo o que esta pra baixo, rever
/*

    public void abrirLogin() {
        Visual.PainelLogin painelLogin = new Visual.PainelLogin(this);
        janelaPrincipal.trocarPainel(painelLogin);
    }

    public void abrirRegistro() {
        PainelRegistro painelRegistro = new PainelRegistro(this);
        janelaPrincipal.trocarPainel(painelRegistro);
    }

    public void loginRealizado(Utilizador utilizador) {
        if (utilizador instanceof Cliente) {
            Visual.PainelCliente painelCliente = new Visual.PainelCliente((Cliente) utilizador);
            janelaPrincipal.trocarPainel(painelCliente);
        } else if (utilizador instanceof Artista) {
            Visual.PainelArtista painelArtista = new Visual.PainelArtista((Artista) utilizador);
            janelaPrincipal.trocarPainel(painelArtista);
        }
    }

 */
}
