package zadatak6;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class EmployeePayroll {
    
    private static final Logger LOGGER = Logger.getLogger(EmployeePayroll.class.getName());
    
    private List<Employee> employees;
    
    public EmployeePayroll() {
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee employee) {
        this.employees.add(employee);
    }
    
    public void displayPayroll() {
        for (Employee employee : employees) {
            try {
                double salary = employee.calculateSalary();
                if (salary < 0) {
                    LOGGER.warning("Greska: Podaci o satnici ili broju radnih sati su neispravni za " + employee.getFullName());
                    continue;
                }
                LOGGER.info(employee.getFullName() + ": " + salary);
            } catch (IllegalArgumentException e) {
                LOGGER.warning(e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        EmployeePayroll payroll = new EmployeePayroll();
        payroll.addEmployee(new Employee("Ivo", "Iviæ", 10, 40));
        payroll.addEmployee(new Employee("Ana", "Anic", 25, 35));
        payroll.addEmployee(new Employee("Petar", "Petrovic", 10, 50));
        payroll.addEmployee(new Employee("Jana", "Janiæ", 1, 20));
        payroll.addEmployee(new Employee("Marko", "Markovic", 15, 45));
        
        payroll.displayPayroll();
    }
}

class Employee {
    
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private int hoursWorked;
    
    public Employee(String firstName, String lastName, double hourlyRate, int hoursWorked) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }
    
    public double calculateSalary() {
        if (this.hourlyRate <= 0 || this.hoursWorked <= 0) {
            throw new IllegalArgumentException("Greska: Podaci o satnici ili broju radnih sati su neispravni za " + this.getFullName());
        }
        return this.hourlyRate * this.hoursWorked;
    }
    
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }
}
