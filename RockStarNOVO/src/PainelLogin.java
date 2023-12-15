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
        add(Box.createVerticalStrut(200));
    }
}