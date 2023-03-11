import organizations.Organization;
import tools.*;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создание коллекции
        Stack<Organization> organizations = new Stack<>();
        File file = new File(args[0]);

        //чтение данных из файла
        ReadDataFromFileClass readDataFromFile = new ReadDataFromFileClass();
        readDataFromFile.readData(file);

        WriteDataIntoFileClass writeDataIntoFile = new WriteDataIntoFileClass(file, organizations);
        CommandList commandList = new CommandList(organizations, writeDataIntoFile);
        CommandExecutor commandExecutor = new CommandExecutor(commandList);
        Scanner console = new Scanner(System.in);

        //чтение команды из консоли и её исполнение
        ReadCommandFromConsoleClass readCommandFromConsole = new ReadCommandFromConsoleClass(commandExecutor, console);
        readCommandFromConsole.readCommand();
        }
}
