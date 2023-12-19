import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class InterfaceGrafica {

    public InterfaceGrafica () {

        //Inicio o PROGRAMA
        Programa programa = new Programa(new ArrayList<>(),new ArrayList<>(),new ArrayList<>(),new ArrayList<>());  //PARA TESTE

        //JANELA PRINCIPAL
        JanelaPrincipal jp = new JanelaPrincipal("RockStar. Inc");

        //painel da JP com os botões login e registar
        PainelBotoesLoginRegistar pn = new PainelBotoesLoginRegistar();

        //painel do LOGIN E DO REGISTO
        PainelLogin pL = new PainelLogin();
        PainelRegisto pR = new PainelRegisto();

        //painel das "Minhas Músicas"
        PainelMinhasMusicas minhasMusicas = new PainelMinhasMusicas();

        //painel do CLIENTE APÓS FAZER LOGIN
        PainelCllienteAposLogin painelCliente = new PainelCllienteAposLogin();

        //painelFlowLayoutParteDeCima
        FLOWlayoutDefault painelCima = new FLOWlayoutDefault();

        //painelFlowLayoutMinhasMusicas
        PainelMinhasMusicas minhasMusicasClientePainel = new PainelMinhasMusicas();

        JButton pesquisarTodas = new JButton();
        pesquisarTodas.setText("Ver todas");
        minhasMusicasClientePainel.add(pesquisarTodas);


        DefaultTableModel tabela = new DefaultTableModel();

       // Adicione suas colunas ao modelo da tabela
        tabela.addColumn("Artista");
        tabela.addColumn("Música");
        tabela.addColumn("Álbum");
        tabela.addColumn("Ano");

        JTable tabelaMusicas = new JTable(tabela);

        int largura = 150; // Largura desejada para as colunas

        for (int i = 0; i < tabelaMusicas.getColumnCount(); i++) {
            tabelaMusicas.getColumnModel().getColumn(i).setPreferredWidth(largura);
        }



        String[] opcoes = {"Pesquisar por", "Nome da Música", "Norme do Artista"};
        JComboBox<String> pesquisar = new JComboBox<>(opcoes);
        pesquisar.setVisible(true);
        minhasMusicasClientePainel.add(pesquisar);


       /* pesquisar.addActionListener(e -> {if (pesquisar.getSelectedItem().equals("Nome da Música")) {

        }} ); */







        //Crio, edito e adiciono os BOTÕES DO PAINEL DO CLIENTE APÓS LOGIN
        JButton minhasMusicasCliente = new JButton();
        minhasMusicasCliente.setText("Minhas Músicas");
        //minhasMusicasCliente.setBounds(50, 50, 100, 30);
        JButton minhasPlaylistsCliente = new JButton();
        minhasPlaylistsCliente.setText("Minhas Playlists");
        JButton pesquisarMusicas = new JButton();
        pesquisarMusicas.setText("Pesquisar Músicas");
        JButton pesquisarPlaylist = new JButton();
        pesquisarPlaylist.setText("Pesquisar Playlists");
        JButton saldo = new JButton();
        saldo.setText("Saldo");
        JButton cestoDeCompras = new JButton();
        cestoDeCompras.setText("Compras pendentes");

        painelCima.add(minhasMusicasCliente);
        painelCima.add(minhasPlaylistsCliente);
        painelCima.add(pesquisarMusicas);
        painelCima.add(pesquisarPlaylist);
        painelCima.add(saldo);
        painelCima.add(cestoDeCompras);

        painelCliente.add(painelCima,BorderLayout.NORTH);
        painelCliente.add(minhasMusicasClientePainel, BorderLayout.WEST);


        JButton logout = new JButton();
        logout.setText("Logout");

        //adiciono TODOS OS PAINÉIS NA JP
        jp.add(pn);
        jp.add(pL);
        jp.add(pR);
        jp.add(painelCliente);



        //Ao carregar no botão de uma das opções fica azul e os restantes ficam pretos (normais) //meter sempre os outros a preto ao mesmo tempo para não ficar azul após carregar noutro
        minhasMusicasCliente.addActionListener(e -> {
                    minhasMusicasCliente.setForeground(Color.BLUE);
                    minhasMusicasClientePainel.setVisible(true);
                }
        );


        //botão LOGIN do 1º painel de todos
        JButton botaoLogin = new JButton();
        botaoLogin.setText("Login");
        pn.add(botaoLogin);

        //botão REGISTAR do 1º painel de todos
        JButton botaoRegistar = new JButton();
        botaoRegistar.setText("Registar");
        pn.add(botaoRegistar);

        //PARA TESTE
        Cliente clienteTemporarioParaTeste = new Cliente("Ricardo","123",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        programa.getClientes().add(clienteTemporarioParaTeste);
        Artista artistaTemporarioParaTeste = new Artista("Ricardo","1234",0, 123,new ArrayList<>(),new ArrayList<>());
        programa.getArtistas().add(artistaTemporarioParaTeste);
        //PARA TESTE

        //Criação de clientes e artistas temporários para login que serão adicionados ou não ao programa
        Cliente clienteTemporarioLogin = new Cliente("","",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        Artista artistaTemporarioLogin = new Artista("","",0, -1,new ArrayList<>(),new ArrayList<>());

        //Criação de clientes e artistas temporários para registo que serão adicionados ou não ao programa
        Cliente clienteTemporarioRegisto = new Cliente("","",0,new ArrayList<>(),new ArrayList<>(),new ArrayList<>());
        Artista artistaTemporarioRegisto = new Artista("", "", 0,-1,new ArrayList<>(),new ArrayList<>());

        //PARA TESTE
        Musica musica1Teste = new Musica("Olá","Roberto", LocalDate.of(2023,10,8),new ArrayList<>(),true,"Olá album",1,new ArrayList<>());
        clienteTemporarioParaTeste.getAquisicoes().add(musica1Teste);
        //PARA TESTE


        //PARA TESTE//PARA TESTE//PARA TESTE
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo(),musica1Teste.getAlbum(),musica1Teste.getData()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        tabela.addRow(new Object[]{musica1Teste.getAutor(),musica1Teste.getTitulo()});
        //PARA TESTE//PARA TESTE//PARA TESTE

       JScrollPane scrollPane = new JScrollPane(tabelaMusicas);
        scrollPane.setPreferredSize(new Dimension(400, 300));
       scrollPane.setVisible(false);

       minhasMusicasClientePainel.add(scrollPane, BorderLayout.CENTER);



        tabelaMusicas.setVisible(false);
        tabelaMusicas.setDefaultEditor(Object.class, null);

        pesquisarTodas.addActionListener(e -> {
            scrollPane.setVisible(true);
            tabelaMusicas.setVisible(true);
            minhasMusicasClientePainel.revalidate();
            minhasMusicasClientePainel.repaint();
        });

        //PARA TESTE
        Playlist playlistTeste = new Playlist("Elias",new ArrayList<>(),true,"chill");
        //PARA TESTE

        JPopupMenu menuOpcoes = new JPopupMenu();
        JMenuItem opcao1 = new JMenuItem("Adicionar a playlist");
        JMenuItem opcao2 = new JMenuItem("Avaliar");
        menuOpcoes.add(opcao1);
        menuOpcoes.add(opcao2);
        menuOpcoes.setVisible(false);

        tabelaMusicas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (SwingUtilities.isRightMouseButton(e)) {
                    menuOpcoes.show(tabelaMusicas,e.getX(), e.getY());
                    menuOpcoes.setVisible(true);
                }
            }
        });

        opcao1.addActionListener(e -> {
            int linha = tabelaMusicas.getSelectedRow();
            int coluna = tabelaMusicas.getSelectedColumn();


            //Obter o objeto música de onde se clica
            Object objetoNaLinha = tabelaMusicas.getValueAt(linha, coluna);
            String objetoString = (String) objetoNaLinha;


            //Método para adicionar música à playlist
            for (Musica musica : clienteTemporarioParaTeste.getAquisicoes()) {
                Musica musicaAdicionada;
                if (objetoString.equals(musica.getTitulo())) {
                    musicaAdicionada = musica;
                    playlistTeste.musicas.add(musicaAdicionada);
                    System.out.println("Musica adiciona com sucesso: " + musicaAdicionada);
                }
            }
        });


        //MÉTODO PARA AVALIAR UMA MÚSICA -- ESTÁ A DAR ERRO, O VALOR REPETE
        /*
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
            menuOpcoesAvaliar.show(tabelaMusicas,linha,coluna);
            menuOpcoesAvaliar.setVisible(true);

                Object objetoNaLinha = tabelaMusicas.getValueAt(linha, coluna);
                String objetoString = (String) objetoNaLinha;

                for (Musica musica : clienteTemporarioParaTeste.getAquisicoes()) {
                    if (objetoString.equals(musica.getTitulo())) {
                    avaliar1.addActionListener(e1-> musica.getRegistodeRating().add(1));
                    avaliar2.addActionListener(e1 -> musica.getRegistodeRating().add(2));
                    avaliar3.addActionListener(e1 -> musica.getRegistodeRating().add(3));
                    avaliar4.addActionListener(e1 -> musica.getRegistodeRating().add(4));
                    avaliar5.addActionListener(e1 -> musica.getRegistodeRating().add(5));
                    avaliar6.addActionListener(e1 -> musica.getRegistodeRating().add(6));
                    avaliar7.addActionListener(e1 -> musica.getRegistodeRating().add(7));
                    avaliar8.addActionListener(e1 -> musica.getRegistodeRating().add(8));
                    avaliar9.addActionListener(e1 -> musica.getRegistodeRating().add(9));
                    avaliar10.addActionListener(e1 -> musica.getRegistodeRating().add(10));
                }
                }
            });

           JButton verRating = new JButton();
            verRating.setVisible(true);
            painelCliente.add(verRating);
            verRating.addActionListener(e -> System.out.println(clienteTemporarioParaTeste.getAquisicoes())); */


        //ESPAÇO PARA COLOCAR O USERNAME NO LOGIN
        JTextField usernameLogin = new JTextField();
        usernameLogin.setToolTipText("exemplo: Joaquim243");

        JLabel usernameLoginTexto = new JLabel("Username");
        JLabel passwordLoginTexto = new JLabel("password");

        usernameLogin.setPreferredSize(new Dimension(100, 30));

        //ESPAÇO PARA COLOCAR A PASSWORD NO LOGIN
        JPasswordField passwordLogin = new JPasswordField();
        passwordLogin.setToolTipText("Exemplo: AnimalDeEstimação + numero preferido");

        passwordLogin.setEchoChar('*');
        passwordLogin.setPreferredSize(new Dimension(100, 30));
        pL.add(usernameLoginTexto);
        pL.add(usernameLogin);
        pL.add(passwordLoginTexto);
        pL.add(passwordLogin);

        //OPÇÃO DE SER MÚSICO NO LOGN
        JCheckBox artistaOpcaoLogin = new JCheckBox();

        artistaOpcaoLogin.setBounds(200, 430, 200, 25);
        artistaOpcaoLogin.setText("Sou Músico");

        //PIN DO MÚSICO NO LOGIN
        JLabel pinTextoLogin = new JLabel("PIN");
        pinTextoLogin.setVisible(false);


        JPasswordField pinArtistaLogin = new JPasswordField();
        pinArtistaLogin.setPreferredSize(new Dimension(100, 30));
        pinArtistaLogin.setVisible(false);

        JCheckBox verPasswordLogin = new JCheckBox();
        verPasswordLogin.setText("Ver password");
        pL.add(verPasswordLogin);
        pL.add(artistaOpcaoLogin);
        pL.add(pinTextoLogin);
        pL.add(pinArtistaLogin);


        //APARECE O PIN SE SELECIONAR A OPÇÃO DE MÚSICO E VICE-VERSA
        artistaOpcaoLogin.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtistaLogin.setVisible(true);
                pinTextoLogin.setVisible(true);
            } else {
                pinArtistaLogin.setVisible(false);
                pinTextoLogin.setVisible(false);
            }
            pL.revalidate();
            pL.repaint();
        });

        //OPÇÃO DE VER A PASSOWORD
        verPasswordLogin.addActionListener(e -> {
            if (verPasswordLogin.isSelected()) {   //mete a password visível ou apenas em "*"
                passwordLogin.setEchoChar('\u0000');
            } else {
                passwordLogin.setEchoChar('*');
            }
        });

        //BOTÃO CONFIRMAR O LOGIN
        JButton botaoConfirmarLogin = new JButton();
        botaoConfirmarLogin.setText("Confirmar");
        pL.add(botaoConfirmarLogin);

        //MÉTODO CONFIRMAÇÃO DE LOGIN
        //confirmar o Login em caso de cliente
        botaoConfirmarLogin.addActionListener(e -> {
        if (!artistaOpcaoLogin.isSelected()) {
                if ((clienteTemporarioLogin.login(usernameLogin.getText(), new String(passwordLogin.getPassword()),programa))) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + usernameLogin.getText() + "\nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                    pL.setVisible(false);
                    clienteTemporarioLogin.setUsername(usernameLogin.getText());
                    JLabel olaUsername = new JLabel();
                    olaUsername.setText("Olá, " + clienteTemporarioLogin.getUsername()+ "!");
                    painelCima.add(olaUsername);
                    painelCima.add(logout);
                    painelCliente.setVisible(true);
                    jp.setLayout(new BorderLayout());
                    jp.add(painelCliente);
                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password não encontrado/encontrada", "Ups", JOptionPane.WARNING_MESSAGE);
                }
            }
        //confirmar o Login em caso de artista
        else {

                if ((artistaTemporarioLogin.loginArtista(usernameLogin.getText(),new String(passwordLogin.getPassword()), Integer.parseInt(new String (pinArtistaLogin.getPassword())),programa))) {
                    JOptionPane.showMessageDialog(null, "Bem-vindo " + usernameLogin.getText() + "\nFique durante muito tempo", "Bem-vindo", JOptionPane.INFORMATION_MESSAGE);
                    pL.setVisible(false);
                    painelCliente.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Username/Password não encontrado/encontrada", "Ups", JOptionPane.WARNING_MESSAGE);
                }
            } } );



        //ESPAÇO PARA COLOCAR O USERNAME NO REGISTO
        JTextField username = new JTextField();
        username.setToolTipText("Exemplo: Joaquim354");

        JLabel usernameTexto = new JLabel("Username");
        JLabel passwordTexto = new JLabel("password");

        username.setPreferredSize(new Dimension(100,30));

        //ESPAÇO PARA COLOCAR A PASSWORD NO REGISTO
        JPasswordField password = new JPasswordField();
        password.setToolTipText("Exemplo: ClubePreferido + AnoDeNascimento");
        password.setEchoChar('*');
        password.setPreferredSize(new Dimension(100,30));
        pR.add(usernameTexto);
        pR.add(username);
        pR.add(passwordTexto);
        pR.add(password);

        //OPÇÃO DE VER A PASSWORD
        JCheckBox verPassword = new JCheckBox();
        verPassword.setText("Ver password");
        pR.add(verPassword);

        verPassword.addActionListener(e -> {if (verPassword.isSelected()){   //mete a password visível ou apenas em "*"
            password.setEchoChar('\u0000');
        } else {
            password.setEchoChar('*');
        }
        });

        //OPÇÃO DE SER MÚSICO
        JCheckBox artistaOpcao = new JCheckBox();

        artistaOpcao.setBounds(200, 430, 200, 25);
        artistaOpcao.setText("Sou Músico");
        pR.add(artistaOpcao);


        //PIN DO MÚSICO
        JLabel pinTexto = new JLabel("PIN");
        pR.add(pinTexto);
        pinTexto.setVisible(false);

        JPasswordField pinArtista = new JPasswordField();
        pinArtista.setText("Pin");
        pinArtista.setPreferredSize(new Dimension(100,30));
        pinArtista.setVisible(false);
        pR.add(pinArtista);

        artistaOpcao.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                pinArtista.setVisible(true);
                pinTexto.setVisible(true);
            } else {pinArtista.setVisible(false);
                pinTexto.setVisible(false);
            }
            pR.revalidate();
            pR.repaint();
        });

        //Ao carregar em LOGIN aparece o painél respetivo
        botaoLogin.addActionListener(e -> pn.setVisible(false));
        botaoLogin.addActionListener(e -> pL.setVisible(true));

        //Ao carregar em REGISTAR aparece o painél respetivo
        botaoRegistar.addActionListener(e -> pn.setVisible(false));
        botaoRegistar.addActionListener(e -> pR.setVisible(true));

        //BOTÃO VOLTAR ATRÁS PARA DO LOGIN
        JButton botaoVoltarAtrasLogin = new JButton();
        botaoVoltarAtrasLogin.setText(("Regressar"));
        botaoVoltarAtrasLogin.setVisible(true);

        pL.add(botaoVoltarAtrasLogin);

        //Ao carregar volta para o ecrã inicial
        botaoVoltarAtrasLogin.addActionListener(e -> pL.setVisible(false));
        botaoVoltarAtrasLogin.addActionListener(e -> pn.setVisible(true));

        //BOTÃO VOLTAR ATRÁS PARA DO REGISTO
        JButton botaoVoltarAtrasRegisto = new JButton();
        botaoVoltarAtrasRegisto.setText(("Regressar"));
        botaoVoltarAtrasRegisto.setVisible(true);

        //botão para CONFIRMAR O REGISTO
        JButton botaoConfirmar = new JButton();
        botaoConfirmar.setText("Confirmar");
        pR.add(botaoConfirmar);
        pR.add(botaoVoltarAtrasRegisto);

        //Ao carregar volta para o ecrã inicial
        botaoVoltarAtrasRegisto.addActionListener(e -> pR.setVisible(false));
        botaoVoltarAtrasRegisto.addActionListener(e -> pn.setVisible(true));

        //CONFIRMAÇÃO DO REGISTO
        //confirmação do registo em caso de cliente
        botaoConfirmar.addActionListener(e -> {
            if (!artistaOpcao.isSelected()) {
                if (clienteTemporarioRegisto.registar(username.getText(),programa)){
                JOptionPane.showMessageDialog(null,"Foi registado com sucesso. \nQue tenha ótimos momentos connosco","Parabéns", JOptionPane.INFORMATION_MESSAGE);
                pR.setVisible(false);
                pL.setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Username já existente", "Ups", JOptionPane.WARNING_MESSAGE);
                }
                }
            //confirmação do registo em caso de artista
        else {
            if (artistaTemporarioRegisto.registarArtista(username.getText(),programa)){
                JOptionPane.showMessageDialog(null,"Foi registado com sucesso. \nQue tenha ótimos momentos connosco","Parabéns", JOptionPane.INFORMATION_MESSAGE);
                pR.setVisible(false);
                pL.setVisible(true);
            }
            else {
                JOptionPane.showMessageDialog(null, "Username já existente.", "Ups", JOptionPane.WARNING_MESSAGE);
            }
        }
        });
















        jp.pack();
        jp.setLocationRelativeTo(null);
    }


}
