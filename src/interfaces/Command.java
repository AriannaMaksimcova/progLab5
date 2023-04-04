package interfaces;
@FunctionalInterface
public interface Command {
    public void execute(String arg);
}
