import java.time.LocalDate;
import java.time.Period;

public final class PerHourEmployee extends Employee{
    private double wage;
    private int workedHours;

    public PerHourEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double wage, int workedHours) {
        super(id, name, jobTitle, dateOfEmployment);
        this.wage = wage;
        this.workedHours = workedHours;
    }

    @Override
    public double salary() {
        return Period.between(getDateOfEmployment(), LocalDate.now()).getMonths()*(workedHours*wage);
    }

    public double getWage() {
        return wage;
    }

    public void setWage(double wage) {
        this.wage = wage;
    }

    public int getWorkedHours() {
        return workedHours;
    }

    public void setWorkedHours(int workedHours) {
        this.workedHours = workedHours;
    }
}
