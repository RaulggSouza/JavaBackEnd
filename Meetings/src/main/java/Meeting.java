import java.time.Duration;
import java.time.LocalTime;

public class Meeting {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;

    public Meeting(String description, LocalTime startTime, LocalTime endTime) {
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public long durationInMinutes(){
        if(startTime != null && endTime != null){
            long minutes = Duration.between(startTime, endTime).toMinutes();
            if (minutes < 0) minutes += Duration.ofHours(24).toMinutes();
            return minutes;
        }
        return -1;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }
}
