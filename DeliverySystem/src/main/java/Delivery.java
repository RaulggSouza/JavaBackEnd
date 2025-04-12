import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.StringJoiner;

public class Delivery {
    private final String id;
    private final Costumer costumer;
    private final Product[] products;
    private DeliveryStatus status;
    private final LocalDateTime orderDate;
    private final LocalDateTime estimatedDeliveryDate;

    public Delivery(Costumer costumer, Product[] products, DeliveryStatus status, LocalDateTime orderDate, LocalDateTime estimatedDeliveryDate) {
        id = DeliveryIdGenerator.nextId();
        this.costumer = costumer;
        this.products = products;
        this.status = status;
        this.orderDate = orderDate;
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    public double calculateTotalPrice(){
        return getProductsPrice() + deliveryFee(getProducts());
    }

    private double getProductsPrice() {
        double totalPrice = 0.0;
        for (Product product : products) {
            if (product != null) {
                totalPrice += product.getPrice();
            }
        }
        return totalPrice;
    }

    private static double deliveryFee(Product[] products){
        double totalWeight = 0;
        for (Product product : products) {
            if (product != null) {
                totalWeight += product.getWeight();
            }
        }
        if(totalWeight <= 5) return 10.00;
        if (totalWeight <= 10) return 15.00;
        return 20.00;
    }

    public void updateStatus (DeliveryStatus status){
        if (status == DeliveryStatus.PENDING) return;
        if (this.status == DeliveryStatus.CANCELED) return;
        if (status == DeliveryStatus.IN_TRANSIT && this.status == DeliveryStatus.PENDING) this.status = status;
        if (status == DeliveryStatus.DELIVERED && this.status == DeliveryStatus.IN_TRANSIT) this.status = status;
        if (status == DeliveryStatus.CANCELED && this.status == DeliveryStatus.PENDING) this.status = status;
    }

    public String asString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
        return String.format("""
                _______________________________________________________________
                Delivery: %s
                Customer: %s (%s)
                Status: %s
                Order Date: %s
                Estimated Delivery: %s
                Products:
                %s
                Total Products: R$%.2f
                Delivery Fee: R$%.2f
                TOTAL: R$%.2f
                _______________________________________________________________
                """, id, getCostumer().getName(), getCostumer().getCpf(), getStatus(), formatter.format(getOrderDate()),
                formatter.format(getEstimatedDeliveryDate()), getProductList(getProducts()), getProductsPrice(),
                deliveryFee(getProducts()), calculateTotalPrice());
    }

    private String getProductList(Product[] products){
        StringJoiner joiner = new StringJoiner("\n");
        int productCounter = 0;
        for (Product product : products) {
            if (product == null) continue;
            joiner.add(String.format("%d. %s (Code: %s) - R$%.2f", productCounter++, product.getName(),
                    product.getCode(), product.getPrice()));
        }
        return joiner.toString();
    }

    public String getId() {
        return id;
    }

    public Costumer getCostumer() {
        return costumer;
    }

    public Product[] getProducts() {
        return products;
    }

    public DeliveryStatus getStatus() {
        return status;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public LocalDateTime getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }


}
