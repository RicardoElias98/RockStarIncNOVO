package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class PainelInicial extends JPanel {
    JButton botaoLogin;
    JButton botaoRegistar;
    JLabel labelLoginOuRegistar;


    public PainelInicial() {
        // características do painel
        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);

        // elementos do painel
        // botão login
        botaoLogin = new JButton("Login");

        botaoLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoLogin)).mostrarPainel("Login");
            }
        });
        this.add(botaoLogin);

        // botão registo
        botaoRegistar = new JButton("Registar");

        botaoRegistar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoRegistar)).mostrarPainel("Registo");
        }
    });
        this.add(botaoRegistar);

        // boas vindas & imagem
        labelLoginOuRegistar = new JLabel("Bem-vindo à Rockstar Inc.");
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("/Extras/Fones.png")));
        labelLoginOuRegistar.setIcon(image);
        labelLoginOuRegistar.setFont(new Font("Arial", Font.BOLD, 30)); //adicionar fonte de texto
        add(labelLoginOuRegistar);
    }
}
