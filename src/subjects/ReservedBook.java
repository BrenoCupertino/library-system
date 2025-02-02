package subjects;

import java.time.LocalDate;

public class ReservedBook {
    Book book;
    private LocalDate reservedDate;

    public ReservedBook(Book book, LocalDate reservedDate) {
        this.book = book;
        this.reservedDate = reservedDate;
    }

    public LocalDate getReservedDate() {
        return reservedDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public void setReservedDate(LocalDate reservedDate) {
        this.reservedDate = reservedDate;
    }
}
