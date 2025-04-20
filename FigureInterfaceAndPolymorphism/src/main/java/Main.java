public class Main {
    public static void main(String[] args) {
        Figure[] figures = new Figure[150];
        int idx = 0;
        double areas = 0;
        for (int i = 1; i <= 50; i++){
            figures[idx++] = new Circle(0, 0, i);
            figures[idx++] = new Triangle(0, 0, i, i, i);
            figures[idx++] = new Rectangle(0, 0, i, i);
        }
        for (Figure figure : figures) {
            areas += figure.area();
        }
        System.out.printf("%.2f", areas);
    }
}
