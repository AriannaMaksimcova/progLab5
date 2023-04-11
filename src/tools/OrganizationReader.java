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

public class OrganizationReader {
    private Stack<Organization> stack;
    private Validator validator;
    Scanner scanner;

    public OrganizationReader(Stack<Organization> stack, Scanner scanner) {
        this.stack = stack;
        validator = new Validator();
        this.scanner = scanner;
    }

    public Organization readOrganization(){
        int id = generateID();
        String name = readOrganizationName();
        float x = readCoordinateX();
        int y = readCoordinateY();
        LocalDate creationDate = LocalDate.now();
        int annualTurnover = readAnnualTurnover();
        String fullName = readFullName();
        long employeeCount = readEmployeeCount();
        OrganizationType organizationType = readOrganizationType();
        Address postalAddress = Address.readAddress();
        return new Organization(id, name, new Coordinates(x, y), creationDate, annualTurnover, fullName,
                employeeCount, organizationType, postalAddress);
    }
    private int generateID(){
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
    private String readOrganizationName(){
        System.out.println("Organization's name:");
        String name = scanner.nextLine();
        while(Objects.equals(name, "") || name == null){
            System.out.println("Try again.");
            name = scanner.nextLine();
        }
        return name;
    }
    private float readCoordinateX(){
        System.out.println("Enter the X coordinate:");
        String str = scanner.nextLine().replace(",",".");
        while(!validator.validateCoordinateX(str)){
            str = scanner.nextLine().replace(",",".");
        }
        return Float.parseFloat(str);
    }
    private int readCoordinateY(){
        System.out.println("Enter the Y coordinate:");
        String str = scanner.nextLine();
        while(!validator.validateCoordinateY(str)){
            str = scanner.nextLine();
        }
        return Integer.parseInt(str);
    }
    private int readAnnualTurnover(){
        System.out.println("Enter annual turnover:");
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
    private String readFullName(){
        System.out.println("Enter full name:");
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
    private long readEmployeeCount(){
        System.out.println("Enter employee count:");
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
    private OrganizationType readOrganizationType(){
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
}
