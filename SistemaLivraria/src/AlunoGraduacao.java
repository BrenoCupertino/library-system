import java.time.LocalDateTime;

public class AlunoGraduacao extends UsuarioAbstrato
{
    protected int quantidadeLimiteDeEmprestimos;
    protected int quantidadeDeLivrosEmEmprestimo;

    public AlunoGraduacao()
    {
        super.tempoDeEmprestimo = 4;
        quantidadeLimiteDeEmprestimos = 2;
    }


    @Override
    public String emprestar(Livro livro)
    {
        String mensagemDeRetorno;
        RegraEmprestimoAbstratoAluno verificadorDeDisponibilidade = new RegraEmprestimoAlunoGraduacao();
        boolean disponivel = verificadorDeDisponibilidade.podeEmprestar(this, livro);
        
        if (disponivel)
        {
            Emprestimo emprestimo = new Emprestimo(this.getCodigo(), livro.getCodigo(), LocalDateTime.now());
            Repositorio repositorio = Repositorio.obterInstancia();
            repositorio.ObterListaDeEmprestimos().add(emprestimo);
            super.livrosEmEmprestimo.add(livro);
            mensagemDeRetorno = "Empréstimo realizado com sucesso !";
            return mensagemDeRetorno;
        }
        else
        {
            mensagemDeRetorno = "Não foi possível realizar o empréstimo !";
            return mensagemDeRetorno;
        }
    }

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
