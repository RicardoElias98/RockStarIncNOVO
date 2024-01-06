package Visual;


import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class JanelaControlo extends JFrame {
    // ATRIBUTOS
    // componentes gráficos
    private PainelInicial visaoInicial;
    private PainelLogin visaoLogin;
    private PainelRegisto visaoRegisto;
    private PainelCliente visaoCliente;
    private PainelArtista visaoArtista;
    private CardLayout cardLayout;


    // ACESSO aos dados e lógica através da passagem da classe Programa como parâmetro


    public JanelaControlo(String title, Programa rockstar) throws HeadlessException {
        super(title);
        // Iniciar  painéis
        visaoInicial = new PainelInicial();
        visaoRegisto = new PainelRegisto(rockstar);
        visaoLogin = new PainelLogin(rockstar);
        Cliente C = new Cliente("","");
        Artista A = new Artista("","", 123);
        visaoCliente = new PainelCliente(rockstar, C);
        visaoArtista = new PainelArtista(rockstar, A);

        // Configuração do CardLayout
        cardLayout = new CardLayout();
        getContentPane().setLayout(cardLayout);

        // Adicionar painéis ao CardLayout
        add(visaoInicial, "Inicial");
        add(visaoRegisto, "Registo");
        add(visaoLogin, "Login");
        add(visaoCliente, "Cliente");
        add(visaoArtista, "Artista");

        // Configurações da janela
        setResizable(true);
        // caso queira definir tamanho
        // setSize(1100, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //adicionar listener para salvar ficheiro programa quando fecha a janela
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                rockstar.salvarDados();
            }
        });

        getContentPane().setBackground(Color.ORANGE);
        setVisible(true);
        this.pack();
        this.setLocationRelativeTo(null);


    }

    // Método para alternar entre painéis
    public void mostrarPainel (String nomePainel) {
        cardLayout.show(getContentPane(), nomePainel);
    }

}


