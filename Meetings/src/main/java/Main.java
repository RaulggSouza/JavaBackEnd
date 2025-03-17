import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) {
        LocalDate date = LocalDate.now();
        LocalTime starting = LocalTime.of(8,0);
        LocalTime ending = LocalTime.of(18,0);
        Schedule schedule = new Schedule(date, starting, ending);
        LocalTime start = LocalTime.of(23,30);
        LocalTime end = LocalTime.of(1,0);
        Meeting meet = new Meeting("Test", start, end);
        schedule.addMeeting(meet);
        System.out.println(schedule.scheduleAsString());
        System.out.println(schedule.percentageSpentInMeetings());
        schedule.removeMeeting(meet);
        System.out.println(schedule.scheduleAsString());

    }
}
