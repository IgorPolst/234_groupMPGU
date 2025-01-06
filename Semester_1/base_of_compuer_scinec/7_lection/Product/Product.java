package Product;

public class Product {

    private String nameProduct;
    private int priceProduct;
    private int weightProduct;

    public Product() {
        this.nameProduct = "Empty";
        this.priceProduct = 10;
        this.weightProduct = 10;
    }

    public Product(String name, int price, int weight) {
        this.nameProduct = name;
        this.priceProduct = price;
        this.weightProduct = weight;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public int getWeightProduct() {
        return weightProduct;
    }

}
