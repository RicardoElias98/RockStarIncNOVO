import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class PainelRegisto extends JPanel {

    public PainelRegisto() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.ORANGE);
        setVisible(false);

        add(Box.createVerticalStrut(200));
        JTextField username = new JTextField();
        username.setToolTipText("Exemplo: Joaquim354");

        JLabel usernameTexto = new JLabel("Username");
        JLabel passwordTexto = new JLabel("password");

        username.setPreferredSize(new Dimension(100,30));
        JPasswordField password = new JPasswordField();
        password.setToolTipText("Exemplo: ClubePreferido + AnoDeNascimento");
        password.setEchoChar('*');
        password.setPreferredSize(new Dimension(100,30));
        add(usernameTexto);
        add(username);
        add(passwordTexto);
        add(password);

        JCheckBox verPassword = new JCheckBox();
        verPassword.setText("Ver password");
        add(verPassword);

        verPassword.addActionListener(e -> {if (verPassword.isSelected()){   //mete a password visível ou apenas em "*"
            password.setEchoChar('\u0000');
        } else {
            password.setEchoChar('*');
        }
        });

        JCheckBox artistaOpcao = new JCheckBox();

        artistaOpcao.setBounds(200, 430, 200, 25);
        artistaOpcao.setText("Sou Músico");
        add(artistaOpcao);

        JLabel pinTexto = new JLabel("PIN");
        add(pinTexto);
        pinTexto.setVisible(false);

        JPasswordField pinArtista = new JPasswordField();
        pinArtista.setText("Pin");
        pinArtista.setPreferredSize(new Dimension(100,30));
        pinArtista.setVisible(false);
        add(pinArtista);

        artistaOpcao.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtista.setVisible(true);
                pinTexto.setVisible(true);
            } else {pinArtista.setVisible(false);
                pinTexto.setVisible(false);
            }
            revalidate();
            repaint();
        });



    }
}