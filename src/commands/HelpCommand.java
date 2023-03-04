package commands;

import interfaces.Command;
import tools.*;

public class HelpCommand implements Command {
    CommandList commandList;

    public HelpCommand(CommandList commandList) {
        this.commandList = commandList;
    }


    @Override
    public void execute() {
        commandList.help();
    }
}
