package strategy.rules;

import subjects.books.Book;
import subjects.user.User;

public class BookReservationRule implements ILoanRule{
    @Override
    public boolean failValidation(User user, Book book) {
        return book.isFullyReserved() && !user.isBookReserved(book);
    }
}
