package Visual;

import javax.swing.*;
import java.awt.*;

public class FLOWlayoutDefault extends JPanel {

    public FLOWlayoutDefault() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new FlowLayout());
        setBackground(Color.orange);
        setVisible(true);
    }
}
