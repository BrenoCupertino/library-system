package command;

import businessstrategy.LoadParameters;
import businessstrategy.Repository;

public class BookInfoCommand implements Icommand {

    private Repository repository;

    public BookInfoCommand() {
        this.repository = Repository.getInstace();
    }

    public void execute(LoadParameters parameters) {
        repository.bookInfoRequest(parameters.getFirstParameter());
    }
}
