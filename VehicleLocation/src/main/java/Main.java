import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Costumer roberto = new Costumer("123.456.789-00 ", "Roberto", "Roberto@gmail.com");
//        System.out.println(roberto.getCpf());
//        System.out.println(roberto.getName());
//        System.out.println(roberto.getEmail());
        Vehicle fusca = new Vehicle("BRA2E34", 34);
//        System.out.println(fusca.getPlate());
//        System.out.println(fusca.getDailyRate());
        Vehicle mustang = new Vehicle("GRE4V56", 50);
        Vehicle camaro = new Vehicle("LKJ8N93", 780);
        Company company = new Company("Mecanica Simas Turbo");
        System.out.println(company.getName());
        company.addVehicle(mustang);
        company.addVehicle(camaro);
        Rental rent1 = company.rentVehicle(roberto, "LKJ8N93", LocalDate.now(), LocalDate.now().plusDays(4));
        Rental rent2 = company.rentVehicle(roberto, "GRE4V56", LocalDate.now(), LocalDate.now().plusDays(4));
        for (Vehicle vehicle : company.getVehicles()) {
            if (vehicle != null) System.out.println(vehicle.getPlate());
        }
        for (Rental rental : company.getRentals()) {
            if (rental != null) System.out.println(rental.asString());
        }
    }
}
