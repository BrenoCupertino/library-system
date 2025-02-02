
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class RegraEmprestimoAlunoGraduacao implements RegraEmprestimoAbstratoAluno
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
                    long diasEmEmprestimo = ChronoUnit.DAYS.between(emprestimo.getDataInicio(), emprestimo.getDataFim());

                    if (diasEmEmprestimo > 4)
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    public boolean abaixoLimiteDeEmprestimos(UsuarioAbstrato usuario)
    {
        AlunoGraduacao alunoGraduação =  (AlunoGraduacao) usuario;
        boolean abaixoLimiteDeEmprestimos = alunoGraduação.abaixoLimiteDeEmprestimos();
        
        return abaixoLimiteDeEmprestimos;
    }
    public boolean quantidadeDeReservaMenorDoQueExemplares(UsuarioAbstrato usuario, Livro livro)
    {
        Repositorio repositorio = Repositorio.obterInstancia();
        int quantidadeDeExemplares = livro.quantidadeDeExemplares();
        int quantidadeDeReservas = 0;
        boolean usuarioTemReserva = false;
        List<Reserva> reservasDoLivro = new ArrayList<>();
        reservasDoLivro = repositorio.obterReservasDeUmLivro(livro.getCodigo());

        for(Reserva reserva : reservasDoLivro)
        {
            if (usuario.getCodigo().equals(reserva.getCodigoDoUsuario()))
            {
                usuarioTemReserva = true;
            }

            quantidadeDeReservas++;
        }
        if (quantidadeDeReservas < quantidadeDeExemplares && !usuarioTemReserva)
            return true;

        return false;
    }
    public boolean reservasMenoresQueExemplares(UsuarioAbstrato usuario, Livro livro)
    {
        Repositorio repositorio = Repositorio.obterInstancia();
        int quantidadeDeExemplares = livro.quantidadeDeExemplares();
        int quantidadeDeReservas = 0;
        boolean usuarioTemReserva = false;
        List<Reserva> reservasDoLivro = new ArrayList<>();
        reservasDoLivro = repositorio.obterReservasDeUmLivro(livro.getCodigo());

        for(Reserva reserva : reservasDoLivro)
        {
            if (usuario.getCodigo().equals(reserva.getCodigoDoUsuario()))
            {
                usuarioTemReserva = true;
            }

            quantidadeDeReservas++;
        }
        if (quantidadeDeReservas >= quantidadeDeExemplares)
            {
                if (usuarioTemReserva) {
                    return true;
                }
                return false;
            }
        return true;
    }
    public boolean jaTemEmprestimoDesteLivro(UsuarioAbstrato usuario, Livro livro)
    {
        List<Livro> livrosEmEmprestimo = usuario.getLivrosEmEmprestimo();

        for(Livro livroEmprestado : livrosEmEmprestimo)
        {
            if(livroEmprestado.getCodigo().equals(livro.getCodigo()))
            {
                return true;
            }
        }
        return false;
        
    }

    @Override
    public boolean podeEmprestar(UsuarioAbstrato usuario, Livro livro)
    {
        
        boolean temExemplarDisponivel = livro.temExemplarDisponivel();
        boolean estaEmDia = estaEmDia(usuario);
        boolean abaixoLimiteDeEmprestimos = abaixoLimiteDeEmprestimos(usuario);
        boolean quantidadeDeReservaMenorDoQueExemplares = quantidadeDeReservaMenorDoQueExemplares(usuario, livro);
        boolean reservasMenoresQueExemplares = reservasMenoresQueExemplares(usuario, livro);
        boolean jaTemEmprestimoDesteLivro = jaTemEmprestimoDesteLivro(usuario,livro);

        return temExemplarDisponivel && estaEmDia && abaixoLimiteDeEmprestimos && quantidadeDeReservaMenorDoQueExemplares && (reservasMenoresQueExemplares || !jaTemEmprestimoDesteLivro);
    }
}