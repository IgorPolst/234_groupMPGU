
import Person.Salesman;
import Person.StoreAdministrator;
import Person.Storekeeper;

public class Laba_8 {

    public static void main(String[] args) {
        Salesman salesman = new Salesman("Mari", "Sharap", "female", false, 100, 18, "unemployed", 10, 0, "Home");
        Storekeeper storkeeper = new Storekeeper("Max", "Sholder", "male", false, 100, 20, "unemployed", 10, 80, "Home");
        StoreAdministrator boss = new StoreAdministrator("Sergo", "Stonks", "male", true, 50, 22, "Store Administrator", 20, 200, "Store");

        salesman.getSettled();
        storkeeper.getSettled();
        boss.getSettled();

        System.out.println("Начало работы!\n");
        salesman.getInfo();
        storkeeper.getInfo();
        boss.getInfo();

        for (int i = 0; i < 3; i++) {
            salesman.work();
            storkeeper.work();
            boss.work();
            salesman.toRest();
            storkeeper.toRest();
            boss.toRest();
        }

        storkeeper.toSleep();

        for (int i = 0; i < 5; i++) {
            storkeeper.work();
            storkeeper.toRest();
        }

        salesman.goHome();
        storkeeper.goHome();
        boss.goHome();

        salesman.toSleep();
        storkeeper.toSleep();
        boss.toSleep();

        salesman.goWork();
        storkeeper.goWork();
        boss.goWork();

        System.out.println("\n\n2 Рабочий день.\n");
        salesman.getInfo();
        storkeeper.getInfo();
        boss.getInfo();
    }
}
