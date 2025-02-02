package strategy.rules;

import subjects.Book;
import subjects.User;

public class BookAvailabilityRule implements ILoanRule{
    public boolean failValidation(User user, Book book) {
        return !book.isBookAvailable();
    }
}
