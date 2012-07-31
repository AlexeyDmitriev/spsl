package geometry;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class Point {
    public double x, y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance() {
        return Math.sqrt(x * x + y * y);
    }

    public double distance(Point other) {
        return this.subtract(other).distance();
    }

    public Point subtract(Point other) {
        return new Point(x - other.x, y - other.y);
    }

    public Point add(Point other) {
        return new Point(x + other.x, y + other.y);
    }

    public double scalarMultiply(Point other) {
        return x * other.x + y * other.y;
    }

    public double vectorMultiply(Point other) {
        return x * other.y - y * other.x;
    }

    public double angle() {
        return Math.atan2(y, x);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;

        Point other = (Point) o;
        return Math.abs(x - other.x) < GeometryUtils.epsilon && Math.abs(y - other.y) < GeometryUtils.epsilon;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = x != +0.0d ? Double.doubleToLongBits(x) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = y != +0.0d ? Double.doubleToLongBits(y) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public Point rotate(double angle) {
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
        return new Point(x * cos - y * sin, x * sin + y * cos);
    }

    public Point rotate(double angle, Point center) {
        return center.add(this.subtract(center).rotate(angle));
    }

}
