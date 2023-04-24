package organizations;

import tools.WrongDataInFileException;

import java.util.Scanner;

public class Address {
    private final String zipCode; //Поле может быть null
    private final Location town; //Поле может быть null

    public Address(String zipCode, Location town) {
        this.zipCode = zipCode;
        this.town = town;

    }

    public static Address readAddress(Scanner scanner){
        System.out.println("Enter zip code for address (String):");
        String zipCode = scanner.nextLine().replace(";","");
        System.out.println("Enter coordinate X of town location (double):");
        double x2;
        while(true) {
            String x = scanner.nextLine();
            try {
                x2 = Double.parseDouble(x);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect input data");
            }
        }
        System.out.println("Enter coordinate Y of town location (int):");
        int y2;
        while(true) {
            String y = scanner.nextLine();
            try {
                y2 = Integer.parseInt(y);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect input data");
            }
        }
        System.out.println("Enter coordinate Z of town location (long):");
        long z2;
        while(true) {
            String z = scanner.nextLine();
            try {
                z2 = Long.parseLong(z);
                break;
            }
            catch (NumberFormatException e){
                System.out.println("Incorrect input data");
            }
        }
        return new Address(zipCode, new Location(x2, y2, z2));
    }

    public static Address readAddressFromFile(Scanner scanner) throws WrongDataInFileException {
        try {
            String zipCode = scanner.nextLine().replace(";","");
            double x2;
            String x = scanner.nextLine();
            x2 = Double.parseDouble(x);
            int y2;
            String y = scanner.nextLine();
            y2 = Integer.parseInt(y);
            long z2;
            String z = scanner.nextLine();
            z2 = Long.parseLong(z);

            return new Address(zipCode, new Location(x2, y2, z2));
        } catch (NumberFormatException e) {
            throw new WrongDataInFileException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!zipCode.equals(address.zipCode)) return false;
        return town.equals(address.town);
    }

    @Override
    public int hashCode() {
        int result = zipCode.hashCode();
        result = 31 * result + town.hashCode();
        return result;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Location getTown() {
        return town;
    }

    @Override
    public String toString() {
        return zipCode + ": " + town;
    }
}
