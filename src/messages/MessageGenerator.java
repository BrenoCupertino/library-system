package messages;

import domain.books.Book;
import domain.user.User;

public class MessageGenerator {

    public static String loanSucceededMessage(User user, Book book) {
        return "[Sucesso] " + user.getName() + " realizou o emprestimo do livro: " + book.getTitle();
    }

    public static String devolutionSucceededMessage(User user, Book book) {
        return "[Sucesso] " + user.getName() + " devolveu o livro: " + book.getTitle();
    }

    public static String reservationSucceededMessage(User user, Book book) {
        return "[Sucesso] " + user.getName() + " reservou o livro: " + book.getTitle();
    }

    public static String notificationSucceededMessage(User user, int timesNotified) {
        return "[Sucesso] " + user.getName() + " foi notificado: " + timesNotified + " vezes.";
    }

    public static String addObserverSucceededMessage(User user, Book book) {
        return "[Sucesso] " + user.getName() + " é observador do livro: " + book.getTitle();
    }

    public static String defaultMessage() {
        return "Digite um comando: ";
    }

    public static String exitMessage() {
        return "Saindo...";
    }
}
