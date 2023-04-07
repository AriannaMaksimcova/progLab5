package validators;

public class Validator {
    public boolean validateInt(String value){

        if (value == null) {
            System.out.println("No input value");
            return false;
        }
        try {
            int v = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println("Input is not an integer");
            return false;
        }
        return true;
    }
    public boolean validateFloat(String value){
        if (value == null) {
            System.out.println("No input value");
            return false;
        }
        try {
            float v = Float.parseFloat(value);

        } catch (NumberFormatException e) {
            System.out.println("Input is not a float");
            return false;
        }
        return true;
    }
    public boolean validateCoordinateX(String value){
        if (!validateFloat(value)){
            System.out.println("Uncorrected format. Try again.");
            return false;
        }
        float x = Float.parseFloat(value);
        if (x > 75){
            System.out.println("X has to be <= 75 and can't be null. Try again.");
            return false;
        }
        return true;
    }
    public boolean validateCoordinateY(String value){
        if (!validateInt(value)){
            System.out.println("Uncorrected format. Try again.");
            return false;
        }
        int y = Integer.parseInt(value);
        if(y < -177){
            System.out.println("Y has to be > -177 and can't be null. Try again.");
            return false;
        }
        return true;
    }
}
