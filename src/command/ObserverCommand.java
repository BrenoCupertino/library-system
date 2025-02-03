package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class ObserverCommand implements Icommand {

    private Repository repository;

    public ObserverCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.observerResquest(parameters.getFirstParameter(), parameters.getSecondParameter());
    }
}
