package geometry;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class GeometryUtils {
    static public double epsilon = 1e-9;

    static public double length(double... coordinates) {
        double sum = 0;
        for (double c : coordinates) {
            sum += c * c;
        }
        return Math.sqrt(sum);
    }

}
