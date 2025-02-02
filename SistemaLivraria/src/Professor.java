
public class Professor extends UsuarioAbstrato
{

    public Professor()
    {
        super.tempoDeEmprestimo = 8;
    }

    @Override
    public String emprestar(Livro livro) 
    {
        
    }

    @Override
    public String getCodigo() {
        return super.codigoDoUsuario;
    }

   
    
}
