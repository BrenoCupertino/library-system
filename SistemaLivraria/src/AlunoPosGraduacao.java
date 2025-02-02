
public class AlunoPosGraduacao extends UsuarioAbstrato
{
    protected int quantidadeLimiteDeEmprestimos;
    protected int quantidadeDeLivrosEmEmprestimo;

    public AlunoPosGraduacao()
    {
        super.tempoDeEmprestimo = 5;
        quantidadeLimiteDeEmprestimos = 3;
    }

    @Override
    public String emprestar(Livro livro)
    {
        
    }

    @Override
    public String getCodigo()
    {
        return super.codigoDoUsuario;
    }
    
    public boolean abaixoLimiteDeEmprestimos()
    {
        for (Livro livro : livrosEmEmprestimo)
        {
            quantidadeDeLivrosEmEmprestimo ++;
        }
        if (quantidadeDeLivrosEmEmprestimo == quantidadeLimiteDeEmprestimos)
            return false;

        return true;
    }
}
