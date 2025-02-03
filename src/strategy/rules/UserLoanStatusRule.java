package strategy.rules;

import exceptions.UserIsDebtorException;
import subjects.books.Book;
import subjects.user.User;

public class UserLoanStatusRule implements ILoanRule{

    @Override
    public void validation(User user, Book book) {
        if(user.isDebtor()) {
            throw new UserIsDebtorException();
        };
    }
}
