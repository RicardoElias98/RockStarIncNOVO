package Visual;

import Modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
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
    private JButton verMinhasPL;
    private JPanel painelCarrinho;
    private JPanel painelMusicasSistema;
    private JPanel painelSaldo;
    private DefaultTableModel tabelaCesto;

    private DefaultTableModel tabelaPlaylist;


    public PainelCliente(Programa rockstar, Cliente cliente) {

        //PAINEL DO OLÁ

        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);
        setVisible(true);
        JPanel saudacaoUser = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel saudacaoLabel = new JLabel("Olá, " + cliente.getUsername());
        saudacaoUser.add(saudacaoLabel);
        add(saudacaoUser);
        Musica minhaMusica = new Musica("Título da Música", "daniel", LocalDateTime.now(), true, "Gênero", 9.99);
        Playlist minhaPlaylist = new Playlist("Nome da Playlist", "bla", true, 3, "Rock");
        cliente.getAquisicoes().add(minhaMusica);
        cliente.getPlaylist().add(minhaPlaylist);
        add(saudacaoLabel);

        //Musica minhaMusica = new Musica("Título da Música", "daniel", LocalDateTime.now(), true, "Gênero", 9.99);
        //Playlist minhaPlaylist = new Playlist("Nome da Playlist","bla",true,3,"Rock");
        //cliente.getAquisicoes().add(minhaMusica);
        //cliente.getPlaylist().add(minhaPlaylist);


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
        iniciarPainelCarrinho(cliente, rockstar);
        add(painelCarrinho);

        painelMusicasSistema = new JPanel();
        iniciarPainelMusicasSistema(rockstar, cliente);
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

            // NOTA ISTO PODE SER USADO PARA OUTROS INPUTS DO UTILIZADOR
            // RICARDO

            //REVER SALDO

            String valor;
            double saldoadd;
            do {
                valor = JOptionPane.showInputDialog(null, "Insira quantos €€ quer depositar. Só aceitamos valores inteiros", "Adicionar Saldo", JOptionPane.INFORMATION_MESSAGE);
                if (!(valor.matches("\\d+")) || Double.parseDouble(valor) == 0.0) {
                    JOptionPane.showMessageDialog(null, "Insira um valor válido.");
                }
            } while (!(valor.matches("\\d+")) || Double.parseDouble(valor) == 0.0);
            saldoadd = Double.parseDouble(valor);
            if (valor != null) {
                if (saldoadd >= 0) {
                    cliente.setSaldo(cliente.getSaldo() + saldoadd);
                    saldo.setText(String.format("Saldo: %.2f€", cliente.getSaldo()));
                }
            }

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
            if (valor >= 0) {
                cliente.setSaldo(cliente.getSaldo() + valor);
                saldo.setText(String.format("Saldo: %.2f€", cliente.getSaldo()));
            }
        });
    }

    private void iniciarPainelMusicasSistema(Programa rockstar, Cliente cliente) {
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
        tabela2.addColumn("Ativa");


        JTable tabelaMusicasSistema = new JTable(tabela2);
        tabelaMusicasSistema.setDefaultEditor(Object.class, null);

        int largura3 = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaMusicasSistema.getColumnCount(); i++) {
            tabelaMusicasSistema.getColumnModel().getColumn(i).setPreferredWidth(largura3);
        }

        for (Musica mus : rockstar.getMusicasTotais()) {
            if (mus != null && !existeMusicaNaTabela(tabela2, mus)) {
                tabela2.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.getPreco(),mus.isAdicionarAPlaylist()});
            }
        }

        JScrollPane scrollPane3 = new JScrollPane(tabelaMusicasSistema);
        scrollPane3.setPreferredSize(new Dimension(400, 300));
        scrollPane3.setVisible(true);

        painelMusicasSistema.add(scrollPane3);

        JButton pesquisarTodasSistema = new JButton();
        pesquisarTodasSistema.setText("Ver todas");
        painelMusicasSistema.add(pesquisarTodasSistema);

        String[] opcoes = {"Pesquisar por", "Nome da Música", "Nome do Artista"};
        JComboBox pesquisarSistema = new JComboBox<>(opcoes);
        painelMusicasSistema.add(pesquisarSistema);

        String[] opcoesOrdenarSistema = {"Ordenar por", "Nome da Música", "Nome do Artista"};
        JComboBox ordenarSistema = new JComboBox<>(opcoesOrdenarSistema);
        painelMusicasSistema.add(ordenarSistema);

        JPopupMenu menuOpcoesSistema = new JPopupMenu();
        JMenuItem opcao001 = new JMenuItem("Adicionar ao carrinho");
        menuOpcoesSistema.add(opcao001);
        menuOpcoesSistema.setVisible(false);

        tabelaMusicasSistema.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menuOpcoesSistema.show(tabelaMusicasSistema, e.getX(), e.getY());
                    menuOpcoesSistema.setVisible(true);
                }
            }
        });

        opcao001.addActionListener(e -> {
            int linha = tabelaMusicasSistema.getSelectedRow();
            int coluna = tabelaMusicasSistema.getSelectedColumn();

            //Obter o objeto música de onde se clica
            Object objetoNaLinha = tabelaMusicasSistema.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;

            for (Musica musc : rockstar.getMusicasTotais()) {
                if (objetoString.equals(musc.getTitulo())) {
                    if (cliente.adicionarMusicasAoCarrinho(musc)) {
                        tabelaCesto.addRow(new Object[]{musc.getTitulo(), musc.getPreco()});
                    }
                    ;
                    painelCarrinho.revalidate();
                    painelCarrinho.repaint();
                }
            }
        });

        pesquisarSistema.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisarSistema.getSelectedItem();
            if ("Nome da Música".equalsIgnoreCase(opcaoSelecionada)) {
                String musica = JOptionPane.showInputDialog("Insira o nome da música");
                tabela2.setRowCount(0);
                for (Musica mus : rockstar.getMusicasTotais()) {
                    if (mus != null && mus.getTitulo().equals(musica)) {
                        tabela2.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.getPreco(),mus.isAdicionarAPlaylist()});
                    }
                }
            }
        });

        pesquisarSistema.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisarSistema.getSelectedItem();
            if ("Nome do Artista".equalsIgnoreCase(opcaoSelecionada)) {
                String artistaNomeSistema = JOptionPane.showInputDialog("Insira o nome do artista");
                tabela2.setRowCount(0);
                for (Musica mus : rockstar.getMusicasTotais()) {
                    if (mus != null && mus.getAutoria().equals(artistaNomeSistema)) {
                        tabela2.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.getPreco(),mus.isAdicionarAPlaylist()});
                    }
                }
            }
        });


        pesquisarTodasSistema.addActionListener(e -> {
            tabelaMusicasSistema.setVisible(true);
            scrollPane3.setVisible(true);
            painelMusicasSistema.revalidate();
            painelMusicasSistema.repaint();
            tabela2.setRowCount(0);
            for (Musica mus : rockstar.getMusicasTotais()) {
                if (mus != null && !existeMusicaNaTabela(tabela2, mus)) {
                    tabela2.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.getPreco(),mus.isAdicionarAPlaylist()});
                }
            }
        });

        //MÉTODO ORDENAR PELO NOME DA MÚSICA

        ordenarSistema.addActionListener(e -> {
            String opcaoSelecionada = (String) ordenarSistema.getSelectedItem();
            if ("Nome da Música".equals(opcaoSelecionada)) {
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabela2); // modelo da tabela
                tabelaMusicasSistema.setRowSorter(sorter); // Associar o TableRowSorter à JTable
                // Definir o comparador para a coluna "Nome da Música" (ordem alfabética)
                sorter.setComparator(1, Comparator.<String>naturalOrder());
                sorter.setSortable(0, false);
                sorter.setSortable(2, false);
                sorter.setSortable(3, false);
                sorter.setSortable(4, false);
                sorter.setSortable(5, false);
                // Aplica a ordenação
                sorter.sort();
            }
        });

        ordenarSistema.addActionListener(e -> {
            String opcaoSelecionada = (String) ordenarSistema.getSelectedItem();
            if ("Nome do Artista".equals(opcaoSelecionada)) {
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabela2); // modelo da tabela
                tabelaMusicasSistema.setRowSorter(sorter); // Associar o TableRowSorter à JTable
                // Definir o comparador para a coluna "Nome do Artista" (ordem alfabética)
                sorter.setComparator(0, Comparator.<String>naturalOrder());
                sorter.setSortable(1, false);
                sorter.setSortable(2, false);
                sorter.setSortable(3, false);
                sorter.setSortable(4, false);
                sorter.setSortable(5, false);
                // Aplica a ordenação
                sorter.sort();
            }
        });




    }

    private void iniciarPainelCarrinho(Cliente cliente, Programa rockstar) {
        painelCarrinho.setLayout(new FlowLayout());
        painelCarrinho.setBackground(Color.ORANGE);
        painelCarrinho.setVisible(false);

        tabelaCesto = new DefaultTableModel();

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

        confirmarCompra.addActionListener(e -> {
            cliente.finalizarCarrinho(rockstar);
            atualizarTabelaMinhasMusicas(cliente);
            tabelaCesto.setRowCount(0);
            saldo.setText(String.format("Saldo: %.2f€", cliente.getSaldo()));
        });

        JButton cancelarCompra = new JButton();
        cancelarCompra.setText("Cancelar");
        painelCarrinho.add(cancelarCompra);
        cancelarCompra.addActionListener(e -> {
            tabelaCesto.setRowCount(0);
            cliente.getAquisicoesEmEsperaPorValidacao().clear();
        });
    }

    private void inicarPainelPlaylist(Cliente cliente) {
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
        criarPlaylistRandom.addActionListener(e -> {

            // Criar o painel que vai conter os componentes de entrada
            JPanel gerarPlaylistRandom = new JPanel();
            gerarPlaylistRandom.setLayout(new BoxLayout(gerarPlaylistRandom, BoxLayout.Y_AXIS));

            // Adicionar componentes ao painel
            JTextField campoTexto1 = new JTextField(20);
            JTextField campoTexto2 = new JTextField(20);
            JTextField campoTexto3 = geraTextfieldSoAceitaDigitos();
            JComboBox<String> comboBox = new JComboBox<>(new String[]{"Pop", "Rock", "Jazz", "Metal", "Clássica", "Hip Hop", "Ambient", "Folk"});
            JCheckBox tornarPublica = new JCheckBox("Tornar Playlist Publica");

            gerarPlaylistRandom.add(new JLabel("Nome da Playlist (20 caracteres max)"));
            gerarPlaylistRandom.add(campoTexto1);
            gerarPlaylistRandom.add(new JLabel("Descrição (300 caracteres max)"));
            gerarPlaylistRandom.add(campoTexto2);
            gerarPlaylistRandom.add(new JLabel("Indique o número de músicas a incluir"));
            gerarPlaylistRandom.add(campoTexto3);
            gerarPlaylistRandom.add(new JLabel("Selecione um género:"));
            gerarPlaylistRandom.add(comboBox);
            gerarPlaylistRandom.add(tornarPublica);


            // Exibir o JOptionPane com o painel personalizado
            int result = JOptionPane.showConfirmDialog(null, gerarPlaylistRandom,
                    "Por favor, indique", JOptionPane.OK_CANCEL_OPTION);
            // codigo que cria e adiciona
            if (result == JOptionPane.OK_OPTION) {

                Playlist nova = new Playlist(campoTexto1.getText(), campoTexto2.getText(), tornarPublica.isSelected());
                int numMusicas = Integer.parseInt(campoTexto3.getText());
                ArrayList<Musica> arrayTemp = new ArrayList<>();

                for (Musica musica : cliente.getAquisicoes()) {
                    if (musica.getGenero() == comboBox.getSelectedItem() && musica.isAdicionarAPlaylist()) {
                        arrayTemp.add(musica);
                    }
                }
                Collections.shuffle(arrayTemp);

                if (arrayTemp.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Não existem músicas do género " + " na sua coleção que possam ser adicionadas a nova Playlist", "Playlist não criada", JOptionPane.ERROR_MESSAGE);
                } else {
                  for (int i = 0; i <= Math.min(numMusicas, arrayTemp.size()); i++) {
                        nova.getMusicas().add(arrayTemp.get(i));
                    }
                  cliente.getPlaylist().add(nova);
                if (nova.getMusicas().size() == arrayTemp.size()){
                  o: JOptionPane.showMessageDialog(null, "Playlist "+nova.getNome()+"já disponível na sua área de Playlists", "Playlist criada com sucesso", JOptionPane.DEFAULT_OPTION);
                }  else {
                    JOptionPane.showMessageDialog(null, "Foi gerada a Playlist "+nova.getNome()+"com todas as músicas desse género que você tem e que permitem ser adicionadas a playlist.", "Playlist criada com sucesso.", JOptionPane.WARNING_MESSAGE);
                }
                }
            }


            // playlistNova.setNome(nome.getText());
            // playlistNova.atribuirVisibilidade(visibilidade.getText());
            // playlistNova.setDescricao(descricao.getText());
            // cliente.getPlaylist().add(playlistNova);
            //tabelaPlaylist.addRow(new Object[]{playlistNova.getNome(),playlistNova.getMusicas().lengt,playlistNova.isVisibilidade(),playlistNova.getDescricao()});
        });


        ;
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

        tabelaPlaylist = new DefaultTableModel();

        JTable tabelaPlaylists = new JTable(tabelaPlaylist);
        tabelaPlaylists.setDefaultEditor(Object.class, null);

        tabelaPlaylist.addColumn("Nome");
        tabelaPlaylist.addColumn("Descrição");
        tabelaPlaylist.addColumn("Num músicas");
        tabelaPlaylist.addColumn("Visibilidade");


        int largura3 = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaPlaylists.getColumnCount(); i++) {
            tabelaPlaylists.getColumnModel().getColumn(i).setPreferredWidth(largura3);
        }

        for (Playlist play : cliente.getPlaylist()) {
            if (play != null && !existePlaylistNaTabela(tabelaPlaylists, play)) {
                tabelaPlaylist.addRow(new Object[]{play.getNome(), play.getDescricao(), play.getMusicas().size(), play.isVisibilidade()});
            }
        }

        JScrollPane scrollPane = new JScrollPane(tabelaPlaylists);
        scrollPane.setVisible(false);
        painelPlayList.add(scrollPane, BorderLayout.CENTER);

        verMinhasPL.addActionListener(e -> {
            tabelaPlaylists.setVisible(true);
            scrollPane.setVisible(true);
            painelPlayList.revalidate();
            painelPlayList.repaint();
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

        JPopupMenu menuOpcoesPlaylist = new JPopupMenu();
        JMenuItem opcao01 = new JMenuItem("Remover");
        JMenuItem opcao02 = new JMenuItem("Alterar visibilidade");
        menuOpcoesPlaylist.add(opcao01);
        menuOpcoesPlaylist.add(opcao02);
        menuOpcoesPlaylist.setVisible(false);

        tabelaPlaylists.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menuOpcoesPlaylist.show(tabelaPlaylists, e.getX(), e.getY());
                    menuOpcoesPlaylist.setVisible(true);
                }
            }
        });

        opcao01.addActionListener(e -> {
            int linha = tabelaPlaylists.getSelectedRow();
            int coluna = tabelaPlaylists.getSelectedColumn();

            //Obter o objeto música de onde se clica
            Object objetoNaLinha = tabelaPlaylists.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;

            for (Playlist pl : cliente.getPlaylist()) {
                if (objetoString.equals(pl.getNome())) {
                    cliente.removerPlaylist(pl, linha, coluna, tabelaPlaylists, tabelaPlaylist, painelPlayList);
                }
            }
        });

        opcao02.addActionListener(e -> {
            int linha = tabelaPlaylists.getSelectedRow();
            int coluna = tabelaPlaylists.getSelectedColumn();

            //Obter o objeto música de onde se clica
            Object objetoNaLinha = tabelaPlaylists.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;

            for (Playlist pl : cliente.getPlaylist()) {
                if (objetoString.equals(pl.getNome())) {
                    System.out.println(pl.isVisibilidade());
                    cliente.mudarVisibilidade(pl.isVisibilidade(), pl);
                    System.out.println(pl.isVisibilidade());
                    tabelaPlaylists.getModel().setValueAt(pl.isVisibilidade(), linha, 3);
                }
            }
        });

        criarPlaylist.addActionListener(e -> {
            Playlist playlistNova = new Playlist("", "", true, 0, "");
            scrollPane.setVisible(false);
            painelPlaylistVazia.setVisible(true);
            confirmarplNova.addActionListener(e1 -> {
                playlistNova.setNome(nome.getText());
                playlistNova.atribuirVisibilidade(visibilidade.getText());
                playlistNova.setDescricao(descricao.getText());
                cliente.getPlaylist().add(playlistNova);
                tabelaPlaylist.addRow(new Object[]{playlistNova.getNome(), playlistNova.getDescricao(), playlistNova.getMusicas().size(), playlistNova.isVisibilidade()});
            });
        });

    }

    private boolean existeMusicaNaTabela(DefaultTableModel tabela, Musica musica) {
        for (int i = 0; i < tabela.getRowCount(); i++) {
            // Comparar nome
            if (musica.getTitulo().equals(tabela.getValueAt(i, 1))) {
                return true; // A música já está na tabela
            }
        }
        return false; // A música não está na tabela
    }

    public boolean existePlaylistNaTabela(JTable tabela, Playlist playlist) {
        for (int i = 0; i < tabela.getRowCount(); i++) {
            // Comparar (nome)
            if (playlist.getNome().equals(tabela.getValueAt(i, 0))) {
                return true; // A playlist já está na tabela
            }
        }
        return false; // A playlist não está na tabela
    }

    private void iniciarPainelMinhasMusicas(Cliente cliente) {
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


        tabela.addColumn("Artista");
        tabela.addColumn("Música");
        tabela.addColumn("Álbum");
        tabela.addColumn("Ano");
        tabela.addColumn("Rating");

        tabelaMusicas = new JTable(tabela);
        tabelaMusicas.setDefaultEditor(Object.class, null);

        int largura2 = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaMusicas.getColumnCount(); i++) {
            tabelaMusicas.getColumnModel().getColumn(i).setPreferredWidth(largura2);
        }


        for (Musica mus : cliente.getAquisicoes()) {
            if (mus != null) {
                tabela.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.verRatingDado(cliente)});
            }
        }


        nomeDaMusicaPesquisa = new JTextField();
        nomeDaMusicaPesquisa.setPreferredSize(new Dimension(200, 20));
        painelMinhasMusicas.add(nomeDaMusicaPesquisa);
        nomeDaMusicaPesquisa.setVisible(false);

        pesquisar.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisar.getSelectedItem();
            if ("Nome da Música".equalsIgnoreCase(opcaoSelecionada)) {
                String musica = JOptionPane.showInputDialog("Insira o nome da música");
                tabela.setRowCount(0);
                for (Musica mus : cliente.getAquisicoes()) {
                    if (mus != null && mus.getTitulo().equals(musica)) {
                        tabela.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.verRatingDado(cliente)});
                    }
                }
            }
        });

        pesquisar.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisar.getSelectedItem();
            if ("Nome do Artista".equalsIgnoreCase(opcaoSelecionada)) {
                String artistaNome = JOptionPane.showInputDialog("Insira o nome do artista");
                tabela.setRowCount(0);
                for (Musica mus : cliente.getAquisicoes()) {
                    if (mus != null && mus.getAutoria().equals(artistaNome)) {
                        tabela.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.verRatingDado(cliente)});
                    }
                }
            }
        });

        scrollPane2 = new JScrollPane(tabelaMusicas);
        scrollPane2.setPreferredSize(new Dimension(400, 300));
        scrollPane2.setVisible(false);

        painelMinhasMusicas.add(scrollPane2, BorderLayout.CENTER);

        pesquisarTodas.addActionListener(e -> {
            tabelaMusicas.setVisible(true);
            scrollPane2.setVisible(true);
            painelMinhasMusicas.revalidate();
            painelMinhasMusicas.repaint();
            atualizarTabelaMinhasMusicas(cliente);
        });

        //APOS CARREGAR NO ENTER

       /* JTextField caixaDeTexto = new JTextField();
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
                            painelMinhasMusicas.add(caixaDeTexto, FlowLayout.TRAILING);
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
        }); */

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

        JPopupMenu menuOpcoes = new JPopupMenu();
        JMenuItem opcao1 = new JMenuItem("Adicionar a playlist");
        JMenuItem opcao2 = new JMenuItem("Avaliar");
        JMenuItem opcao3 = new JMenuItem("Histórico de preços");
        menuOpcoes.add(opcao1);
        menuOpcoes.add(opcao2);
        menuOpcoes.add(opcao3);
        menuOpcoes.setVisible(false);

        tabelaMusicas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menuOpcoes.show(tabelaMusicas, e.getX(), e.getY());
                    menuOpcoes.setVisible(true);
                }
            }
        });

        opcao1.addActionListener(e -> {

            int linha = tabelaMusicas.getSelectedRow();
            int coluna = tabelaMusicas.getSelectedColumn();

            JPopupMenu menuOpcoesPlaylistssss = new JPopupMenu();

            for (Playlist pl : cliente.getPlaylist()) {
                JMenuItem nomeParaAopcao = new JMenuItem(pl.getNome());
                menuOpcoesPlaylistssss.add(nomeParaAopcao);

                nomeParaAopcao.addActionListener(e1 -> {
                    //método para adicionar no backhend
                    cliente.adicionarMusicaAplaylist(pl, tabelaMusicas, tabelaPlaylist, linha, coluna);
                    menuOpcoesPlaylistssss.setVisible(false);
                });
            }
            menuOpcoesPlaylistssss.setVisible(true);
        });

        JPopupMenu menuOpcoesAvaliar = new JPopupMenu();
        JMenuItem avaliar1 = new JMenuItem("1");
        JMenuItem avaliar2 = new JMenuItem("2");
        JMenuItem avaliar3 = new JMenuItem("3");
        JMenuItem avaliar4 = new JMenuItem("4");
        JMenuItem avaliar5 = new JMenuItem("5");
        JMenuItem avaliar6 = new JMenuItem("6");
        JMenuItem avaliar7 = new JMenuItem("7");
        JMenuItem avaliar8 = new JMenuItem("8");
        JMenuItem avaliar9 = new JMenuItem("9");
        JMenuItem avaliar10 = new JMenuItem("10");


        menuOpcoesAvaliar.add(avaliar1);
        menuOpcoesAvaliar.add(avaliar2);
        menuOpcoesAvaliar.add(avaliar3);
        menuOpcoesAvaliar.add(avaliar4);
        menuOpcoesAvaliar.add(avaliar5);
        menuOpcoesAvaliar.add(avaliar6);
        menuOpcoesAvaliar.add(avaliar7);
        menuOpcoesAvaliar.add(avaliar8);
        menuOpcoesAvaliar.add(avaliar9);
        menuOpcoesAvaliar.add(avaliar10);
        menuOpcoesAvaliar.setVisible(false);

        //Método para avaliar música

        opcao2.addActionListener(e -> {
            int linha = tabelaMusicas.getSelectedRow();
            int coluna = tabelaMusicas.getSelectedColumn();
            menuOpcoesAvaliar.show(tabelaMusicas, linha, coluna);
            menuOpcoesAvaliar.setVisible(true);

            Object objetoNaLinha = tabelaMusicas.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;

            for (Musica musica : cliente.getAquisicoes()) {
                if (objetoString.equals(musica.getTitulo())) {
                    avaliar1.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 1);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar2.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 2);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar3.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 3);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar4.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 4);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar5.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 5);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar6.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 6);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar7.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 7);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar8.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 8);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar9.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 9);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                    avaliar10.addActionListener((e1) -> {
                        musica.adicionarRating(cliente, 10);
                        atualizarTabelaMinhasMusicas(cliente);
                    });
                }
            }
        });

        opcao3.addActionListener(e -> {

        });

    }

    private void atualizarTabelaMinhasMusicas(Cliente cliente) {
        tabela.setRowCount(0);
        for (Musica mus : cliente.getAquisicoes()) {
            if (mus != null) {
                tabela.addRow(new Object[]{mus.getAutoria(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.verRatingDado(cliente)});
            }
        }
    }


    private void iniciarPainelDeCima(Cliente cliente) {
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
        saldo.setText(String.format("Saldo: %.2f€", cliente.getSaldo()));
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

    //

    // PARA TERMOS CAMPOS PREENCHIDOS SÓ COM DIGITOS
    // UTILIZAR TEXTFIELD ESPECIFICO JÁ COM KEYLISTENER QE BLOQUEIA.
    // keylistener para só permitir digitos

    // construtor de textfield que aceita só digitos
    public JTextField geraTextfieldSoAceitaDigitos() {
        KeyListener soDigitosTecla = new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char pin = e.getKeyChar();
                if (!Character.isDigit(pin)) {
                    e.consume();
                }
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        };
        JTextField soDigitos = new JTextField(10);
        soDigitos.addKeyListener(soDigitosTecla);
        return soDigitos;
    }


}



