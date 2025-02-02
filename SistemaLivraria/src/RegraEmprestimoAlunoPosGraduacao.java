
public class RegraEmprestimoAlunoPosGraduacao implements RegraEmprestimoAbstratoAluno
{
    public boolean estaEmDia(UsuarioAbstrato usuario)
    {
        return false; // Falta codificar
    }
    public boolean abaixoLimiteDeEmprestimos(UsuarioAbstrato usuario)
    {
        AlunoPosGraduacao alunoPosGraduação =  (AlunoPosGraduacao) usuario;
        alunoPosGraduação.abaixoLimiteDeEmprestimos();

        return false;
    }
    public boolean jaPossuiEsteLivro(UsuarioAbstrato usuario)
    {
        return false;
    }
    public boolean temReservaParaEsteLivro(UsuarioAbstrato usuario)
    {
        return false;
    }
    public boolean reservasMenoresQueExemplares(UsuarioAbstrato usuario)
    {
        return false;
    }

    @Override
    public boolean podeEmprestar(UsuarioAbstrato usuario, Livro livro)
    {
        
        boolean temExemplarDisponivel = livro.temExemplarDisponivel();
        boolean estaEmDia = estaEmDia(usuario);
        boolean abaixoLimiteDeEmprestimos = abaixoLimiteDeEmprestimos(usuario);
        boolean jaPossuiEsteLivro = jaPossuiEsteLivro(usuario);
        boolean temReservaParaEsteLivro = temReservaParaEsteLivro(usuario);
        boolean reservasMenoresQueExemplares = reservasMenoresQueExemplares(usuario);

        return temExemplarDisponivel && estaEmDia && abaixoLimiteDeEmprestimos && !jaPossuiEsteLivro && (reservasMenoresQueExemplares || temReservaParaEsteLivro);
    }
}