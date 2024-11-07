package Market;

public class Product{

    private String title;
    private float price;
    private float weight;
    private float quality;



    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public float getPrice(){
        return price;
    } 

    public float getWeight(){
        return weight;
    }

    public float getQuality(){
        return quality;
    }

    public void setPrice(float price) {
        if (price < 0) throw new IllegalArgumentException("Price cannot be negative");
        this.price = price;
    }

    public void setWeight(float weight) {
        if (weight < 0) throw new IllegalArgumentException("Weight cannot be negative");
        this.weight = weight;
    }

    public void setQuality(float quality) {
        if (quality < 0) throw new IllegalArgumentException("Quality cannot be negative");
        this.quality = quality;
    }

    public void statisticProduct(){
        System.out.printf("%8s|%8.1f|%7.1f|%9.1f|%5.1f\n",
				this.title,
				this.weight,
				this.price,
				this.quality,
                getCost()
				);
    }


    public float getCost() {
        return calculateCost();
    }

    private float calculateCost() {
        return this.price * this.weight * this.quality;
    }

    public Product(){
        this.title = "Apple";
        this.price = 0;
        this.weight = 0;
        this.quality = 0;
    } 

    public Product(String title, float price, float weight, float quality){
        this.title = title;
        this.price = price;
        this.weight = weight;
        this.quality = quality;
    }
}