package Person;

public class Employee extends Person {

    private String position;
    private int payment;
    private int expirience;
    private String department;

    public Employee() {
        super();
        this.position = "unemployed";
        this.payment = 0;
        this.department = "Home";
    }

    public Employee(String name, String surname, String gender, boolean activity, int stamina, double age, String position,
            int payment, int expirience, String department) {
        super(name, surname, gender, activity, stamina, age);
        this.position = position;
        this.payment = payment;
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public int getPayment() {
        return payment;
    }

    public int getExpirience() {
        return expirience;
    }

    public String getDepartment() {
        return department;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }

    public void setExpirience(int expirience) {
        this.expirience += expirience;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void getInfo() {
        System.out.printf("Имя: %s\nФамилия: %s\nПол: %s\nВыносливость: %d\nВозраст: %.1f\nСостояние: %.2f\nДолжность: %s\nЗарплата: %d\nОпыт: %d\nМесто работы: %s\n\n\n", this.getName(), this.getSurname(), this.getGender(), this.getStamina(), this.getAge(), this.getMoney(), this.getPosition(), this.getPayment(), this.getExpirience(), this.getDepartment());
    }

    public void goHome() {
        if (this.getStamina() < 0) {
            this.setAge(0.4);
        } else {
            this.setStamina(-5);
            this.setAge(0.2);
        }
        this.sleep();
    }

    public void goWork() {
        this.wakeUp();
        if (this.getStamina() < 0) {
            this.setAge(0.4);
        } else {
            this.setStamina(-5);
            this.setAge(0.2);
        }
    }

    public void toRest() {
        this.setStamina(2);
        this.setExpirience(-5);
        this.setAge(0.1);
    }

    public void toSleep() {
        if (this.getActivity()) {
            this.setStamina(20);
            this.setAge(0.2);
        } else {
            this.setStamina(10);
            this.setMoney(-10);
            this.setExpirience(-2);
        }
    }


}
