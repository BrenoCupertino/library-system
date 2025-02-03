package strategy.rules;

import exceptions.BookNotAvailableException;
import subjects.books.Book;
import subjects.user.User;

public class BookAvailabilityRule implements ILoanRule{
    public void validation(User user, Book book) {
        if(!book.isBookAvailable()) {
            throw  new BookNotAvailableException();
        };
    }
}
