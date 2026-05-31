public class Employee {

    private int id;
    private String name;
    private String department;
    private double salary;
    private String email;

    // Constructor
    public Employee(
            int id,
            String name,
            String department,
            double salary,
            String email
    ) {

        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    @Override
public String toString() {

    return
            "ID: " + id +
            ", Name: " + name +
            ", Department: " + department +
            ", Salary: " + salary +
            ", Email: " + email;
}
}