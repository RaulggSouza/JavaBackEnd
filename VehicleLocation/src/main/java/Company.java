import java.time.LocalDate;

public class Company {
    private final String name;
    private final Vehicle[] vehicles;
    private final Rental[] rentals;
    private int vehicleCounter;
    private int rentalCounter;

    public Company(String name) {
        this.name = name;
        vehicles = new Vehicle[100];
        rentals = new Rental[100];
        vehicleCounter = 0;
        rentalCounter = 0;
    }

    public void addVehicle(Vehicle vehicle){
        if (vehicle != null) {
            vehicles[vehicleCounter++] = vehicle;
        }
    }

    public Rental rentVehicle(Costumer costumer, String plate, LocalDate start, LocalDate end){
        Vehicle vehicle = getVehicle(plate);
        if (vehicle != null){
            Rental rent = new Rental(costumer, vehicle, start, end);
            rentals[rentalCounter++] = rent;
            return rent;
        }
        return null;
    }

    private Vehicle getVehicle(String plate) {
        for (int i = 0; i < vehicleCounter; i++) {
            Vehicle vehicle = vehicles[i];
            if (vehicle.getPlate().equals(plate)) return vehicle;
        }
        return null;
    }

    public boolean returnVehicle(String rentalId){
        int index = hasRent(rentalId);
        if(index >= 0){
            for (int i = index; i+1 < rentalCounter; i++) {
                rentals[i] = rentals[i+1];
            }
            rentalCounter--;
            rentals[rentalCounter] = null;
            return true;
        }
        return false;
    }

    private int hasRent(String rentalId) {
        for (int i = 0; i < rentalCounter; i++) {
            Rental rent = rentals[i];
            if (rent.getId().equals(rentalId)) return i;
        }
        return -1;
    }

    public String getName() {
        return name;
    }

    public Vehicle[] getVehicles() {
        return vehicles;
    }

    public Rental[] getRentals() {
        return rentals;
    }
}
