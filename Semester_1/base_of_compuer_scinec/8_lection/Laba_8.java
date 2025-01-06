
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

        for (int i = 0; i < 3; i++) {
            salesman.work();
            storkeeper.work();
            boss.work();
            salesman.toRest();
            storkeeper.toRest();
            boss.toRest();
        }

        storkeeper.toSleep();
        for(int i = 0; i < 5; i ++){
            storkeeper.work();
            storkeeper.work();
            storkeeper.toRest();
        }

        salesman.goHome();
        salesman.toSleep();
        salesman.goWork();


        salesman.getInfo();
        storkeeper.getInfo();
        boss.getInfo();
    }
}
