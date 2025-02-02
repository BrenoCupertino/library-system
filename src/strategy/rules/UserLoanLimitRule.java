package strategy.rules;

import subjects.Book;
import subjects.User;

public class UserLoanLimitRule implements ILoanRule{
    @Override
    public boolean failValidation(User user, Book book) {
        return !user.userOnLimit();
    }
}
