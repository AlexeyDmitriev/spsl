package geometry;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class GeometryUtils {
    public static double epsilon = 1e-9;

    public static double length(double... coordinates) {
        double sum = 0;
        for (double c : coordinates) {
            sum += c * c;
        }
        return Math.sqrt(sum);
    }

}
