package objects;

import strategy.LoanStrategy;

import java.util.ArrayList;

public class Professor extends User {

    public Professor(String id, String name, LoanStrategy loanStrategy, int maxLoanDays) {
        super(id, name, loanStrategy, maxLoanDays);
    }
}
