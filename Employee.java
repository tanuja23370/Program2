
public class Employee extends Person {
    private String empId;

    private double salary;

    public Employee(String name, String dob, String empId, double salary) throws Exception {
        super(name, dob);
        this.empId = empId;
        this.salary = salary;
    }

    public void displayEmployeeDetails() {
        displayName();
        displayAge();
        System.out.println("Employee ID: " + empId);
        System.out.println("Salary: " + salary);
    }

    public static void main(String[] args) {
        try {
            Employee e = new Employee("Bob", "1995-03-22", "E101", 50000.0);
            e.displayEmployeeDetails();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
