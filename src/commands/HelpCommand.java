package commands;

import tools.*;

public class HelpCommand extends Command {
    /**
     * Class that allows to create command "help" and execute it.
     */
    public HelpCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.help();
    }

}
