import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;

public class InterfaceGrafica {

    public InterfaceGrafica () {

        Programa programa = new Programa(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());  //PARA TESTE
        JanelaPrincipal jp = new JanelaPrincipal("RockStar. Inc");
        PainelBotoesLoginRegistar pn = new PainelBotoesLoginRegistar();
        PainelLogin pL = new PainelLogin();
        PainelRegisto pR = new PainelRegisto();
        PainelCllienteAposLogin painelCliente = new PainelCllienteAposLogin();
        JButton minhasMusicasCliente = new JButton();
        minhasMusicasCliente.setText("Minhas Músicas");
        JButton minhasPlaylistsCliente = new JButton();
        minhasPlaylistsCliente.setText("Minhas Playlists");
        JButton pesquisarMusicas = new JButton();
        pesquisarMusicas.setText("Pesquisar Músicas");
        JButton pesquisarPlaylist = new JButton();
        pesquisarPlaylist.setText("Pesquisar Playlists");
        JButton saldo = new JButton();
        saldo.setText("Saldo");
        JButton cestoDeCompras = new JButton();
        cestoDeCompras.setText("Compras pendentes");

        painelCliente.add(minhasMusicasCliente);
        painelCliente.add(minhasPlaylistsCliente);
        painelCliente.add(pesquisarMusicas);
        painelCliente.add(pesquisarPlaylist);
        painelCliente.add(saldo);
        painelCliente.add(cestoDeCompras);

        JButton logout = new JButton();
        logout.setText("Logout");




        minhasMusicasCliente.addActionListener(e -> minhasMusicasCliente.setForeground(Color.BLUE)); //meter sempre os outros a preto ao mesmo tempo para não ficar azul após carregar noutro

        jp.add(pn);
        jp.add(pL);
        jp.add(pR);
        jp.add(painelCliente);

        JButton botaoLogin = new JButton();
        botaoLogin.setText("Login");
        pn.add(botaoLogin);

        //PARA TESTE
        Cliente clienteTemporarioParaTeste = new Cliente("Ricardo","123",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        programa.getClientes().add(clienteTemporarioParaTeste);
        Artista artistaTemporarioParaTeste = new Artista("Ricardo","1234",0, 123,new ArrayList<>(),new ArrayList<>());
        programa.getArtistas().add(artistaTemporarioParaTeste);
        //PARA TESTE

        Cliente clienteTemporarioLogin = new Cliente("","",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        Artista artistaTemporarioLogin = new Artista("","",0, -1,new ArrayList<>(),new ArrayList<>());

        Cliente clienteTemporarioRegisto = new Cliente("","",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        Artista artistaTemporarioRegisto = new Artista("", "", 0,-1,new ArrayList<>(),new ArrayList<>());


        JTextField usernameLogin = new JTextField();
        usernameLogin.setToolTipText("exemplo: Joaquim243");


        JLabel usernameLoginTexto = new JLabel("Username");
        JLabel passwordLoginTexto = new JLabel("password");

        usernameLogin.setPreferredSize(new Dimension(100, 30));
        JPasswordField passwordLogin = new JPasswordField();
        passwordLogin.setToolTipText("Exemplo: AnimalDeEstimação + numero preferido");

        passwordLogin.setEchoChar('*');
        passwordLogin.setPreferredSize(new Dimension(100, 30));
        pL.add(usernameLoginTexto);
        pL.add(usernameLogin);
        pL.add(passwordLoginTexto);
        pL.add(passwordLogin);

        JCheckBox artistaOpcaoLogin = new JCheckBox();

        artistaOpcaoLogin.setBounds(200, 430, 200, 25);
        artistaOpcaoLogin.setText("Sou Músico");


        JLabel pinTextoLogin = new JLabel("PIN");
        pinTextoLogin.setVisible(false);


        JPasswordField pinArtistaLogin = new JPasswordField();
        pinArtistaLogin.setPreferredSize(new Dimension(100, 30));
        pinArtistaLogin.setVisible(false);

        JCheckBox verPasswordLogin = new JCheckBox();
        verPasswordLogin.setText("Ver password");
        pL.add(verPasswordLogin);
        pL.add(artistaOpcaoLogin);
        pL.add(pinTextoLogin);
        pL.add(pinArtistaLogin);


        artistaOpcaoLogin.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtistaLogin.setVisible(true);
                pinTextoLogin.setVisible(true);
            } else {
                pinArtistaLogin.setVisible(false);
                pinTextoLogin.setVisible(false);
            }
            pL.revalidate();
            pL.repaint();
        });

        verPasswordLogin.addActionListener(e -> {
            if (verPasswordLogin.isSelected()) {   //mete a password visível ou apenas em "*"
                passwordLogin.setEchoChar('\u0000');
            } else {
                passwordLogin.setEchoChar('*');
            }
        });

        JButton botaoConfirmarLogin = new JButton();
        botaoConfirmarLogin.setText("Confirmar");
        pL.add(botaoConfirmarLogin);

        //CONFIRMAÇÃO DE LOGIN
        //confirmar o Login em caso de cliente
        botaoConfirmarLogin.addActionListener(e -> {
        if (!artistaOpcaoLogin.isSelected()) {
                if ((clienteTemporarioLogin.login(usernameLogin.getText(), new String(passwordLogin.getPassword()),programa))) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + usernameLogin.getText() + "\nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                    pL.setVisible(false);
                    clienteTemporarioLogin.setUsername(usernameLogin.getText());
                    JLabel olaUsername = new JLabel();
                    olaUsername.setText("Olá, " + clienteTemporarioLogin.getUsername()+ "!");
                    painelCliente.add(olaUsername);
                    painelCliente.add(logout);
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
                    painelCliente.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password não encontrado/encontrada", "Ups", JOptionPane.WARNING_MESSAGE);
                }
            } } );




        JTextField username = new JTextField();
        username.setToolTipText("Exemplo: Joaquim354");

        JLabel usernameTexto = new JLabel("Username");
        JLabel passwordTexto = new JLabel("password");

        username.setPreferredSize(new Dimension(100,30));
        JPasswordField password = new JPasswordField();
        password.setToolTipText("Exemplo: ClubePreferido + AnoDeNascimento");
        password.setEchoChar('*');
        password.setPreferredSize(new Dimension(100,30));
        pR.add(usernameTexto);
        pR.add(username);
        pR.add(passwordTexto);
        pR.add(password);

        JCheckBox verPassword = new JCheckBox();
        verPassword.setText("Ver password");
        pR.add(verPassword);

        verPassword.addActionListener(e -> {if (verPassword.isSelected()){   //mete a password visível ou apenas em "*"
            password.setEchoChar('\u0000');
        } else {
            password.setEchoChar('*');
        }
        });

        JCheckBox artistaOpcao = new JCheckBox();

        artistaOpcao.setBounds(200, 430, 200, 25);
        artistaOpcao.setText("Sou Músico");
        pR.add(artistaOpcao);

        JLabel pinTexto = new JLabel("PIN");
        pR.add(pinTexto);
        pinTexto.setVisible(false);

        JPasswordField pinArtista = new JPasswordField();
        pinArtista.setText("Pin");
        pinArtista.setPreferredSize(new Dimension(100,30));
        pinArtista.setVisible(false);
        pR.add(pinArtista);

        artistaOpcao.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtista.setVisible(true);
                pinTexto.setVisible(true);
            } else {pinArtista.setVisible(false);
                pinTexto.setVisible(false);
            }
            pR.revalidate();
            pR.repaint();
        });

        JButton botaoRegistar = new JButton();
        botaoRegistar.setText("Registar");
        pn.add(botaoRegistar);


        botaoLogin.addActionListener(e -> pn.setVisible(false));
        botaoLogin.addActionListener(e -> pL.setVisible(true));
        botaoRegistar.addActionListener(e -> pn.setVisible(false));
        botaoRegistar.addActionListener(e -> pR.setVisible(true));


        JButton botaoVoltarAtrasLogin = new JButton();
        botaoVoltarAtrasLogin.setText(("Regressar"));
        botaoVoltarAtrasLogin.setVisible(true);

        pL.add(botaoVoltarAtrasLogin);

        botaoVoltarAtrasLogin.addActionListener(e -> pL.setVisible(false));
        botaoVoltarAtrasLogin.addActionListener(e -> pn.setVisible(true));

        JButton botaoVoltarAtrasRegisto = new JButton();
        botaoVoltarAtrasRegisto.setText(("Regressar"));
        botaoVoltarAtrasRegisto.setVisible(true);

        JButton botaoConfirmar = new JButton();
        botaoConfirmar.setText("Confirmar");
        pR.add(botaoConfirmar);
        pR.add(botaoVoltarAtrasRegisto);


        botaoVoltarAtrasRegisto.addActionListener(e -> pR.setVisible(false));
        botaoVoltarAtrasRegisto.addActionListener(e -> pn.setVisible(true));

        //CONFIRMAÇÃO DO REGISTO
        //confirmação do registo em caso de cliente
        botaoConfirmar.addActionListener(e -> {
            if (!artistaOpcao.isSelected()) {
                if (clienteTemporarioRegisto.registar(username.getText(),programa)){
                JOptionPane.showMessageDialog(null,"Foi registado com sucesso. \nQue tenha ótimos momentos connosco","Parabéns", JOptionPane.INFORMATION_MESSAGE);
                pR.setVisible(false);
                pL.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username já existente", "Ups", JOptionPane.WARNING_MESSAGE);
                }
                }
            //confirmação do registo em caso de artista
        else {
            if (artistaTemporarioRegisto.registarArtista(username.getText(),programa)){
                JOptionPane.showMessageDialog(null,"Foi registado com sucesso. \nQue tenha ótimos momentos connosco","Parabéns", JOptionPane.INFORMATION_MESSAGE);
                pR.setVisible(false);
                pL.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Username já existente.", "Ups", JOptionPane.WARNING_MESSAGE);
            }
        }
        });
















        jp.pack();
        jp.setLocationRelativeTo(null);
    }


}
