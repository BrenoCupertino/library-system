package mainsystem;

import messages.MessageManager;
import subjects.user.Professor;
import subjects.user.User;
import subjects.books.Book;

import java.util.ArrayList;
import java.util.Objects;

public class Repository {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private Console console = Console.getInstance();

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
        int timesNotified = prof.getNotificationCount();

        console.clearConsole();
        MessageManager.notificationSucceededMessage(user ,timesNotified);

    }

    public void observerResquest(User user, Book book) {
        book.addObserver((Professor)user);

        console.clearConsole();
        MessageManager.addObserverSucceededMessage(user, book);
    }

    public void reservationRequest(User user, Book book) {
        try {
            book.addReservation(user);
            console.clearConsole();
            MessageManager.reservationSucceededMessage(user, book);
        } catch (Exception e) {
            console.clearConsole();
            MessageManager.ExceptionMessage(e.getMessage());
        }
    }

    public void devolutionRequest(User user, Book book) {
        try {
            user.returnBook(book);
            console.clearConsole();
            MessageManager.devolutionSucceededMessage(user, book);
        } catch (Exception e) {
            console.clearConsole();
            MessageManager.ExceptionMessage(e.getMessage());
        }
    }

    public void loanResquest(User user, Book book) {
        try {
            user.loanBook(book);
            console.clearConsole();
            MessageManager.loanSucceededMessage(user, book);
        } catch (Exception e) {
            console.clearConsole();
            MessageManager.ExceptionMessage(e.getMessage());
        }
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
