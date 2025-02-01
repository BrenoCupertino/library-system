package objects;

import strategy.LoanStrategy;

public class PosGraduationStudent extends User{
    static final int MAX_LOAN_BOOKS = 3;

    public PosGraduationStudent(String id, String name, LoanStrategy loanStrategy, int maxLoanDays) {
        super(id, name, loanStrategy, maxLoanDays);
    }
}
