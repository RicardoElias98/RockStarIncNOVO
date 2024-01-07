package Visual;
import Modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class PainelArtista extends JPanel {

    private JButton adicionarMusica;
    private JButton corrigirTitulo;
    private JButton alterarPreco;
    private JButton inativarMusica;
    private JButton minhasMusicas;
    private JButton verEstatisticas;

    private JButton saldo;

    private JButton logout;
    private JPanel painelDeCimaFixo;

    private JPanel painelCorrigirTitulo;

    private JPanel painelMinhasMusicas;
    private JPanel painelAdicionarMusicas;

    private JTable tabelaMusicas;

    private JScrollPane scrollPane2;
    private DefaultTableModel tabela;

    public PainelArtista(Programa rockstar, Artista artista) {

        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);
        setVisible(true);

        Musica minhaMusica = new Musica("Título da Música", "daniel", LocalDateTime.now(), true, "Gênero", 9.99);
        //artista.getMusicas().add(minhaMusica);
        //rockstar.getMusicasTotais().add(minhaMusica);

        painelDeCimaFixo = new JPanel();
        iniciarPainelDeCima(artista);
        add(painelDeCimaFixo);

        JPanel saudacaoUser = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel saudacaoLabel = new JLabel("Olá, " + artista.getUsername());
        saudacaoUser.add(saudacaoLabel);
        add(saudacaoLabel);

        painelCorrigirTitulo =new JPanel();
        iniciarPainelCorrigirTitulo(rockstar, artista);
        add(painelCorrigirTitulo);

        painelMinhasMusicas = new JPanel();
        inicarPainelMinhasMusicas(artista);
        add(painelMinhasMusicas);

        painelAdicionarMusicas = new JPanel();
        inicarPainelAdicionarMusica(artista, rockstar);
        add(painelAdicionarMusicas);

        corrigirTitulo.addActionListener(e -> {
            painelCorrigirTitulo.setVisible(true);
            painelMinhasMusicas.setVisible(false);
            painelAdicionarMusicas.setVisible(false);
        });

        minhasMusicas.addActionListener(e -> {
            painelMinhasMusicas.setVisible(true);
            painelCorrigirTitulo.setVisible(false);
            painelAdicionarMusicas.setVisible(false);
        });

        adicionarMusica.addActionListener(e -> {
            painelAdicionarMusicas.setVisible(true);
            painelMinhasMusicas.setVisible(false);
            painelCorrigirTitulo.setVisible(false);
        });
    }

    private void inicarPainelAdicionarMusica(Artista artista, Programa rockstar) {
        painelAdicionarMusicas.setLayout(new FlowLayout());
        painelAdicionarMusicas.setBackground(Color.ORANGE);
        painelAdicionarMusicas.setVisible(false);

        JTextField nomeDaMusica = new JTextField("Nome da música");
        JTextField preco = new JTextField("Preço");
        JComboBox generoBox = new JComboBox<>(new String[]{"Pop", "Rock", "Jazz","Metal","Clássica", "Hip Hop"});
        JComboBox publicaOuPrivada = new JComboBox<>(new String[]{"Pública", "Privada"});
        JButton confirmarCriacao = new JButton("Confirmar");

        painelAdicionarMusicas.add(nomeDaMusica);
        painelAdicionarMusicas.add(preco);
        painelAdicionarMusicas.add(generoBox);
        painelAdicionarMusicas.add(publicaOuPrivada);
        painelAdicionarMusicas.add(confirmarCriacao);

        String publicaOuNao1 = (String) publicaOuPrivada.getSelectedItem();
        String genero = (String) generoBox.getSelectedItem();


        confirmarCriacao.addActionListener(e -> {
            if (publicaOuNao1 != null && !nomeDaMusica.equals("") && genero != null) {
                Musica musicaCriada = new Musica(nomeDaMusica.getText(),artista.getUsername(),LocalDateTime.now(),publicaOuNao(publicaOuNao1),genero,Double.parseDouble(preco.getText()));
                System.out.println(musicaCriada + "criada com sucesso");
                rockstar.getMusicasTotais().add(musicaCriada);
                artista.getMusicas().add(musicaCriada);
            }

        });
    }

    private boolean publicaOuNao (String publicaOuPrivada) {
        if (publicaOuPrivada.equals("Pública")) {
            return true;
        } else
        return false;
    }
    private void inicarPainelMinhasMusicas (Artista artista) {
        painelMinhasMusicas.setLayout(new FlowLayout());
        painelMinhasMusicas.setBackground(Color.ORANGE);
        painelMinhasMusicas.setVisible(false);

        JButton pesquisarTodas = new JButton();
        pesquisarTodas.setText("Ver todas");
        painelMinhasMusicas.add(pesquisarTodas);


        String[] opcoes = {"Pesquisar por", "Nome da Música", "Nome do Artista"};
        JComboBox pesquisar = new JComboBox<>(opcoes);
        painelMinhasMusicas.add(pesquisar);

        String[] opcoesOrdenar = {"Ordenar por", "Nome da Música", "Nome do Artista"};
        JComboBox ordenar = new JComboBox<>(opcoesOrdenar);
        painelMinhasMusicas.add(ordenar);

        tabela = new DefaultTableModel();

        // Adicione suas colunas ao modelo da tabela
        tabela.addColumn("Artista");
        tabela.addColumn("Música");
        tabela.addColumn("Álbum");
        tabela.addColumn("Ano");

        tabelaMusicas = new JTable(tabela);
        tabelaMusicas.setDefaultEditor(Object.class, null);

        int largura2 = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaMusicas.getColumnCount(); i++) {
            tabelaMusicas.getColumnModel().getColumn(i).setPreferredWidth(largura2);
        }

        for (Musica mus : artista.getMusicas()) {
            if (mus!=null) {
                tabela.addRow(new Object[]{mus.getAutoria(),mus.getTitulo(),mus.getNomeAlbum(),mus.getData().getYear()});
            }

        }

        scrollPane2 = new JScrollPane(tabelaMusicas);
        scrollPane2.setPreferredSize(new Dimension(400, 300));
        scrollPane2.setVisible(false);

        painelMinhasMusicas.add(scrollPane2);

        pesquisarTodas.addActionListener(e -> {
            tabelaMusicas.setVisible(true);
            scrollPane2.setVisible(true);
            painelMinhasMusicas.repaint();
            painelMinhasMusicas.revalidate();
        });
    }

    private void iniciarPainelCorrigirTitulo (Programa rockstar ,Artista artista) {
        painelCorrigirTitulo.setLayout(new FlowLayout());
        painelCorrigirTitulo.setBackground(Color.ORANGE);
        painelCorrigirTitulo.setVisible(false);

        JTextField nomeDaMusica = new JTextField("Título antigo");
        JTextField novoTitulo = new JTextField("Novo título");
        JButton confirmar = new JButton("Confirmar");
        painelCorrigirTitulo.add(nomeDaMusica);
        painelCorrigirTitulo.add(novoTitulo);
        painelCorrigirTitulo.add(confirmar);

        confirmar.addActionListener(e -> {
            for (Musica mus : artista.getMusicas()) {
                if (mus.getTitulo().equals(nomeDaMusica.getText())) {
                    mus.setTitulo(novoTitulo.getText());
                    System.out.println(mus.getTitulo());

                    int rowCount = tabela.getRowCount();
                    int colCount = tabela.getColumnCount();

                    for (int row = 0; row < rowCount; row++) {
                        for (int col = 0; col < colCount; col++) {
                            Object musicaAmudar = tabela.getValueAt(row, col);
                            if (musicaAmudar != null && musicaAmudar.equals(nomeDaMusica.getText())) {
                                tabela.setValueAt(mus.getTitulo(), row, col);
                            }
                        }
                    }
                }
            }
        });;    //ALTERA MAS NÃO ALTERA NA TABELA
    }

    private void iniciarPainelDeCima (Artista artista) {
        painelDeCimaFixo.setLayout(new FlowLayout());
        painelDeCimaFixo.setBackground(Color.ORANGE);
        setVisible(true);

        adicionarMusica = new JButton();
        adicionarMusica.setText("Adicionar música");
        painelDeCimaFixo.add(adicionarMusica);

        corrigirTitulo = new JButton();
        corrigirTitulo.setText("Corrigir título");
        painelDeCimaFixo.add(corrigirTitulo);

        alterarPreco = new JButton();
        alterarPreco.setText("Alterar Preço");
        painelDeCimaFixo.add( alterarPreco);

        minhasMusicas = new JButton();
        minhasMusicas.setText("Minhas Músicas");
        painelDeCimaFixo.add(minhasMusicas);

        saldo = new JButton();
        saldo.setText(String.format("Saldo: %.2f€", artista.getSaldo()));
        painelDeCimaFixo.add(saldo);

        logout = new JButton();
        logout.setText("Logout");
        logout.addActionListener(e -> {
            ((JanelaControlo) SwingUtilities.getWindowAncestor(logout)).mostrarPainel("Inicial");
        });
        painelDeCimaFixo.add(logout);






    }
}

