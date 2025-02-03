package exceptions;

public class BookAlreadyReservedException extends RuntimeException {
    public BookAlreadyReservedException() {
        super("[Falha] O usuário já possui reserva para o livro.");
    }
}
