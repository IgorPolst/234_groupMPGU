package Person;

public class Person {

    private String name;
    private String surname;
    private String gender;
    private boolean activity;
    private int stamina;
    private double age;
    private double money;

    public Person() {
        this.name = "Bob";
        this.surname = "Bob";
        this.gender = "male";
        this.activity = false;
        this.stamina = 100;
        this.age = 18;
    }

    public Person(String name, String surname, String gender, boolean activity, int stamina, double age) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.activity = activity;
        this.stamina = stamina;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public boolean getActivity() {
        return activity;
    }

    public int getStamina() {
        return stamina;
    }

    public double getAge() {
        return age;
    }

    public double getMoney() {
        return money;
    }
    

    public void sleep() {
        this.activity = false;
    }

    public void wakeUp() {
        this.activity = true;
    }

    public void setStamina(int stamina) {
        this.stamina += stamina;
    }

    public void setMoney(double money) {
        this.money += money;
    }

    public void setAge(double age) {
        this.age += age;
    }


}
