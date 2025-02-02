import java.time.LocalDateTime;

public class AlunoGraduacao extends UsuarioAbstrato
{
    protected int quantidadeLimiteDeEmprestimos;
    protected int quantidadeDeLivrosEmEmprestimo;

    
    public AlunoGraduacao(String codigoDoUsuario, String nome)
    {
        super.codigoDoUsuario = codigoDoUsuario;
        super.nome = nome;
        super.tempoLimiteDeEmprestimo = 4;
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
            Repositorio repositorio = Repositorio.obterInstancia();
            Emprestimo emprestimo = new Emprestimo(this.getCodigo(), livro.getCodigo(), LocalDateTime.now());
            repositorio.ObterListaDeEmprestimos().add(emprestimo);
            super.livrosEmEmprestimo.add(livro);
            repositorio.removerReservaDaLista(super.codigoDoUsuario, livro.getCodigo());
            livro.obterExemplarDisponivel().indisponibilizarExemplar();
            mensagemDeRetorno = String.format("Empréstimo do livro %s realizado para o usuário %s", livro.getTitulo() ,super.getNome());
            return mensagemDeRetorno;
        }
        else
        {
            mensagemDeRetorno = String.format("Não foi possível realizar o empréstimo do livro %s para o usuário %s", livro.getTitulo() ,super.getNome());
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
