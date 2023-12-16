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






    }
}