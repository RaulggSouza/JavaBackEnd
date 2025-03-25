public class Main {
    public static void main(String[] args) {
        System.out.println(ReservationIdGenerator.nextId());

        final Guest guestA = new Guest("12321", "Jão", "jão@pao.com");
        final Guest guestB = new Guest("12324", "Maria", "maria@pao.com");

        Room room1 = new Room(2, 500);
        Room room2 = new Room(3, 500);
        Room[] rooms = new Room[]{room1, room2};
        Hotel hotel = new Hotel("IFSP", rooms);
    }
}
