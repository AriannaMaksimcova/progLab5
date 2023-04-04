import organizations.Organization;
import tools.CommandExecutor;
import tools.CommandList;
import tools.FileHandler;
import tools.ConsoleManager;

import java.io.File;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        //Создание коллекции
        Stack<Organization> organizations = new Stack<>();
        File file = new File(args[0]);
        Scanner scanner = new Scanner(System.in);

        //чтение данных из файла
        FileHandler fileHandler = new FileHandler(organizations, file);
        fileHandler.readData();


        CommandList commandList = new CommandList(organizations, fileHandler, scanner);
        CommandExecutor commandExecutor = new CommandExecutor(commandList);
        ConsoleManager consoleManager = new ConsoleManager(commandExecutor, scanner);
        //чтение команды из консоли и её исполнение
        while (true) {
            System.out.println("Введите команду. Если не знакомы с командами, введите \"help\".");
            String input = scanner.nextLine();
            try {
                String[] commandline = input.split(" ");
                String command = commandline[0];
                if (commandline.length >= 2) {
                    String arg = commandline[1];
                    commandExecutor.executeCommand(command, arg);
                } else if (commandline.length == 1) {
                    commandExecutor.executeCommand(command, "");
                }
            }
            catch(NullPointerException e) {
                System.out.println("Данной команды не найдено");
            }
            catch (NoSuchElementException e) {
                System.out.println("Завершаемся..");
                break;
            }
        }
        }
}
