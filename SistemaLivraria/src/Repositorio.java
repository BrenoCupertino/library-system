
// Utilização do padrão Singleton para implementar a classe em que vão permanecer os dados de usuários e livros

import java.util.ArrayList;
import java.util.List;

public class Repositorio
{
    private List<UsuarioInterface> usuarios = new ArrayList<UsuarioInterface>();
	private List<Livro> livros = new ArrayList<Livro>();

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

    public UsuarioInterface obterUsuarioPorCodigo(String codigoDoUsuario)
    {
        for (UsuarioInterface usuario : usuarios)
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
}
