package subjects.user;

import strategy.ILoanStrategy;

public class Professor extends User {
    static final int maxLoanDays = 4;

    public Professor(String id, String name, ILoanStrategy loanStrategy) {
        super(id, name, loanStrategy, maxLoanDays);
    }

    @Override
    public boolean userOnLimit() {
        return false;
    }
}
