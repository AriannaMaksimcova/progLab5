package organizations;
/**
 * Class that allows you to create a location and work with it.
 */
public class Location {
    private final double x;
    private final int y;
    private final Long z; //Поле не может быть null

    public Location(double x, int y, Long z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    /**
     * Method that returns field x.
     * @return double
     */
    public double getX() {
        return x;
    }
    /**
     * Method that returns field y.
     * @return int
     */
    public int getY() {
        return y;
    }
    /**
     * Method that returns field z.
     * @return Long
     */
    public Long getZ() {
        return z;
    }
    /**
     * Method that converts an object of this class to a string.
     * @return String
     */
    @Override
    public String toString() {
        return x + ";" + y + ";" + z;
    }
}
