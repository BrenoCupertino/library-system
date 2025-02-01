package mainsystem;

import command.Icommand;
import command.LoanCommand;

import java.util.ArrayList;

public class Repository {
    private ArrayList<Users> users = new ArrayList<Users>();
    private ArrayList<Books> books = new ArrayList<Books>();
    private static Repository repository;

    private Repository(){}

    public static Repository getInstace() {
        if (repository == null) {
            repository = new Repository();
        }
        return repository;
    }

    public void addUser() {

    }

    public void addBook() {

    }

    public void findBookById() {

    }

    public void findUserById() {

    }
}
