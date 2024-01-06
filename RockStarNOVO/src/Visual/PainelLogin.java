package Visual;

import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

// VARIOS PAINEIS QUE ESTAO NO CENTRO; TRABALHAR A PARTIR DAQUI

public class PainelLogin extends JPanel {
    private JTextField usernameLogin;
    private JPasswordField passwordLogin;
    private JCheckBox artistaOpcaoLogin;
    private JPasswordField pinArtistaLogin;
    private JButton botaoConfirmarLogin;

    private Programa rockstar;

    public PainelLogin(Programa rockstar) {

        this.rockstar = rockstar;

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

        artistaOpcaoLogin.setBounds(200, 430, 200, 25);

        //PIN DO MÚSICO NO LOGIN
        JLabel pinTextoLogin = new JLabel("PIN");
        pinTextoLogin.setVisible(false);


        pinArtistaLogin = new JPasswordField();
        pinArtistaLogin.setPreferredSize(new Dimension(100, 30));
        pinArtistaLogin.setVisible(false);

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
            ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoConfirmarLogin)).mostrarPainel("Cliente");
        });


        // action listeners login (MUDAR)
        //
/*
        botaoConfirmarLogin.addActionListener(e -> {
            if (!artistaOpcaoLogin.isSelected()) {
                if ((clienteTemporarioLogin.login(usernameLogin.getText(), new String(passwordLogin.getPassword()),programa))) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + usernameLogin.getText() + "\nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                    pL.setVisible(false);
                    clienteTemporarioLogin.setUsername(usernameLogin.getText());
                    JLabel olaUsername = new JLabel();
                    olaUsername.setText("Olá, " + clienteTemporarioLogin.getUsername()+ "!");
                    painelCima.add(olaUsername);
                    painelCima.add(logout);
                    painelCliente.setVisible(true);
                    jp.setLayout(new BorderLayout());
                    jp.add(painelCliente);
                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password não encontrado/encontrada", "Ups", JOptionPane.WARNING_MESSAGE);
                }
            }
            //confirmar o Login em caso de artista
            else {

                if ((artistaTemporarioLogin.loginArtista(usernameLogin.getText(),new String(passwordLogin.getPassword()), Integer.parseInt(new String (pinArtistaLogin.getPassword())),programa))) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + usernameLogin.getText() + "\nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                    pL.setVisible(false);
                    painelCliente.setVisible(false);
                    PainelArtistaAposLogin painelArtista = new PainelArtistaAposLogin(artistaTemporarioLogin);
                    jp.add(painelArtista);
                    painelArtista.setVisible(true);

                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password não encontrado/encontrada", "Ups", JOptionPane.WARNING_MESSAGE);
                }
            } } );

 */
        /*
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridwidth = GridBagConstraints.REMAINDER;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.insets = new Insets(10, 0, 10, 0);

        add(new JLabel("Bem-vindo à Rockstar Inc."), constraints);
        utilizadorTextField = new JTextField(20);
        add(utilizadorTextField, constraints);
        passwordField = new JPasswordField(20);
        add(passwordField, constraints);

        loginButton = new JButton("Login");
        add(loginButton, constraints);

        artistaCheckBox = new JCheckBox("Sou Artista");
        add(artistaCheckBox, constraints);
        add(new JLabel("PIN (apenas para músicos):"));
        pinTextField = new JTextField(20);
        add(pinTextField);
        pinTextField.setVisible(false);
        artistaCheckBox.addActionListener(e -> pinTextField.setVisible(artistaCheckBox.isSelected()));
        // Adicionar lógica do botão de login
    }

         */


    }
}