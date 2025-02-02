package subjects.books;

import java.time.LocalDate;

public class LoanedBook {
    private BookSample bookSample;
    private LocalDate loanDate;
    private LocalDate loanExpiratioDate;
    private LoanStatus loanStatus;

    public LoanedBook(BookSample bookSample, int maxUserLoanDays) {
        this.bookSample = bookSample;
        this.loanDate = LocalDate.now();
        this.loanExpiratioDate = loanDate.plusDays(maxUserLoanDays);
        this.loanStatus = LoanStatus.TO_DAY;
    }

    public BookSample getBookSample() {
        return bookSample;
    }

    public void setBookSample(BookSample bookSample) {
        this.bookSample = bookSample;
    }

    public LocalDate getLoanDate() {
        return loanDate;
    }

    public void setLoanDate(LocalDate loanDate) {
        this.loanDate = loanDate;
    }

    public LocalDate getLoanExpiratioDate() {
        return loanExpiratioDate;
    }

    public void setLoanExpiratioDate(LocalDate loanExpiratioDate) {
        this.loanExpiratioDate = loanExpiratioDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
