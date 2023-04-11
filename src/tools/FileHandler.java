package tools;

import organizations.*;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

public class FileHandler {
    private Stack<Organization> organizations;
    private File file;

    public FileHandler(Stack<Organization> organizations, File file) {
        this.organizations = organizations;
        this.file = file;
    }
    public void writeData(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for(Organization o : organizations){
                fileOutputStream.write(o.toCSV().getBytes());
            }

            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
    public Stack<Organization> readData(){
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found.");
        }

        Scanner scanner = new Scanner(fileReader);
        while((scanner.hasNextLine())){
            String[] record = scanner.nextLine().split(";");
            int id = Integer.parseInt(record[0]);
            String name = record[1];
            Float x = Float.parseFloat(record[2]);
            Integer y = Integer.parseInt(record[3]);
            Coordinates coordinates = new Coordinates(x, y);
            LocalDate creationDate = LocalDate.parse(record[4]);
            Integer annualTurnover = Integer.parseInt(record[5]);
            String fullName = record[6];
            long employeeCount = Long.parseLong(record[7]);
            OrganizationType type = OrganizationType.valueOf(record[8]);
            String zipCode = record[9];
            Double x1 = Double.parseDouble(record[10]);
            int y1 = Integer.parseInt(record[11]);
            Long z1 = Long.parseLong(record[12]);
            Address address = new Address(zipCode, new Location(x1, y1, z1));
            Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover,
                    fullName, employeeCount, type, address);
            organizations.push(organization);
        }
        scanner.close();
        return organizations;
    }
}
