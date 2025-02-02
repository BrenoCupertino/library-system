package strategy.rules;

import subjects.books.Book;
import subjects.user.User;

public interface ILoanRule {
    boolean failValidation(User user, Book book);
}
