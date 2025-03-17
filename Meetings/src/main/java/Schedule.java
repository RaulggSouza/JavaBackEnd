import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class Schedule {
    private final LocalDate day;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final Meeting[] meetings = new Meeting[24];
    private int numberOfMeetings;

    public Schedule(LocalDate day, LocalTime startTime, LocalTime endTime) {
        this.day = day;
        this.startTime = startTime;
        this.endTime = endTime;
        numberOfMeetings = 0;
    }

    public void addMeeting(Meeting meeting){
        if(isMeetingValid(meeting)){
            meetings[numberOfMeetings] = meeting;
            numberOfMeetings++;
        }
    }

    private int indexOfMeeting(Meeting meeting){
        for (int i = 0; i < numberOfMeetings; i++) {
            Meeting meet = meetings[i];
            if(meeting.equals(meet)){
                return i;
            }
        }
        return -1;
    }

    public void removeMeeting(Meeting meeting){
        int index = indexOfMeeting(meeting);
        if(index != -1){
            for (int i = index; i+1 < numberOfMeetings; i++) {
                meetings[i] = meetings[i+1];
            }
        }
        numberOfMeetings--;
    }

    public double percentageSpentInMeetings(){
        long allDay = Duration.between(startTime,endTime).toMinutes();
        long timeInMeetings = 0;
        if (numberOfMeetings > 0){
            for (int i = 0; i < numberOfMeetings; i++) {
                Meeting meeting = meetings[i];
                timeInMeetings += meeting.durationInMinutes();
            }
        }
        return (double) (timeInMeetings*100)/allDay;
    }

    public String scheduleAsString(){
        StringBuilder output = new StringBuilder();
        if (numberOfMeetings > 0){
            output.append("Day: ").append(day).append("\n");
            output.append("Starting time: ").append(startTime).append("\n");
            output.append("Ending time: ").append(endTime).append("\n");
            for (int i = 0; i < numberOfMeetings; i++) {
                Meeting meeting = meetings[i];
                output.append("Durantion of meeting number ").append(i+1).append(": ").append(meeting.durationInMinutes()).append(" minutes").append("\n");
                output.append("Description: ").append(meeting.getDescription()).append("\n");
            }
        }else {
            output.append("Clean Schedule");
        }
        return output.toString();
    }

    private boolean isMeetingValid(Meeting meeting){
        LocalTime startTimeNew = meeting.getStartTime();
        LocalTime endTimeNew = meeting.getEndTime();
        if(startTimeNew.isBefore(startTime) || endTimeNew.isAfter(endTime)){
            return false;
        }
        if (numberOfMeetings > 0){
            for (Meeting meet : meetings) {
                LocalTime startTimeTested = meet.getStartTime();
                LocalTime endTimeTested = meet.getEndTime();
                if (!(startTimeNew.isBefore(startTimeTested) && endTimeNew.isBefore(startTimeTested)) && !(startTimeNew.isAfter(endTimeTested) && endTimeNew.isAfter(endTimeTested))){
                    return false;
                }
            }
        }
        return true;
    }
}
