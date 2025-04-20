public sealed abstract class Figure permits Circle, Rectangle, Triangle{
    private final double x;
    private final double y;

    public Figure(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public abstract double area();

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
