package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class UserInfoCommand implements Icommand {

    private Repository repository;

    public UserInfoCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.userInfoRequest(parameters.getFirstParameter());
    }
}
