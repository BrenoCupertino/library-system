package subjects.books;

import java.time.LocalDate;

public class LoanedBook {
    private BookSample bookSample;
    private LocalDate loanDate;
    private LocalDate loanReturnDate;
    private LoanStatus loanStatus;

    public LoanedBook(BookSample bookSample, int maxUserLoanDays) {
        this.bookSample = bookSample;
        this.loanDate = LocalDate.now();
        this.loanReturnDate = loanDate.plusDays(maxUserLoanDays);
        this.loanStatus = LoanStatus.LOANED;
    }

    public BookSample getBookSample() {
        return bookSample;
    }

    public void returnedBook() {
        setLoanStatus(LoanStatus.RETURNED);
        setLoanReturnDate(LocalDate.now());
        this.bookSample.setAvaliable(true);
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

    public LocalDate getLoanReturnDate() {
        return loanReturnDate;
    }

    public void setLoanReturnDate(LocalDate loanReturnDate) {
        this.loanReturnDate = loanReturnDate;
    }

    public LoanStatus getLoanStatus() {
        return loanStatus;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        this.loanStatus = loanStatus;
    }
}
