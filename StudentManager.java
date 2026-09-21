import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();
    private final String fileName = "students.txt";

    public StudentManager() {
        loadStudents();
    }

    public boolean addStudent(Student student) {
        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
        saveStudents();
        return true;
    }

    public List<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }

    public boolean updateStudent(int id, String newName, double newGpa) {
        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        student.setName(newName);
        student.setGpa(newGpa);

        saveStudents();
        return true;
    }

    public boolean deleteStudent(int id) {
        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        saveStudents();
        return true;
    }

    private void saveStudents() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {

            for (Student student : students) {
                writer.println(
                        student.getId() + "," +
                        student.getName() + "," +
                        student.getGpa()
                );
            }

        } catch (IOException e) {
            System.out.println("Error saving students.");
        }
    }

    private void loadStudents() {
        File file = new File(fileName);

        if (!file.exists()) {
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                double gpa = Double.parseDouble(data[2]);

                students.add(new Student(id, name, gpa));
            }

        } catch (IOException | NumberFormatException e) {
            System.out.println("Error loading students.");
        }
    }
}