import java.util.Scanner;

public class HW_2_lection{
    public static void main(String[] args) {
        Exe_1();   
        Exe_2();
        Exe_3();
        Exe_4();
        Exe_5();
        Exe_6();
        Exe_7();
        Exe_8();
        Exe_9();
        Exe_10();
        Exe_11();
        Exe_12();
        Exe_13();
        Exe_14();
        Exe_15();
        Exe_16();


    }

    public static void Exe_1 (){
        Scanner in = new Scanner (System.in);
        float n = in.nextFloat();
        System.out.println(Math.round(n));

    }

    public static void Exe_2(){
        Scanner in = new Scanner (System.in);
        float dollar = in.nextFloat();
        double sterling = dollar/1.487, frank = dollar/0.172, mark = dollar/0.584, ena = dollar/0.00955;

        System.out.println("Result: " +sterling+" funt, "+frank+" frank, "+mark+" German mark, "+ena+ " ena");
    }

    public static void Exe_3(){
        Scanner in = new Scanner (System.in);
        int tempreture = in.nextInt();

        System.out.println(tempreture * 9 /5 + 32);
    }

    public static void Exe_4(){
        Scanner in = new Scanner (System.in);
        int income = in.nextInt();
        int year = in.nextInt();
        float rate = in.nextFloat();

        for (int i = 0; i < year; i++){
            income += income*((rate*1.0)/100); 
        }

        System.out.println("Your income: " + income);
    }

    public static void Exe_5(){
        for (int i = 25; i < 63; i++){
            if (i%2 == 0){
                System.out.print(i + " ");
            }
        }
    }

    public static void Exe_6(){
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        if (n%2 == 0){
            System.out.println("Yes");
        }else{ 
            System.out.println("No");
        }
    }

    public static void Exe_7(){
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int ticket_60 = 0, ticket_20 = 0, ticket_10 = 0, ticket_5 = 0, ticket_1 = 0; 
        while (n > 0){
            if (n >= 60){
                ticket_60++;
                n -= 60;
            }
            else if (n >= 20){
                ticket_20++;
                n -= 20;
            }
            else if (n >= 10){
                ticket_10++;
                n -= 10;
            }
            else if (n >= 5){
                ticket_5++;
                n -= 5;
            }
            else {
                ticket_1++;
                n--;
            }
        }
        System.out.println(ticket_1 + " " + ticket_5 + " " + ticket_10 + " " + ticket_20 + " " + ticket_60);
    }

    public static void Exe_8(){
        Scanner in = new Scanner (System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        if (a == 0 && b == 0)
            System.out.println("INF");
            
        else if (a == 0 && b != 0)
            System.out.println("NO");
        else
            if (((-b*1.0)/a)%1 == 0)
                System.out.println(((-b*1.0)/a));
            else
                System.out.println("NO");
    }  

    public static void Exe_9() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int result = 1;
        for (int i = 1; i <= n; i++ )
            result *=i;
        System.out.println(result);    
    }

    public static void Exe_10() {
        Scanner in = new Scanner (System.in);
        int n = in.nextInt();
        int count = 0;
        while(n > 0){
            count += n%10;
            n /= 10;
        }    
        System.out.println(count);
    }

    public static void Exe_11() {
        Scanner in = new Scanner (System.in);
        int a = in.nextInt();
        int b = in.nextInt();

        for (int i = a; i <= b; i++){
            if(i%2 == 0)
                System.out.print(i + " "); 
        }
    }

    public static void Exe_12() {
        Scanner in = new Scanner (System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        if (a > b)
            System.out.println(a);
        else
            System.out.println(b);
    }

    public static void Exe_13() {
        Scanner in = new Scanner (System.in);
        int year = in.nextInt();
        if ((year%4 == 0 && year%100 != 0) || year%400 == 0)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
    
    public static void Exe_14() {
        Scanner in = new Scanner (System.in);
        int number = in.nextInt();
        if (number > 0)
            System.out.println(1);
        else if (number < 0)
            System.out.println(-1);
        else
            System.out.println(0); 
    }

    public static void Exe_15() {
        Scanner in = new Scanner (System.in);
        int rub = in.nextInt();
        int pennies = in.nextInt();
        int price = rub*10 + pennies;
        rub = in.nextInt();
        pennies= in.nextInt();
        int incom = rub*10 + pennies;
        
        if (incom < price)
            System.out.println("Ooooops! This item is worth more.");
        else
            System.out.println((price - incom)/10 + " " + (price-incom)%10);
    }

    public static void Exe_16() {
        Scanner in = new Scanner (System.in);
        int ice_balls = in.nextInt();
        while (ice_balls >=  3 || ice_balls >= 5){
            if (ice_balls >= 5)
                ice_balls -= 5;
            else if (ice_balls >= 3)
                ice_balls -= 3;
        }

        if (ice_balls == 0){
            System.out.println("Yes");
        }
        else{
            System.out.println("No");
        }
        
    }

}
