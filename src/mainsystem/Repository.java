package mainsystem;

import observer.IObserver;
import subjects.user.Professor;
import subjects.user.User;
import subjects.books.Book;

import java.util.ArrayList;
import java.util.Objects;

public class Repository {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private static Repository repository;

    private Repository(){}

    public static Repository getInstace() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public void bookInfoRequest (Book book) {

    }

    public void userInfoRequest (User user) {

    }

    public void notificationRequest (User user) {
        Professor prof = (Professor)user;
        prof.getNotificationCount();
    }

    public void observerResquest(User user, Book book) {
        book.addObserver((Professor)user);
    }

    public void reservationRequest(User user, Book book) {
        book.addReservation(user);
    }

    public void devolutionRequest(User user, Book book) {
        user.returnBook(book);
    }

    public void loanResquest(User user, Book book) {
        user.loanBook(book);
    }

    public User getUserById(String userId) {
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }
        return null;
    }

    public Book getBookById(String bookId) {
        for (Book book : books) {
            if (Objects.equals(book.getId(), bookId)) {
                return book;
            }
        }
        return null;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
