import java.time.LocalTime;

public class DeliveryIdGenerator {
    private static int id = 10_000;

    private DeliveryIdGenerator(){}

    public static String nextId(){
        LocalTime now = LocalTime.now();
        return String.format("DLV-%d-%d-%d", now.getSecond(), now.getMinute(), id++);
    }
}
