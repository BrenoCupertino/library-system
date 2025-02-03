package exceptions;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException() {
        super("[Falha] O livro não possui exemplares disponiveis.");
    }
}
