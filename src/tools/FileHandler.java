package tools;

import organizations.*;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 * Class for working with file in CSV format.
 */
public class FileHandler {
    private final Stack<Organization> organizations;
    private final File file;

    public FileHandler(Stack<Organization> organizations, File file) {
        this.organizations = organizations;
        this.file = file;
    }
    /**
     * Method for writing stack of organizations into file.
     */
    public void writeData(){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            for(Organization organization : organizations){
                String row = organization.toCSV() ;
                fileOutputStream.write(row.getBytes());
            }
            fileOutputStream.close();
        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }
    /**
     * Method for reading organizations from file.
     * @return Stack
     */
    public Stack<Organization> readData() {
        FileReader fileReader = null;
        ArrayList<Integer> ids = new ArrayList<>();
        try {
            fileReader = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File was not found. Check the access rights or the path to the file.");
            System.exit(0);
        }
        try {
            Scanner scanner = new Scanner(fileReader);
            while ((scanner.hasNextLine())) {
                String[] record = scanner.nextLine().split(";");
                int id = Integer.parseInt(record[0]);
                if (ids.contains(id)){
                    throw new NumberFormatException();
                }else{
                    ids.add(id);
                }
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
                double x1 = Double.parseDouble(record[10]);
                int y1 = Integer.parseInt(record[11]);
                Long z1 = Long.parseLong(record[12]);
                Address address = new Address(zipCode, new Location(x1, y1, z1));

                Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover,
                        fullName, employeeCount, type, address);
                organizations.push(organization);
            }
            scanner.close();
            return organizations;
        } catch(NumberFormatException e){
            System.out.println("Invalid data in file. If the data in the file is not important to you, \n" +
                    "you can continue working with the program. Otherwise, change file and restart the program.");
        }
        return organizations;
    }
}
