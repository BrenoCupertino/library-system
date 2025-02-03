package mainsystem;

import command.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Console {
    private final HashMap<String, Icommand> commands = new HashMap<String, Icommand>();
    private static Console console;

    public Console() {
        initializeCommands();
    }

    public void initializeCommands() {
        commands.put("emp", new LoanCommand());
        commands.put("dev", new DevolutionCommand());
        commands.put("res", new ReserveCommand());
        commands.put("obs", new ObserverCommand());
        commands.put("liv", new BookInfoCommand());
        commands.put("usu", new UserInfoCommand());
        commands.put("ntf", new NotificationCommand());
    }

    public static Console getInstance() {
        if (console == null) {
            console = new Console();
        }
        return console;
    }

    public void log(String str) {
        System.out.println(str);
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void start() {

        while (true) {}
    }

    public void executeCommand(String strCommand, LoadParameters args) {
        Icommand command = commands.get(strCommand);
        command.execute(args);
    }
}
