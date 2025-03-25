import java.time.LocalDate;

public class Hotel {
    private final String name;
    private final Room[] rooms;
    private final Reservation[] reservations;
    private int reservationsCount;

    public Hotel(String name, Room[] rooms) {
        this.name = name;
        this.rooms = rooms;
        this.reservations = new Reservation[100];
    }

    public Reservation makeReservation(Guest guest, int roomNumber, LocalDate checkIn, LocalDate checkOut){
        final Room room = getRoom(roomNumber);
        if (room == null) return null;
        if(isInvalidDateRange(checkIn, checkOut)) return null;
        if(!isAvaliableAt(room, checkIn, checkOut)) return null;

        final Reservation reservation = new Reservation(checkIn, checkOut, guest, room);
        reservations[reservationsCount++] = reservation;

        return reservation;
    }

    public Reservation cancelReservation(String reservationId){
        for (int i = 0; i < reservationsCount; i++) {
            Reservation reservation = reservations[i];
            if(reservation.getId().equals(reservationId)){
                reservationsCount--;
                return reservation;
            }
        }
        return null;
    }

    public Room[] getAvailableRoomsAt(LocalDate date){
        Room[] reservedRooms = new Room[rooms.length];
        int reservedRoomIndex = 0;
        for (Room room : rooms) {
            for (int i = 0; i < reservationsCount; i++){
                Reservation reservation = reservations[i];
                if (reservation == null) continue;
                if (reservation.isReservedAt(date, room)){
                    reservedRooms[reservedRoomIndex++] = room;
                    break;
                }
            }
        }
        int availableRoomSize = rooms.length - reservedRoomIndex;
        Room[] availableRooms = new Room[availableRoomSize];
        int availableRoomIndex = 0;

        for (Room room : rooms) {
            if (room == null) continue;
            boolean contains = false;
            for (Room reservedRoom : reservedRooms) {
                if (room.getNumber() == reservedRoom.getNumber()){
                    contains = true;
                    break;
                }
            }
            if(!contains) availableRooms[availableRoomIndex++] = room;
        }
        return availableRooms;
    }

    private static boolean isInvalidDateRange(LocalDate checkIn, LocalDate checkOut) {
        return checkIn == null || checkOut == null || !checkIn.isBefore(checkOut);
    }

    private Room getRoom(int roomNumber){
        for (Room room : rooms) {
            if (room.getNumber() == roomNumber){
                return room;
            }
        }
        return null;
    }

    private boolean isAvaliableAt(Room room, LocalDate checkIn, LocalDate checkOut){
        if(!hasRoom(room)) return false;

        for (int i = 0; i < reservationsCount; i++) {
            if(reservations[i].getRoom() == room.getNumber()){
                if (isReservedInRange(room, checkIn, checkOut, reservations[i])) return false;
            }
        }
        return true;
    }

    private static boolean isReservedInRange(Room room, LocalDate checkIn, LocalDate checkOut, Reservation reservation) {
        LocalDate current = checkIn;
        while (current.isBefore(checkOut)){
           if(reservation.isReservedAt(current, room)) return true;
        }
        current.plusDays(1);
        return false;
    }

    private boolean hasRoom(Room room) {
        for (Room r : rooms) {
            if (r.getNumber() == room.getNumber()) return true;
        }
        return false;
    }
}
