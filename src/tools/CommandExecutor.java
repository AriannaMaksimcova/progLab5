package tools;

import commands.*;
import organizations.Address;
import organizations.Organization;

import java.util.LinkedHashMap;
/**
 * Class that contains Map with commands.
 * Sends a request for command execution.
 */
public class CommandExecutor {
    private static LinkedHashMap<String, Command> commands;

    public CommandExecutor(CommandList commandList, OrganizationReader organizationReader) {
        commands = new LinkedHashMap<>();
        commands.put("help", new HelpCommand("help", "вывести справку по доступным командам", commandList, false));
        commands.put("info", new InfoCommand("info", "вывести в стандартный поток вывода информацию " +
                "о коллекции (тип, дата инициализации, количество элементов и т.д.)", commandList, false));
        commands.put("show", new ShowCommand("show", "вывести в стандартный поток вывода все элементы" +
                " коллекции в строковом представлении", commandList, false));
        commands.put("add", new AddCommand("add {element}", "добавить новый элемент в коллекцию", commandList, true));
        commands.put("update", new UpdateCommand("update  id {element}", "обновить значение элемента коллекции," +
                " id которого равен заданному", commandList, true));
        commands.put("remove_by_id", new RemoveByIDCommand("remove_by_id id", "удалить элемент из " +
                "коллекции по его id", commandList, false));
        commands.put("clear", new ClearCommand("clear", "очистить коллекцию", commandList, false));
        commands.put("save", new SaveCommand("save", "сохранить коллекцию в файл", commandList, false));
        commands.put("execute_script", new ExecuteScriptCommand("execute_script file_name", "считать и исполнить" +
                " скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит " +
                "пользователь в интерактивном режиме.", commandList, this, false, organizationReader));
        commands.put("exit", new ExitCommand("exit", "завершить программу (без сохранения в файл)", commandList, false));
        commands.put("remove_last", new RemoveLastCommand("remove_last", "удалить последний элемент " +
                "из коллекции", commandList, false));
        commands.put("shuffle", new ShuffleCommand("shuffle", "перемешать элементы коллекции в случайном" +
                " порядке", commandList, false));
        commands.put("remove_lower", new RemoveLoverCommand("remove_lower {element}", "удалить из коллекции все" +
                " элементы, меньшие, чем заданный", commandList, true));
        commands.put("remove_all_by_postal_address", new RemoveAllByPostalAddressCommand("remove_all_by_postal_address {Address}",
                "удалить из коллекции все элементы, значение поля postalAddress которого эквивалентно заданному", commandList, true));
        commands.put("min_by_full_name", new MinByFullNameCommand("min_by_full_name", "вывести любой" +
                " объект из коллекции, значение поля fullName которого является минимальным", commandList, false));
        commands.put("filter_greater_than_postal_address",
                new FilterGreaterThanPostalAddressCommand("filter_greater_than_postal_address {Address}",
                        "вывести элементы, значение поля postalAddress которых больше заданного",commandList, true));
    }
    /**
     * Method that sends request for command execution.
     */
    public void executeCommand (String command, String arg){
            try {
                commands.get(command).execute(arg);
            }catch (NullPointerException e){
                System.out.println("There is no such command.");
            }
        }
    public void executeCommand (String command, Organization arg){
        try {
            commands.get(command).execute(arg);
        } catch (NullPointerException e){
            System.out.println("There is no such command.");
        }
    }
    public void executeCommand (String command, Address arg){
        try{
            commands.get(command).execute(arg);
        } catch(NullPointerException e){
            System.out.println("There is no such command.");
        }
    }

    public static LinkedHashMap<String, Command> getCommands() {
        return commands;
    }

}
