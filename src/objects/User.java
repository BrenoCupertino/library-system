package objects;

import strategy.LoanStrategy;

public abstract class User {
    private String id;
    private String name;
    private LoanStrategy loanStrategy;
    private int MAX_LOAN_DAYS;

    public User(String id, String name, LoanStrategy loanStrategy, int MAX_LOAN_DAYS) {
        this.id = id;
        this.name = name;
        this.loanStrategy = loanStrategy;
        this.MAX_LOAN_DAYS = MAX_LOAN_DAYS;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getMAX_LOAN_DAYS() {
        return MAX_LOAN_DAYS;
    }

    public void setMAX_LOAN_DAYS(int MAX_LOAN_DAYS) {
        this.MAX_LOAN_DAYS = MAX_LOAN_DAYS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LoanStrategy getLoanStrategy() {
        return loanStrategy;
    }

    public void setLoanStrategy(LoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
    }
}
