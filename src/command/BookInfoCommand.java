package command;

import mainsystem.LoadParameters;
import mainsystem.Repository;

public class BookInfoCommand implements Icommand {

    private Repository repository;

    public BookInfoCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        // Invoker responsavel por tranferir o comando para o receiver (repository) executar
    }
}
