
import Student.Group;
import Student.Student;
import java.util.*;

public class Laba_10 {

    public static void main(String[] args) {
        Group group = new Group();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            int menuItem = -2;
            boolean close = false;
            try {
                menuItem = sc.nextInt();
                if (menuItem < -1 || menuItem > 9) {
                    throw new IllegalArgumentException("Ошибка: Такого пункта в меню нет. Сделайте корректный выбор");
                }

                if (executeChoice(menuItem, group)) {
                    break;
                }

            } catch (IllegalArgumentException e) {
                
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное число для возраста.");
                sc.next();
            }

        }

        

        sc.close();
    }

    public static void printMenu() {
        StringBuilder sb = new StringBuilder();
        sb.

        sb.append("Здравствуйте! Выберите один из пунктов меню:\n");
        sb.append("0 - Добавить студента созданного автоматически;\n");
        sb.append("1 - Добавить студента созданного в ручную;\n");
        sb.append("2 - Удалить студента из группы;\n");
        sb.append("3 - Изменить средний бал студента;\n");
        sb.append("4 - Изменить размер стипендии студента;\n");
        sb.append("5 - Добавить отметку посещения;\n");
        sb.append("6 - Добавить отметку пропуска;\n");
        sb.append("7 - Вывесьт информацию по студенту;\n");
        sb.append("8 - Вывести информацию о группе;\n");
        sb.append("9 - Вывести информацию о группе в от сортированном виде;\n");
        sb.append("-1 - Закончить работу с группой;\n");

        System.out.println(sb.toString());
    }

    public static boolean executeChoice(int num, Group group) {
        Student buf = null;
        boolean close = false;
        switch (num) {
            case 0:
                group.addStudent(Group.generateStudent(true));
                break;
            case 1:
                group.addStudent(Group.generateStudent(false));
                break;
            case 2:
                group.addStudent(Group.generateStudent(false));
                break;
            case 3:
                buf = group.findStudent();
                Group.changeRatingStudent(buf);
                buf.getStudentInfo();
                break;
            case 4:
                buf = group.findStudent();
                Group.changeScholarship(buf);
                buf.getStudentInfo();
                break;
            case 5:
                buf = group.findStudent();
                Group.addAttendedlasses(buf);
                buf.getStudentInfo();
                break;
            case 6:
                buf = group.findStudent();
                Group.addMissedClasses(buf);
                buf.getStudentInfo();
                break;
            case 7:
                group.findStudent().getStudentInfo();
                break;
            case 8:
                Group.getGroupInfo(group.getGroup());
                break;
            case 9:
                group.printSortedGroup();
                break;

            case -1:
                close = true;
                break;


        }
        return close;
    }

}
