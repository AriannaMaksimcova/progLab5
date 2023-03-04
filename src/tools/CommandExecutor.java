package tools;
import interfaces.Command;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CommandExecutor {
    private Map<String, Command> commands= new LinkedHashMap<String, Command>();
    public void executeCommand (String command){
        this.commands.get(command).execute();
    }
    public void addCommand(Command command) {
        this.commands.put("help", command);
    }
}
