package domain.books;

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

    public String getMessageFromStatus() {
        checkAndUpdateStatusToLate();

        if(this.loanStatus == LoanStatus.LOANED) {
            return "Em curso";
        } else if(this.loanStatus == LoanStatus.LATE) {
            return "Atrasado";
        }

        return "Finalizado";
    }

    public String getBookTitle() {
        return this.bookSample.getBook().getTitle();
    }

    public BookSample getBookSample() {
        return bookSample;
    }

    public void returnedBook() {
        setLoanStatus(LoanStatus.RETURNED);
        setLoanReturnDate(LocalDate.now());
        this.bookSample.setAvaliable(true);
    }

    public void checkAndUpdateStatusToLate() {
        if(this.loanReturnDate.isBefore(LocalDate.now()) && this.loanStatus != LoanStatus.RETURNED) {
            setLoanStatus(LoanStatus.LATE);
        }
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
