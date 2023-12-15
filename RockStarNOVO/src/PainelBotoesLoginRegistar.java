import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class PainelBotoesLoginRegistar extends JPanel {

    public PainelBotoesLoginRegistar() {
        initComponents();
    }

    private void initComponents() {
        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);

        JLabel labelLoginOuRegistar = new JLabel();  //cria um label
        labelLoginOuRegistar.setText("Bem-vindo à Rockstar Inc.");  //escreve no label
        ImageIcon image = new ImageIcon(Objects.requireNonNull(getClass().getResource("Extras/Fones.png")));  //cria a imagem //só funcionou assim, mas porquê?
        labelLoginOuRegistar.setIcon(image);
        labelLoginOuRegistar.setFont(new Font("Arial", Font.BOLD, 30)); //adicionar fonte de texto
        add(labelLoginOuRegistar);


    }
}
