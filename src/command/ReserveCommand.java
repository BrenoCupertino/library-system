package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class ReserveCommand implements Icommand {

    private Repository repository;

    public ReserveCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.reservationRequest(parameters.getFirstParameter(), parameters.getSecondParameter());
    }
}
