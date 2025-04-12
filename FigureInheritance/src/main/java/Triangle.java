public final class Triangle extends Figure{
    private double a;
    private double b;
    private double c;
    private TriangleType type;
    public Triangle(double x, double y, double a, double b, double c) {
        super(x, y);
        this.a = a;
        this.b = b;
        this.c = c;
        type = getType();
    }

    @Override
    public double area() {
        double result;
        if (type == TriangleType.EQUILATERO) {
            result = Math.sqrt(3)/4*Math.pow(a,2);
        } else if (type == TriangleType.ISOCELES){
            double base = getBase();
            double altura = Math.sqrt(Math.pow(Math.min(Math.min(a,b),c),2) - Math.pow(base/2, 2));
            result = (base*altura)/2;
        } else {
            //Fórmula de Heron
            double semiperimetro = (a+b+c)/2;
            result = Math.sqrt(semiperimetro*(semiperimetro-a)*(semiperimetro-b)*(semiperimetro-c));
        }
        return result;
    }

    private TriangleType getType(){
        if (a == b && b == c) return TriangleType.EQUILATERO;
        if (a != b && b != c) return TriangleType.ESCALENO;
        return TriangleType.ISOCELES;
    }

    private double getBase(){
        return Math.max(Math.max(a,b),c);
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
        type = getType();
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
        type = getType();
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
        type = getType();
    }
}
