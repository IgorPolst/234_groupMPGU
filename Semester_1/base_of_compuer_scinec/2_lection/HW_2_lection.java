
import java.util.Scanner;

public class HW_2_lection {

    public static void main(String[] args) {

        // Exe_1();   
        // Exe_2();
        // Exe_3();
        // Exe_4();
        // Exe_5();
        // Exe_6();
        Exe_7();
        // Exe_8();
        // Exe_9();
        // Exe_10();
        // Exe_11();
        // Exe_12();
        // Exe_13();
        // Exe_14();
        // Exe_15();
        // Exe_16();

    }

    public static void Exe_1() {
        Scanner in = new Scanner(System.in);
        float n = in.nextFloat();
        System.out.println(Math.round(n));

    }

    public static void Exe_2() {
        Scanner in = new Scanner(System.in);
        double dollar = in.nextDouble();
        double sterling = dollar / 1.487, frank = dollar / 0.172, mark = dollar / 0.584, ena = dollar / 0.00955;
        System.out.printf("Result:\n %.2f funt;\n %.2f frank;\n %.2f German mark;\n %.2f ena", sterling, frank, mark, ena);
    }

    public static void Exe_3() {
        Scanner in = new Scanner(System.in);
        float tempreture = in.nextFloat();

        System.out.println(tempreture * 9 / 5 + 32);
    }

    public static void Exe_4() {
        Scanner in = new Scanner(System.in);
        float income = in.nextFloat();
        int year = in.nextInt();
        float rate = in.nextFloat();

        for (int i = 0; i < year; i++) {
            income += income * (rate / 100);
        }

        System.out.println("Your income: " + income);
    }

    public static void Exe_5() {
        for (int i = 25; i < 63; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void Exe_6() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n % 2 == 0) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static void Exe_7() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ticket_60, ticket_20, ticket_10, ticket_5, ticket_1;
        ticket_60 = n / 60;
        n -= ticket_60 * 60;
        if (n >= 36) {
            ticket_60++;
            n = 0;
        }

        ticket_20 = n / 20;
        n -= ticket_20 * 20;
        if (n >= 18) {
            ticket_20++;
            n = 0;
        }

        ticket_10 = n / 10;
        n -= ticket_10 * 10;
        if (n >= 9) {
            ticket_10++;
            n = 0;
        }

        ticket_5 = n / 5;
        n -= ticket_5 * 5;
        ticket_1 = n % 5;

        System.out.printf("Ticket 1: %d \nTicket 5: %d \nTicket 10: %d \nTicket 20: %d \nTicket 60: %d\n", ticket_1, ticket_5, ticket_10, ticket_20, ticket_60);

        int price = ticket_1 * 15 + ticket_5 * 70 + ticket_10 * 125 + ticket_20 * 230 + ticket_60 * 440;
        System.out.printf("Total price %d", price);
    }

    public static void Exe_8() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        if (a == 0 && b == 0) {
            System.out.println("INF"); 
        }else if (a == 0 && b != 0) {
            System.out.println("NO"); 
        }else if ((-(double) b / a) % 1 == 0) {
            System.out.println((-(double) b / a)); 
        }else {
            System.out.println("NO");
        }
    }

    public static void Exe_9() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println(result);
    }

    public static void Exe_10() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int count = 0;
        while (n > 0) {
            count += n % 10;
            n /= 10;
        }
        System.out.println(count);
    }

    public static void Exe_11() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        if (b > a) {
            int buffer = b;
            b = a;
            a = buffer;
        }

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
    }

    public static void Exe_12() {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a > b) {
            System.out.println(a); 
        }else {
            System.out.println(b);
        }
    }

    public static void Exe_13() {
        Scanner in = new Scanner(System.in);
        int year = in.nextInt();
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            System.out.println("Yes"); 
        }else {
            System.out.println("No");
        }
    }

    public static void Exe_14() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();
        if (number > 0) {
            System.out.println(1); 
        }else if (number < 0) {
            System.out.println(-1); 
        }else {
            System.out.println(0);
        }
    }

    public static void Exe_15() {
        Scanner in = new Scanner(System.in);
        int rub = in.nextInt();
        int pennies = in.nextInt();
        int price = rub * 10 + pennies;
        rub = in.nextInt();
        pennies = in.nextInt();
        int incom = rub * 10 + pennies;

        if (incom < price) {
            System.out.println("Ooooops! This item is worth more."); 
        }else {
            System.out.println((price - incom) / 10 + " " + (price - incom) % 10);
        }
    }

    public static void Exe_16() {
        Scanner in = new Scanner(System.in);
        int ice_balls = in.nextInt();
        for (int i = 0; i <= ice_balls / 5; i++) {
            if ((ice_balls - i * 5) % 3 == 0) {
                System.out.println("Yes");
            }
        }
        System.out.println("No");
    }

}
