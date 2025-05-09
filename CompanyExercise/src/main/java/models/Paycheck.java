import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Paycheck {
    private LocalDate payday;
    private final double salary;

    public Paycheck(LocalDate payday, double salary) {
        this.payday = payday;
        this.salary = salary;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public double getSalary() {
        return salary;
    }

    public void setPayday(LocalDate payday) {
        this.payday = payday;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paycheck paycheck = (Paycheck) o;
        return Double.compare(salary, paycheck.salary) == 0 && Objects.equals(payday, paycheck.payday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payday, salary);
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return "Paycheck{" +
                "payday=" + formatter.format(payday) +
                ", salary=" + salary +
                '}';
    }
}
