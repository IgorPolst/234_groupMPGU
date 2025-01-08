
import Student.Group;
import Student.Student;
import java.util.*;

public class Laba_10 {

 public static void main(String[] args) {
        Group group = new Group();

        Scanner sсan = new Scanner(System.in);
        while (true) {
            System.out.println("Хотите создать студента в ручную - 1 или автоматически - 0, закончить добавлять в группу - -1");
            boolean close = false;
            switch (sсan.nextInt()) {
                case 0:
                    group.addStudent(Group.generateStudent(true));
                    break;

                case 1:
                    group.addStudent(Group.generateStudent(false));
                    break;

                case -1:
                    close = true;
                    break;

            }

            if (close) {
                break;
            }
            
        }

        sсan.close();

        group.removeStudent(
                new Student());
        group.removeStudent(
                new Student());

        group.getInfo();
    }

}
