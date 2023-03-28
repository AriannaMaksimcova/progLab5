package tools;

import interfaces.Command;
import organizations.*;

import java.time.LocalDate;
import java.util.*;

public class CommandList {
    private Stack<Organization> stack;
    private FileHandler fileHandler;
    private Scanner scanner;
    public CommandList(Stack<Organization> stack, FileHandler fileHandler) {
        this.stack = stack;
        this.fileHandler = fileHandler;
        scanner = new Scanner(System.in);
    }

    public void help(){
        LinkedHashMap<String, Command> commands = CommandExecutor.getCommands();
        for (Command c : commands.values()){
            System.out.println(c.toString());
        }

    }
    public void info(){
        stack.toString();

    }
    public void show(){
        for(Organization element : stack) {
            element.toString();
        }
    }
    public void add(){
        stack.push(readOrganization());
    }
    public void update(){
        System.out.println("Enter id of the organization, that you want to update:");
        int id = scanner.nextInt();
        System.out.println("Enter new values:");
        Organization organization = readOrganization();
        for(int i = 0; i < stack.size(); i++){
            if(stack.get(i).getId() == id){
                stack.set(i, organization);
                break;
            }
        }
        stack.set(id, organization);
    }
    public void remove_by_id(){
        System.out.println("Enter organization's id:");
        int id = scanner.nextInt();
        for(Organization o : stack){
            if(o.getId() == id){
                stack.remove(o);
                break;
            }
        }
    }
    public void clear(){
        stack.clear();
    }
    public void save(){
        fileHandler.writeData();
    }
    public void exit(){
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
        Organization organization = readOrganization();
        stack.removeIf(element -> comparator.compare(element, organization) < 0);
        }
    public void remove_all_by_postal_address(){
        Address postalAddress = readAddress();
        stack.removeIf(element -> element.getPostalAddress().equals(postalAddress));
    }
    public void min_by_full_name(){
        //???
    }
    public void filter_greater_than_postal_address(){
        Address postalAddress = readAddress();
        AddressComparator comparator = new AddressComparator();
        for (Organization element : stack) {
            if (comparator.compare(element.getPostalAddress(), postalAddress) > 0){
                System.out.println(element);
            }
        }
    }
    public Address readAddress(){
        System.out.println("Enter zip code for address:");
        String zipCode = scanner.nextLine();
        System.out.println("Enter coordinate X of town location:");
        double x2 = scanner.nextDouble();
        System.out.println("Enter coordinate Y of town location:");
        int y2 = scanner.nextInt();
        System.out.println("Enter coordinate Z of town location:");
        Long z2 = scanner.nextLong();
        return new Address(zipCode, new Location(x2, y2, z2));
    }
    public Organization readOrganization(){
        int id = generateID();

        System.out.println("Organization's name:");
        String name = scanner.nextLine();
        while(Objects.equals(name, "") || name == null){
            System.out.println("Try again");
            name = scanner.nextLine();
        }

        System.out.println("Enter the X coordinate:");
        float x = scanner.nextFloat();
        while(x > 75){
            System.out.println("X has to be <= 75 and can't be null. Try again.");
            x = scanner.nextFloat();
        }

        System.out.println("Enter the Y coordinate:");
        int y = scanner.nextInt();
        while(y < -177){
            System.out.println("Y has to be > -177 and can't be null. Try again.");
            y = scanner.nextInt();
        }

        LocalDate creationDate = LocalDate.now();

        System.out.println("Enter annual turnover:");
        int annualTurnover = scanner.nextInt();
        while (annualTurnover <= 0){
            System.out.println("Annual turnover has to be > 0. Try again.");
            annualTurnover = scanner.nextInt();
        }

        System.out.println("Enter full name:");
        String fullName = scanner.nextLine();

        System.out.println("Enter employee count:");
        long employeeCount = scanner.nextLong();
        while (employeeCount <= 0){
            System.out.println("Employee count has to be > 0. Try again.");
            employeeCount = scanner.nextLong();
        }

        System.out.println("Enter organization type from list \"COMMERCIAL, PUBLIC, GOVERNMENT," +
                " PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY\":");
        String orgType = scanner.nextLine();
        while(orgType == null){
            System.out.println("Organization type can't be null. Try again.");
            orgType = scanner.nextLine();
        }
        OrganizationType organizationType = OrganizationType.valueOf(orgType.toUpperCase());

        Address postalAddress = readAddress();

        return new Organization(id, name, new Coordinates(x, y), creationDate, annualTurnover, fullName,
                employeeCount, organizationType, postalAddress);
    }
    public int generateID(){
        TreeSet<Integer> IDs = new TreeSet<>();
        int id = 0;
        for(Organization element : stack){
            IDs.add(element.getId());
        }
        for(int i = 0; i < Integer.MAX_VALUE; i++){
            if (!IDs.contains(i)){
                id = i;
                break;
            }
        }
        return id;
    }
}
