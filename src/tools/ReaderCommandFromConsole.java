package tools;

import java.util.Scanner;

public class ReaderCommandFromConsole {
    private CommandExecutor commandExecutor;
    private Scanner console;

    public ReaderCommandFromConsole(CommandExecutor commandExecutor) {
        this.commandExecutor = commandExecutor;
        console = new Scanner(System.in);
    }

    public void readCommand() {

        //запрос команды
        System.out.println("Введите команду. Если не знакомы с командами, введите \"help\".");
        if (console.hasNext()) {
            String[] commandline = console.nextLine().split(" ");
                String command = commandline[0];
                commandExecutor.executeCommand(command);
            } else {
                System.out.println("Команда введена неверно. Попробуйте ещё раз.");
            }
        }
    }
