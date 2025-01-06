package Person;

public class StoreAdministrator extends Employee implements Worker {

    public StoreAdministrator() {
        super();
    }

    public StoreAdministrator(String name, String surname, String gender, boolean activity, int stamina, double age, String position,
            int payment, int expirience, String department) {
        super(name, surname, gender, activity, stamina, age, position,
                payment, expirience, department);
    }

    @Override
    public void getSettled() {
        this.setPosition("Store Administrator");
        this.setPayment(30);
        this.setDepartment("Store");
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

        this.setStamina(-15);
        this.setExpirience(15);

        double salary = this.getPayment() * (1 + (this.getExpirience() / 100) * 2);
        if (this.getAge() > 10) {

            this.setMoney(salary * 1.3);

        } else {
            this.setMoney(salary);
        }
        this.setAge(0.2);

    }

    @Override
    public void goHome() {
        if (this.getStamina() < 0) {
            this.setAge(0.2);
        } else {
            this.setStamina(-2);
            this.setAge(0.1);
        }
        this.sleep();
    }

    @Override
    public void goWork() {
        this.wakeUp();
        if (this.getStamina() < 0) {
            this.setAge(0.2);
        } else {
            this.setStamina(-2);
            this.setAge(0.1);
        }
    }

    @Override
    public void toRest() {
        this.setStamina(2);
        this.setMoney(-5);
        this.setAge(0.1);
    }

    @Override
    public void toSleep() {
        if (this.getActivity()) {
            this.setStamina(30);
            this.setAge(0.2);
        } else {
            this.setStamina(15);
            this.setMoney(-20);
        }
    }

}
