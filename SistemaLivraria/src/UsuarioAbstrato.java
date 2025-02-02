
// Utilização do padrão Strategy para implementar a lógica dos usuários

import java.util.ArrayList;
import java.util.List;

public abstract class UsuarioAbstrato
{
    protected String codigoDoUsuario;
    protected String nome;
    protected int tempoDeEmprestimo;
    protected List<Livro> livrosEmEmprestimo = new ArrayList<Livro>();

    public abstract String emprestar(Livro livro);
    public abstract String getCodigo();

    public int getTempoEmprestimo()
    {
        return this.tempoDeEmprestimo;
    }

    public List<Livro> getLivrosEmEmprestimo()
    {
        return livrosEmEmprestimo;
    }
}