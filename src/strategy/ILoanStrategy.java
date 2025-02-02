package strategy;

import subjects.books.Book;
import subjects.user.User;

public interface ILoanStrategy {
    boolean canGetLoan(User user, Book book);
}
