import organizations.Organization;
import tools.CommandExecutor;
import tools.CommandList;
import tools.FileHandler;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

/**
 * Program entry point class. Contains main() method.
 * This program is managing collection of Stack type
 *
 * @since 1.0
 * @author AriannaMaksimcova
 */
public class Main {
    public static void main(String[] args){
        //Создание коллекции
        Stack<Organization> organizations = new Stack<>();
        File file = new File(args[0]);

        Scanner scanner = new Scanner(System.in);

        //чтение данных из файла
        FileHandler fileHandler = new FileHandler(organizations, file);
        organizations = fileHandler.readData();


        CommandList commandList = new CommandList(organizations, fileHandler, scanner);
        CommandExecutor commandExecutor = new CommandExecutor(commandList);

        //чтение команды из консоли и её исполнение
        while (true) {
            System.out.println("Enter the command. If you are not familiar with the commands, enter \"help\".");
            try {
            String input = scanner.nextLine();
                String[] commandline = input.split(" ");
                String command = commandline[0];
                if (commandline.length >= 2) {
                    String arg = commandline[1];
                    commandExecutor.executeCommand(command, arg);
                } else{
                    commandExecutor.executeCommand(command, "");
                }
            }
            catch(NullPointerException e) {
                System.out.println("This command was not found.");
            }
            catch (NoSuchElementException e) {
                commandExecutor.executeCommand("exit", "");
                break;
            }
        }
        }
}
