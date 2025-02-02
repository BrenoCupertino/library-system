

public class Exemplar {

    private boolean disponivel;
    private String codigoExemplar;

    public Exemplar(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void emprestar() {
        this.disponivel = false;
    }

    public String getCodigoExemplar()
    {
        return codigoExemplar;
    }
}