package Person;

public class Storekeeper extends Employee implements Worker {

    public Storekeeper() {
        super();
    }

    public Storekeeper(String name, String surname, String gender, boolean activity, int stamina, double age, String position,
            int payment, int expirience, String department) {
        super(name, surname, gender, activity, stamina, age, position,
                payment, expirience, department);
    }

    @Override
    public void getSettled() {
        this.setPosition("Storekeeper");
        this.setPayment(15);
        this.setDepartment("warehouse");
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

        this.setStamina(-30);
        this.setExpirience(10);

        double salary = this.getPayment() * (1 + (this.getExpirience() * this.getStamina() / 100));
        if (this.getGender().equals("male")) {

            this.setMoney(salary * 1.01);

        } else {
            this.setMoney(salary);
        }
        this.setAge(0.2);

    }

}
