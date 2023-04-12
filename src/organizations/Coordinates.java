package organizations;
/**
 * Class that allows you to create an object of coordinates and work with it.
 */
public class Coordinates {
    private Float x; //Максимальное значение поля: 75, Поле не может быть null
    private Integer y; //Значение поля должно быть больше -177, Поле не может быть null

    public Coordinates(Float x, Integer y) {
        if(x <= 75){
            this.x = x;
        }
        if(y > -177){
            this.y = y;
        }

    }
    /**
     * Method that returns field x.
     * @return Float
     */
    public Float getX() {
        return x;
    }
    /**
     * Method that returns field y.
     * @return Integer
     */
    public Integer getY() {
        return y;
    }
    /**
     * Method that converts an object of this class to a string.
     * @return String
     */
    @Override
    public String toString() {
        return x + ";" + y;
    }
}
