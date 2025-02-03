package subjects.books;

import observer.IObserver;
import observer.ISubject;
import subjects.user.User;

import java.util.ArrayList;

public class Book implements ISubject {
    private String id;
    private String title;
    private String editor;
    private String edition;
    private String year;
    private static final int minReversesToNotify = 2;
    private ArrayList<String> authors;
    private ArrayList<BookSample> samples = new ArrayList<BookSample>();
    private ArrayList<User> reservations = new ArrayList<User>();
    private ArrayList<IObserver> observers = new ArrayList<IObserver>();

    public Book(String id, String name, String editor, String edition, String year, ArrayList<String> authors) {
        this.id = id;
        this.title = name;
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

    public void checkNumberReservations() {
        if (this.reservations.size() >= minReversesToNotify) {
            notifyObservers();
        }
    }

    public void addReservation(User user) {
        user.addReservation(this);

        this.reservations.add(user);

        checkNumberReservations();
    }

    @Override
    public void addObserver(IObserver user) {
        this.observers.add(user);
    }

    @Override
    public void notifyObservers() {
        for(IObserver observer: this.observers) {
            observer.update();
        }
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
