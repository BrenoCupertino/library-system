public class Professor implements UsuarioInterface
{
    private String codigoDoUsuario;
    private String nome;

    @Override
    public void emprestar() 
    {
        
    }

    @Override
    public String getCodigo() {
        return this.codigoDoUsuario;
    }

}
