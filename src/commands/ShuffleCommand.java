package commands;

import tools.CommandList;

public class ShuffleCommand extends Command {
    /**
     * CLass that allows to create command "shuffle" and execute it.
     */
    public ShuffleCommand(String name, String description, CommandList commandList, boolean needObject) {
        super(name, description, commandList, needObject);
    }

    @Override
    public void execute(String arg) {
        commandList.shuffle();
    }
}
