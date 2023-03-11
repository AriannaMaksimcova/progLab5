package commands;

import interfaces.Command;
import tools.*;

public class HelpCommand implements Command {
    private CommandList commandList;
    private String name;
    private String description;

    public HelpCommand(String name, String description, CommandList commandList) {
        this.commandList = commandList;
        this.name = name;
        this.description = description;
    }

    @Override
    public void execute() {
        commandList.help();
    }


}
