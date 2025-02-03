package strategy.rules;

import exceptions.BookNotReservedExeception;
import subjects.books.Book;
import subjects.user.User;

public class BookReservationRule implements ILoanRule{
    @Override
    public void validation(User user, Book book) {
        if(book.isFullyReserved() && !user.isBookReserved(book)) {
            throw new BookNotReservedExeception();
        }
    }
}
