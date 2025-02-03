package exceptions;

public class UserIsDebtorException extends RuntimeException {
    public UserIsDebtorException() {
        super("[Falha] O usuário possui emprestimo(s) de livro(s) atrasado(s).");
    }
}
