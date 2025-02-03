package exceptions;

public class ReserveLimitExceededException extends RuntimeException {
    public ReserveLimitExceededException() {
        super("[Falha] O usuário atingiu o numero máximo de reservas.");
    }
}
