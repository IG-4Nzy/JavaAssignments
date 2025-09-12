 class Employee{
    String name;
    private double salary;

    public Employee(String name,double salary){
        this.name = name;
        this.salary = salary;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getSalary(){
        return salary;
    }

    public void setSalary(double salary){
        this.salary = salary;
    }
}

 class Manager extends Employee{
    public  Manager(String name,double salary){
        super(name, salary);
    }

}

class Developer extends Employee{
    public  Developer(String name,double salary){
        super(name,salary);
    }
}

class EmployeeQn{
    public static void main(String[] args){
        Employee employee = new Employee("employee",30000);
        Manager manager = new Manager("manager",40000);
        Developer developer = new Developer("developer",25000);

        System.out.println("Employee Details - " + employee.getName() + " and " + employee.getSalary());
        System.out.println("Manager Details - " + manager.getName() + " and " + manager.getSalary());
        System.out.println("Developer Details - " + developer.getName() + " and " + developer.getSalary());

        System.out.println("\nSalary incremented by 2000/- \n");

        employee.setSalary(32000);
        manager.setSalary(42000);
        developer.setSalary(27000);

        System.out.println("Employee Details - " + employee.getName() + " and " + employee.getSalary());
        System.out.println("Manager Details - " + manager.getName() + " and " + manager.getSalary());
        System.out.println("Developer Details - " + developer.getName() + " and " + developer.getSalary());
    }
 }