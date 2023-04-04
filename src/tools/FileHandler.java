package tools;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import organizations.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
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
                fileOutputStream.write(o.toString().getBytes());
            }

            fileOutputStream.close();

        } catch (IOException e) {
            System.out.println("File not found.");
        }
    }
    public Stack<Organization> readData(){
        try {
            // Открытие заданного файла и чтение данных из него (построчно)
            if (!file.exists()) {
                System.out.println("There is no file with this name.");
                System.out.println("To continue working with the program, exit and rerun it with the correct file name.");
                return null;
            } else{
                CSVReader csvReader = new CSVReader(new FileReader(file));
                String[] record;
                while((record = csvReader.readNext()) != null){
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
                csvReader.close();
                return organizations;
            }
        } catch (CsvValidationException | IOException e){
            System.out.println("Unable to read data from file.");
            return null;
        }
    }

}
