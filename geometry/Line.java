package geometry;

/**
 * Created with IntelliJ IDEA.
 * User: riad
 */
public class Line {
    public double a, b, c;

    public Line(double a, double b, double c) {
        double h = GeometryUtils.length(a, b);
        this.a = a / h;
        this.b = b / h;
        this.c = c / h;
        if (this.a < 0.0) {
            this.a *= -1;
            this.b *= -1;
        }
    }

    public Line(double k, double m) {
        this(new Point(0, m), new Point(1, k + m));
    }

    public Line(Point x, Point y) {
        if (Math.abs(x.x - y.x) < GeometryUtils.epsilon) {
            b = 1;
            a = (y.y - x.y) / (x.x - y.x);
            double h = GeometryUtils.length(a, b);
            if (a < 0.0)
                h *= -1;
            a /= h;
            b /= h;
            c = -(a * x.x + b * y.x);
        } else {
            a = 1;
            b = 0;
            c = -x.x;
        }
    }

    public double angle() {
        return Math.atan2(a, -b);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (Double.compare(line.a, a) != 0) return false;
        if (Double.compare(line.b, b) != 0) return false;
        if (Double.compare(line.c, c) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = a != +0.0d ? Double.doubleToLongBits(a) : 0L;
        result = (int) (temp ^ (temp >>> 32));
        temp = b != +0.0d ? Double.doubleToLongBits(b) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = c != +0.0d ? Double.doubleToLongBits(c) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean parallel(Line other) {
        return Math.abs(a - other.a) < GeometryUtils.epsilon && Math.abs(b - other.b) < GeometryUtils.epsilon;
    }

    public Point intersect(Line other) {
        if (this.parallel(other))
            return null;
        double det = a * other.b - b * other.a;
        double det1 = -c * other.b + b * other.c;
        double det2 = -a * other.c + c * other.a;
        return new Point(det1 / det, det2 / det);
    }
}
