import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Rental {
    private final String id;
    private final Costumer costumer;
    private final Vehicle vehicle;
    private final LocalDate startDate;
    private final LocalDate endDate;

    public Rental(Costumer costumer, Vehicle vehicle, LocalDate startDate, LocalDate endDate) {
        this.id = RentalIdGenerator.generateId();
        this.costumer = costumer;
        this.vehicle = vehicle;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getTotalPrice(){
        return getVehicle().getDailyRate() * daysWithCar();
    }

    private int daysWithCar(){
        return Period.between(getStartDate(), getEndDate()).getDays();
    }

    public String asString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("ID: %s | Costumer: %s | Vehicle Plate: %s | Start Date: %s | End Date: %s",
                id, getCostumer(), getVehicle().getPlate(), formatter.format(startDate), formatter.format(endDate));
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public String getId() {
        return id;
    }

    public String getCostumer() {
        return costumer.getName();
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }
}
