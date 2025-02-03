package strategy.rules;

import exceptions.BookNotAvailableException;
import domain.books.Book;
import domain.user.User;

public class BookAvailabilityRule implements ILoanRule{
    public void validation(User user, Book book) {
        if(!book.isBookAvailable()) {
            throw  new BookNotAvailableException();
        };
    }
}
