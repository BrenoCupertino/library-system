package domain.user;

import exceptions.BookAlreadyReservedException;
import exceptions.DevolutionBookException;
import exceptions.ReserveLimitExceededException;
import strategy.ILoanStrategy;
import domain.books.LoanStatus;
import domain.books.Book;
import domain.books.BookSample;
import domain.books.LoanedBook;
import domain.books.ReservedBook;

import java.util.ArrayList;

public abstract class User {
    private String id;
    private String name;
    private ILoanStrategy loanStrategy;
    private int maxLoanDays;
    private static final int maxReserves = 3;
    private ArrayList<LoanedBook> loans = new ArrayList<LoanedBook>();
    private ArrayList<ReservedBook> reserves = new ArrayList<ReservedBook>();
    private ArrayList<LoanedBook> historyLoans = new ArrayList<LoanedBook>();

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
            loan.checkAndUpdateStatusToLate();
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
            if(reserve.getBook().equals(book)) {
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

    public LoanedBook getLoanedBook(Book book) {
        for (LoanedBook loanedBook : this.loans) {
            if (book == loanedBook.getBookSample().getBook()) {
                return loanedBook;
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
        removeReservation(getReversedBook(book));
        book.removeReservation(this);
    }

    public void loanBook(Book book) {
        BookSample sample = book.getAvaliableSample();

        if (this.canGetLoan(book)) {
            sample.setAvaliable(false);
            loans.add(new LoanedBook(sample, this.maxLoanDays));
        }
        this.analyseReservation(book);
    }

    public void removeLoanedBook(LoanedBook loanedBook) {
        this.loans.remove(loanedBook);
    }

    public void addLoanedBookToHistory(LoanedBook loanedBook) {
        this.historyLoans.add(loanedBook);
    }

    public void returnBook(Book book) {
        LoanedBook loanedBook = getLoanedBook(book);
        if(loanedBook == null) {
            throw new DevolutionBookException();
        }
        removeLoanedBook(loanedBook);
        loanedBook.returnedBook();
        addLoanedBookToHistory(loanedBook);
    }

    public boolean onReservationLimit() {
        return this.reserves.size() < maxReserves;
    }

    public boolean canIReserve(Book book) {
        if(!onReservationLimit()) {
            throw new ReserveLimitExceededException();
        }

        if(isBookReserved(book)) {
            throw new BookAlreadyReservedException();
        }

        return true;
    }

    public void addReservation(Book book) {
        if(canIReserve(book)) {
            this.reserves.add(new ReservedBook(book));
        }
    }

    public String getLoanInformations(ArrayList<LoanedBook> array) {
        String loanInfo = "";

        if(array.isEmpty()) return "0 \n";

        for(LoanedBook loan: array) {
            loanInfo += "\n";
            loanInfo += "   Titulo: " + loan.getBookTitle() + "\n";
            loanInfo += "   Data do emprestimo: " + loan.getLoanDate() + "\n";
            loanInfo += "   Status: " + loan.getMessageFromStatus() + "\n";
            loanInfo += "   Data de devolução: " +loan.getLoanReturnDate() + "\n";
        }

        return loanInfo;
    }

    public String getReserveInformations() {
        String reserveInfo = "";

        if(this.reserves.isEmpty()) return "0 \n";

        for(ReservedBook reserve: this.reserves) {
            reserveInfo += "    \nTitulo: " + reserve.getBook().getTitle() + "\n";
            reserveInfo += "    Data da reserva: " + reserve.getReservedDate()+ "\n";
            reserveInfo += "\n";
        }

        return reserveInfo;
    }

    public String getUserLoansAndReservesInformations() {
        String informations = "";
        informations += "Reservas: ";
        informations += getReserveInformations();
        informations += "Emprestimos correntes: ";
        informations += getLoanInformations(this.loans);
        informations += "Emprestimos antigos: ";
        informations += getLoanInformations(this.historyLoans);
        return informations;
    }

    public abstract boolean userOnLimit();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<LoanedBook> getLoans() {
        return loans;
    }

}
