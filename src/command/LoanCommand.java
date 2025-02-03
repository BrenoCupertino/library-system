package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class LoanCommand implements Icommand {

    private Repository repository;

    public LoanCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.loanResquest(parameters.getFirstParameter(), parameters.getSecondParameter());
    }
}
