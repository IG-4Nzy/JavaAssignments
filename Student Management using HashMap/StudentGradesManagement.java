import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

class Student {
    private HashMap<String, String> studentRecords = new HashMap<>();

    public HashMap<String, String> getAllRecords() {
        return studentRecords;
    }

    public String getStudentDetail(String name) {
        return studentRecords.getOrDefault(name, "No Records!");
    }

    public void setStudentDetail(String name, String grade) {
        studentRecords.put(name, grade);
    }

    public boolean removeStudentDetail(String name) {
        return studentRecords.remove(name) != null;
    }
}

class StudentManager {
    private static Scanner scanner = new Scanner(System.in);
    private static Student student = new Student();

    public void addNewStudent() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();

        System.out.println("Enter Grade");
        String grade = scanner.nextLine();

        student.setStudentDetail(name, grade);
    }

    public void getStudentDetail() {
        System.out.println("Enter Name");
        String name = scanner.nextLine();
        System.out.println(student.getStudentDetail(name));
    }

    public void getAllStudentRecords() {
        HashMap<String, String> studentRecords = student.getAllRecords();
        if(studentRecords.isEmpty()){
            System.out.println("No Records \n");
            return;
        }
        for (Map.Entry<String, String> entry : studentRecords.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public void removeStudentData() {
        String name = scanner.nextLine();
        System.out.println(student.removeStudentDetail(name) ? "Student Removed" : "No Records");
    }
}

class StudentGradesManagement {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {
        while (true) {
            showMenu();
            int option = scanner.nextInt();
            switch (option) {
                case 1 -> manager.addNewStudent();
                case 2 -> manager.addNewStudent();
                case 3 -> manager.getStudentDetail();
                case 4 -> manager.getAllStudentRecords();
                case 5 -> manager.removeStudentData();
                case 6 -> {
                    System.out.println("Exiting..!");
                    return;
                }
                default -> System.out.println("Invalid option");
            }
        }

    }

    private static void showMenu() {

        System.out.println("\n1 - Add new Student");
        System.out.println("2 - Update student grade");
        System.out.println("3 - Get Student Grade");
        System.out.println("4 - Get all student records");
        System.out.println("5 - Remove student data");
        System.out.println("6 - Exit");

    }
}