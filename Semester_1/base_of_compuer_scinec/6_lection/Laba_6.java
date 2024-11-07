import Market.Market;
import Market.Product;
import Market.SuperMarket;
import java.util.Scanner;

public class Laba_6{

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        // Market shop = generateMarket();
        // shop.marketStatistic();
        // System.out.println("\nStatistic warehouse:\n");
        // shop.warehouseStatistic();

        SuperMarket store = generateSuperMarket();
        store.marketStatistic();

        
    }


//Должны ли эти функции быть тут? Или их лучше перенести в классы этих объектов? 
    public static Market generateMarket(){
        System.out.println("How many cashiers will work in your store?");
        int cashiers = sc.nextInt();
        System.out.println("How many cash registers will your store have?");
        int cashReg = sc.nextInt();

        System.out.println("How many items will you have in stock?");
        int size = sc.nextInt();
        sc.nextLine();

        Product[] warehouse = new Product[size];
        for (int i = 0; i < size; i++) {
            warehouse[i] = shipment();            
        }

        Market shop = new Market(cashiers, cashReg, warehouse);
        return shop;
    }

    public static SuperMarket generateSuperMarket(){
        System.out.println("What is the area of the room?");
        float area = sc.nextFloat();
        
        Market buf = generateMarket();

        String [] categories = creatingCategory();

        return new SuperMarket(buf.getCashRegisters(), buf.getCashiers(), buf.getProducts(), area, categories);
    }

    public static String [] creatingCategory(){
        int countCateg;
        System.out.println("How many categories are there in your supermarket?");
        countCateg = sc.nextInt();
        String [] Categories = new String[countCateg];

        sc.nextLine();
        for (int i = 0; i < countCateg; i++) {
            System.out.println("Enter your category:");
            Categories[i] = sc.nextLine();
        }

        return Categories;
    }

    public static Product shipment(){
        String title;
        float price,weight,quality;
        System.out.printf("Product Name: ");
        title = sc.nextLine();
        System.out.printf("Product Weight: ");
        weight = sc.nextFloat();
        System.out.printf("Product Price: ");
        price = sc.nextFloat();
        System.out.printf("Product Quality: ");
        quality = sc.nextFloat();

        sc.nextLine();
        Product newProduct = new Product(title, price, weight, quality);
        return newProduct;
    }


}