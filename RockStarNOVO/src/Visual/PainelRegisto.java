package Visual;

import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PainelRegisto extends JPanel {


    JLabel registoTitulo = new JLabel("Registo");
    JLabel usernameRegistoTexto = new JLabel("Username");
    private JTextField usernameRegisto = new JTextField();
    JLabel passwordRegistoTexto = new JLabel("Password");
    private JPasswordField passwordRegisto;
    private JCheckBox artistaOpcaoRegisto;
    private JPasswordField pinArtistaRegisto;
    private JButton botaoConfirmarRegisto;
    private JButton botaoVoltarAtras;


    public PainelRegisto(Programa rockstar) {


        // características do painel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.ORANGE);
        setVisible(true);
        add(Box.createVerticalStrut(150));


        // Título
        Font fonte = new Font(registoTitulo.getFont().getName(), Font.PLAIN, 20);
        registoTitulo.setFont(fonte);
        registoTitulo.setVisible(true);
        add(registoTitulo);
        add(Box.createVerticalStrut(50));


        usernameRegisto.setToolTipText("exemplo: Joaquim243");
        usernameRegisto.setMaximumSize(new Dimension(100, 30));

        //ESPAÇO PARA COLOCAR A PASSWORD NO registo
        passwordRegisto = new JPasswordField();
        passwordRegisto.setToolTipText("Exemplo: AnimalDeEstimação + numero preferido");

        passwordRegisto.setEchoChar('*');
        passwordRegisto.setMaximumSize(new Dimension(100, 30));

        usernameRegistoTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        usernameRegisto.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordRegistoTexto.setAlignmentX(Component.CENTER_ALIGNMENT);
        passwordRegisto.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(usernameRegistoTexto);
        add(usernameRegisto);
        add(passwordRegistoTexto);
        add(passwordRegisto);

        //OPÇÃO DE SER Artista
        artistaOpcaoRegisto = new JCheckBox();
        artistaOpcaoRegisto.setText("Sou artista");

        artistaOpcaoRegisto.setBounds(200, 430, 200, 25);

        //PIN DO artista
        JLabel pinTextoLogin = new JLabel("PIN numérico");
        pinTextoLogin.setVisible(false);


        pinArtistaRegisto = new JPasswordField();
        pinArtistaRegisto.setMaximumSize(new Dimension(100, 30));
        pinArtistaRegisto.setVisible(false);
        pinArtistaRegisto.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char pin = e.getKeyChar();
                if (!Character.isDigit(pin)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });


        JCheckBox verPasswordRegisto = new JCheckBox("Ver Password");
        verPasswordRegisto.setText("Ver Password");
        add(verPasswordRegisto);
        add(artistaOpcaoRegisto);
        add(pinTextoLogin);
        add(pinArtistaRegisto);


        //BOTÃO CONFIRMAR O Registo
        botaoConfirmarRegisto = new JButton();
        botaoConfirmarRegisto.setText("Confirmar");
        add(botaoConfirmarRegisto);

        //BOTÃO VOLTAR Início
        botaoVoltarAtras = new JButton("Regressar");
        botaoVoltarAtras.setVisible(true);
        add(botaoVoltarAtras);


// listeners

        //APARECE O PIN SE SELECIONAR A OPÇÃO DE MÚSICO E VICE-VERSA
        artistaOpcaoRegisto.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtistaRegisto.setVisible(true);
                pinTextoLogin.setVisible(true);
            } else {
                pinArtistaRegisto.setVisible(false);
                pinTextoLogin.setVisible(false);
            }
            revalidate();
            repaint();
        });

        //OPÇÃO DE VER A PASSOWORD
        verPasswordRegisto.addActionListener(e -> {
            if (verPasswordRegisto.isSelected()) {   //mete a password visível ou apenas em "*"
                passwordRegisto.setEchoChar('\u0000');
            } else {
                passwordRegisto.setEchoChar('*');
            }
        });


        botaoVoltarAtras.addActionListener(e -> ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoVoltarAtras)).mostrarPainel("Inicial"));


        botaoConfirmarRegisto.addActionListener(e -> {
            if (artistaOpcaoRegisto.isSelected()) {
                int valorPrimitivo = Integer.parseInt(new String(pinArtistaRegisto.getPassword()));
                Artista novoArtista = new Artista(usernameRegisto.getText(), new String(passwordRegisto.getPassword()));

                if (novoArtista.existe(rockstar)) {
                    JOptionPane.showMessageDialog(null, "O username " + usernameRegisto.getText() + " já se encontra registado.\nEscolha outro username.", "Artista já existente", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (novoArtista.getPin() == valorPrimitivo) {
                        rockstar.getArtistas().add(novoArtista);
                        JOptionPane.showMessageDialog(null, "Conta de Artista criada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Tente novamente. Caso se tenha esquecido, contacte rockstarInc@gmail.com", "Pin necessário incorreto", JOptionPane.WARNING_MESSAGE);
                    }

                }
            } else {
                Cliente novoCliente = new Cliente(usernameRegisto.getText(), new String(passwordRegisto.getPassword()));
                if (novoCliente.existe(rockstar)) {
                    JOptionPane.showMessageDialog(null, "O username " + usernameRegisto.getText() + " já se encontra registado.\nEscolha outro username.", "Cliente já existente", JOptionPane.WARNING_MESSAGE);
                } else {
                    rockstar.getClientes().add(novoCliente);
                    JOptionPane.showMessageDialog(null, "Conta de Cliente criada com sucesso!");
                }
            }
        });
    }
}