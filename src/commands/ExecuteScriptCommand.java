package commands;
import interfaces.Command;
import tools.CommandList;
import java.io.File;

public class ExecuteScriptCommand implements Command {
    CommandList collection;

    File file;

    public ExecuteScriptCommand(CommandList collection, File file) {
        this.collection = collection;
        this.file = file;
    }
    @Override
    public void execute(){
        collection.execute_script(file);
    }
}
