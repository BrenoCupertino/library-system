package strategy.rules;

import subjects.books.Book;
import subjects.user.User;

public interface ILoanRule {
    void validation(User user, Book book);
}
