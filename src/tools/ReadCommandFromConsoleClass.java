package tools;

import java.util.Scanner;

public class ReadCommandFromConsoleClass {
    private CommandExecutor commandExecutor;
    private Scanner console;

    public ReadCommandFromConsoleClass(CommandExecutor commandExecutor, Scanner console) {
        this.commandExecutor = commandExecutor;
        this.console = console;
    }

    public void readCommand() {
        //запрос команды
        System.out.println("Введите команду по шаблону. Если не знакомы с шаблонами, введите \"help\".");
        if (console.hasNext()) {
            String[] commandline = console.nextLine().split(" ");
            if (commandline.length == 1) {
                String command = commandline[0];
                commandExecutor.executeCommand(command);
            } else if (commandline.length > 1) {
                String command = commandline[0];
                String argument = commandline[1];
                commandExecutor.executeCommandWithArgument(command);
            } else {
                System.out.println("Команда введена неверно. Попробуйте ещё раз.");
            }
        }
    }
}
