
public class 

     1_lection{

    public static void castDataType() {
        double y = 25.3, tmp2;
        int x = 10, tmp;
        //String str = "210";

        tmp = (int) y; // Приведение (cast) y к типу int
        tmp2 = (double) x;

        //x = Integer.valueOf(str); //Нельзя привести строку к типу данных str 
        System.out.println(tmp);
        System.out.println(tmp2);
        System.out.println(x);

    }
}
