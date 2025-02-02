package strategy;

import subjects.Book;
import subjects.User;

public interface LoanStrategy {
    boolean canGetLoan(User user, Book book);
}
