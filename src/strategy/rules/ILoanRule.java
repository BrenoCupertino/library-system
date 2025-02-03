package strategy.rules;

import domain.books.Book;
import domain.user.User;

public interface ILoanRule {
    void validation(User user, Book book);
}
