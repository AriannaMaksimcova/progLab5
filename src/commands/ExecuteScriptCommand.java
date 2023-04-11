package commands;

import interfaces.Command;
import tools.CommandExecutor;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Vector;

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
    public void execute(String arg){
        Vector<String> filePaths = new Vector<>();
        File file = new File(arg);
        filePaths.add(arg);
        try{
            Scanner scanner1 = new Scanner(file);
            while (scanner1.hasNext()){
                String[] commandLine = scanner1.nextLine().split(" ");
                String command = commandLine[0];
                if(commandLine.length == 1){
                    commandExecutor.executeCommand(command, "");
                }
                if(commandLine.length == 2){
                    String argument = commandLine[1];
                    if(command == "execute_script"){
                        if(filePaths.contains(argument)){
                            System.out.println("Command " + command + " " + argument + " has already been completed. " +
                                    "Further execution will lead to recursion.");
                        }
                        else{
                            commandExecutor.executeCommand(command, argument);
                        }
                    }
                    else{
                        commandExecutor.executeCommand(command, argument);
                    }
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not found.");
        }
    }

    @Override
    public String toString() {
        return  name + ": " + description ;
    }
}
