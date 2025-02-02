import java.util.ArrayList;
import java.util.List;

public class Livro 
{
    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private String anoPublicacao;
    private List<Exemplar> exemplares = new ArrayList<Exemplar>();
    private int quantidadeDeExemplares = 0;

   

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublicacao)
    {
        this.codigo = codigo;
        this.titulo = titulo;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }


    public String getCodigo()
    {
        return codigo;
    }

    public boolean temExemplarDisponivel()
    {
        for (Exemplar exemplar : exemplares)
        {
            if (exemplar.isDisponivel())
                return true;
        }
        return false;
    }

    public int quantidadeDeExemplares()
    {
        for (Exemplar exemplar : exemplares)
        {
            quantidadeDeExemplares++;
        }
        return quantidadeDeExemplares;
    }
   
}
