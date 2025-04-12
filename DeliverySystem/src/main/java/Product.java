public class Product {
    private final String code;
    private String name;
    private double price;
    private double weight;

    public Product(String code, String name, double price, double weight) {
        this.code = (code == null || code.isBlank() ? "Default" : code);
        this.name = name;
        setPrice(price);
        setWeight(weight);
    }

    public String asString(){
        return String.format("Code: %s Name: %s Price: %.2f Weight: %.2f", code, getName(), getPrice(), getWeight());
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = (price < 0 ? 1.0 : price);
    }

    public void setWeight(double weight) {
        this.weight = (weight < 0 ? 1.5 : weight);
    }
}
