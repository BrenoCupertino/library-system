package domain.books;

public class BookSample {
    private String id;
    private boolean avaliable = true;
    private Book book;

    public BookSample(String id, Book book) {
        this.id = id;
        this.book = book;
    }

    public String getMessageStatus() {
        if(this.avaliable) {
            return "disponível";
        }
        return "emprestado";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isAvaliable() {
        return avaliable;
    }

    public void setAvaliable(boolean avaliable) {
        this.avaliable = avaliable;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
