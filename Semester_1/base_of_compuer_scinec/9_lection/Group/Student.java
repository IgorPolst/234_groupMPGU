package Group;

public class Student {

    String name;
    String surname;
    int age;
    int number;

    public Student(int number) {
        this.name = "Боб";
        this.surname = "Бобович";
        this.age = 17;
        this.number = number;
    }

    public Student(String name, String surname, int age, int number) {
        this.age = age;
        this.name = name;
        this.number = number;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getAge() {
        return age;
    }

    public int getNumber() {
        return number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
