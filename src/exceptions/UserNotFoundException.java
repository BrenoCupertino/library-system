package exceptions;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException() {
        super("O código de usuário digitado não existe.");
    }
}
