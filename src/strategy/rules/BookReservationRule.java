package strategy.rules;

import subjects.Book;
import subjects.User;

public class BookReservationRule implements ILoanRule{
    @Override
    public boolean failValidation(User user, Book book) {
        return book.isFullyReserved() && !user.isBookReserved(book);
    }
}
