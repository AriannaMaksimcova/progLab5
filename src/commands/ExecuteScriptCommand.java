package commands;

import interfaces.Command;
import tools.CommandExecutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExecuteScriptCommand implements Command {
    private final String name;
    private final String description;
    private final CommandExecutor commandExecutor;

    public ExecuteScriptCommand(String name, String description, CommandExecutor commandExecutor) {
        this.name = name;

        this.description = description;
        this.commandExecutor = commandExecutor;
    }
    @Override
    public void execute(){
        System.out.println("Enter the address of the script file:");
        Scanner scanner = new Scanner(System.in);
        File file = new File(scanner.nextLine());
        try{
            Scanner scanner1 = new Scanner(file);
            while (scanner1.hasNext()){
                String command = scanner1.nextLine();
                commandExecutor.executeCommand(command);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }
    }

    @Override
    public String toString() {
        return "ExecuteScriptCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
