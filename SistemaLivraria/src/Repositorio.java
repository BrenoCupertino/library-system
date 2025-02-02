
// Utilização do padrão Singleton para implementar a classe em que vão permanecer os dados de usuários e livros

import java.util.ArrayList;
import java.util.List;

public class Repositorio
{
    private List<UsuarioAbstrato> usuarios = new ArrayList<UsuarioAbstrato>();
	private List<Livro> livros = new ArrayList<Livro>();
    private List<Reserva> reservas = new ArrayList<Reserva>();
    private List<Emprestimo> emprestimos = new ArrayList<Emprestimo>();
                                                
    private static Repositorio instancia;
    
    private Repositorio()
    {
        // Construtor vazio
    }

    public static Repositorio obterInstancia()
    {
        if (instancia == null)
            instancia = new Repositorio();
        
        return instancia;
    }

    public UsuarioAbstrato obterUsuarioPorCodigo(String codigoDoUsuario)
    {
        for (UsuarioAbstrato usuario : usuarios)
        {
            if (usuario.getCodigo() == codigoDoUsuario)
                return usuario;
        }
        return null;
    }

    public Livro obterLivroPorCodigo(String codigoDoLivro)
    {
        for (Livro livro : livros)
        {
            if (livro.getCodigo() == codigoDoLivro)
                return livro;
        }
        return null;
    }

    public List<Reserva> obterReservasDeUmLivro(String codigoDoLivro)
    {
        List<Reserva> reservasDoLivro = new ArrayList<>();

        for(Reserva reserva : reservas)
        {
            if (reserva.getCodigoDoLivro().equals(codigoDoLivro))
            {
                reservasDoLivro.add(reserva);
            }
        }
        return reservasDoLivro;
    }

    public List<Emprestimo> ObterListaDeEmprestimos()
    {
        return emprestimos;
    }
}
