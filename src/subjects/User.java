package subjects;

import strategy.LoanStrategy;

import java.util.ArrayList;

public abstract class User {
    private String id;
    private String name;
    private LoanStrategy loanStrategy;
    private int MAX_LOAN_DAYS;
    private static final int MAX_RESERVATIONS = 3;
    private ArrayList<LoanedBook> loans = new ArrayList<LoanedBook>();
    private ArrayList<ReservedBook> reserves = new ArrayList<ReservedBook>(3);

    public User(String id, String name, LoanStrategy loanStrategy) {
        this.id = id;
        this.name = name;
        this.loanStrategy = loanStrategy;
    }

    public boolean isBookReserved(Book book) {
        for(ReservedBook reserve: this.reserves) {
            if(reserve.getBook().getId().equals(book.getId())) {
                return true;
            }
        }
        return false;
    }

    public int getNumLoans() {
        return loans.size();
    }

    public boolean isDebtor() {
        for(LoanedBook loan: this.loans) {
            if(loan.getLoanStatus() == LoanStatus.LATE){
                return true;
            }
        }
        return false;
    }

    public boolean canGetLoan(Book book) {
        return this.loanStrategy.canGetLoan(this, book);
    }

    public void loanBook(Book book) {
        BookSample sample = book.getAvaliableSample();

        if (!user.canGetLoan(book)) {

        }
    }

    public abstract boolean userOnLimit();

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
