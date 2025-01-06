package Person;

public class Salesman extends Employee implements Worker {

    public Salesman() {
        super();
    }

    public Salesman(String name, String surname, String gender, boolean activity, int stamina, double age, String position,
            int payment, int expirience, String department) {
        super(name, surname, gender, activity, stamina, age, position,
                payment, expirience, department);
    }

    @Override
    public void getSettled() {
        this.setPosition("Salesman");
        this.setPayment(10);
        this.setDepartment("hall");
    }

    @Override
    public void work() {

        if (this.getStamina() < 0) {
            System.out.println("Нет сил продолжать!");
            return;
        }

        if (this.getStamina() < 10) {
            System.err.println("Вы слишком устали. Пора отдохнуть!");
        }

        this.setStamina(-5);
        this.setExpirience(10);

        double salary = this.getPayment() * (1 + (this.getExpirience() / 100));
        if (this.getGender().equals("female")) {

            this.setMoney(salary * 1.02);

        } else {
            this.setMoney(salary);
        }
        this.setAge(0.2);

    }

}
