import java.time.LocalDate;

public class Hotel {
    private final String name;
    private final Room[] rooms;
    private final Reservation[] reservations;
    private int numberOfReservations;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        reservations = new Reservation[100];
        numberOfReservations = 0;
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut){
        Room room = getRoom(roomNumber);
        if (room == null) return null;
        if (!isAvaliableAt(room, checkIn, checkOut)) return null;
        if (checkIn == null || checkOut == null || !checkIn.isBefore(checkOut)) return null;

        final Reservation reservation = new Reservation(checkIn, checkOut, guest, room);
        reservations[numberOfReservations++] = reservation;
        return reservation;
    }

    private Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber) return room;
        }
        return null;
    }

    public Reservation cancelReservation(String reservationId){
        for (int i = 0; i < numberOfReservations; i++) {
            if (reservations[i].getId().equals(reservationId)){
                Reservation removed = reservations[i];
                removeFromReservations(i);
                return removed;
            }
        }
        return null;
    }

    private void removeFromReservations(int indexReservation){
        for (int i = indexReservation; i+1 < numberOfReservations; i++) {
            reservations[i] = reservations[i+1];
        }
        numberOfReservations--;
    }

    public Room[] getRoomsAvailableAt(LocalDate date){
        Room[] reservedRooms = new Room[rooms.length];
        int roomsReserved = 0;

        for (Room room : rooms) {
            for (int i = 0; i < numberOfReservations; i++){
                if (reservations[i] == null) continue;
                if (reservations[i].isReservedAt(date, room)) {
                    reservedRooms[roomsReserved++] = room;
                    break;
                }
            }
        }

        Room[] availableRooms = new Room[rooms.length - roomsReserved];
        int roomsAvailable = 0;
        for (Room room : rooms) {
            boolean contains = false;
            for (int i = 0; i < roomsReserved; i++) {
                 if (room == reservedRooms[i]){
                     contains = true;
                     break;
                 }
            }
            if (!contains) availableRooms[roomsAvailable++] = room;
        }
        return availableRooms;
    }

    private boolean isAvaliableAt(Room room, LocalDate checkIn, LocalDate checkOut){
        if (!hasRoom(room)) return false;

        for (int i = 0; i < numberOfReservations; i++) {
            Reservation current = reservations[i];
            if (room.getNumber() != current.getRoom()) continue;
            if (isReservedInRange(room, checkIn, checkOut, current)) return false;
        }
        return true;
    }

    private boolean isReservedInRange(Room room, LocalDate checkIn, LocalDate checkOut, Reservation reservation){
        LocalDate current = checkIn;
        while (current.isBefore(checkOut)){
            if (reservation.isReservedAt(current, room)) return true;
            current.plusDays(1);
        }
        return false;
    }

    private boolean hasRoom(Room room){
        for (Room r : rooms) {
            if (r.getNumber() == room.getNumber()) return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public Room[] getRooms() {
        return rooms;
    }

    public Reservation[] getReservations() {
        return reservations;
    }
}
