package command;

import mainsystem.LoadParameters;
import mainsystem.Repository;
import subjects.user.User;

public class NotificationCommand implements Icommand {

    private Repository repository;

    public NotificationCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        // Invoker responsavel por tranferir o comando para o receiver (repository) executar
        User user = repository.getUserById(parameters.getFirstParameter());
        repository.notificationRequest(user);
    }
}
