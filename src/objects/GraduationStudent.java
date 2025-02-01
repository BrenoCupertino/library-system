package objects;

import strategy.LoanStrategy;

public class GraduationStudent extends User {
    static final int MAX_LOAN_BOOKS = 2;

    public GraduationStudent(String id, String name, LoanStrategy loanStrategy, int maxLoanDays) {
        super(id, name, loanStrategy, maxLoanDays);
    }
}
