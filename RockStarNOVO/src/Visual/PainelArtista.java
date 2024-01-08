package Visual;

import Modelo.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class PainelArtista extends JPanel {

    private JButton adicionarMusica;
    private JButton corrigirTitulo;
    private JButton alterarPreco;
    private JButton inativarMusica;
    private JButton minhasMusicas;
    private JButton criarAlbum;

    private JButton saldo;

    private JButton logout;

    private JButton verEstatisticas;
    private JPanel painelDeCimaFixo;

    private JPanel painelCorrigirTitulo;

    private JPanel painelMinhasMusicas;
    private JPanel painelAdicionarMusicas;

    private JTable tabelaMusicas;

    private JScrollPane scrollPane2;
    private DefaultTableModel tabela;

    private JPanel painelCriarAlbum;


    public PainelArtista(Programa rockstar, Artista artista) {

        setLayout(new FlowLayout());
        setBackground(Color.ORANGE);
        setVisible(true);

        Musica minhaMusica = new Musica("Título da Música", "daniel", LocalDateTime.now(), true, "Gênero", 9.99);
        //artista.getMusicas().add(minhaMusica);
        //rockstar.getMusicasTotais().add(minhaMusica);

        painelDeCimaFixo = new JPanel();
        iniciarPainelDeCima(artista, rockstar);
        add(painelDeCimaFixo);

        JPanel saudacaoUser = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel saudacaoLabel = new JLabel("Olá, " + artista.getUsername());
        saudacaoUser.add(saudacaoLabel);
        add(saudacaoLabel);

        painelCorrigirTitulo = new JPanel();
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
            atualizarTabelaMinhasMusicas(artista);
        });

        adicionarMusica.addActionListener(e -> {
            painelAdicionarMusicas.setVisible(true);
            painelMinhasMusicas.setVisible(false);
            painelCorrigirTitulo.setVisible(false);
        });

        alterarPreco.addActionListener(e -> {
            painelAdicionarMusicas.setVisible(false);
            painelMinhasMusicas.setVisible(false);
            painelCorrigirTitulo.setVisible(false);

            String musica = JOptionPane.showInputDialog("Insira o nome da música a alterar");
            for (Musica mus : artista.getMusicas()) {
                if (musica.equals(mus.getTitulo()) && mus != null && musica != null) {
                    String valorNovo = JOptionPane.showInputDialog("Insira o novo preço");
                    double valorNovoDouble = Double.parseDouble(valorNovo);
                    mus.setPreco(valorNovoDouble);
                    atualizarTabelaMinhasMusicas(artista);
                }
            }
        });

        criarAlbum.addActionListener(e -> {
            String album = JOptionPane.showInputDialog("Insira o nome da novo Álbum");
            String albumGenero = JOptionPane.showInputDialog("Género : Pop, Rock, Jazz, Metal, Clássica, Hip Hop");
            Album albumNovo = new Album(album, albumGenero);
            artista.getAlbuns().add(albumNovo);
        });

    }


    private void inicarPainelAdicionarMusica(Artista artista, Programa rockstar) {
        painelAdicionarMusicas.setLayout(new FlowLayout());
        painelAdicionarMusicas.setBackground(Color.ORANGE);
        painelAdicionarMusicas.setVisible(false);

        JTextField nomeDaMusica = new JTextField("Nome da música");
        JTextField preco = new JTextField("Preço");
        JComboBox generoBox = new JComboBox<>(new String[]{"Pop", "Rock", "Jazz", "Metal", "Clássica", "Hip Hop"});
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
                Musica musicaCriada = new Musica(nomeDaMusica.getText(), artista.getUsername(), LocalDateTime.now(), publicaOuNao(publicaOuNao1), genero, Double.parseDouble(preco.getText()));
                System.out.println(musicaCriada + "criada com sucesso");
                rockstar.getMusicasTotais().add(musicaCriada);
                artista.getMusicas().add(musicaCriada);
            }

        });
    }

    private void atualizarTabelaMinhasMusicas(Artista artista) {
        tabela.setRowCount(0);
        for (Musica mus : artista.getMusicas()) {
            if (mus != null) {
                tabela.addRow(new Object[]{mus.getPreco(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.isAdicionarAPlaylist()});
            }
        }
    }


    private boolean publicaOuNao(String publicaOuPrivada) {
        if (publicaOuPrivada.equals("Pública")) {
            return true;
        } else if (publicaOuPrivada.equals("Privada")) {
            return false;
        } else return false;
    }

    private void inicarPainelMinhasMusicas(Artista artista) {
        painelMinhasMusicas.setLayout(new FlowLayout());
        painelMinhasMusicas.setBackground(Color.ORANGE);
        painelMinhasMusicas.setVisible(false);

        JButton pesquisarTodas = new JButton();
        pesquisarTodas.setText("Ver todas");
        painelMinhasMusicas.add(pesquisarTodas);


        String[] opcoes = {"Pesquisar por", "Nome da Música", "Nome do Álbum"};
        JComboBox pesquisar = new JComboBox<>(opcoes);
        painelMinhasMusicas.add(pesquisar);

        String[] opcoesOrdenar = {"Ordenar por", "Nome da Música", "Nome do Álbum"};
        JComboBox ordenar = new JComboBox<>(opcoesOrdenar);
        painelMinhasMusicas.add(ordenar);

        tabela = new DefaultTableModel();

        // Adicione suas colunas ao modelo da tabela
        tabela.addColumn("Preço");
        tabela.addColumn("Música");
        tabela.addColumn("Álbum");
        tabela.addColumn("Ano");
        tabela.addColumn("Ativa/Inativa");

        tabelaMusicas = new JTable(tabela);
        tabelaMusicas.setDefaultEditor(Object.class, null);

        int largura2 = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaMusicas.getColumnCount(); i++) {
            tabelaMusicas.getColumnModel().getColumn(i).setPreferredWidth(largura2);
        }

        for (Musica mus : artista.getMusicas()) {
            if (mus != null) {
                tabela.addRow(new Object[]{mus.getPreco(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.isAdicionarAPlaylist()});
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

            atualizarTabelaMinhasMusicas(artista);
        });


        pesquisar.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisar.getSelectedItem();
            if ("Nome da Música".equalsIgnoreCase(opcaoSelecionada)) {
                String musica = JOptionPane.showInputDialog("Insira o nome da música");
                tabela.setRowCount(0);
                for (Musica mus : artista.getMusicas()) {
                    if (mus != null && mus.getTitulo().equals(musica)) {
                        tabela.addRow(new Object[]{mus.getPreco(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.isAdicionarAPlaylist()});
                    }
                }
            }
        });

        pesquisar.addActionListener(e -> {
            String opcaoSelecionada = (String) pesquisar.getSelectedItem();
            if ("Nome do Álbum".equalsIgnoreCase(opcaoSelecionada)) {
                String album = JOptionPane.showInputDialog("Insira o nome do álbum");
                tabela.setRowCount(0);
                for (Musica mus : artista.getMusicas()) {
                    if (mus != null && mus.getNomeAlbum().equals(album)) {
                        tabela.addRow(new Object[]{mus.getPreco(), mus.getTitulo(), mus.getNomeAlbum(), mus.getData().getYear(), mus.isAdicionarAPlaylist()});
                    }
                }
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

        //MÉTODO ORDENAR PELO NOME DO ÁLBUM

        ordenar.addActionListener(e -> {
            String opcaoSelecionada = (String) ordenar.getSelectedItem();
            if ("Nome do Álbum".equals(opcaoSelecionada)) {
                TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(tabela); // modelo da tabela
                tabelaMusicas.setRowSorter(sorter); // Associar o TableRowSorter à JTable

                sorter.setSortable(0, false);
                sorter.setSortable(0, false);
                sorter.setComparator(2, Comparator.<String>naturalOrder());
                sorter.setSortable(3, false);
                // Aplica a ordenação
                sorter.sort();
            }
        });

        JPopupMenu menuOpcoes = new JPopupMenu();
        JMenuItem opcao1 = new JMenuItem("Adicionar a Álbum");
        JMenuItem opcao2 = new JMenuItem("Alterar disponibilidade");
        menuOpcoes.add(opcao1);
        menuOpcoes.add(opcao2);
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

            JPopupMenu menuOpcoesAlbum = new JPopupMenu();

            //Obter o objeto música de onde se clica
            Object objetoNaLinha = tabelaMusicas.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;

            for (Album alb : artista.getAlbuns()) {
                JMenuItem nomeParaAopcao = new JMenuItem(alb.getNome());
                menuOpcoesAlbum.add(nomeParaAopcao);

                nomeParaAopcao.addActionListener(e1 -> {
                    for (Musica mus : artista.getMusicas()) {
                        if (mus.getTitulo().equals(objetoString)) {
                            alb.getMusicas().add(mus);
                            mus.setNomeAlbum(alb.getNome());
                            System.out.println("Música adicionada ao álbum: " + mus.getTitulo() + " - " + alb.getNome());
                            atualizarTabelaMinhasMusicas(artista);
                        }
                    }
                });
            }
            menuOpcoesAlbum.setVisible(true);
        });

        opcao2.addActionListener(e -> {
            int linha = tabelaMusicas.getSelectedRow();
            int coluna = tabelaMusicas.getSelectedColumn();

            //Obter o objeto música de onde se clica
            Object objetoNaLinha = tabelaMusicas.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;

            for (Musica musc : artista.getMusicas()) {
                if (objetoString.equals(musc.getTitulo())) {
                    if (musc.isAdicionarAPlaylist()) {
                        musc.setAdicionarAPlaylist(false);
                    } else musc.setAdicionarAPlaylist(true);
                }
                tabelaMusicas.getModel().setValueAt(musc.isAdicionarAPlaylist(), linha, 4);
            }
        });
    }

    private void iniciarPainelCorrigirTitulo(Programa rockstar, Artista artista) {
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
        });
        ;    //ALTERA MAS NÃO ALTERA NA TABELA
    }

    private void iniciarPainelDeCima(Artista artista, Programa rockstar) {
        painelDeCimaFixo.setLayout(new FlowLayout());
        painelDeCimaFixo.setBackground(Color.ORANGE);
        setVisible(true);

        adicionarMusica = new JButton();
        adicionarMusica.setText("Adicionar música");
        painelDeCimaFixo.add(adicionarMusica);

        criarAlbum = new JButton();
        criarAlbum.setText("Criar álbum");
        painelDeCimaFixo.add(criarAlbum);

        corrigirTitulo = new JButton();
        corrigirTitulo.setText("Corrigir título");
        painelDeCimaFixo.add(corrigirTitulo);

        alterarPreco = new JButton();
        alterarPreco.setText("Alterar Preço");
        painelDeCimaFixo.add(alterarPreco);

        minhasMusicas = new JButton();
        minhasMusicas.setText("Minhas Músicas");
        painelDeCimaFixo.add(minhasMusicas);

        saldo = new JButton();
        saldo.setText(String.format("Saldo: %.2f€", artista.getSaldo()));
        painelDeCimaFixo.add(saldo);

        verEstatisticas = new JButton();
        verEstatisticas.setText("Estatísticas");
        painelDeCimaFixo.add(verEstatisticas);

        verEstatisticas.addActionListener(e -> {

            // total artistas registados
            int nTotalArtistas = rockstar.getArtistas().size();

            // total clientes registados
            int nTotalClientes = rockstar.getClientes().size();

            // total de Musicas
            int nTotalMusicas = rockstar.getMusicasTotais().size();

            // valor total das músicas
            double precoTodasAsMusicas = 0.00;
            for (Musica m: rockstar.getMusicasTotais()) {
              precoTodasAsMusicas += m.getPreco();
            }

            // total gasto por todos os clientes // valor total das vendas
            double gastoTotal = 0.00;
            for (Cliente c : rockstar.getClientes()) {
                gastoTotal += c.totalGasto();
            }

            // valor total de álbuns por géneros
            //hashmap genero, numero de albuns

            String totalAlbunsGenero ="";

            if (rockstar.getAlbunsTotais().isEmpty()) {
                totalAlbunsGenero = "Não existem álbuns criados";
            } else {
                HashMap<String, Integer> totalAlbunsGeneroMap = new HashMap<>();
                for (Album a : rockstar.getAlbunsTotais()) {
                    totalAlbunsGeneroMap.put(a.getAlbumGenero(), totalAlbunsGeneroMap.getOrDefault(a.getAlbumGenero(), 0) + 1);
                }
                for (Map.Entry<String, Integer> entrada : totalAlbunsGeneroMap.entrySet()) {
                    String string = entrada.getKey();
                    Integer contagem = entrada.getValue();
                    totalAlbunsGenero += "\n"+"Nº de álbuns do género" + string + ": " + contagem+"";
                }
            }


            // quantas músicas do artista já foram descarregadas
            int descargas = 0;
            for (Cliente c : rockstar.getClientes()) {
                for (Musica musica: c.getAquisicoes()) {
                    if (artista.getUsername()==musica.getAutoria()){
                        descargas++;
                    }
                }
            }



            // musica mais bem classificada do artista
            String ratingMedio = "As suas músicas ainda não obtiveram qualquer avaliação";
            double tempRating = 0.00;
            for (Musica m : artista.getMusicas()) {
                if (m.obterRatingMedio() > tempRating) {
                    ratingMedio = m.getTitulo() +", com a nota "+ m.obterRatingMedio();
                }
            }


            ////PAINEL

            JPanel painelStats = new JPanel();
            JTextArea textArea = new JTextArea("Nº total de artistas: "+nTotalArtistas+"" +
                    "\n"+"Nº total de clientes: "+nTotalClientes+"\n"+"Nº total de musicas: "+nTotalMusicas+
                    "\n"+"Valor total do conjunto de músicas: "+precoTodasAsMusicas+"€\n"
                    +"Volume total de transações: "+gastoTotal+"€\n"+"Álbuns por género: "+totalAlbunsGenero+""+
                    "\n"+"A sua música com melhor avaliação: "+ratingMedio+"\n"+"Número de downloadas das suas músicas: " +
                    descargas)
                    ;
            textArea.setEditable(false);
            textArea.setWrapStyleWord(true);
            textArea.setLineWrap(true);
            textArea.setSize(600,600);
            painelStats.add(textArea);
            JOptionPane.showMessageDialog(null, painelStats, "Estatísticas", JOptionPane.PLAIN_MESSAGE);

        });


        logout = new JButton();
        logout.setText("Logout");
        logout.addActionListener(e -> {
            ((JanelaControlo) SwingUtilities.getWindowAncestor(logout)).mostrarPainel("Inicial");
        });
        painelDeCimaFixo.add(logout);


    }

}

