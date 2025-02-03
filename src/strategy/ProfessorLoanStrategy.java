package strategy;

import strategy.rules.*;
import subjects.books.Book;
import subjects.user.User;

import java.util.ArrayList;

public class ProfessorLoanStrategy implements ILoanStrategy {
    private ArrayList<ILoanRule> rules = new ArrayList<ILoanRule>();

    public ProfessorLoanStrategy() {
        initializeRules();
    }

    public void initializeRules(){
        rules.add(new BookAvailabilityRule());
        rules.add(new UserLoanStatusRule());
    }

    @Override
    public boolean canGetLoan(User user, Book book) {
        for (ILoanRule rule : rules) {
            rule.validation(user, book);
        }
        return true;
    }
}
