import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    private final List<Student> students = new ArrayList<>();

    public boolean addStudent(Student student) {
        if (findStudent(student.getId()) != null) {
            return false;
        }

        students.add(student);
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
        return true;
    }

    public boolean deleteStudent(int id) {
        Student student = findStudent(id);

        if (student == null) {
            return false;
        }

        students.remove(student);
        return true;
    }
}