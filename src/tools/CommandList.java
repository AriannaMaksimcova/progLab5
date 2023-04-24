package tools;

import comparators.AddressComparator;
import comparators.FullNameComparator;
import comparators.OrganizationsComparator;
import commands.Command;
import organizations.Address;
import organizations.Coordinates;
import organizations.Organization;
import organizations.OrganizationType;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.Stack;
/**
 * Class that contains realizations of commands.
 * (Receiver)
 */
public class CommandList {
    private final Stack<Organization> stack;
    private final FileHandler fileHandler;
    private final Scanner scanner;
    OrganizationReader organizationReader;
    public CommandList(Stack<Organization> stack, FileHandler fileHandler, Scanner scanner, OrganizationReader organizationReader) {
        this.stack = stack;
        this.fileHandler = fileHandler;
        this.scanner = scanner;
        this.organizationReader = organizationReader;
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
        if(stack.size() == 0){
            System.out.println("The collection is empty.");
        }else {
            for (Organization element : stack) {
                System.out.println(element.toString());
            }
        }
    }
    /**
     * Method with realization of AddCommand.
     */
    public void add(Organization organization){
        stack.push(organization);
        if(stack.contains(organization)) {
            System.out.println("New element has been added to the collection.");
        }
    }
    /**
     * Method with realization of UpdateCommand.
     */
    public void update(String arg) {
        try {
            int id = Integer.parseInt(arg);
            if(organizationReader.getIDs().contains(id)){
                System.out.println("Enter new values:");
                String name = organizationReader.readOrganizationName();
                float x = organizationReader.readCoordinateX();
                int y = organizationReader.readCoordinateY();
                int annualTurnover = organizationReader.readAnnualTurnover();
                String fullName = organizationReader.readFullName();
                long employeeCount = organizationReader.readEmployeeCount();
                OrganizationType organizationType = organizationReader.readOrganizationType();
                Address postalAddress = Address.readAddress(scanner);
                boolean updated = false;
                for (Organization organization : stack) {
                    if (organization.getId() == id) {
                        organization.setName(name);
                        organization.setCoordinates(new Coordinates(x, y));
                        organization.setAnnualTurnover(annualTurnover);
                        organization.setFullName(fullName);
                        organization.setEmployeesCount(employeeCount);
                        organization.setType(organizationType);
                        organization.setPostalAddress(postalAddress);
                        updated = true;
                        break;
                    }
                }
                if (updated) {
                    System.out.println("The element was updated.");
                }
            }else{
                System.out.println("There is no element with such id in collection.");
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
                    System.out.println("The element was removed.");
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
        System.out.println("The element was removed.");
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
    public void remove_lower(Organization organization){
        OrganizationsComparator comparator = new OrganizationsComparator();
        stack.removeIf(element -> comparator.compare(element, organization) < 0);
        }
    /**
     * Method with realization of RemoveAllByPostalAddressCommand.
     */
    public void remove_all_by_postal_address(Address postalAddress){
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
    public void filter_greater_than_postal_address(Address postalAddress){
        AddressComparator comparator = new AddressComparator();
        for (Organization element : stack) {
            if (comparator.compare(element.getPostalAddress(), postalAddress) > 0){
                System.out.println(element);
            }
        }
    }
}
