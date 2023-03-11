package tools;

import organizations.*;

import java.io.EOFException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

public class ReadDataFromFileClass {
    Stack<Organization> organizations = new Stack<>();

    public Stack<Organization> readData(File file) throws IOException, EOFException {
        Scanner console = new Scanner(System.in);
        // Открытие заданного файла и чтение данных из него (построчно)
        if (!file.exists()) {
            System.out.println("Файла с таким названием не существует. Хотите создать новый файл? (y or n)");
            if (console.nextLine() == "y") {
                file.createNewFile();
            } else {
                System.out.println("Для продолжения работы программы выйдите из неё и запустите ещё раз с правильным именем файла.");
            }
        }
        Scanner fileScanner = new Scanner(new FileReader(file));
        CSVReader csvReader = new CSVReader(new FileReader(file));

        // пока не конец файла
        while (true) {
            String buff = fileScanner.nextLine();
            String[] string = buff.split(";");
                    int id = Integer.parseInt(string[0]);
                    String name = string[1];
                    Float x = Float.parseFloat(string[2].split(",")[0]);
                    Integer y = Integer.parseInt(string[2].split(",")[1]);
                    Coordinates coordinates = new Coordinates(x, y);
                    LocalDate creationDate = LocalDate.parse(string[3]);
                    Integer annualTurnover = Integer.parseInt(string[4]);
                    String fullName = string[5];
                    long employeeCount = Long.parseLong(string[6]);
                    OrganizationType type = OrganizationType.valueOf(string[7]);
                    String[] address = string[8].split(",");
                    String[] coordinatesForLocation = address[1].split(" ");
                    Location location = new Location(Double.parseDouble(coordinatesForLocation[0]), Integer.parseInt(coordinatesForLocation[1]), Long.parseLong(coordinatesForLocation[2]));
                    Address postalAddress = new Address(address[0], location);
                    Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeeCount, type, postalAddress);
                    organizations.push(organization);
                    System.out.println("Некорректные данные. Проверьте корректность данных в файле.");
                    }

            }
        }