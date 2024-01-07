package Visual;
import Modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.ClientInfoStatus;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;

public class PainelCliente extends JPanel {


    private JButton musicasDoSistema;
    private JButton minhasMusicas;
    private JButton minhasPlaylists;
    private JButton saldo;
    private JButton comprasPendentes;
    private JButton logout;
    private JPanel painelDeCimaFixo;
    private JPanel painelMinhasMusicas;
    private JButton pesquisarTodas;
    private JComboBox pesquisar;
    private JComboBox ordenar;
    private JTextField nomeDaMusicaPesquisa;
    private JScrollPane scrollPane2;
    private DefaultTableModel tabela;
    private JTable tabelaMusicas;
    private JPanel painelPlayList;
    private JButton criarPlaylist;
    private JButton criarPlaylistRandom;
    private  JButton verMinhasPL;
    private JPanel painelCarrinho;
    private JPanel painelMusicasSistema;

    private JPanel painelSaldo;





    public PainelCliente(Programa rockstar, Cliente cliente) {

        //PAINEL DO OLÁ

        JPanel saudacaoUser = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel saudacaoLabel = new JLabel("Olá, " + cliente.getUsername());
        saudacaoUser.add(saudacaoLabel);
        add(saudacaoLabel);
        Musica minhaMusica = new Musica("Título da Música", "Autor/Intérprete", LocalDateTime.now(), true, "Gênero", 9.99);
        //Playlist minhaPlaylist = new Playlist("Nome da Playlist", new ArrayList<>(), true, "Descrição da Playlist");
        cliente.getAquisicoes().add(minhaMusica);
        //cliente.getPlaylist().add(minhaPlaylist);

        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);
        setVisible(true);

        painelDeCimaFixo = new JPanel();
        iniciarPainelDeCima(cliente);
        add(painelDeCimaFixo);

        painelMinhasMusicas = new JPanel();
        iniciarPainelMinhasMusicas(cliente);
        add(painelMinhasMusicas);

        painelPlayList = new JPanel();
        inicarPainelPlaylist(cliente);
        add(painelPlayList);

        painelCarrinho = new JPanel();
        iniciarPainelCarrinho();
        add(painelCarrinho);

        painelMusicasSistema = new JPanel();
        iniciarPainelMusicasSistema(cliente);
        add(painelMusicasSistema);

        painelSaldo = new JPanel();
        inicarPainelSaldo(cliente);
        add(painelSaldo);

        minhasPlaylists.addActionListener(e -> {
            painelPlayList.setVisible(true);
            painelMinhasMusicas.setVisible(false);
            painelCarrinho.setVisible(false);
            painelMusicasSistema.setVisible(false);
            painelSaldo.setVisible(false);
        });

        minhasMusicas.addActionListener(e -> {
            painelMinhasMusicas.setVisible(true);
            painelPlayList.setVisible(false);
            painelCarrinho.setVisible(false);
            painelMusicasSistema.setVisible(false);
            painelSaldo.setVisible(false);
        });

        comprasPendentes.addActionListener(e -> {
            painelCarrinho.setVisible(true);
            painelMinhasMusicas.setVisible(false);
            painelPlayList.setVisible(false);
            painelMusicasSistema.setVisible(false);
            painelSaldo.setVisible(false);
        });

        musicasDoSistema.addActionListener(e -> {
            painelMusicasSistema.setVisible(true);
            painelCarrinho.setVisible(false);
            painelMinhasMusicas.setVisible(false);
            painelPlayList.setVisible(false);
            painelSaldo.setVisible(false);
        });

        saldo.addActionListener(e -> {
            painelSaldo.setVisible(true);
            painelMusicasSistema.setVisible(false);
            painelCarrinho.setVisible(false);
            painelMinhasMusicas.setVisible(false);
            painelPlayList.setVisible(false);
        });

    }

    private void inicarPainelSaldo(Cliente cliente) {
        painelSaldo.setLayout(new FlowLayout());
        painelSaldo.setBackground(Color.ORANGE);
        painelSaldo.setVisible(false);

        JTextField valorAadicionar = new JTextField();
        valorAadicionar.setText("valor");
        painelSaldo.add(valorAadicionar);

        JButton inserirValor = new JButton();
        inserirValor.setText("Confirmar");
        painelSaldo.add(inserirValor);

        inserirValor.addActionListener(e -> {
            double valor = Double.parseDouble(valorAadicionar.getText());
            if (valor >= 0) { cliente.setSaldo(cliente.getSaldo() + valor);
                saldo.setText("Saldo: " + cliente.getSaldo() + "€");
            }
        });
    }
    private void iniciarPainelMusicasSistema(Cliente cliente){
        painelMusicasSistema.setLayout(new FlowLayout());
        painelMusicasSistema.setBackground(Color.ORANGE);
        painelMusicasSistema.setVisible(false);

        DefaultTableModel tabela2 = new DefaultTableModel();

        // Adicione suas colunas ao modelo da tabela
        tabela2.addColumn("Artista");
        tabela2.addColumn("Música");
        tabela2.addColumn("Álbum");
        tabela2.addColumn("Ano");
        tabela2.addColumn("Preço");


        JTable tabelaMusicasSistema = new JTable(tabela2);
        tabelaMusicasSistema.setDefaultEditor(Object.class, null);

        int largura3 = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaMusicasSistema.getColumnCount(); i++) {
            tabelaMusicasSistema.getColumnModel().getColumn(i).setPreferredWidth(largura3);
        }

        JScrollPane scrollPane3 = new JScrollPane(tabelaMusicasSistema);
        scrollPane3.setPreferredSize(new Dimension(400, 300));
        scrollPane3.setVisible(true);

        painelMusicasSistema.add(scrollPane3, BorderLayout.CENTER);
    }

    private void iniciarPainelCarrinho() {
        painelCarrinho.setLayout(new FlowLayout());
        painelCarrinho.setBackground(Color.ORANGE);
        painelCarrinho.setVisible(false);

        DefaultTableModel tabelaCesto = new DefaultTableModel();

        // Adicionar colunas ao modelo da tabela
        tabelaCesto.addColumn("Nome");
        tabelaCesto.addColumn("Preço");

        JTable tabelaCestoCompras = new JTable(tabelaCesto);
        tabelaCestoCompras.setDefaultEditor(Object.class, null);

        JScrollPane scrollPaneCesto = new JScrollPane(tabelaCestoCompras);
        scrollPaneCesto.setPreferredSize(new Dimension(800, 300));
        scrollPaneCesto.setVisible(true);
        painelCarrinho.add(scrollPaneCesto);

        JButton confirmarCompra = new JButton();
        confirmarCompra.setText("Comprar");
        painelCarrinho.add(confirmarCompra);
    }


    private void inicarPainelPlaylist (Cliente cliente) {
        painelPlayList.setLayout(new FlowLayout());
        painelPlayList.setBackground(Color.ORANGE);
        painelPlayList.setVisible(false);

        verMinhasPL = new JButton();
        verMinhasPL.setText("Ver minhas");
        painelPlayList.add(verMinhasPL);

        criarPlaylist = new JButton();
        criarPlaylist.setText("Criar playlist");
        painelPlayList.add(criarPlaylist);

        criarPlaylistRandom = new JButton();
        criarPlaylistRandom.setText("Criar playlist aleatória");
        painelPlayList.add(criarPlaylistRandom);

        //Playlist playlistNova = cliente.criarPlaylist();
        JTextField nome = new JTextField();
        nome.setText("Nome");
        nome.setPreferredSize(new Dimension(200, 30));
        JTextField visibilidade = new JTextField();
        visibilidade.setText("Sim/Não");
        JTextField descricao = new JTextField();
        descricao.setText("Descrição");
        JButton confirmarplNova = new JButton();
        confirmarplNova.setText("Confirmar");


        JPanel painelPlaylistVazia = new JPanel();
        painelPlaylistVazia.setLayout(new BoxLayout(painelPlaylistVazia, BoxLayout.Y_AXIS));
        painelPlaylistVazia.add(nome);
        painelPlaylistVazia.add(visibilidade);
        painelPlaylistVazia.add(descricao);
        painelPlaylistVazia.add(confirmarplNova);
        painelPlaylistVazia.setVisible(false);
        painelPlayList.add(painelPlaylistVazia);

        DefaultTableModel tabelaPlaylist = new DefaultTableModel();

        JTable tabelaPlaylists = new JTable(tabelaPlaylist);
        tabelaPlaylists.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaPlaylists);
        scrollPane.setPreferredSize(new Dimension(800, 300));
        scrollPane.setVisible(false);
        painelPlayList.add(scrollPane, BorderLayout.CENTER);

        verMinhasPL.addActionListener(e -> {
            scrollPane.setVisible(true);
        });

        criarPlaylist.addActionListener(e -> {
            scrollPane.setVisible(false);
            painelPlaylistVazia.setVisible(true);
            confirmarplNova.addActionListener(e1 -> {
               // playlistNova.setNome(nome.getText());
               // playlistNova.atribuirVisibilidade(visibilidade.getText());
               // playlistNova.setDescricao(descricao.getText());
               // cliente.getPlaylist().add(playlistNova);
                //tabelaPlaylist.addRow(new Object[]{playlistNova.getNome(),playlistNova.getMusicas().lengt,playlistNova.isVisibilidade(),playlistNova.getDescricao()});
            });
        });
    }

    private void iniciarPainelMinhasMusicas (Cliente cliente) {
        painelMinhasMusicas.setLayout(new FlowLayout());
        painelMinhasMusicas.setBackground(Color.ORANGE);
        painelMinhasMusicas.setVisible(false);

        // painel do olá

        pesquisarTodas = new JButton();
        pesquisarTodas.setText("Ver todas");
        painelMinhasMusicas.add(pesquisarTodas);


        String[] opcoes = {"Pesquisar por", "Nome da Música", "Nome do Artista"};
        pesquisar = new JComboBox<>(opcoes);
        painelMinhasMusicas.add(pesquisar);

        String[] opcoesOrdenar = {"Ordenar por", "Nome da Música", "Nome do Artista"};
        ordenar = new JComboBox<>(opcoesOrdenar);
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

        for (Musica mus : cliente.getAquisicoes()) {
            if (mus!=null) {
                tabela.addRow(new Object[]{mus.getAutoria(),mus.getTitulo(),mus.getData().getYear()});
            }

        }


        nomeDaMusicaPesquisa = new JTextField();
        nomeDaMusicaPesquisa.setPreferredSize(new Dimension(200, 20));
        painelMinhasMusicas.add(nomeDaMusicaPesquisa);
        nomeDaMusicaPesquisa.setVisible(false);

        pesquisar.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisar.getSelectedItem();
            if ("Nome da Música".equalsIgnoreCase(opcaoSelecionada)) {
                nomeDaMusicaPesquisa.setVisible(true);
                painelMinhasMusicas.revalidate();
                painelMinhasMusicas.repaint();
            }
        });

        scrollPane2 = new JScrollPane(tabelaMusicas);
        scrollPane2.setPreferredSize(new Dimension(400, 300));
        scrollPane2.setVisible(false);

        painelMinhasMusicas.add(scrollPane2, BorderLayout.CENTER);

        pesquisarTodas.addActionListener(e -> {
            tabelaMusicas.setVisible(true);
            scrollPane2.setVisible(true);
        });

        //APOS CARREGAR NO ENTER

        JTextField caixaDeTexto = new JTextField();
        caixaDeTexto.setEditable(false);
        caixaDeTexto.setVisible(false);
        nomeDaMusicaPesquisa.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // Este método é chamado quando uma tecla é pressionada
            }

            @Override

            public void keyPressed(KeyEvent e) {
                // Este método é chamado quando uma tecla é pressionada
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    // Ação a ser realizada quando Enter for pressionado
                    String textoDigitado = nomeDaMusicaPesquisa.getText();
                    scrollPane2.setVisible(false);
                    //Método verificar a musica
                    for (Musica musicas : cliente.getAquisicoes()) {
                        if (textoDigitado.equals(musicas.getTitulo())) {
                            caixaDeTexto.setText(String.valueOf(musicas));
                            caixaDeTexto.setVisible(true);
                            painelMinhasMusicas.add(caixaDeTexto,FlowLayout.TRAILING);
                            painelMinhasMusicas.revalidate();
                            painelMinhasMusicas.repaint();
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // Este método é chamado quando uma tecla é libertada
            }
        });

        //MÉTODO ORDENAR PELO NOME DA MÚSICA

        ordenar.addActionListener(e -> {
            String opcaoSelecionada = (String) ordenar.getSelectedItem();
            if ("Nome da Música".equals(opcaoSelecionada)) {
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabela); // modelo da tabela
                tabelaMusicas.setRowSorter(sorter); // Associar o TableRowSorter à JTable
                // Definir o comparador para a coluna "Nome da Música" (ordem alfabética)
                sorter.setComparator(1, Comparator.<String>naturalOrder());
                sorter.setSortable(0, false);
                sorter.setSortable(2, false);
                sorter.setSortable(3, false);
                // Aplica a ordenação
                sorter.sort();
            }
        });

        //MÉTODO ORDENAR PELO NOME DO ARTISTA

        ordenar.addActionListener(e -> {
            String opcaoSelecionada = (String) ordenar.getSelectedItem();
            if ("Nome do Artista".equals(opcaoSelecionada)) {
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabela); // modelo da tabela
                tabelaMusicas.setRowSorter(sorter); // Associar o TableRowSorter à JTable
                // Definir o comparador para a coluna "Nome do Artista" (ordem alfabética)
                sorter.setComparator(0, Comparator.<String>naturalOrder());
                sorter.setSortable(1, false);
                sorter.setSortable(2, false);
                sorter.setSortable(3, false);
                // Aplica a ordenação
                sorter.sort();
            }
        });

    }


    private void iniciarPainelDeCima (Cliente cliente) {
        painelDeCimaFixo.setLayout(new FlowLayout());
        painelDeCimaFixo.setBackground(Color.ORANGE);
        setVisible(true);

        musicasDoSistema = new JButton();
        musicasDoSistema.setText("Músicas do Sistema");
        painelDeCimaFixo.add(musicasDoSistema);

        minhasMusicas = new JButton();
        minhasMusicas.setText("Minhas Músicas");
        painelDeCimaFixo.add(minhasMusicas);

        minhasPlaylists = new JButton();
        minhasPlaylists.setText("Minhas Playlists");
        painelDeCimaFixo.add(minhasPlaylists);

        saldo = new JButton();
        saldo.setText("Saldo: " + cliente.getSaldo() + "€");
        painelDeCimaFixo.add(saldo);

        comprasPendentes = new JButton();
        comprasPendentes.setText("Compras Pendentes");
        painelDeCimaFixo.add(comprasPendentes);

        logout = new JButton();
        logout.setText("Logout");
        logout.addActionListener(e -> {
            ((JanelaControlo) SwingUtilities.getWindowAncestor(logout)).mostrarPainel("Inicial");
        });
        painelDeCimaFixo.add(logout);
        painelDeCimaFixo.add(logout);
    }
}
