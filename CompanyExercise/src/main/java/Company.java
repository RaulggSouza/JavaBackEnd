import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Company {
    private String name;
    private final String id;
    private List<Employee> employees = new ArrayList<>();

    public Company(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment){
        employees.add(new Employee(id, name, jobTitle, salary, dateOfEmployment));
    }

    public void hire(Employee employee){
        employees.add(employee);
    }

    public void fire(String idToBeFired){
        employees.stream()
                .filter(e -> e.getId().equals(idToBeFired))
                .findFirst()
                .ifPresent(employees::remove);
    }

    public Iterator<Employee> getEmployees(){
        return employees.iterator();
    }

    public Iterator<Employee> getEmployees(String jobTitle){
        return employees.stream()
                .filter(e -> e.getJobTitle().equals(jobTitle))
                .iterator();
    }

    public void pay(String idToBePayed){
        employees.stream()
                .filter(e -> e.getId().equals(idToBePayed))
                .findFirst()
                .ifPresent(e -> e.addPaycheck(LocalDate.now()));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Company company = (Company) o;
        return Objects.equals(id, company.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
