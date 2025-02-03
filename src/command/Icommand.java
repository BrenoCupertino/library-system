package command;

import businessstrategy.LoadParameters;

public interface Icommand {
    void execute(LoadParameters parameters);
}
