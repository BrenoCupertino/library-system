public class Livro 
{
    private String codigo;
    private String titulo;
    private String editora;
    private String autores;
    private String edicao;
    private String anoPublicacao;
    

   

    public Livro(String codigo, String titulo, String editora, String autores, String edicao, String anoPublicacao) {
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
    

}
