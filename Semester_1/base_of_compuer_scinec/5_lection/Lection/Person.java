package Lection;

import java.time.LocalDate;

public class Person {

    // ��� ��������������, ������� ��������� �����, ���������� ���������� ������
    private int age;
    private String firstName;
    private String lastName;
    private boolean gender;
    private LocalDate birthday;

    // ������� - ������ ��� ��������� ������ �� ������� ������
    public int getAge() {
        return age;
    }

    // ������� - ������ ��� ��������� ������ �� ������� ������
    public void setAge(int age) {
        if (age > 0) {
            this.age = age; 
        }else {
            System.err.println("������! �������� �� ����� �������� ������������� ���������");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.length() > 1) {
            this.firstName = firstName; 
        }else {
            System.out.println("������! ��� ������ ��������� �� ����� 2 ����");
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.length() > 1) {
            this.lastName = lastName; 
        }else {
            System.out.println("������! ������� ������ ��������� �� ����� 2 ����");
        }
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    // ����������� �� ���������. ��� ������������� ���������� �����, ������� ���������� ��� ������������� �������
    // ����������� �� ��������� - ��� �� ����������������� �����������, ���������� ������ ��� "�����������" �������
    // ����������� ������ ����� ���, ������������� ����� ������
    public Person() {
        this.age = 20; // this - ��� ��������� �� ������, ������� ������� ���� �����.
        this.firstName = "����";
        this.lastName = "��������";
        this.gender = false;
        birthday = LocalDate.of(2000, 10, 10);
    }

    // ����������������� ����������� - ��� ����������� � �����������, ������ ������ ���������� ��� �������� �������
    public Person(int age, String firstName, String lastName, boolean gender, LocalDate birthday) {
        this.age = age; // this � ���� ������ �������� ������ �������� ���������������
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
    }

    @Override // ���������, ������� �������, ��� �� �������������� �����, ����������� �����
    public String toString() { // �����, ������� ���������� �������� ������������� �������
        // ����� ����������� ������������� ��� ��������� � ������� � sout
        return ("���: " + this.firstName + "\n�������: " + this.lastName
                + "\n�������: " + this.age + "\n���: " + (this.gender ? "�������" : "�������")
                + "\n���� ��������: " + this.birthday);
    }

    // ������� �������� ��� ���� ��������, ��� �������� �� "����������" ����� �������� ���������� ��������
    public boolean isAdult() {
        return age >= 18 ? true : false;
    }
}
