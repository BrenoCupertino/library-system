package command;

import mainsystem.LoadParameters;
import mainsystem.Repository;
import subjects.books.Book;
import subjects.user.User;

public class DevolutionCommand implements Icommand {

    private Repository repository;

    public DevolutionCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        User user = repository.getUserById(parameters.getFirstParameter());
        Book book = repository.getBookById(parameters.getSecondParameter());
        repository.devolutionRequest(user, book);
    }
}
