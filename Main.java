import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner input = new Scanner(System.in);
    private static final StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        while (true) {
            printMenu();

            int choice = readInt("Choose: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> showStudents();
                case 3 -> searchStudent();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> {
                    System.out.println("Goodbye.");
                    input.close();
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n=== Student Management System ===");
        System.out.println("1. Add Student");
        System.out.println("2. Show Students");
        System.out.println("3. Search Student");
        System.out.println("4. Update Student");
        System.out.println("5. Delete Student");
        System.out.println("6. Exit");
    }

    private static void addStudent() {
        int id = readInt("ID: ");

        if (manager.findStudent(id) != null) {
            System.out.println("A student with this ID already exists.");
            return;
        }

        String name = readNonEmptyString("Name: ");
        double gpa = readGpa("GPA (0.0 - 5.0): ");

        Student student = new Student(id, name, gpa);

        if (manager.addStudent(student)) {
            System.out.println("Student added successfully.");
        }
    }

    private static void showStudents() {
        List<Student> students = manager.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        System.out.println("\n--- Students ---");

        for (Student student : students) {
            System.out.println(student);
        }
    }

    private static void searchStudent() {
        int id = readInt("Enter student ID: ");
        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println(student);
        }
    }

    private static void updateStudent() {
        int id = readInt("Enter student ID to update: ");
        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student not found.");
            return;
        }

        String newName = readNonEmptyString("New name: ");
        double newGpa = readGpa("New GPA (0.0 - 5.0): ");

        if (manager.updateStudent(id, newName, newGpa)) {
            System.out.println("Student updated successfully.");
        }
    }

    private static void deleteStudent() {
        int id = readInt("Enter student ID to delete: ");

        if (manager.deleteStudent(id)) {
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextInt()) {
                int value = input.nextInt();
                input.nextLine();
                return value;
            }

            System.out.println("Please enter a valid integer.");
            input.nextLine();
        }
    }

    private static double readGpa(String message) {
        while (true) {
            System.out.print(message);

            if (input.hasNextDouble()) {
                double gpa = input.nextDouble();
                input.nextLine();

                if (gpa >= 0.0 && gpa <= 5.0) {
                    return gpa;
                }
            } else {
                input.nextLine();
            }

            System.out.println("GPA must be between 0.0 and 5.0.");
        }
    }

    private static String readNonEmptyString(String message) {
        while (true) {
            System.out.print(message);
            String value = input.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("This field cannot be empty.");
        }
    }
}