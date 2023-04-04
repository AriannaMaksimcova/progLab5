package tools;

import interfaces.Command;
import organizations.*;

import java.util.*;

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

    public void help(){
        LinkedHashMap<String, Command> commands = CommandExecutor.getCommands();
        for (Command c : commands.values()){
            System.out.println(c.toString());
        }

    }
    public void info(){
        System.out.println(stack.toString());

    }
    public void show(){
        for(Organization element : stack) {
            System.out.println(element.toString());
        }
    }
    public void add(){
        stack.push(organizationReader.readOrganization());
        System.out.println(stack.get(0));
    }
    public void update(String arg){
        int id = Integer.parseInt(arg); //todo: validation
        System.out.println("Enter new values:");
        Organization organization = organizationReader.readOrganization();
        boolean updated = false;
        for(int i = 0; i < stack.size(); i++){
            if(stack.get(i).getId() == id){
                stack.set(i, organization);
                updated = true;
                break;
            }
        } if(!updated){
            System.out.println("No such element in collection.");
        }

    }
    public void remove_by_id(String arg){
        int id = Integer.parseInt(arg); //todo: validation
        boolean removed = false;
        for(Organization o : stack){
            if(o.getId() == id){
                stack.remove(o);
                removed = true;
                break;
            }
        }if (!removed){
            System.out.println("No such element in collection.");
        }
    }
    public void clear(){
        stack.clear();
    }
    public void save(){
        fileHandler.writeData();
    }
    public void exit(){
        scanner.close();
        System.exit(0);
    }
    public void remove_last(){
        stack.pop();
    }
    public void shuffle(){
        Collections.shuffle(stack);
    }
    public void remove_lower(){
        OrganizationsComparator comparator = new OrganizationsComparator();
        Organization organization = organizationReader.readOrganization();
        stack.removeIf(element -> comparator.compare(element, organization) < 0);
        }
    public void remove_all_by_postal_address(){
        Address postalAddress = Address.readAddress();
        stack.removeIf(element -> element.getPostalAddress().equals(postalAddress));
    }
    public void min_by_full_name(){
        Stack<Organization> organizations = stack;
        Collections.sort(organizations, new FullNameComparator());
        System.out.println(organizations.peek());
    }
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
