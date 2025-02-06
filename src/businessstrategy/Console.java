package businessstrategy;

import command.*;
import messages.MessageGenerator;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Console {
    private HashMap<String, Icommand> commands = new HashMap<String, Icommand>();
    private Scanner scanner;
    private static Console console;

    public Console() {
        scanner = new Scanner(System.in);
        console = this;
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

    public void displayMessage(String message) {
        clearConsole();
        System.out.println("-----------------------------");
        System.out.println(message);
        System.out.println("-----------------------------");
    }

    public static Console getInstance() {
        if (console == null) {
            console = new Console();
        }
        return console;
    }

    public void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public void start() {

        while (true) {
            System.out.println(MessageGenerator.defaultMessage());
            String input = scanner.nextLine();
            String[] commandAndArgs = input.split(" ");
            String command = commandAndArgs[0];

            if(Objects.equals(command, "sai")) {
                System.out.println(MessageGenerator.exitMessage());
                break;
            }

            if(commandAndArgs.length > 2) {
                LoadParameters args = new LoadParameters(commandAndArgs[1], commandAndArgs[2]);
                executeCommand(command, args);
            } else {
                LoadParameters args = new LoadParameters(commandAndArgs[1]);
                executeCommand(command, args);
            }

        }
    }

    public void executeCommand(String strCommand, LoadParameters args) {
        Icommand command = commands.get(strCommand);
        command.execute(args);
    }
}
