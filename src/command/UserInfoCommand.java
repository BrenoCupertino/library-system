package command;

import mainsystem.LoadParameters;
import mainsystem.Repository;

public class UserInfoCommand implements Icommand {

    private Repository repository;

    public UserInfoCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        // Invoker responsavel por tranferir o comando para o receiver (repository) executar
    }
}
