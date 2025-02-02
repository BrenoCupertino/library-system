
import java.time.LocalDateTime;

public class Reserva
{

    private String codigoDoUsuario;
    private String codigoDoLivro;
    private LocalDateTime dataDaReserva;

    public Reserva(String codigoDoUsuario, String codigoDoLivro)
    {
        this.codigoDoUsuario = codigoDoUsuario;
        this.codigoDoLivro = codigoDoLivro;
        this.dataDaReserva = LocalDateTime.now();
    }

    public String getCodigoDoLivro()
    {
        return this.codigoDoLivro;
    }

    public String getCodigoDoUsuario()
    {
        return this.codigoDoUsuario;
    }
}
