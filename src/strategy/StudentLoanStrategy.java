package strategy;

import strategy.rules.*;
import domain.books.Book;
import domain.user.User;

import java.util.ArrayList;

public class StudentLoanStrategy implements ILoanStrategy {
    private ArrayList<ILoanRule> rules = new ArrayList<ILoanRule>();

    public StudentLoanStrategy() {
        initializeRules();
    }

    public void initializeRules(){
        rules.add(new BookAvailabilityRule());
        rules.add(new UserLoanStatusRule());
        rules.add(new BookReservationRule());
        rules.add(new UserLoanLimitRule());
    }

    @Override
    public boolean canGetLoan(User user, Book book) {
        for (ILoanRule rule : rules) {
            rule.validation(user, book);
        }
        return true;
    }
}
