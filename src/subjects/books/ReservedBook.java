package subjects.books;

import java.time.LocalDate;

public class ReservedBook {
    Book book;
    private LocalDate reservedDate;

    public ReservedBook(Book book) {
        this.book = book;
        this.reservedDate = LocalDate.now();
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
