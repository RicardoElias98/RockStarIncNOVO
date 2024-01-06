package Visual;

import Modelo.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PainelRegisto extends JPanel {
    ////////////////////

    // REVER REVER


    ///////////


    private JTextField usuarioTextField;
    private JPasswordField senhaPasswordField;
    private JCheckBox artistaCheckBox;
    private JTextField pinTextField;
    private JButton registrarButton;


    public PainelRegisto(Programa rockstar) {

      //  this.rockstar = rockstar;

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        usuarioTextField = new JTextField(20);
        senhaPasswordField = new JPasswordField(20);
        artistaCheckBox = new JCheckBox("Registar como Artista");
        pinTextField = new JTextField(20);
        registrarButton = new JButton("Registar");

        add(new JLabel("User:"));
        add(usuarioTextField);
        add(new JLabel("Senha:"));
        add(senhaPasswordField);
        add(artistaCheckBox);
        add(new JLabel("PIN (apenas para músicos):"));
        add(pinTextField);
        add(registrarButton);

        pinTextField.setVisible(false);
        artistaCheckBox.addActionListener(e -> pinTextField.setVisible(artistaCheckBox.isSelected()));
//BOTÃO VOLTAR ATRÁS PARA DO LOGIN
        JButton botaoVoltarAtrasLogin = new JButton("Regressar");
        botaoVoltarAtrasLogin.setVisible(true);
        add(botaoVoltarAtrasLogin);
        botaoVoltarAtrasLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ((JanelaControlo) SwingUtilities.getWindowAncestor(botaoVoltarAtrasLogin)).mostrarPainel("Inicial");
            }
        });
        // Adicionar lógica do botão de registro
    }
}
