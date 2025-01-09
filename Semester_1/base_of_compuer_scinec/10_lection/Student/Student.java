package Student;

public class Student extends Group {

    String midleName;
    String name;
    String surname;
    String gender;
    int age;
    double averageScore;
    int scholarship;
    int attendedClasses;
    int missedClasses;

    public Student(String midleName, String name, String surname, String gender, int age, double averageScore, int scholarship, int attendedClasses, int missedClasses) {
        this.scholarship = scholarship;
        this.age = age;
        this.attendedClasses = attendedClasses;
        this.averageScore = averageScore;
        this.gender = gender;
        this.midleName = midleName;
        this.missedClasses = missedClasses;
        this.name = name;
        this.surname = surname;
    }

    public Student() {
        this.scholarship = 2700;
        this.age = 18;
        this.attendedClasses = 10;
        this.averageScore = 5.4;
        this.gender = "male";
        this.midleName = "Stevenson";
        this.missedClasses = 0;
        this.name = "Bob";
        this.surname = "Steve";
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Student{");
        sb.append("midleName=").append(midleName);
        sb.append(", name=").append(name);
        sb.append(", surname=").append(surname);
        sb.append(", gender=").append(gender);
        sb.append(", age=").append(age);
        sb.append(", averageScore=").append(averageScore);
        sb.append(", scholarship=").append(scholarship);
        sb.append(", attendedClasses=").append(attendedClasses);
        sb.append(", missedClasses=").append(missedClasses);
        sb.append('}');
        return sb.toString();
    }

    public String getMidleName() {
        return midleName;
    }

    public void setMidleName(String midleName) {
        this.midleName = midleName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

    public int getScholarship() {
        return scholarship;
    }

    public void setScholarship(int scholarship) {
        this.scholarship = scholarship;
    }

    public void setAttendedClasses(int attendedClasses) {
        this.attendedClasses = attendedClasses;
    }

    public void setMissedClasses(int missedClasses) {
        this.missedClasses = missedClasses;
    }

    public int getAttendedClasses() {
        return attendedClasses;
    }

    public int getMissedClasses() {
        return missedClasses;
    }

    public double attendance() {
        double allClasses = this.getAttendedClasses() + this.getMissedClasses();
        double PercentageOfVisits;
        try {
            PercentageOfVisits = this.getAttendedClasses() / allClasses * 100;
            
        } catch (ArithmeticException e) {
            System.out.println("Этот студнт не посетил и не пропустил ни одного занятия!");
            return 0;
        }        
            return PercentageOfVisits; 

    }

    public void getStudentInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append("ФИО\t").append(surname).append(" ").append(name).append(" ").append(midleName);
        sb.append("\nПол: ").append(gender).append(",   Возраст: ").append(age);
        sb.append("\nСредний балл: ").append(averageScore).append(", Стипендия: ").append(scholarship);
        sb.append("\nПосещаемость: ").append(String.format("%.2f", attendance())).append("%\n");
        System.out.println(sb.toString());
    }




}
