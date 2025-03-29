import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Reservation {
    private final String id;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private final Guest guest;
    private final Room room;

    public Reservation(LocalDate checkIn, LocalDate checkOut, Guest guest, Room room) {
        id = ReservationIdGenerator.nextId();
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guest = guest;
        this.room = room;
    }

    public Double getPrice(){
        return room.getPrice() * getDays();
    }

    private int getDays() {
        return Period.between(checkIn, checkOut).getDays();
    }


    public boolean isReservedAt(LocalDate date, Room room){
        if (room != this.room) return false;
        return !date.isBefore(checkIn) && date.isBefore(checkOut);
    }

    public String asString(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return String.format("""
                _______________________________________________________________
                Reservation: %s Room number: %d
                Guest name: %s SSN: %s E-mail: %s
                Check-in: %s Check-out: %s
                Number of days: %d Room price: U$%.2f
                TOTAL: U$%.2f;
                _______________________________________________________________
                """, id, getRoom(), getGuest(), guest.getSsn(), guest.getEmail(), formatter.format(checkIn),
                formatter.format(checkOut), getDays(), room.getPrice(), getPrice());
    }

    public String getId() {
        return id;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public String getGuest() {
        return guest.getName();
    }

    public int getRoom() {
        return room.getNumber();
    }
}
