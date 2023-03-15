package organizations;

public class Address {
    private final String zipCode; //Поле может быть null
    private final Location town; //Поле может быть null

    public Address(String zipCode, Location town) {
        this.zipCode = zipCode;
        this.town = town;
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
