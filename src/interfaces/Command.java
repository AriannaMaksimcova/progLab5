package interfaces;
/**
 * Interface that is using for creating commands.
 */
@FunctionalInterface
public interface Command {
    public void execute(String arg);
}
