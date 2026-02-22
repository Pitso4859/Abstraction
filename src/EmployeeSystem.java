import java.util.ArrayList;
import java.util.Scanner;

// ================= ABSTRACT CLASS =================
abstract class Employee {
    private String name;
    private int id;

    public Employee(String name, int id) {
        this.name = name;
        this.id = id;
    }

    // Abstract method - must be implemented by subclasses
    public abstract double calculateSalary();

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Salary: " + calculateSalary());
        System.out.println("---------------------------------");
    }
}

// ================= FULL TIME EMPLOYEE =================
class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double calculateSalary() {
        return monthlySalary;
    }
}

// ================= PART TIME EMPLOYEE =================
class PartTimeEmployee extends Employee {
    private double hourlyRate;
    private double hoursWorked;

    public PartTimeEmployee(String name, int id, double hourlyRate, double hoursWorked) {
        super(name, id);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return hourlyRate * hoursWorked;
    }
}

// ================= COMMISSION EMPLOYEE =================
class CommissionEmployee extends Employee {
    private double baseSalary;
    private double commission;

    public CommissionEmployee(String name, int id, double baseSalary, double commission) {
        super(name, id);
        this.baseSalary = baseSalary;
        this.commission = commission;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + commission;
    }
}

// ================= MAIN SYSTEM =================
public class EmployeePayrollSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        while (true) {
            System.out.println("===== EMPLOYEE PAYROLL MENU =====");
            System.out.println("1. Add Full-Time Employee");
            System.out.println("2. Add Part-Time Employee");
            System.out.println("3. Add Commission Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Calculate Total Payroll");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String ftName = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int ftId = sc.nextInt();
                    System.out.print("Enter Monthly Salary: ");
                    double monthlySalary = sc.nextDouble();
                    employees.add(new FullTimeEmployee(ftName, ftId, monthlySalary));
                    System.out.println("Full-Time Employee Added!\n");
                    break;

                case 2:
                    System.out.print("Enter Name: ");
                    String ptName = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int ptId = sc.nextInt();
                    System.out.print("Enter Hourly Rate: ");
                    double hourlyRate = sc.nextDouble();
                    System.out.print("Enter Hours Worked: ");
                    double hoursWorked = sc.nextDouble();
                    employees.add(new PartTimeEmployee(ptName, ptId, hourlyRate, hoursWorked));
                    System.out.println("Part-Time Employee Added!\n");
                    break;

                case 3:
                    System.out.print("Enter Name: ");
                    String cName = sc.nextLine();
                    System.out.print("Enter ID: ");
                    int cId = sc.nextInt();
                    System.out.print("Enter Base Salary: ");
                    double baseSalary = sc.nextDouble();
                    System.out.print("Enter Commission: ");
                    double commission = sc.nextDouble();
                    employees.add(new CommissionEmployee(cName, cId, baseSalary, commission));
                    System.out.println("Commission Employee Added!\n");
                    break;

                case 4:
                    System.out.println("\n===== EMPLOYEE LIST =====");
                    for (Employee e : employees) {
                        e.displayInfo(); // Polymorphism
                    }
                    break;

                case 5:
                    double totalPayroll = 0;
                    for (Employee e : employees) {
                        totalPayroll += e.calculateSalary(); // Polymorphism
                    }
                    System.out.println("Total Payroll: " + totalPayroll + "\n");
                    break;

                case 6:
                    System.out.println("Exiting... Goodbye!");
                    sc.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice! Try again.\n");
            }
        }
    }
}