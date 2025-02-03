package businessstrategy;

import exceptions.BookNotFoundException;
import exceptions.UserNotFoundException;
import messages.MessageGenerator;
import domain.user.Professor;
import domain.user.User;
import domain.books.Book;

import java.util.ArrayList;
import java.util.Objects;

public class Repository {
    private ArrayList<User> users = new ArrayList<User>();
    private ArrayList<Book> books = new ArrayList<Book>();
    private final Console console = Console.getInstance();

    private static Repository repository;

    private Repository(){}

    public static Repository getInstace() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public void bookInfoRequest (String bookId) {
        try {
            Book book = getBookById(bookId);
            String informations = book.getBookInformations();
            console.displayMessage(informations);
        } catch (Exception e) {
            console.displayMessage(e.getMessage());
        }
    }

    public void userInfoRequest (User user) {

    }

    public void notificationRequest (String userId) {
        try {
            User user = getUserById(userId);
            Professor prof = (Professor) user;
            int timesNotified = prof.getNotificationCount();
            console.displayMessage(MessageGenerator.notificationSucceededMessage(user, timesNotified));
        } catch (Exception e) {
            console.displayMessage(e.getMessage());
        }

    }

    public void observerResquest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            book.addObserver((Professor) user);
            console.displayMessage(MessageGenerator.addObserverSucceededMessage(user, book));
        } catch (Exception e) {
            console.displayMessage(e.getMessage());
        }
    }

    public void reservationRequest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            book.addReservation(user);
            console.displayMessage(MessageGenerator.reservationSucceededMessage(user, book));
        } catch (Exception e) {
            console.displayMessage(e.getMessage());
        }
    }

    public void devolutionRequest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            user.returnBook(book);
            console.displayMessage(MessageGenerator.devolutionSucceededMessage(user, book));
        } catch (Exception e) {
            console.displayMessage(e.getMessage());
        }
    }

    public void loanResquest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            user.loanBook(book);
            console.displayMessage(MessageGenerator.loanSucceededMessage(user, book));
        } catch (Exception e) {
            console.displayMessage(e.getMessage());
        }
    }

    public User getUserById(String userId) {
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }
        throw new UserNotFoundException();
    }

    public Book getBookById(String bookId) {
        for (Book book : books) {
            if (Objects.equals(book.getId(), bookId)) {
                return book;
            }
        }
        throw new BookNotFoundException();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
