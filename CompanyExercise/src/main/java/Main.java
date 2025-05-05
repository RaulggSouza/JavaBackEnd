import java.time.LocalDate;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("2", "Astolfo", "PO", 20000.00, LocalDate.now().plusDays(3));
        Company dell = new Company("Dell", "32");


        employee.addPaycheck(LocalDate.now().plusDays(30));
        employee.addPaycheck(LocalDate.now().plusMonths(2));

        Iterator<Paycheck> paycheckIterator = employee.iteratorPaycheck();
        while(paycheckIterator.hasNext()){
            final Paycheck pay = paycheckIterator.next();
            System.out.println(pay.toString());
        }
    }
}
