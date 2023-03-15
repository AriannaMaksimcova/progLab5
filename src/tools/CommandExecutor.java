package tools;

import commands.*;
import interfaces.Command;

import java.util.LinkedHashMap;

public class CommandExecutor {
    private static LinkedHashMap<String, Command> commands;
    private CommandList commandList;

    public CommandExecutor(CommandList commandList) {
        commands = new LinkedHashMap<>();
        this.commandList = commandList;
        commands.put("help", new HelpCommand("help", "вывести справку по доступным командам", commandList));
        commands.put("info", new InfoCommand("info", "вывести в стандартный поток вывода информацию " +
                "о коллекции (тип, дата инициализации, количество элементов и т.д.)", commandList));
        commands.put("show", new ShowCommand("show", "вывести в стандартный поток вывода все элементы" +
                " коллекции в строковом представлении", commandList));
        commands.put("add", new AddCommand("add", "добавить новый элемент в коллекцию",commandList));
        commands.put("update", new UpdateCommand("update", "обновить значение элемента коллекции," +
                " id которого равен заданному", commandList));
        commands.put("remove_by_id", new RemoveByIDCommand("remove_by_id", "удалить элемент из " +
                "коллекции по его id", commandList));
        commands.put("clear", new ClearCommand("clear", "очистить коллекцию", commandList));
        commands.put("save", new SaveCommand("save", "сохранить коллекцию в файл", commandList));
        commands.put("execute_script", new ExecuteScriptCommand("execute_script", "считать и исполнить" +
                " скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит " +
                "пользователь в интерактивном режиме.", this));
        commands.put("exit", new ExitCommand("exit", "завершить программу (без сохранения в файл)", commandList));
        commands.put("remove_last", new RemoveLastCommand("remove_last", "удалить последний элемент " +
                "из коллекции", commandList));
        commands.put("shuffle", new ShuffleCommand("shuffle", "перемешать элементы коллекции в случайном" +
                " порядке", commandList));
        commands.put("remove_lower", new RemoveLoverCommand("remove_lower", "удалить из коллекции все" +
                " элементы, меньшие, чем заданный", commandList));
        commands.put("remove_all_by_postal_address", new RemoveAllByPostalAddressCommand("remove_all_by_postal_address",
                "удалить из коллекции все элементы, значение поля postalAddress которого эквивалентно заданному", commandList));
        commands.put("min_by_full_name", new MinByFullNameCommand("min_by_full_name", "вывести любой" +
                " объект из коллекции, значение поля fullName которого является минимальным", commandList));
        commands.put("filter_greater_than_postal_address",
                new FilterGreaterThanPostalAddressCommand("filter_greater_than_postal_address",
                        "вывести элементы, значение поля postalAddress которых больше заданного",commandList));
    }

    public void executeCommand (String command){
        this.commands.get(command).execute();
    }

    public static LinkedHashMap<String, Command> getCommands() {
        return commands;
    }

}
