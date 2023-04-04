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

    public double getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Long getZ() {
        return z;
    }

    @Override
    public String toString() {
        return x + ";" + y + ";" + z;
    }
}
