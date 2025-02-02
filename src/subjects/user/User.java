package subjects.user;

import strategy.ILoanStrategy;
import subjects.books.LoanStatus;
import subjects.books.Book;
import subjects.books.BookSample;
import subjects.books.LoanedBook;
import subjects.books.ReservedBook;

import java.util.ArrayList;

public abstract class User {
    private String id;
    private String name;
    private ILoanStrategy loanStrategy;
    private int maxLoanDays;
    private static final int maxReservations = 3;
    private ArrayList<LoanedBook> loans = new ArrayList<LoanedBook>();
    private ArrayList<ReservedBook> reserves = new ArrayList<ReservedBook>(3);

    public User(String id, String name, ILoanStrategy loanStrategy, int maxLoanDays) {
        this.id = id;
        this.name = name;
        this.loanStrategy = loanStrategy;
        this.maxLoanDays = maxLoanDays;
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

    public boolean isBookReserved(Book book) {
        for(ReservedBook reserve: this.reserves) {
            if(reserve.getBook().getId().equals(book.getId())) {
                return true;
            }
        }
        return false;
    }

    public ReservedBook getReversedBook(Book book) {
        for (ReservedBook reserve : this.reserves) {
            if (book == reserve.getBook()) {
                return reserve;
            }
        }
        return null;
    }

    public void removeReservation(ReservedBook reservedBook) {
        this.reserves.remove(reservedBook);
    }

    public void analyseReservation(Book book) {
        if(!isBookReserved(book)) {
            return;
        }
        this.removeReservation(getReversedBook(book));
        book.removeReservation(this);
    }

    public void loanSample(BookSample sample) {
        sample.setAvaliable(false);
        loans.add(new LoanedBook(sample, this.maxLoanDays));
    }

    public void loanBook(Book book) {
        BookSample sample = book.getAvaliableSample();

        if (this.canGetLoan(book)) {
            loanSample(sample);
            //Mensagem de sucesso
        }
        this.analyseReservation(book);
    }

    public abstract boolean userOnLimit();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ILoanStrategy getLoanStrategy() {
        return loanStrategy;
    }

    public void setLoanStrategy(ILoanStrategy loanStrategy) {
        this.loanStrategy = loanStrategy;
    }
}
