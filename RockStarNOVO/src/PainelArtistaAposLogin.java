import javax.swing.*;
import java.awt.*;

public class PainelArtistaAposLogin extends JPanel {


    public PainelArtistaAposLogin(Artista artista) {
        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.ORANGE);
        setVisible(true);
        PainelMinhasMusicas minhasMusicas = new PainelMinhasMusicas();

    }
}
