import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.Arrays;

public class InterfaceGrafica {

    public InterfaceGrafica () {

        Programa programa = new Programa(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());  //PARA TESTE
        JanelaPrincipal jp = new JanelaPrincipal("RockStar. Inc");
        PainelBotoesLoginRegistar pn = new PainelBotoesLoginRegistar();
        PainelLogin pL = new PainelLogin();
        PainelRegisto pR = new PainelRegisto();
        jp.add(pn);

        jp.add(pL);
        jp.add(pR);

        JButton botaoLogin = new JButton();
        botaoLogin.setText("Login");
        pn.add(botaoLogin);

        //PARA TESTE
        Cliente clienteTemporarioParaTeste = new Cliente("Ricardo","123",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        programa.getClientes().add(clienteTemporarioParaTeste);
        //PARA TESTE

        Cliente clienteTemporario = new Cliente("","",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());


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
        pinArtistaLogin.setText("Pin");
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

        botaoConfirmarLogin.addActionListener(e -> {
            if ((clienteTemporario.login(usernameLogin.getText(), new String(passwordLogin.getPassword()),programa)) == true) {
                JOptionPane.showMessageDialog(null, "Bem-vindo " + usernameLogin.getText() + "\nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Username/Password não encontrado/encontrada", "Ups", JOptionPane.WARNING_MESSAGE);
            }
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

        botaoConfirmar.addActionListener(e ->  JOptionPane.showMessageDialog(null,"Foi registado com sucesso. \nQue tenha ótimos momentos connosco","Parabéns", JOptionPane.INFORMATION_MESSAGE));

        jp.pack();
        jp.setLocationRelativeTo(null);
    }


}
