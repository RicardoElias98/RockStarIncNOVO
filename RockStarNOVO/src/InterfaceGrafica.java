import javax.swing.*;
public class InterfaceGrafica {

    public InterfaceGrafica () {
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

        JButton botaoConfirmarLogin = new JButton();
        botaoConfirmarLogin.setText("Confirmar");
        pL.add(botaoConfirmarLogin);

        botaoConfirmarLogin.addActionListener(e -> JOptionPane.showMessageDialog(null, "Bem-vindo ******* \nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE));

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
