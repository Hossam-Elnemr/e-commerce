package Services;
import Products.*;
public class Item {
    Product product;
    int quantity;
    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    public double totalPrice() {
        return product.getPrice()*quantity;
    }
    double totalWeight() {
        return quantity*((ShippableProduct)product).getWeight();
    }
}
