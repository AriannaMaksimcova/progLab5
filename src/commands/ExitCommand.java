package commands;


import tools.CommandList;

public class ExitCommand extends Command {
    /**
     * Class that allows to create command "exit" and execute it.
     */
    public ExitCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.exit();
    }

}
