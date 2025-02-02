package strategy.rules;

import subjects.Book;
import subjects.User;

public interface ILoanRule {
    boolean failValidation(User user, Book book);
}
