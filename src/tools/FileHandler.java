package tools;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.ICSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.opencsv.exceptions.CsvValidationException;
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
            StatefulBeanToCsv<Organization> csvWriter = new StatefulBeanToCsvBuilder<Organization>((ICSVWriter) fileOutputStream)
                    .withSeparator(';').withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .withEscapechar(CSVWriter.DEFAULT_ESCAPE_CHARACTER).withLineEnd(CSVWriter.DEFAULT_LINE_END)
                    .withOrderedResults(false).build();
            csvWriter.write(organizations);

            fileOutputStream.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (CsvRequiredFieldEmptyException e) {
            System.out.println("Something went wrong. Check your data.");
        } catch (CsvDataTypeMismatchException e) {
            System.out.println("Something went wrong. Check your data.");
        } catch (IOException e) {
            System.out.println("Something went wrong. Check your data.");
        }
    }
    public Stack<Organization> readData() throws IOException, CsvValidationException {
        Scanner console = new Scanner(System.in);
        // Открытие заданного файла и чтение данных из него (построчно)
        if (!file.exists()) {
            System.out.println("There is no file with this name. Do you want to create a new file? (y or n)");
            if (console.nextLine() == "y") {
                file.createNewFile();
            } else {
                System.out.println("To continue working with the program, exit and rerun it with the correct file name.");
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
