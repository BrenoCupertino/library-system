package strategy;

import domain.books.Book;
import domain.user.User;

public interface ILoanStrategy {
    boolean canGetLoan(User user, Book book);
}
