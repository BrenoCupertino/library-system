package exceptions;

public class LoanLimitExceededException extends RuntimeException {
    public LoanLimitExceededException() {
        super("[Falha] O usuário atingiu o numero máximo de emprestimo.");
    }
}
