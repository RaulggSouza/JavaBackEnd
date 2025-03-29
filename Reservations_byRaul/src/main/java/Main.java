import java.time.LocalDate;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Guest mario = new Guest("234", "Mario", "mario@gmail.com");
        Room room = new Room(3, 300.00);
        Room room2 = new Room(4, 3030.00);
        //System.out.println(room.asString());
        Reservation reservation = new Reservation(LocalDate.now(), LocalDate.now().plusDays(3), mario, room);
//        System.out.println(reservation.isReservedAt(LocalDate.now().plusDays(3), room));
        Room[] rooms = {room, room2};
        Hotel hotel = new Hotel("Hotel", rooms);
        Reservation res = hotel.makeReservation(mario, 3, LocalDate.now(), LocalDate.now().plusDays(2));
        Reservation r = hotel.makeReservation(mario, 4, LocalDate.now().plusDays(4), LocalDate.now().plusDays(6));
        System.out.println(res.asString());
        System.out.println(r.asString());
        Reservation re = hotel.cancelReservation(res.getId());
        System.out.println(re.asString());
    }
}
