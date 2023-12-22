package Visual;

import java.io.*;

public class FicheiroObjetos {
    private ObjectInputStream iS;
    private ObjectOutputStream oS;

    private File f;

    public FicheiroObjetos(String nomeDoFicheiro) {
        f = new File (nomeDoFicheiro);
    }

    public File getF() {
        return f;
    }

    public boolean abreLeitura(String nomeDoFicheiro) throws IOException {

        if (f != null) {
            iS = new ObjectInputStream(new FileInputStream(f));
            if (iS != null) return true;
            else return false;
        }
        return false;
    }

    public void abreEscrita(String nomeDoFicheiro) throws IOException {
        oS = new ObjectOutputStream(new FileOutputStream(nomeDoFicheiro));
    }

    public Object leObjeto() throws IOException, ClassNotFoundException {
        return iS.readObject();
    }

    public void escreveObjeto(Object o) throws IOException {
        oS.writeObject(o);
    }

    public void fechaLeitura() throws IOException {
        iS.close();
    }

    public void fechaEscrita() throws IOException {
        oS.close();
    }

}
