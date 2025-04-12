import java.time.LocalDateTime;

public class DeliveryCompany {
    private final String name;
    private Delivery[] deliveries;

    public DeliveryCompany(String name, Delivery[] deliveries) {
        this.name = name;
        this.deliveries = new Delivery[100];
    }

    public Delivery createDelivery(Costumer costumer, Product[] products){
        if (costumer == null) return null;
        if (products == null) return null;
        Delivery delivery = new Delivery(costumer, products, DeliveryStatus.PENDING, LocalDateTime.now(), LocalDateTime.now().plusDays(2));
        return null;
    }

    public Delivery cancelDelivery(String deliveryId){
        for (Delivery delivery : deliveries) {
            if (delivery != null){
                if (delivery.getId().equals(deliveryId)){
                    delivery.updateStatus(DeliveryStatus.CANCELED);
                    return delivery;
                }
            }
        }
        return null;
    }

    public Delivery[] getDeliveriesByStatus(DeliveryStatus status){
        Delivery[] deliveriesByStatus = new Delivery[deliveries.length];
        int indexStatus = 0;
        for (Delivery delivery : deliveries) {
            if (delivery != null && delivery.getStatus().equals(status)){
                deliveriesByStatus[indexStatus++] = delivery;
            }
        }
        return deliveriesByStatus;
    }

    public String getName() {
        return name;
    }

    public Delivery[] getDeliveries() {
        return deliveries;
    }
}
