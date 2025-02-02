package subjects.user;

import strategy.ILoanStrategy;

public class GraduationStudent extends User {
    static final int maxLoanBooks = 2;
    static final int maxLoanDays = 4;

    public GraduationStudent(String id, String name, ILoanStrategy loanStrategy) {
        super(id, name, loanStrategy, maxLoanDays);
    }

    public boolean userOnLimit() {
        return super.getNumLoans() <= maxLoanBooks;
    }
}
