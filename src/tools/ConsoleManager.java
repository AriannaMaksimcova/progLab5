package tools;

import java.util.Scanner;

public class ConsoleManager {
    private CommandExecutor commandExecutor;
    private Scanner console;

    public ConsoleManager(CommandExecutor commandExecutor, Scanner scanner) {
        this.commandExecutor = commandExecutor;
        console = scanner;
    }

    public void readCommand() {

        //запрос команды


    }
}
