package strategy.rules;

import subjects.Book;
import subjects.User;

public class UserLoanStatusRule implements ILoanRule{

    @Override
    public boolean failValidation(User user, Book book) {
        return user.isDebtor();
    }
}
