package command;

import mainsystem.LoadParameters;
import mainsystem.Repository;
import subjects.books.Book;
import subjects.user.User;

public class LoanCommand implements Icommand {

    private Repository repository;

    public LoanCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        User user = repository.getUserById(parameters.getFirstParameter());
        Book book = repository.getBookById(parameters.getSecondParameter());
        repository.loanResquest(user, book);
    }
}
