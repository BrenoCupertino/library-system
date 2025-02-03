package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class DevolutionCommand implements Icommand {

    private Repository repository;

    public DevolutionCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.devolutionRequest(parameters.getFirstParameter(), parameters.getSecondParameter());
    }
}
