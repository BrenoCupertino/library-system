import java.time.LocalDateTime;

public class Professor extends UsuarioAbstrato
{

    public Professor(String codigoDoUsuario, String nome)
    {
        super.codigoDoUsuario = codigoDoUsuario;
        super.nome = nome;
        super.tempoLimiteDeEmprestimo = 8;
    }

    @Override
    public String emprestar(Livro livro) 
    {
        String mensagemDeRetorno;
        RegraEmprestimoAbstratoProfessor verificadorDeDisponibilidade = new RegraEmprestimoProfessor();
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
    
}
