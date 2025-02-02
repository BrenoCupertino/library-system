package strategy;

import strategy.rules.*;
import subjects.Book;
import subjects.User;

import java.util.ArrayList;

public class StudentLoanStrategy implements LoanStrategy {
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
            if (rule.failValidation(user, book)) {
                return false;
            }
        }
        return true;
    }
}
