package strategy.rules;

import subjects.books.Book;
import subjects.user.User;

public class BookAvailabilityRule implements ILoanRule{
    public boolean failValidation(User user, Book book) {
        return !book.isBookAvailable();
    }
}
