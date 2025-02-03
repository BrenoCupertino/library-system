package exceptions;

public class DevolutionBookException extends RuntimeException {
    public DevolutionBookException() {
        super("[Falha] O usuário não possui nenhum exemplar deste livro com emprestimo em aberto.");
    }
}
