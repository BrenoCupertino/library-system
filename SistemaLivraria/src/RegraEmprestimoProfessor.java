
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RegraEmprestimoProfessor implements RegraEmprestimoAbstratoProfessor
{
    public boolean estaEmDia(UsuarioAbstrato usuario)
    {
        Repositorio repositorio = Repositorio.obterInstancia();
        List<Emprestimo> emprestimos = repositorio.ObterListaDeEmprestimos();

        for (Emprestimo emprestimo : emprestimos)
        {
            if(emprestimo.getCodigoDoUsuario().equals(usuario.getCodigo()))
            {
                if (emprestimo.getEmprestimoEmAberto())
                {
                    long diasEmEmprestimo = ChronoUnit.DAYS.between(emprestimo.getDataInicio(), LocalDateTime.now());

                    if (diasEmEmprestimo > usuario.getTempoLimiteDeEmprestimo())
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean podeEmprestar(UsuarioAbstrato usuario, Livro livro)
    {
        boolean temExemplarDisponivel = livro.temExemplarDisponivel();
        boolean estaEmDia = estaEmDia(usuario);
        return (temExemplarDisponivel && estaEmDia);
    }
}