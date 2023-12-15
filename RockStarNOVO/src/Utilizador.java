public abstract class Utilizador {
    protected String username;
    protected String password;
    protected double saldo;

    public Utilizador(String username, String password, double saldo) {
        this.username = username;
        this.password = password;
        this.saldo = saldo;
    }

    protected void listarMusicas () {

    }

    protected void pesquisarMusicas () {

    }

    protected void login (String username, String password) {
    }

    protected void logout () {

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
