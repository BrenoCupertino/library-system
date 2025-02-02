package mainsystem;

import subjects.User;
import subjects.Book;

import java.util.ArrayList;
import java.util.HashMap;
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

    public void loanBook(User user, Book book) {
        user.loanBook(book);

    }

    public User getUserById(String userId) {
        for (User user : users) {
            if (Objects.equals(user.getId(), userId)) {
                return user;
            }
        }
        // Fazer uma classe que terá diversas mensagens de erro
        throw new RuntimeException();
    }

    public Book getBookById(String bookId) {
        for (Book book : books) {
            if (Objects.equals(book.getId(), bookId)) {
                return book;
            }
        }
        // Fazer uma classe que terá diversas mensagens de erro
        throw new RuntimeException();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addBook(Book book) {
        books.add(book);
    }
}
