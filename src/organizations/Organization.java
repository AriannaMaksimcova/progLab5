package organizations;

import java.time.LocalDate;

public class Organization{
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDate creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer annualTurnover; //Поле может быть null, Значение поля должно быть больше 0
    private String fullName; //Поле может быть null
    private long employeesCount; //Значение поля должно быть больше 0
    private OrganizationType type; //Поле не может быть null
    private Address postalAddress; //Поле может быть null

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

    @Override
    public String toString() {
        return id + ";" + name + ";" + coordinates.getX() + ";" + coordinates.getY() + ";" + creationDate + ";"
                + annualTurnover + ";" + fullName + ";" + employeesCount + ";" + type + ";"
                + postalAddress.getZipCode() + ";" + postalAddress.getTown().toString();
    }


    public int getId() {
        return id;
    }

    public Address getPostalAddress() {
        return postalAddress;
    }

    public String getName() {
        return name;
    }

    public Integer getAnnualTurnover() {
        return annualTurnover;
    }

    public String getFullName() {
        return fullName;
    }

    public long getEmployeesCount() {
        return employeesCount;
    }
}

