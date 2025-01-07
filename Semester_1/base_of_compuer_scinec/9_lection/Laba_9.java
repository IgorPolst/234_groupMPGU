
import Group.Group;
import Group.Student;

public class Laba_9 {

    public static void main(String[] args) {
        Group group = new Group();

        // Пример добавления студентов
        for (int i = 1; i <= 17; i++) {
            group.addStudent(new Student("Student " + i));
        }

        // Пример удаления студента
        group.removeStudent(new Student("Student 1"));
        group.removeStudent(new Student("Student 20")); // Этот студент не существует в группе.
    }
}
