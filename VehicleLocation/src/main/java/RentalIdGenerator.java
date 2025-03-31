public class RentalIdGenerator {
    private static int counter = 1;

    private RentalIdGenerator() {}

    public static String generateId(){
        return String.format("Rental - %d", counter++);
    }
}
