package commands;

import organizations.Address;
import organizations.Organization;
import tools.CommandExecutor;
import tools.CommandList;
import tools.OrganizationReader;
import tools.WrongDataInFileException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Vector;

public class ExecuteScriptCommand extends Command {
    private final CommandExecutor commandExecutor;
    private final OrganizationReader organizationReader;

    /**
     * Class that allows to create command "execute_script" and execute it.
     */
    public ExecuteScriptCommand(String name, String description, CommandList commandList,
                                CommandExecutor commandExecutor, boolean needObject, OrganizationReader organizationReader) {
        super(name, description, commandList,needObject);
        this.commandExecutor = commandExecutor;
        this.organizationReader = organizationReader;
    }

    @Override
    public void execute(String arg) {
        if (!arg.equals("")) {
            Vector<String> filePaths = new Vector<>();
            File file = new File(arg);
            filePaths.add(arg);
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNext()) {
                    String input = scanner.nextLine();
                    String[] commandline = input.split(" ");
                    String command = commandline[0];
                    if(commandline.length == 2){
                        String argument = commandline[1];
                        if (command.equals("execute_script")) {
                            if (filePaths.contains(argument)) {
                                System.out.println("Command " + command + " " + argument + " has already been completed. " +
                                        "Further execution will lead to recursion.");
                                break;
                            } else {
                                commandExecutor.executeCommand(command, argument);
                            }
                        } else {
                            commandExecutor.executeCommand(command, argument);
                        }
                    }else {
                        if (CommandExecutor.getCommands().get(command).isNeedObject()) {
                            if (command.equals("add") || command.equals("remove_lower")){
                                Organization organization = organizationReader.readOrganizationFromFile(scanner);
                                if(organization != null) {
                                    commandExecutor.executeCommand(command, organization);
                                }
                            } else if (command.equals("remove_all_by_postal_address" )||
                                    command.equals("filter_greater_than_postal_address")) {
                                Address address = Address.readAddressFromFile(scanner);
                                if(address != null){
                                    commandExecutor.executeCommand(command, address);
                                }
                            }
                        }else {
                            commandExecutor.executeCommand(command,"");
                        }
                    }
                }
                scanner.close();
            } catch (FileNotFoundException e) {
                System.out.println("File is not found.");
            }
            catch (NoSuchElementException e){
                commandExecutor.executeCommand("exit", "");
            } catch (WrongDataInFileException e) {
                System.out.println("Wrong data in file.");
            }

        }else {
            System.out.println("The argument was not passed.");
        }
    }
}
