package messages;

import subjects.books.Book;
import subjects.user.Professor;
import subjects.user.User;

public class MessageManager {

    public static void loanSucceededMessage(User user, Book book) {
        System.out.println("-----------------------------");
        System.out.println("[Sucesso] " +user.getName() + " realizou o emprestimo do livro: " + book.getTitle());
        System.out.println("-----------------------------");
    }

    public static void devolutionSucceededMessage(User user, Book book) {
        System.out.println("-----------------------------");
        System.out.println("[Sucesso] " + user.getName() + " devolveu o livro: " + book.getTitle());
        System.out.println("-----------------------------");
    }

    public static void reservationSucceededMessage(User user, Book book) {
        System.out.println("-----------------------------");
        System.out.println("[Sucesso] " + user.getName() + " reservou o livro: " + book.getTitle());
        System.out.println("-----------------------------");
    }

    public static void notificationSucceededMessage(User user, int timesNotified) {
        System.out.println("-----------------------------");
        System.out.println("[Sucesso] " + user.getName() + " foi notificado: " + timesNotified + " vezes.");
        System.out.println("-----------------------------");
    }

    public static void addObserverSucceededMessage(User user, Book book) {
        System.out.println("-----------------------------");
        System.out.println("[Sucesso] " + user.getName() + " é observador do livro: " + book.getTitle());
        System.out.println("-----------------------------");
    }

    public static void ExceptionMessage(String message) {
        System.out.println("-----------------------------");
        System.out.println(message);
        System.out.println("-----------------------------");
    }

}
