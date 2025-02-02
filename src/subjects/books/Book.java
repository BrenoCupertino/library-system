package subjects.books;

import subjects.user.User;

import java.util.ArrayList;

public class Book {
    private String id;
    private String name;
    private String editor;
    private String edition;
    private String year;
    private ArrayList<String> authors = new ArrayList<String>();
    private ArrayList<BookSample> samples = new ArrayList<BookSample>();
    private ArrayList<User> reservations = new ArrayList<User>();

    public Book(String id, String name, String editor, String edition, String year, ArrayList<String> authors) {
        this.id = id;
        this.name = name;
        this.editor = editor;
        this.edition = edition;
        this.year = year;
        this.authors = authors;
    }

    public void removeReservation (User user) {
        this.reservations.remove(user);
    }

    public boolean isFullyReserved() {
        return this.reservations.size() >= this.samples.size();
    }

    public boolean isBookAvailable() {
        for(BookSample sample: this.samples) {
            if(sample.isAvaliable()) {
                return true;
            }
        }
        return false;
    }

    public BookSample getAvaliableSample() {
        for (BookSample sample : samples) {
            if (sample.isAvaliable()) {
                return sample;
            }
        }
        return null;
    }

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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }
}
