package tools;

import comparators.*;
import interfaces.Command;
import organizations.*;

import java.util.*;
/**
 * Class that contains realizations of commands.
 * (Receiver)
 */
public class CommandList {
    private Stack<Organization> stack;
    private FileHandler fileHandler;
    private Scanner scanner;
    OrganizationReader organizationReader;
    public CommandList(Stack<Organization> stack, FileHandler fileHandler, Scanner scanner) {
        this.stack = stack;
        this.fileHandler = fileHandler;
        this.scanner = scanner;
        organizationReader = new OrganizationReader(stack, scanner);
    }
    /**
     * Method with realization of HelpCommand.
     */
    public void help(){
        LinkedHashMap<String, Command> commands = CommandExecutor.getCommands();
        for (Command c : commands.values()){
            System.out.println(c.toString());
        }

    }
    /**
     * Method with realization of InfoCommand.
     */
    public void info(){
        System.out.println("Collection type: Stack.");
        System.out.println("Object class: Organization.");
        System.out.println("Number of elements: " + stack.size() + ".");

    }
    /**
     * Method with realization of ShowCommand.
     */
    public void show(){
        for(Organization element : stack) {
            System.out.println(element.toString());
        }
    }
    /**
     * Method with realization of AddCommand.
     */
    public void add(){
        stack.push(organizationReader.readOrganization());
    }
    /**
     * Method with realization of UpdateCommand.
     */
    public void update(String arg) {
        try {
            int id = Integer.parseInt(arg);
            System.out.println("Enter new values:");
            Organization organization = organizationReader.readOrganization();
            boolean updated = false;
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i).getId() == id) {
                    stack.set(i, organization);
                    updated = true;
                    break;
                }
            }
            if (!updated) {
                System.out.println("No such element in collection.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Incorrect format of id.");
        }
    }
    /**
     * Method with realization of RemoveByIDCommand.
     */
    public void remove_by_id(String arg) {
        try {
            int id = Integer.parseInt(arg);
            boolean removed = false;
            for (Organization o : stack) {
                if (o.getId() == id) {
                    stack.remove(o);
                    removed = true;
                    break;
                }
            }
            if (!removed) {
                System.out.println("No such element in collection.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Incorrect format of id.");
        }
    }
    /**
     * Method with realization of ClearCommand.
     */
    public void clear (){
        stack.clear();
    }
    /**
     * Method with realization of SaveCommand.
     */
    public void save(){
        fileHandler.writeData();
    }
    /**
     * Method with realization of ExitCommand.
     */
    public void exit(){
        scanner.close();
        System.exit(0);
    }
    /**
     * Method with realization of RemoveLastCommand.
     */
    public void remove_last(){
        stack.pop();
    }
    /**
     * Method with realization of ShuffleCommand.
     */
    public void shuffle(){
        Collections.shuffle(stack);
    }
    /**
     * Method with realization of RemoveLoverCommand.
     */
    public void remove_lower(){
        OrganizationsComparator comparator = new OrganizationsComparator();
        Organization organization = organizationReader.readOrganization();
        stack.removeIf(element -> comparator.compare(element, organization) < 0);
        }
    /**
     * Method with realization of RemoveAllByPostalAddressCommand.
     */
    public void remove_all_by_postal_address(){
        Address postalAddress = Address.readAddress();
        stack.removeIf(element -> element.getPostalAddress().equals(postalAddress));
    }
    /**
     * Method with realization of MinByFullNameCommand.
     */
    public void min_by_full_name(){
        Stack<Organization> organizations = stack;
        organizations.sort(new FullNameComparator());
        System.out.println(organizations.peek());
    }
    /**
     * Method with realization of FilterGreaterThanPostalAddressCommand.
     */
    public void filter_greater_than_postal_address(){
        Address postalAddress = Address.readAddress();
        AddressComparator comparator = new AddressComparator();
        for (Organization element : stack) {
            if (comparator.compare(element.getPostalAddress(), postalAddress) > 0){
                System.out.println(element);
            }
        }
    }


}
