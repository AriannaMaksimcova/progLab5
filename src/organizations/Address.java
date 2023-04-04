package organizations;

import java.util.Scanner;

public class Address {
    private final String zipCode; //Поле может быть null
    private final Location town; //Поле может быть null

    public Address(String zipCode, Location town) {
        this.zipCode = zipCode;
        this.town = town;
    }

    public static Address readAddress(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter zip code for address:");
        String zipCode = scanner.nextLine(); //todo: validation
        System.out.println("Enter coordinate X of town location:");
        double x2 = scanner.nextDouble(); //todo: validation
        System.out.println("Enter coordinate Y of town location:");
        int y2 = scanner.nextInt();//todo: validation
        System.out.println("Enter coordinate Z of town location:");
        Long z2 = scanner.nextLong();//todo: validation
        scanner.close();
        return new Address(zipCode, new Location(x2, y2, z2));
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
}
