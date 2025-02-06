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
            Console.getInstance().displayMessage(informations);
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
        }
    }

    public void userInfoRequest (String userId) {
        try {
            User user = getUserById(userId);
            String informations = user.getUserLoansAndReservesInformations();
            Console.getInstance().displayMessage(informations);
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
        }

    }

    public void notificationRequest (String userId) {
        try {
            User user = getUserById(userId);
            Professor prof = (Professor) user;
            int timesNotified = prof.getNotificationCount();
            Console.getInstance().displayMessage(MessageGenerator.notificationSucceededMessage(user, timesNotified));
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
        }

    }

    public void observerResquest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            book.addObserver((Professor) user);
            Console.getInstance().displayMessage(MessageGenerator.addObserverSucceededMessage(user, book));
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
        }
    }

    public void reservationRequest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            book.addReservation(user);
            Console.getInstance().displayMessage(MessageGenerator.reservationSucceededMessage(user, book));
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
        }
    }

    public void devolutionRequest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            user.returnBook(book);
            Console.getInstance().displayMessage(MessageGenerator.devolutionSucceededMessage(user, book));
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
        }
    }

    public void loanResquest(String userId, String bookId) {
        try {
            User user = getUserById(userId);
            Book book = getBookById(bookId);
            user.loanBook(book);
            Console.getInstance().displayMessage(MessageGenerator.loanSucceededMessage(user, book));
        } catch (Exception e) {
            Console.getInstance().displayMessage(e.getMessage());
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

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
