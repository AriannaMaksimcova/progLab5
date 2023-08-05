package tools;

import organizations.Address;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Class that controlling what happens in console.
 */

public class ConsoleHandler {
    private final Scanner scanner;
    private final CommandExecutor commandExecutor;
    private final OrganizationReader organizationReader;

    public ConsoleHandler(Scanner scanner, CommandExecutor commandExecutor, OrganizationReader organizationReader) {
        this.scanner = scanner;
        this.commandExecutor = commandExecutor;
        this.organizationReader = organizationReader;
    }

    public void readCommand(){
        //чтение команды из консоли и её исполнение
        while (true) {
            System.out.println("Enter the command. If you are not familiar with the commands, enter \"help\".");
            try {
                String input = scanner.nextLine();
                String[] commandline = input.split(" ");
                String command = commandline[0];
                if (commandline.length == 2) {
                    String arg = commandline[1];
                    commandExecutor.executeCommand(command, arg);
                } else{
                    if (CommandExecutor.getCommands().get(command).isNeedObject()) {
                        switch (command){
                            case "add":
                            case "remove_lower":
                                commandExecutor.executeCommand(command, organizationReader.readOrganization());
                                break;
                            case "remove_all_by_postal_address":
                            case "filter_greater_than_postal_address":
                                commandExecutor.executeCommand(command, Address.readAddress(scanner));
                                break;
                        }
                    }else {
                        commandExecutor.executeCommand(command, "");
                    }
                }
            }
            catch (ArrayIndexOutOfBoundsException | NoSuchElementException | NullPointerException e){
                System.out.println("There is no such command.");
            }
        }
    }
}
