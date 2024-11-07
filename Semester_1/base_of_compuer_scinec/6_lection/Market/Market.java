package Market;

public class Market{
	protected int cashRegisters;
	protected int cashiers; 
	protected Product[] products;
	 
	public int getCashRegisters(){
		return this.cashRegisters;
	}

	public int getCashiers(){
		return this.cashiers;
	}

	public Product[] getProducts(){
		return this.products;
	}

	public Market() {
		this.cashRegisters = 1;
		this.products = new Product[10];
		this.cashiers = 1;
	}

	public Market(int numCashRegister, int cashiers, Product[] products){
		this.cashRegisters = numCashRegister;
		this.cashiers = cashiers;
		this.products = products;
	}

	public float effectiveCashRegister(){
		if (this.cashRegisters == 0) {
            throw new ArithmeticException("Number of cash registers cannot be zero.");
        }

		float effective = (float) this.cashiers / this.cashRegisters;
        return effective >= 1 ? 1 : effective;
	}


	public float averageWeight(){
		if (this.products.length == 0) {
            return 0; // Или выбросить исключение, если это необходимо
        }

        float weight = 0;
		float total = 0;
        for (Product product : this.products) {
            if (product != null) {
                weight += product.getWeight();
				total += product.getCost();
            }
        }
        return weight / total;
	}

	public float effectiveMarket(){
		return averageWeight() / effectiveCashRegister();
	}

	public void marketStatistic(){
		System.out.printf("Number of cashiers: %d\nNumber of cash registers: %d\nAverage weight of products: %.2f\nCash register efficiency: %.2f\nStore efficiency: %.2f\n", 
		this.cashiers, 
		this.cashRegisters, 
		averageWeight(), 
		effectiveCashRegister(), 
		effectiveMarket()
		);
	}

	public void warehouseStatistic(){
		int size = this.products.length;
		System.out.println("Title | Weight | Price | Quality | Cost ");
		for (int i = 0; i < size; i++) {
			this.products[i].statisticProduct();
		}
	}


}