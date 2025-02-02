package command;

import mainsystem.LoadParameters;
import mainsystem.Repository;
import subjects.books.Book;
import subjects.user.User;

public class ObserverCommand implements Icommand {

    private Repository repository;

    public ObserverCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        // Invoker responsavel por tranferir o comando para o receiver (repository) executar
        User user = repository.getUserById(parameters.getFirstParameter());
        Book book = repository.getBookById(parameters.getSecondParameter());
        repository.observerResquest(user, book);
    }
}
