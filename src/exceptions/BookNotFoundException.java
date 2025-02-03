package exceptions;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException() {
        super("O código do livro digitado não existe.");
    }
}
