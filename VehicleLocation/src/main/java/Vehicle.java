public class Vehicle {
    private final String plate;
    private double dailyRate;

    public Vehicle(String plate, double dailyRate) {
        this.plate = (plate != null && !plate.isBlank() ? plate : "Default");
        setDailyRate(dailyRate);
    }

    public String getPlate() {
        return plate;
    }

    public double getDailyRate() {
        return dailyRate;
    }

    public void setDailyRate(double dailyRate) {
        this.dailyRate = (dailyRate < 0 ? 1.0 : dailyRate);
    }
}
