import java.util.Date;
import java.util.Scanner;
import java.io.*;
import Products.*;
import Customer.*;
import Services.Cart;
public class Main {
    static void checkout(Customer c, Cart cart) {
        if(cart.isEmpty())
            throw new RuntimeException("Cart is empty");
        if(!c.canBuy(cart.cost()))
            throw new RuntimeException("Insufficient balance");
        double before = c.getCurrentBalance();
        c.modifyBalance(cart.cost());
        cart.process();
        System.out.println("\nBalance before: " + before + "\nBalance after " + c.getCurrentBalance());
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cart cart = new Cart();
        Date now = new Date();
        now.setYear(now.getYear() + 1);
        Product Cheese = new ExpirableShippableProduct("Cheese", 3.0, 10, now, 2);
        Product tv = new ShippableProduct("TV", 5, 4, 100);
        cart.addProduct(Cheese, 2);
        cart.addProduct(tv, 4);
        Customer c = new Customer("Hossam", 100);
        Cart cart2 = new Cart();
        cart2.addProduct(Cheese, 9);
        checkout(c, cart);
//        Cheese.increaseQuantity(10);
        checkout(c, cart2);
    }
}