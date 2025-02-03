package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;
import domain.user.User;

public class UserInfoCommand implements Icommand {

    private Repository repository;

    public UserInfoCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        User user = repository.getUserById(parameters.getFirstParameter());
        repository.userInfoRequest(user);


    }
}
