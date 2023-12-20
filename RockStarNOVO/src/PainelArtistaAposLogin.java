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
        FLOWlayoutDefault painelCima = new FLOWlayoutDefault();


// erro get nome artista
        JLabel olaUsername = new JLabel();
       olaUsername.setText("Olá, " +  "artista.getUsername()" + "!");
        JButton logout = new JButton();
        logout.setText("Logout");

        painelCima.add(olaUsername);
        painelCima.add(logout);
        JButton minhasMusicasArtista = new JButton();
        minhasMusicasArtista.setText("Minhas Músicas");
        JButton adicionarMusicas = new JButton();
        adicionarMusicas.setText("Adicionar Músicas");
        JButton estatisticas = new JButton();
        estatisticas.setText("Estatísticas");


        painelCima.add(minhasMusicasArtista);
        painelCima.add(adicionarMusicas);
        painelCima.add(estatisticas);

    }
}
