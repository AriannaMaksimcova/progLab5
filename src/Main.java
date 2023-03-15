import com.opencsv.exceptions.CsvValidationException;
import organizations.Organization;
import tools.*;

import java.io.File;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args){
        //Создание коллекции
        Stack<Organization> organizations = new Stack<>();
        File file = new File(args[0]);

        //чтение данных из файла
        ReadDataFromFileClass readDataFromFile = new ReadDataFromFileClass(organizations, file);
        try {
            readDataFromFile.readData();
        } catch (CsvValidationException | IOException e){
            System.out.println("Unable to read data from file.");
        }


        WriteDataIntoFileClass writeDataIntoFile = new WriteDataIntoFileClass(file, organizations);
        CommandList commandList = new CommandList(organizations, writeDataIntoFile);
        CommandExecutor commandExecutor = new CommandExecutor(commandList);

        //чтение команды из консоли и её исполнение
        while (true){
            ReadCommandFromConsoleClass readCommandFromConsole = new ReadCommandFromConsoleClass(commandExecutor);
            readCommandFromConsole.readCommand();
        }

        }
}
