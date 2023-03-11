package commands;
import interfaces.Command;
import tools.CommandList;
import java.io.File;

public class ExecuteScriptCommand implements Command {
    private CommandList collection;
    private String name;
    private String description;

    public ExecuteScriptCommand(String name, String description, CommandList collection) {
        this.collection = collection;
        this.name = name;
        this.description = description;
    }
    @Override
    public void execute(){
        collection.execute_script();
    }

    @Override
    public String toString() {
        return "ExecuteScriptCommand{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
