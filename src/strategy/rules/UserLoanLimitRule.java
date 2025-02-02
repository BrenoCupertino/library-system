package strategy.rules;

import subjects.books.Book;
import subjects.user.User;

public class UserLoanLimitRule implements ILoanRule{
    @Override
    public boolean failValidation(User user, Book book) {
        return !user.userOnLimit();
    }
}
