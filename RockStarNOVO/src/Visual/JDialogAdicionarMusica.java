package Visual;
import Modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
public class JDialogAdicionarMusica  extends JDialog {
    private JTextField tituloField;
    private JTextField autoriaField;
    private JTextField dataField;
    private JTextField precoField;
    private JComboBox<String> generoBox;
    private JRadioButton publicaRadio;
    private JRadioButton privadaRadio;
    private JButton okButton;
    private JButton cancelButton;

    public JDialogAdicionarMusica(Frame parent) {
        super(parent, "Adicionar Música", true);

        // Layout
        setBackground(Color.ORANGE);
        setLayout(new GridLayout(0, 2));
        // Componentes
        tituloField = new JTextField();
        autoriaField = new JTextField();
        dataField = new JTextField();
        precoField = new JTextField();
        generoBox = new JComboBox<>(new String[]{"Pop", "Rock", "Jazz","Metal","Clássica", "Hip Hop","Ambient"});
        publicaRadio = new JRadioButton("Pública");
        privadaRadio = new JRadioButton("Privada");
        ButtonGroup group = new ButtonGroup();
        group.add(publicaRadio);
        group.add(privadaRadio);
        publicaRadio.setSelected(true);
        okButton = new JButton("OK");
        cancelButton = new JButton("Cancelar");
        // Adiciona componentes
        add(new JLabel("Título:"));
        add(tituloField);
        add(new JLabel("Autoria:"));
        add(autoriaField);
        add(new JLabel("Data (yyyy-mm-ddThh:mm):"));
        add(dataField);
        add(new JLabel("Género:"));
        add(generoBox);
        add(new JLabel("Preço:"));
        add(precoField);
        add(new JLabel("Adicionar à Playlist:"));
        add(publicaRadio);
        add(new JLabel(""));
        add(privadaRadio);
        add(okButton);
        add(cancelButton);
        // Listeners
        okButton.addActionListener(e -> okButtonClicked());
        cancelButton.addActionListener(e -> setVisible(false));
        setSize(400, 300);
        setResizable(false);
        setLocationRelativeTo(parent);
    }

    private void okButtonClicked() {
        try {
            String titulo = tituloField.getText();
            String autoria = autoriaField.getText();
            LocalDateTime data = LocalDateTime.parse(dataField.getText(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
            String genero = (String) generoBox.getSelectedItem();
            double preco = Double.parseDouble(precoField.getText());
            boolean adicionarAPlaylist = publicaRadio.isSelected();

            Musica musica = new Musica(titulo, autoria, data, adicionarAPlaylist, genero, preco);
            // Aqui você pode fazer algo com o objeto 'musica' criado

            setVisible(false);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao criar a música: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

}

    // o action listener de adicionar musica vai disparar isto
    // pede os dados que vao ser usados pelo construtor musica, e adiciona a lista de musicas do artista
    // a opçao de adicionar album vai mostrar a opçao de adicionar so aos que foram criados

