package Services;

import Products.*;

import java.util.ArrayList;
import java.util.Date;

public class Cart {
    public ArrayList<Item> list = new ArrayList<>();
    public ArrayList<Product> shippables = new ArrayList<>();
    double total = 0;
    public void addProduct(Product p, int amount) {
        list.add(new Item(p, amount));
        total += list.getLast().totalPrice();
    }
    void validateItem(Product p, int amount) {
        if(!p.isAvailable(amount))
            throw new RuntimeException("amount exceeds stock");
        if(p instanceof ExpirableProduct || p instanceof ExpirableShippableProduct) {
            Date date;
            if(p instanceof ExpirableProduct)
                date = ((ExpirableProduct) p).getExpiryDate();
            else
                date = ((ExpirableShippableProduct) p).getExpiryDate();
            if(date.before(new Date()))
                throw new RuntimeException("product out of date");
        }
    }
    void validateAll() {
        for (Item item : list)
            validateItem(item.product, item.quantity);
        for (Item item : list)
            item.product.decreaseQuantity(item.quantity);
    }
    public void process() {
        validateAll();
        shippables = ShippableOnly();
        if(!shippables.isEmpty()) {
            System.out.println("** Shipment notice **");
            double total = 0;
            for(var p : list)
                if(p.product instanceof ShippableProduct) {
                    System.out.println(p.quantity + "x " + p.product.getName() + "\t\t" + p.totalWeight());
                    total += p.totalWeight();
                }
            System.out.println("Total package weight " + total/1000.0 + "kg\n");
        }
        System.out.println("** Checkout receipt **");
        for(var p : list)
            System.out.println(p.quantity + "x " + p.product.getName() + "\t\t" + p.totalPrice());
        System.out.println("----------------------");
        System.out.println("Subtotal \t\t" + total);
        System.out.println("Shipping \t\t" + (new ShippingService(ShippableOnly())).cost());
        System.out.println("Amount \t\t " + totalCost());

    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    ArrayList<Product> ShippableOnly() {
        ArrayList<Product> result = new ArrayList<>();
        for(Item i : list)
            if(i.product instanceof ShippableProduct)
                result.add(i.product);
        return (shippables = result);
    }
    public double cost() {
        return total;
    }
    public double totalCost() {
        return total + (new ShippingService(ShippableOnly())).cost();
    }
}