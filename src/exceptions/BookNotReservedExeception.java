package exceptions;

public class BookNotReservedExeception extends RuntimeException {
    public BookNotReservedExeception() {
        super("[Falha] O usuário não possui uma reserva para este livro.");
    }
}
