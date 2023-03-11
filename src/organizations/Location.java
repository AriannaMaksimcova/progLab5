package organizations;

public class Location {
    private double x;
    private int y;
    private Long z; //Поле не может быть null

    public Location(double x, int y, Long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
