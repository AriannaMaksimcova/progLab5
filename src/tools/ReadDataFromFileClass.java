package tools;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import organizations.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

public class ReadDataFromFileClass {
    private Stack<Organization> organizations = new Stack<>();
    private File file;

    public ReadDataFromFileClass(Stack<Organization> organizations, File file) {
        this.organizations = organizations;
        this.file = file;
    }

    public Stack<Organization> readData() throws IOException, CsvValidationException {
        Scanner console = new Scanner(System.in);
        // Открытие заданного файла и чтение данных из него (построчно)
        if (!file.exists()) {
            System.out.println("There is no file with this name. Do you want to create a new file? (y or n)");
            if (console.nextLine() == "y") {
                file.createNewFile();
            } else {
                System.out.println("To continue working with the program, exit it and run it again with the correct file name.");
            }
        }
        CSVReader csvReader = new CSVReader(new FileReader(file));
        String[] record;
        while((record = csvReader.readNext()) != null){
            int id = Integer.parseInt(record[0]);
            String name = record[1];
            Float x = Float.parseFloat(record[2].split(",")[0]);
            Integer y = Integer.parseInt(record[2].split(",")[1]);
            Coordinates coordinates = new Coordinates(x, y);
            LocalDate creationDate = LocalDate.parse(record[3]);
            Integer annualTurnover = Integer.parseInt(record[4]);
            String fullName = record[5];
            long employeeCount = Long.parseLong(record[6]);
            OrganizationType type = OrganizationType.valueOf(record[7]);
            String[] address = record[8].split(",");
            String[] coordinatesForLocation = address[1].split(" ");
            Location location = new Location(Double.parseDouble(coordinatesForLocation[0]), Integer.parseInt(coordinatesForLocation[1]), Long.parseLong(coordinatesForLocation[2]));
            Address postalAddress = new Address(address[0], location);
            Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeeCount, type, postalAddress);
            organizations.push(organization);
        }
        csvReader.close();
        return organizations;
    }
}