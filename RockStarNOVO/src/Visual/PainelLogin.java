package Visual;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;

public class PainelLogin extends JPanel {

    public PainelLogin() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(Color.ORANGE);
        setVisible(false);
        add(Box.createVerticalStrut(150));

        JLabel loginTitulo = new JLabel();
        loginTitulo.setText("        LOGIN");   //NÃO APARECE CENTRADO SEM SER ASSIM -- IMPORTANTE!!!!!!
        Font fonte = new Font(loginTitulo.getFont().getName(), Font.PLAIN, 20);
        loginTitulo.setFont(fonte);
        loginTitulo.setVisible(true);
        add(loginTitulo);
        add(Box.createVerticalStrut(50));
    }
}