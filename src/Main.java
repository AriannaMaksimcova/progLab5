import organizations.Address;
import organizations.Coordinates;
import organizations.Organization;
import organizations.OrganizationType;
import tools.CommandList;

import java.io.*;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        //Создание коллекции
        Stack<Organization> organizations = new Stack<>();
        CommandList commandList = new CommandList(organizations);


        Scanner console = new Scanner(System.in);

        // Открытие заданного файла и чтение данных из него (построчно)
        File file = new File(args[0]);
        if (!file.exists()){
            System.out.println("Файла с таким названием не существует. Хотите создать новый файл? (y or n)");
            if (console.nextLine() == "y"){
                file.createNewFile();
            } else{
                System.out.println("Для продолжения работы программы запустите её ещё раз с правильным именем файла.");
                user.exitRecord();
            }
        }
        Scanner fileScanner = new Scanner(new FileReader(file));

        // пока не конец файла
        try{
            while(true) {
                String buff = fileScanner.nextLine();
                String[] string = buff.split(";");
                try {
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
                    Address postalAddress = ;
                    Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeeCount, type, postalAddress);
                    organizations.push(organization);
                } catch (NumberFormatException e) {
                    System.out.println("Некорректные данные. Проверьте корректность данных в файле.");
                }
            }
        } catch (EOFException eofException) {
            //запрос команды
            System.out.println("Введите команду по шаблону. Если не знакомы с шаблонами, введите \"HELP\".");
            if(console.hasNextLine()){
                String[] commandline = console.nextLine().split(" ");
                String command = commandline[0];
                switch (Commands.valueOf(command)) {
                    case HELP:
                        user.helpRecord();
                        break;
                    case INFO:
                        user.infoRecord();
                        break;
                    case SHOW:
                        user.showRecord();
                        break;
                    case ADD:
                        user.addRecord(Organization...);
                    case UPDATE:
                        user.updateRecord(...);
                        break;
                    case REMOVE_BY_ID:
                        user.removeByIDRecord(...id...);
                        break;
                    case CLEAR:
                        user.clearRecord();
                        break;
                    case SAVE:
                        user.saveRecord();
                        break;
                    case EXECUTE_SCRIPT:
                        user.executeScriptRecord(.file_name.);
                        break;
                    case EXIT:
                        user.exitRecord();
                        break;
                    case REMOVE_LAST:
                        user.removeLastRecord();
                        break;
                    case SHUFFLE:
                        user.shuffleRecord();
                        break;
                    case REMOVE_LOWER:
                        user.removeLoverRecord(.element.)
                        break;
                    case REMOVE_ALL_BY_POSTAL_ADDRESS:
                        user.removeAllByPostalAddressRecord(.postal_address.);
                        break;
                    case MIN_BY_FULL_NAME:
                        user.minByFullNameRecord();
                        break;
                    case FILTER_GREATER_THAN_POSTAL_ADDRESS:
                        user.filterGreaterThanPostalAddressRecord(.postal_address.);
                        break;
                }
            } else{
                System.out.println("Команда введена неверно. Попробуйте ещё раз.");
            }

        }


        // fileReader.read(buff);
        /*String row = new String();*/
        /*for (char c : buff){
            if (c == '\n'){
               String[] string =  row.split(";");
               try{
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
                   Address postalAddress = ;
                   Organization organization = new Organization(id, name, coordinates, creationDate, annualTurnover, fullName, employeeCount, type, postalAddress);
                   organizations.push(organization);
                   row = "";
               }catch (NumberFormatException e){
                   System.out.println("Некорректные данные. Проверьте корректность данных в файле.");
               }
            }
            row += c;*/
        Organization last = organizations.peek();
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        }
    }
