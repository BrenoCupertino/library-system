package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class NotificationCommand implements Icommand {

    private Repository repository;

    public NotificationCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.notificationRequest(parameters.getFirstParameter());
    }
}
