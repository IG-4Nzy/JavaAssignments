import java.util.Scanner;
import java.util.ArrayList;

class Employee {
    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return name + ":" + salary;
    }
}

class OptionManager {
    private static Scanner scanner = new Scanner(System.in);

    private ArrayList<Employee> employees = new ArrayList<>();

    public void AddData() {
        System.out.println("Enter name");
        String name = scanner.nextLine();

        System.out.println("Enter salary");
        double salary = scanner.nextDouble();
        scanner.nextLine();

        employees.add(new Employee(name, salary));
    }

    public void sortDescending() {
        employees.sort((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

    public void sortAscending() {
        employees.sort((e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));

        for (Employee e : employees) {
            System.out.println(e);
        }
    }

}

public class EmployeesArrayList {
    private static Scanner scanner = new Scanner(System.in);
    private static OptionManager manager = new OptionManager();

    public static void main(String[] args) {
        while (true) {
            displayOptions();
            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1 -> manager.AddData();
                case 2 -> manager.sortDescending();
                case 3 -> manager.sortAscending();
                case 4 -> {
                    System.out.println("Exiting");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void displayOptions() {
        System.out.println("1 - Add Data");
        System.out.println("2 - Sort Descending");
        System.out.println("3 - Sort Ascending");
        System.out.println("4 - Exit");
    }
}