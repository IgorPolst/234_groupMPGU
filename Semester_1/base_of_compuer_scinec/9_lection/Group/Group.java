package Group;

import java.util.*;

public class Group {

    private int maxSize;
    private int minSize;
    private List<Student> group;

    public Group() {
        this.maxSize = 15;
        this.minSize = 3;
        this.group = new ArrayList<Student>();
    }

    public static Student generateStudent(boolean avtomatic, int num) {
        Student def;

        if (avtomatic) {
            def = new Student(num);

        } else {
            String name, surname;
            int age;
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите имя: ");
            name = sc.nextLine();
            System.out.println("Введите фамилию: ");
            surname = sc.nextLine();
            System.out.println("Введите возраст: ");
            age = sc.nextInt();

            
            def = new Student(name, surname, age, num);
        }
        return def;
    }

    public void addStudent(Student student, int num) {
        try {

            if (this.group.size() >= maxSize) {
                throw new IllegalStateException("Cannot add student: group is full.");
            } else if (student.getAge() >= 60 || student.getAge() <= 16) {
                throw new IllegalStateException("Cannot add student: The student must be over 16 and under 60 years of age.");
            }

            for (Student s : this.group) {
                if (s.getNumber() == student.getNumber()) {
                    throw new IllegalStateException("Cannot add student: student " + student.getNumber() + " already exists in the group.");
                }
            }

            this.group.add(student);
            System.out.println("Student " + student.getName() + " added to the group.");

        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
            num--;
        }

    }

    public void removeStudent(Student student) {
        try {
            if (this.group.size() <= minSize) {
                throw new IllegalStateException("Cannot remove student: group is empty.");
            }

            boolean studentFound = false;
            for (Student s : this.group) {
                if (s.getName().equals(student.getName())) {
                    studentFound = true;
                    break;
                }
            }

            if (!studentFound) {
                throw new IllegalStateException("Cannot remove student: student " + student.getName() + " is not in the group.");
            }

            this.group.remove(student);
            System.out.println("Student " + student.getName() + " removed from the group.");
        } catch (IllegalStateException e) {

            System.err.println(e.getMessage());
        }
    }

    public void getInfo(){
        System.out.println("Имя         Фамилия     Возраст Номер");
        for(Student s : this.group){
            System.out.printf("%-11s %-11s %-7d %-2d\n", s.getName(), s.getSurname(), s.getAge(), s.getNumber());
        }
    }


}
