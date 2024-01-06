package Visual;
import Modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class PainelArtista extends JPanel {
    private Artista artista;
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

    public PainelArtista(Programa rockstar, Artista artista) {

        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);
        setVisible(true);

        artista = new Artista("Elias" , "123");
        Musica minhaMusica = new Musica("Título da Música", "Autor/Intérprete", LocalDateTime.now(), true, "Gênero", 9.99);
        artista.getMusicas().add(minhaMusica);
        rockstar.getMusicasTotais().add(minhaMusica);

        painelDeCimaFixo = new JPanel();
        iniciarPainelDeCima(artista);
        add(painelDeCimaFixo);

        painelCorrigirTitulo =new JPanel();
        iniciarPainelCorrigirTitulo(rockstar, artista);
        add(painelCorrigirTitulo);

        painelMinhasMusicas = new JPanel();
        inicarPainelMinhasMusicas(artista);
        add(painelMinhasMusicas);

        corrigirTitulo.addActionListener(e -> {
            painelCorrigirTitulo.setVisible(true);
        });

        minhasMusicas.addActionListener(e -> {
            painelMinhasMusicas.setVisible(true);
        });
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

       DefaultTableModel tabela = new DefaultTableModel();

        // Adicione suas colunas ao modelo da tabela
        tabela.addColumn("Artista");
        tabela.addColumn("Música");
        tabela.addColumn("Álbum");
        tabela.addColumn("Ano");

        JTable tabelaMusicas = new JTable(tabela);
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

        JScrollPane scrollPane2 = new JScrollPane(tabelaMusicas);
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
                }
            }
        });
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
        saldo.setText("Saldo: " + artista.getSaldo() + "€");
        painelDeCimaFixo.add(saldo);

        logout = new JButton();
        logout.setText("Logout");
        painelDeCimaFixo.add(logout);
    }
}

