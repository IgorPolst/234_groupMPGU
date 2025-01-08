package Student;

import java.util.*;

public class Group {

    private int maxSize;
    private int minSize;
    private TreeSet<Student> group;

    public Group() {
        this.maxSize = 15;
        this.minSize = 3;
        this.group = new TreeSet<Student>();
    }

    public TreeSet<Student> getGroup() {

        return group;
    }

    public static Student generateStudent(boolean avtomatic) {
        Student def;

        if (avtomatic) {
            def = new Student();
            return def;
        }

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

        settingAverageScore(sc, def);

        settingScholarship(sc, def);

        settingAttendedClasses(sc, def);

        settingMissedClasses(sc, def);

        return def;
    }

    public void addStudent(Student student) {
        try {

            if (this.group.size() >= maxSize) {
                throw new IllegalStateException("Cannot add student: group is full.");
            } else if (student.getAge() >= 60 || student.getAge() <= 16) {
                throw new IllegalStateException("Cannot add student: The student must be over 16 and under 60 years of age.");
            }

            for (Student s : this.group) {
                if (s.getName().equals(student.getName())) {
                    throw new IllegalStateException("Cannot add student: student " + student.getName() + " already exists in the group.");
                }
            }

            this.group.add(student);
            System.out.println("Student " + student.getName() + " added to the group.");

        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());

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

    public Student findeStudent() { // Поиск студентов по имени
        Student rightStudent = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            boolean found = false;
            try {
                String name = readString(sc, "Введите имя студента: ");
                for (Student s : this.group) {
                    if (s.getName().equals(name)) {
                        rightStudent = s;
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException("Студента с таким именем в этой группе не существует!");
                }
                break;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return rightStudent;
    }

    public void changeRatingStudent(Student student) {
        System.out.println("Введите новый средний балл студента: ");
        Scanner sc = new Scanner(System.in);
        settingAverageScore(sc, student);
        sc.close();
    }

    public void changeScholarship(Student student) {
        System.out.println("Введите новый размер стипендии: ");
        Scanner sc = new Scanner(System.in);
        settingAverageScore(sc, student);
        sc.close();
    }

    public void addAttendedlasses(Student student) {
        int previousVisits = student.getAttendedClasses();
        Scanner sc = new Scanner(System.in);
        settingAttendedClasses(sc, student);
        int newVisit = student.getAttendedClasses();
        student.setAttendedClasses(previousVisits + newVisit);
    }

    public void addMissedClasses(Student student) {
        int previousMissed = student.getAttendedClasses();
        Scanner sc = new Scanner(System.in);
        settingMissedClasses(sc, student);
        int newMiss = student.getAttendedClasses();
        student.setAttendedClasses(previousMissed + newMiss);
    }

    public void getInfo() {

        for (Student s : this.group) {
            System.out.printf("%-11s %-11s %-2d\n", s.getName(), s.getSurname(), s.getAge());
        }
    }

    public void printSortedGroup(){
        
    }

    private static Comparator ComparatorSelector(int num) {
        switch (num) {
            case 1:
                Comparator<Student> averageScoreComparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Double.compare(s1.getAverageScore(), s2.getAverageScore());
                    }
                };
                return averageScoreComparator;
                
            case 2:
                Comparator<Student> ageComparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Double.compare(s1.getAge(), s2.getAge());
                    }
                };

                return ageComparator;
            case 3:
                Comparator<Student> scholarshipComparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Double.compare(s1.getScholarship(), s2.getScholarship());
                    }
                };

                return scholarshipComparator;
            case 4:
                Comparator<Student> attendanceComparator = new Comparator<Student>() {
                    @Override
                    public int compare(Student s1, Student s2) {
                        return Double.compare(s1.attendance(), s2.attendance());
                    }
                };

                return attendanceComparator;
            default:
                throw new AssertionError();
        }
        
    }

    private static String readString(Scanner sc, String prompt) { // Проверка заполнения имени, фамилии и отчества без цифр
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

    private static void settingAverageScore(Scanner sc, Student def) {
        double averageScore = sc.nextDouble();
        while (true) {
            System.out.print("Установите средний балл студента: ");
            try {

                if (averageScore < 0 || averageScore > 100) {
                    throw new IllegalArgumentException("Ошибка: Средний балл должен быть в диапазоне от 0 до 100.");
                }

                def.setAverageScore(averageScore);
                System.out.println("Средний балл установлен: " + def.getAverageScore());
                break;

            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Введите корректное число для возраста.");
                sc.next();
            }
        }
    }

    private static void settingScholarship(Scanner sc, Student def) {
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
    }

    private static void settingAttendedClasses(Scanner sc, Student def) {
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
    }

    private static void settingMissedClasses(Scanner sc, Student def) {
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
}
