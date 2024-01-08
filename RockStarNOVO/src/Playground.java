import Modelo.*;
import Visual.*;

import javax.swing.*;


public class Playground {
    public static void main(String[] args) {

       // Cliente paulo = new Cliente("paulo", "1235");

        /////// TESTE DE OUTRA COISA; CLASSE ROCKSTAR APP PRA VER IDEIAS DE COISAS E ORGANIZAÇÃO GRAFICA
       // RockstarApp oi = new RockstarApp();
        JFrame frame = new JFrame();
        JDialogAdicionarMusica dialog = new JDialogAdicionarMusica(frame);
        dialog.setVisible(true);

    }
}
