package organizations;

public class Coordinates {
    private Float x; //Максимальное значение поля: 75, Поле не может быть null
    private Integer y; //Значение поля должно быть больше -177, Поле не может быть null

    public Coordinates(Float x, Integer y) {
        if(x <= 75 && x != null){
            this.x = x;
        }
        if(y > -177 && y!= null){
            this.y = y;
        }

    }

    public Float getX() {
        return x;
    }

    public Integer getY() {
        return y;
    }
}
