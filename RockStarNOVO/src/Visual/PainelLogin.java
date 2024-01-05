package Visual;

import Modelo.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;

// VARIOS PAINEIS QUE ESTAO NO CENTRO; TRABALHAR A PARTIR DAQUI

public class PainelLogin extends JPanel {
    private JTextField utilizadorTextField;
    private JPasswordField passwordField;
    private JCheckBox artistaCheckBox;
    private JTextField pinTextField;
    private JButton loginButton;
    private Programa rockstar;



    /*  public Visual.PainelLogin() {
          // características do painel
          setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
          setBackground(Color.ORANGE);
          setVisible(false);

          // Painel para o título
          JPanel tituloPanel = new JPanel();
          tituloPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
          JLabel loginTitulo = new JLabel("LOGIN");
          loginTitulo.setFont(new Font(loginTitulo.getFont().getName(), Font.PLAIN, 20));
          tituloPanel.add(loginTitulo);
          add(tituloPanel);

          // Painel para o campo de username
          JPanel usernamePanel = new JPanel();
          usernamePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
          utilizadorTextField = new JTextField(20); // Tamanho do campo
          usernamePanel.add(utilizadorTextField);
          add(usernamePanel);

          // Painel para o campo de password
          JPanel passwordPanel = new JPanel();
          passwordPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
          passwordField = new JPasswordField(20); // Tamanho do campo
          passwordPanel.add(passwordField);
          add(passwordPanel);

          // Painel para o checkbox de artista
          JPanel artistaPanel = new JPanel();
          artistaPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
          artistaCheckBox = new JCheckBox("Artista");
          artistaPanel.add(artistaCheckBox);
          add(artistaPanel);

          // Painel para o campo de PIN
          JPanel pinPanel = new JPanel();
          pinPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
          pinTextField = new JTextField(20); // Tamanho do campo
          pinPanel.add(pinTextField);
          add(pinPanel);

          // Painel para o botão de login
          JPanel loginButtonPanel = new JPanel();
          loginButtonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
          loginButton = new JButton("Login");
          loginButtonPanel.add(loginButton);
          add(loginButtonPanel);
      }
  }

*/
    public PainelLogin(Programa rockstar) {

        this.rockstar = rockstar;

        // características do painel
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.ORANGE);
        setVisible(true);
        this.add(Box.createVerticalStrut(150));

        JLabel loginTitulo = new JLabel();
        loginTitulo.setText("        LOGIN");   //NÃO APARECE CENTRADO SEM SER ASSIM -- IMPORTANTE!!!!!!
        Font fonte = new Font(loginTitulo.getFont().getName(), Font.PLAIN, 20);
        loginTitulo.setFont(fonte);
        loginTitulo.setVisible(true);
        add(loginTitulo);
        add(Box.createVerticalStrut(50));

        //ESPAÇO PARA COLOCAR O USERNAME NO LOGIN
        JTextField usernameLogin = new JTextField();
        usernameLogin.setToolTipText("exemplo: Joaquim243");

        JLabel usernameLoginTexto = new JLabel("Username");
        JLabel passwordLoginTexto = new JLabel("password");

        usernameLogin.setPreferredSize(new Dimension(100, 30));

        //ESPAÇO PARA COLOCAR A PASSWORD NO LOGIN
        JPasswordField passwordLogin = new JPasswordField();
        passwordLogin.setToolTipText("Exemplo: AnimalDeEstimação + numero preferido");

        passwordLogin.setEchoChar('*');
        passwordLogin.setPreferredSize(new Dimension(100, 30));
        add(usernameLoginTexto);
        add(usernameLogin);
        add(passwordLoginTexto);
        add(passwordLogin);

        //OPÇÃO DE SER MÚSICO NO LOGN
        JCheckBox artistaOpcaoLogin = new JCheckBox();

        artistaOpcaoLogin.setBounds(200, 430, 200, 25);
        artistaOpcaoLogin.setText("Sou Músico");

        //PIN DO MÚSICO NO LOGIN
        JLabel pinTextoLogin = new JLabel("PIN");
        pinTextoLogin.setVisible(false);


        JPasswordField pinArtistaLogin = new JPasswordField();
        pinArtistaLogin.setPreferredSize(new Dimension(100, 30));
        pinArtistaLogin.setVisible(false);

        JCheckBox verPasswordLogin = new JCheckBox();
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
        JButton botaoConfirmarLogin = new JButton();
        botaoConfirmarLogin.setText("Confirmar");
        add(botaoConfirmarLogin);

        //BOTÃO VOLTAR ATRÁS PARA DO LOGIN
        JButton botaoVoltarAtrasLogin = new JButton();
        botaoVoltarAtrasLogin.setText(("Regressar"));
        botaoVoltarAtrasLogin.setVisible(true);

        add(botaoVoltarAtrasLogin);
        botaoVoltarAtrasLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoVoltarAtrasLogin)).mostrarPainel("Inicial");
            }
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