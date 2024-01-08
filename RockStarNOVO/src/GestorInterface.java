import Modelo.*;
import Visual.*;
import java.io.*;
import java.time.LocalDateTime;

public class GestorInterface {


    public GestorInterface() {

        // carrega (primeiro verifica a existência do objeto) Programa; caso este não exista, cria-o.
        Programa rockstar = carregarPrograma();
        // cria a janela inicial.
        // os vários painéis são criados a partir da classe da janelaPrincipal.
        // classe a partir de qual são apresentados todos os painéis e respetivos subpaineis, com acesso
        // à parte lógica / dados
       new JanelaControlo("Rockstar.Inc", rockstar);

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
    }
