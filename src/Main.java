import organizations.Organization;
import tools.*;

import java.io.File;
import java.util.Objects;
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
        try {

        }catch (Exception e){

        }

        if(!Objects.equals(args[0], "")){
            File file = new File(args[0]);
            Scanner scanner = new Scanner(System.in);

            //чтение данных из файла
            FileHandler fileHandler = new FileHandler(organizations, file);
            organizations = fileHandler.readData();

            OrganizationReader organizationReader = new OrganizationReader(organizations, scanner);
            CommandList commandList = new CommandList(organizations, fileHandler, scanner, organizationReader);
            CommandExecutor commandExecutor = new CommandExecutor(commandList, organizationReader);
            ConsoleHandler consoleHandler = new ConsoleHandler(scanner, commandExecutor, organizationReader);

            consoleHandler.readCommand();


        } else{
            System.out.println("The path to the file for executing the program was not passed.\nRestart the program.");
            System.exit(0);
        }
    }
}
