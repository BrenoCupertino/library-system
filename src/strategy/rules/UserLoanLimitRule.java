package strategy.rules;

import exceptions.LoanLimitExceededException;
import domain.books.Book;
import domain.user.User;

public class UserLoanLimitRule implements ILoanRule{
    @Override
    public void validation(User user, Book book) {
        if(!user.userOnLimit()) {
            throw new LoanLimitExceededException();
        }
    }
}
