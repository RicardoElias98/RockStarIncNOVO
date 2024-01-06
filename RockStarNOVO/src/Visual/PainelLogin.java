package Visual;

import Modelo.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

// VARIOS PAINEIS QUE ESTAO NO CENTRO; TRABALHAR A PARTIR DAQUI

public class PainelLogin extends JPanel {
    private JTextField usernameLogin;
    private JPasswordField passwordLogin;
    private JCheckBox artistaOpcaoLogin;
    private JPasswordField pinArtistaLogin;
    private JButton botaoConfirmarLogin;


    public PainelLogin(Programa rockstar) {


        // características do painel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.ORANGE);
        setVisible(true);

        add(Box.createVerticalStrut(150));


        JLabel loginTitulo = new JLabel("Login");
        Font fonte = new Font(loginTitulo.getFont().getName(), Font.PLAIN, 20);
        loginTitulo.setFont(fonte);
        loginTitulo.setVisible(true);
        add(loginTitulo);
        add(Box.createVerticalStrut(50));

        //ESPAÇO PARA COLOCAR O USERNAME NO LOGIN
        usernameLogin = new JTextField();
        usernameLogin.setToolTipText("exemplo: Joaquim243");

        JLabel usernameLoginTexto = new JLabel("Username");
        JLabel passwordLoginTexto = new JLabel("password");

        usernameLogin.setMaximumSize(new Dimension(100, 30));

        //ESPAÇO PARA COLOCAR A PASSWORD NO LOGIN
        passwordLogin = new JPasswordField();
        passwordLogin.setToolTipText("Exemplo: AnimalDeEstimação + numero preferido");

        passwordLogin.setEchoChar('*');
        passwordLogin.setMaximumSize(new Dimension(100, 30));
        add(usernameLoginTexto);
        add(usernameLogin);
        add(passwordLoginTexto);
        add(passwordLogin);

        //OPÇÃO DE SER MÚSICO NO LOGN
        artistaOpcaoLogin = new JCheckBox();
        artistaOpcaoLogin.setText("Sou artista");

        artistaOpcaoLogin.setBounds(200, 430, 200, 25);

        //PIN DO MÚSICO NO LOGIN
        JLabel pinTextoLogin = new JLabel("PIN numérico");
        pinTextoLogin.setVisible(false);


        pinArtistaLogin = new JPasswordField();
        pinArtistaLogin.setPreferredSize(new Dimension(100, 30));
        pinArtistaLogin.setVisible(false);
        pinArtistaLogin.addKeyListener(new KeyListener() {
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


        JCheckBox verPasswordLogin = new JCheckBox("Ver Password");
        verPasswordLogin.setText("Ver password");
        add(verPasswordLogin);
        add(artistaOpcaoLogin);
        add(pinTextoLogin);
        add(pinArtistaLogin);


        //APARECE O PIN SE SELECIONAR A OPÇÃO DE MÚSICO E VICE-VERSA
        artistaOpcaoLogin.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtistaLogin.setVisible(true);
                pinTextoLogin.setVisible(true);
            } else {
                pinArtistaLogin.setVisible(false);
                pinTextoLogin.setVisible(false);
            }
            revalidate();
            repaint();
        });

        //OPÇÃO DE VER A PASSOWORD
        verPasswordLogin.addActionListener(e -> {
            if (verPasswordLogin.isSelected()) {   //mete a password visível ou apenas em "*"
                passwordLogin.setEchoChar('\u0000');
            } else {
                passwordLogin.setEchoChar('*');
            }
        });

        //BOTÃO CONFIRMAR O LOGIN
        botaoConfirmarLogin = new JButton();
        botaoConfirmarLogin.setText("Confirmar");
        add(botaoConfirmarLogin);

        //BOTÃO VOLTAR ATRÁS PARA DO LOGIN
        JButton botaoVoltarAtrasLogin = new JButton("Regressar");
        botaoVoltarAtrasLogin.setVisible(true);
        add(botaoVoltarAtrasLogin);
        botaoVoltarAtrasLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoVoltarAtrasLogin)).mostrarPainel("Inicial");
            }
        });


        botaoConfirmarLogin.addActionListener(e -> {
            if (artistaOpcaoLogin.isSelected()) {
                int valorPrimitivo = Integer.parseInt(new String(pinArtistaLogin.getPassword()));
                if (rockstar.login(usernameLogin.getText(), new String(passwordLogin.getPassword()), valorPrimitivo)) {

                    ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoConfirmarLogin)).mostrarPainel("Artista");
                } else {
                    JOptionPane.showMessageDialog(null, "Artista ou password/pin inválidos", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                if (rockstar.login(usernameLogin.getText(), new String(passwordLogin.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login bem-sucedido!");
                    ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoConfirmarLogin)).mostrarPainel("Cliente");
                } else {
                    JOptionPane.showMessageDialog(null, "Cliente ou Password inválidos", "Erro", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }
}
