package tools;

import organizations.Address;
import organizations.Coordinates;
import organizations.Organization;
import organizations.OrganizationType;
import validators.Validator;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;
/**
 * Class for reading organization from command line.
 */
public class OrganizationReader {
    private final Stack<Organization> stack;
    private final Validator validator;
    Scanner scanner;
    public static TreeSet<Integer> IDs = new TreeSet<>();

    public OrganizationReader(Stack<Organization> stack, Scanner scanner) {
        this.stack = stack;
        validator = new Validator();
        this.scanner = scanner;
    }
    /**
     * Method for reading input new organization's parameters.
     * @return Organization
     */
    public Organization readOrganization(){
        int id = generateID();
        String name = readOrganizationName().replace(";","");
        float x = readCoordinateX();
        int y = readCoordinateY();
        LocalDate creationDate = LocalDate.now();
        int annualTurnover = readAnnualTurnover();
        String fullName = readFullName().replace(";","");
        long employeeCount = readEmployeeCount();
        OrganizationType organizationType = readOrganizationType();
        Address postalAddress = Address.readAddress(scanner);
        return new Organization(id, name, new Coordinates(x, y), creationDate, annualTurnover, fullName,
                employeeCount, organizationType, postalAddress);
    }
    /**
     * Method for generating ID for organization.
     * @return int
     */
    private int generateID(){
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
        IDs.add(id);
        return id;
    }
    /**
     * Method for reading organization's name.
     * @return String
     */
    public String readOrganizationName(){
        System.out.println("Organization's name (String):");
        String name = scanner.nextLine();
        while(Objects.equals(name, "") || name == null){
            System.out.println("Try again.");
            name = scanner.nextLine();
        }
        return name;
    }
    /**
     * Method for reading organization's coordinate X.
     * @return float
     */
    public float readCoordinateX(){
        System.out.println("Enter the X coordinate (float, <= 75):");
        String str = scanner.nextLine().replace(",",".");
        while(!validator.validateCoordinateX(str)){
            str = scanner.nextLine().replace(",",".");
        }
        return Float.parseFloat(str);
    }
    /**
     * Method for reading organization's coordinate Y.
     * @return int
     */
    public int readCoordinateY(){
        System.out.println("Enter the Y coordinate (int, > -177):");
        String str = scanner.nextLine();
        while(!validator.validateCoordinateY(str)){
            str = scanner.nextLine();
        }
        return Integer.parseInt(str);
    }
    /**
     * Method for reading organization's annual turnover.
     * @return int
     */
    public int readAnnualTurnover(){
        System.out.println("Enter annual turnover (int, > 0):");
        int annualTurnover;
        while(true){
            String annualTurnoverStr = scanner.nextLine();
            try {
                annualTurnover = Integer.parseInt(annualTurnoverStr);
                if (annualTurnover <= 0) {
                    System.out.println("Annual turnover has to be > 0.");
                }
                else{
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect input data.");

            }
        }
        return annualTurnover;
    }
    /**
     * Method for reading organization's full name.
     * @return String
     */
    public String readFullName(){
        System.out.println("Enter full name (String):");
        String fullName;
        while(true) {
            fullName = scanner.nextLine();
            if (fullName.trim().isEmpty()) {
                System.out.println("Try again.");
            }
            else {
                break;
            }
        }
        return fullName;
    }
    /**
     * Method for reading organization's employee count.
     * @return long
     */
    public long readEmployeeCount(){
        System.out.println("Enter employee count (long, > 0):");
        long employeeCount;
        while(true) {
            String employeeCountStr = scanner.nextLine();
            try {
                employeeCount = Long.parseLong(employeeCountStr);
                if (employeeCount <= 0) {
                    System.out.println("Employee count has to be > 0.");
                }
                else{
                    break;
                }
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect input data.");

            }
        }
        return employeeCount;
    }
    /**
     * Method for reading organization's type.
     * @return OrganizationType
     */
    public OrganizationType readOrganizationType(){
        System.out.println("Enter organization type from list \"COMMERCIAL, PUBLIC, GOVERNMENT," +
                " PRIVATE_LIMITED_COMPANY, OPEN_JOINT_STOCK_COMPANY\":");
        String orgType;
        orgType = scanner.nextLine();
        while(!OrganizationType.isPresent(orgType)){
            System.out.println("Organization type can't be null and has to be from the list. Try again.");
            orgType = scanner.nextLine();
        }
        return OrganizationType.valueOf(orgType.toUpperCase());
    }

    public Organization readOrganizationFromFile(Scanner scanner) throws WrongDataInFileException{
        try {
            int id = generateID();
            String name = scanner.nextLine().replace(";","");
            float x = scanner.nextFloat();
            int y = scanner.nextInt();
            LocalDate creationDate = LocalDate.now();
            int annualTurnover = scanner.nextInt();
            scanner.nextLine();
            String fullName = scanner.nextLine().replace(";","");
            long employeeCount = scanner.nextLong();
            scanner.nextLine();
            OrganizationType organizationType = OrganizationType.valueOf(scanner.nextLine().toUpperCase());
            Address postalAddress = Address.readAddressFromFile(scanner);
            return new Organization(id, name, new Coordinates(x, y), creationDate, annualTurnover, fullName,
                    employeeCount, organizationType, postalAddress);
        } catch (Exception e){
            throw new WrongDataInFileException();
        }

    }

    public TreeSet<Integer> getIDs() {
        return IDs;
    }
    public static void addID(int id){
        IDs.add(id);
    }
}
