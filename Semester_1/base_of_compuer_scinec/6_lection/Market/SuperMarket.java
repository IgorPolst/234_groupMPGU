package Market;

public class SuperMarket extends Market{

    private float area;
    private String [] categories;  


    public SuperMarket() {
        super();
        this.area = 10;
        this.categories = new String[10];
    }

    public SuperMarket(int numCashRegister, int cashiers, Product[] products, float area, String[] category){
        super(numCashRegister, cashiers, products);
        this.area = area;
        this.categories = category;
    }

    public float effectiveSuperMarket(){
        float effective = this.area/this.categories.length*effectiveCashRegister();        
        return effective >= 1 ? 1 : effective;
    }

    @Override
    public void marketStatistic(){
		System.out.printf("Number of cashiers: %d\nNumber of cash registers: %d\nArea: %.2f\n\nCash register efficiency: %.2f\nStore efficiency: %.2f\n", 
		this.cashiers, 
		this.cashRegisters,
        this.area,
		effectiveCashRegister(), 
		effectiveSuperMarket()
		);

        System.out.println("\nCategories:");

        for(String category : this.categories){
            System.out.printf("%s ",category);
        }
	}

}