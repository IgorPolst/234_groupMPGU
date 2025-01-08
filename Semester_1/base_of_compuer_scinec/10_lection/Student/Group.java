package Student;

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

    public static Student generateStudent(boolean avtomatic) {
        Student def;

        if (avtomatic) {
            def = new Student();

        } else {
            def = new Student();

            Scanner sc = new Scanner(System.in);

            def.setName(readString(sc, "Введите имя: "));
            def.setMidleName(readString(sc, "Введите отчество: "));
            def.setSurname(readString(sc, "Введите фамилию: "));

            int age = 0;
            while (true) {
                try {
                    System.out.println("Введите возраст: ");
                    age = sc.nextInt();
                    if (age < 0) {
                        throw new IllegalArgumentException("Возраст не может быть отрицательным. Повторите ввод.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректное число для возраста.");
                    sc.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            def.setAge(age);

            int genderInput = -1;
            while (true) {
                try {
                    System.out.println("Ваш пол м - 1 или ж - 0");
                    genderInput = sc.nextInt();
                    if (genderInput == 1) {
                        def.setGender("male");
                    } else if (genderInput == 0) {
                        def.setGender("female");
                    } else {
                        throw new IllegalArgumentException("Введите 1 для мужского и 0 для женского пола.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Пожалуйста, введите 1 или 0.");
                    sc.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }

            int scholarship = 0;
            while (true) {
                try {
                    System.out.println("Установите размер стипендии: ");
                    scholarship = sc.nextInt();
                    if (scholarship < 0) {
                        throw new IllegalArgumentException("Размер стипендии не может быть отрицательным. Повторите ввод.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректное число для стипендии.");
                    sc.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            def.setScholarship(scholarship);

            int attendedClasses = 0;
            while (true) {
                try {
                    System.out.println("На скольких занятиях вы присутствовали: ");
                    attendedClasses = sc.nextInt();
                    if (attendedClasses < 0) {
                        throw new IllegalArgumentException("Количество посещённых занятий не может быть отрицательным. Повторите ввод.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректное число для посещённых занятий.");
                    sc.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            def.setAttendedClasses(attendedClasses);

            int missedClasses = 0;
            while (true) {
                try {
                    System.out.println("Сколько занятий вы пропустили: ");
                    missedClasses = sc.nextInt();
                    if (missedClasses < 0) {
                        throw new IllegalArgumentException("Количество пропущенных занятий не может быть отрицательным. Повторите ввод.");
                    }
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка: Введите корректное число для пропущенных занятий.");
                    sc.next();
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
            def.setMissedClasses(missedClasses);

        }
        return def;
    }

    public void addStudent(Student student) {
        try {

            if (group.size() >= maxSize) {
                throw new IllegalStateException("Cannot add student: group is full.");
            } else if (student.getAge() >= 60 || student.getAge() <= 16) {
                throw new IllegalStateException("Cannot add student: The student must be over 16 and under 60 years of age.");
            }

            for (Student s : group) {
                if (s.getName().equals(student.getName())) {
                    throw new IllegalStateException("Cannot add student: student " + student.getName() + " already exists in the group.");
                }
            }

            group.add(student);
            System.out.println("Student " + student.getName() + " added to the group.");

        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());

        }

    }

    public void removeStudent(Student student) {
        try {
            if (group.size() <= minSize) {
                throw new IllegalStateException("Cannot remove student: group is empty.");
            }

            boolean studentFound = false;
            for (Student s : group) {
                if (s.getName().equals(student.getName())) {
                    studentFound = true;
                    break;
                }
            }

            if (!studentFound) {
                throw new IllegalStateException("Cannot remove student: student " + student.getName() + " is not in the group.");
            }

            group.remove(student);
            System.out.println("Student " + student.getName() + " removed from the group.");
        } catch (IllegalStateException e) {

            System.err.println(e.getMessage());
        }
    }

    public void changeRatingStudent(Student student){
    }
    public void getInfo() {
        System.out.println("Имя         Фамилия     Возраст Номер");
        for (Student s : this.group) {
            System.out.printf("%-11s %-11s %-2d\n", s.getName(), s.getSurname(), s.getAge());
        }
    }

    private static String readString(Scanner sc, String prompt) {
        String input = "";
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.println(prompt);
                input = sc.nextLine();

                if (!input.matches("[a-zA-Zа-яА-ЯёЁ]+")) {
                    throw new IllegalArgumentException("Ошибка: Ввод должен содержать только буквы.");
                }

                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

}
