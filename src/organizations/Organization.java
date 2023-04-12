package organizations;

import java.time.LocalDate;
/**
 * Class that allows you to create an organization and work with it.
 */
public class Organization{
    private final int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private final String name; //Поле не может быть null, Строка не может быть пустой
    private final Coordinates coordinates; //Поле не может быть null
    private final java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private final Integer annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private final String fullName; //Поле может быть null
    private final long employeesCount; //Значение поля должно быть больше 0
    private final OrganizationType type; //Поле не может быть null
    private final Address postalAddress; //Поле может быть null

    public Organization(int id, String name, Coordinates coordinates, LocalDate creationDate, Integer annualTurnover, String fullName, long employeesCount, OrganizationType type, Address postalAddress) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.annualTurnover = annualTurnover;
        this.fullName = fullName;
        this.employeesCount = employeesCount;
        this.type = type;
        this.postalAddress = postalAddress;
    }
    /**
     * Method that converts an object of this class to a string.
     * @return String
     */
    @Override
    public String toString() {
        return "Organization{ " +
                " id = " + id +
                ", name = '" + name + '\'' +
                ", coordinates = " + coordinates +
                ", creationDate = " + creationDate +
                ", annualTurnover = " + annualTurnover +
                ", fullName = '" + fullName + '\'' +
                ", employeesCount = " + employeesCount +
                ", type = " + type +
                ", postalAddress = " + postalAddress +
                '}';
    }
    /**
     * Method that converts an object of this class to CSV format.
     * @return String
     */
    public String toCSV() {
        return id + ";" + name + ";" + coordinates.getX() + ";" + coordinates.getY() + ";" + creationDate + ";"
                + annualTurnover + ";" + fullName + ";" + employeesCount + ";" + type + ";"
                + postalAddress.getZipCode() + ";" + postalAddress.getTown().toString() + "\n";
    }

    /**
     * Method that returns field id.
     * @return int
     */
    public int getId() {
        return id;
    }
    /**
     * Method that returns field postalAddress.
     * @return Address
     */
    public Address getPostalAddress() {
        return postalAddress;
    }
    /**
     * Method that returns field name.
     * @return String
     */
    public String getName() {
        return name;
    }
    /**
     * Method that returns field annualTurnover.
     * @return Integer
     */
    public Integer getAnnualTurnover() {
        return annualTurnover;
    }
    /**
     * Method that returns field fullName.
     * @return String
     */
    public String getFullName() {
        return fullName;
    }
    /**
     * Method that returns field employeeCount.
     * @return long
     */
    public long getEmployeesCount() {
        return employeesCount;
    }
}

